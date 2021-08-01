package com.cci.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pregunta implements Serializable {

    int id;
    String info;
    Date fecha;
    String tags;
    
    
    public Pregunta() {
    }

    public Pregunta(String info, Date fecha) {
        this.info = info;
        this.fecha = fecha;
    }

    public Pregunta(int id, String info, Date fecha, String tags) {
        this.id = id;
        this.info = info;
        this.fecha = fecha;
        this.tags = tags;
    }

    public Pregunta(int id, String info, Date fecha) {
        this.id = id;
        this.info = info;
        this.fecha = fecha;
    }

    
    public Pregunta( String info, Date fecha, String tags) {
        this.info = info;
        this.fecha = fecha;
        this.tags = tags;
    }

    public Pregunta(String infoBase, String tagsbase, java.util.Date fechabase) {
    }

    public Pregunta(int id, int idUsuario, int idTema, String info) {
    }

  
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


}
