package com.cci.controller;

import com.cci.model.Respuesta;
import com.cci.service.RespuestaDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "respuestaController")
@SessionScoped
public class RespuestaController implements Serializable {

    @ManagedProperty(value = "#{preguntaController}")
    private PreguntaController preguntaController;

    private List<Respuesta> lstRespuestas = new ArrayList<>();
    private String info;
    private Respuesta respuesta = new Respuesta();

    @PostConstruct
    public void inicializar() {
        this.cargarRespuestas();
    }

    public void cargarRespuestas() {
        RespuestaDao respuestadao = new RespuestaDao();
        this.lstRespuestas = respuestadao.getAll();

    }
////EL PROBLEMA ES AQUÍ
    public String RealizarRespuesta() {
        try {
            RespuestaDao servRespuesta = new RespuestaDao();
            Respuesta res = new Respuesta(this.respuesta.getInfo(), new Date());
            servRespuesta.insert(res);
            this.cargarRespuestas();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }finally{
        this.cargarRespuestas();}
        return "Foro";
    }
public String agregarResp() {
        try {
            
            Respuesta respuesta = new Respuesta(this.respuesta.getInfo(), new Date());
            Respuesta respdao = new RespuestaDao().agregarRespuesta(respuesta);
            
            this.cargarRespuestas();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return "Pregunta";
    }

    public void preguntasRegistradas() {

        try {
            Respuesta respuestadao = new RespuestaDao().imprimirRespuesta();

            if (respuestadao != null) {
                respuesta.setInfo(respuestadao.getInfo());
                respuesta.setFecha(respuestadao.getFecha());
                
            } else {

            }
        } catch (NullPointerException nul) {

        }

    }
    
    public RespuestaController() {
    }

    public RespuestaController(String info, int cedula) {
        this.info = info;
    }

    public List<Respuesta> getLstRespuestas() {
        return lstRespuestas;
    }

    public void setLstRespuestas(List<Respuesta> lstRespuestas) {
        this.lstRespuestas = lstRespuestas;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PreguntaController getPreguntaController() {
        return preguntaController;
    }

    public void setPreguntaController(PreguntaController preguntaController) {
        this.preguntaController = preguntaController;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

}
