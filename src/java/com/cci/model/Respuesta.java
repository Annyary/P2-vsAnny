package com.cci.model;

import java.util.Date;

public class Respuesta {

    private int id;
    private String info;
    private Date fecha;

    public Respuesta() {
    }

    public Respuesta(int id, String info, Date fecha) {
        this.id = id;
        this.info = info;
        this.fecha = fecha;
    }

    public Respuesta(String info, Date fecha) {
        this.info = info;
        this.fecha = fecha;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
