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

@WebServlet(name = "eliminarLibroServlet", value = "/eliminarLibro")
public class EliminarLibroServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminarLibro.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminacionErronea.jsp");

        String nombreParameter = req.getParameter("nombre");
        String editorialParameter = req.getParameter("editorial");
        String categoriaParameter = req.getParameter("categoria");
        String añoParameter = req.getParameter("año");
        String tipoParameter = req.getParameter("tipo");

        if (nombreParameter != null && editorialParameter != null &&
                categoriaParameter != null && añoParameter != null && tipoParameter != null &&
                nombreParameter.length() != 0 && editorialParameter.length() != 0 &&
                categoriaParameter.length() != 0 && añoParameter.length() != 0 && tipoParameter.length() != 0) {

            String nombre = nombreParameter;
            String editorial = editorialParameter;
            String categoria = categoriaParameter;
            int año = Integer.parseInt(añoParameter);
            String tipo = tipoParameter;

            Libro libro = new Libro(nombre, editorial, categoria, año, tipo);

            try {
                if (eliminarLibro(libro)) {
                    req.setAttribute("libro", libro);
                    respuesta = req.getRequestDispatcher("/eliminacionExitosa.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        respuesta.forward(req, resp);
    }




    private boolean eliminarLibro(Libro libro) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("LibrosDB");
        return LibroDAO.eliminarLibro(query, libro);
    }


}

