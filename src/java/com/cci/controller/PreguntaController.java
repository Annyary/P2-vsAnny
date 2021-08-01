package com.cci.controller;

import com.cci.model.Pregunta;
import com.cci.service.PreguntaDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "preguntaController")
@SessionScoped
public class PreguntaController implements Serializable {

    private List<Pregunta> listaPreguntasData = new ArrayList<>();
    private Date fecha;
    private String info;
    private Pregunta pregunta = new Pregunta();

    public PreguntaController() {
    }

    public PreguntaController(Date fecha, String info) {
        this.fecha = fecha;
        this.info = info;
    }
    
    @PostConstruct
    public void inicializar() {
        this.cargarPreguntas();
    }

    public void cargarPreguntas() {
        PreguntaDao preguntad = new PreguntaDao();
        this.listaPreguntasData = preguntad.getAll();

    }

//    public String RealizarPregunta() {
//        try {
//            PreguntaDao preguntadao = new PreguntaDao();
//            Pregunta pregunta = new Pregunta(this.pregunta.getInfo(), new Date(), this.pregunta.getTags());
//            preguntadao.insert(pregunta);
//            this.cargarPreguntas();
//
//        } catch (NullPointerException ex) {
//            ex.printStackTrace();
//        }
//        return "Foro";
//    }
   
   
    public String agregarPreg() {
        try {
            
            Pregunta pregunta = new Pregunta(this.pregunta.getInfo(), new Date());
            Pregunta pregdao = new PreguntaDao().agregarPreguntas(pregunta);
            
            this.cargarPreguntas();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return "Pregunta";
    }

//    public void preguntasRegistradas() {
//
//        try {
//            Pregunta preguntaDao = new PreguntaDao().imprimirPregunta();
//
//            if (preguntaDao != null) {
//                pregunta.setInfo(preguntaDao.getInfo());
//                pregunta.setTags(preguntaDao.getTags());
//                pregunta.setFecha(preguntaDao.getFecha());
//            } else {
//
//            }
//        } catch (NullPointerException nul) {
//
//        }
//
//    }
    public List<Pregunta> getListaPreguntasData() {
        return listaPreguntasData;
    }

    public void setListaPreguntasData(List<Pregunta> listaPreguntasData) {
        this.listaPreguntasData = listaPreguntasData;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
