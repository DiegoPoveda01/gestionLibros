package com.gestion.gestionlibros.model;

public class Libro {
    private String nombre;
    private String editorial;
    private String categoria;
    private int año;
    private String tipo;
    public Libro(String nombre, String editorial, String categoria, int año, String tipo) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.categoria = categoria;
        this.año = año;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", editorial='" + editorial + '\'' +
                ", categoria='" + categoria + '\'' +
                ", año=" + año +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}

