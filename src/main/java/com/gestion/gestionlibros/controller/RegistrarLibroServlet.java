package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.model.Libro;
import com.gestion.gestionlibros.model.data.DBGenerator;
import com.gestion.gestionlibros.model.data.dao.LibroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registrarLibroServlet", value = "/registroLibro")
public class RegistrarLibroServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("LibrosDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroLibro.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("editorial").length()!=0  &&
                req.getParameter("categoria").length()!=0 && req.getParameter("año").length()!=0 && req.getParameter("tipo").length()!=0){
            String nombre = req.getParameter("nombre");
            String editorial = req.getParameter("editorial");
            String categoria = req.getParameter("categoria");
            int año = Integer.parseInt(req.getParameter("año"));
            String tipo = req.getParameter("tipo");
            Libro libro = new Libro(nombre, editorial, categoria, año, tipo);
            try {
                if(agregarLibro(libro)){
                    req.setAttribute("libro",libro);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarLibro(Libro libro) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("LibrosDB");
        List<Libro> libros = LibroDAO.obtenerLibro(query,"categoria", libro.getCategoria());
        if(libros.size()!=0){
            return false;
        }
        else{
            LibroDAO.agregarLibro(query,libro);
            return true;
        }
    }
}
