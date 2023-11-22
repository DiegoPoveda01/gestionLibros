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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MostrarLibrosServlet", value = "/mostrarLibros")
public class MostrarLibrosServlet extends HttpServlet {
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
        try {
            req.setAttribute("libros",agregarLibrosEjemplo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarLibros.jsp");
        respuesta.forward(req,resp);
    }

    private List agregarLibrosEjemplo() throws ClassNotFoundException {
        List<Libro> libros = new ArrayList<>();
        libros = LibroDAO.obtenerLibros(DBGenerator.conectarBD("LibrosDB"));
        return libros;
    }
}