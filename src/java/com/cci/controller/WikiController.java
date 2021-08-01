/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.controller;

import com.cci.model.Wiki;
import com.cci.service.WikiDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anny Mora
 */
@ManagedBean(name = "wikiController")
@SessionScoped

public class WikiController implements Serializable {

    private List<Wiki> lstContenidosWiki = new ArrayList<>();
    private String tema;
    private String contenido;
    private Wiki wiki = new Wiki();

    public WikiController() {
    }

    public WikiController(String tema, String contenido) {
        this.tema = tema;
        this.contenido = contenido;
    }
    
     @PostConstruct
    public void inicializar() {
        this.cargarContenidos();
    }
    public void cargarContenidos() {
         WikiDao wikidao = new WikiDao();
         this.lstContenidosWiki = wikidao.getAll();
    
    }
    
    public String agregarTema() {
        try {
            Wiki wikidao = new WikiDao().agregarWiki(wiki);
            Wiki wiki = new Wiki(this.wiki.getNombreTema(), this.wiki.getDescripcionTema());
           
            this.cargarContenidos();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }finally{
            this.cargarContenidos();
        }
        return "Wiki";
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    public List<Wiki> getLstContenidosWiki() {
        return lstContenidosWiki;
    }

    public void setLstContenidosWiki(List<Wiki> lstContenidosWiki) {
        this.lstContenidosWiki = lstContenidosWiki;
    }

}
