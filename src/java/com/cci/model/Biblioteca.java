package com.cci.model;

/**
 *
 * @author Anny Mora
 */
public class Biblioteca {

    private int id;
    private String nombre;    
    private String pathArchivo;
    private String extension;

    public Biblioteca(int id, String nombre, String pathArchivo, String extension) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    public Biblioteca() {
    }

}