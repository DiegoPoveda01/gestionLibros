package com.gestion.gestionlibros.model.data.dao;

import com.gestion.gestionlibros.model.Libro;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class LibroDAO {
    public static void agregarLibro(DSLContext query, Libro libro){
        Table tablaLibro= table(name("Libros"));
        Field[] columnas = tablaLibro.fields("nombre","editorial","categoria","año","tipo");
        query.insertInto(tablaLibro, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(libro.getNombre(),libro.getEditorial(),libro.getCategoria(),libro.getAño(),libro.getTipo())
                .execute();
    }
    public static void modificarLibro(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Libros")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre").eq(nombre)).execute();
    }
    public static List obtenerLibro(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Libros")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaLibros(resultados);
    }
    public static List<Libro> obtenerLibros(DSLContext query) {
        Result<Record> resultados = query.select().from(DSL.table("Libros")).fetch();

        return obtenerListaLibros(resultados);
    }
    public static boolean eliminarLibro(DSLContext query, Libro libro) {
        String nombreLibro=libro.getNombre();
        int result=0;
        try{
            result=query.deleteFrom(
                            DSL.table("Libros"))
                    .where(DSL.field("nombre").eq(nombreLibro))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result==1;
    }
    private static List<Libro> obtenerListaLibros(Result<Record> resultados) {
        List<Libro> libros = new ArrayList<>();

        for (Record record : resultados) {
            String nombre = record.getValue(DSL.field("nombre", String.class));
            String editorial = record.getValue(DSL.field("editorial", String.class));
            String categoria = record.getValue(DSL.field("categoria", String.class));
            int año = record.getValue(DSL.field("año", Integer.class));
            String tipo = record.getValue(DSL.field("tipo_libro", String.class));

            libros.add(new Libro(nombre, editorial, categoria, año, tipo));
        }

        return libros;
    }
    }

