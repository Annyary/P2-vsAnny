/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.model;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Wiki implements Serializable {

    public String nombreTema;

    public String descripcionTema;

    public int idTema;

    public Wiki() {
    }

    public Wiki(String nombreTema, String descripcionTema, int idTema) {
        this.nombreTema = nombreTema;
        this.descripcionTema = descripcionTema;
        this.idTema = idTema;
        
    }

    public Wiki(String nombreTema, String descripcionTema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getDescripcionTema() {
        return descripcionTema;
    }

    public void setDescripcionTema(String descripcionTema) {
        this.descripcionTema = descripcionTema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
}
