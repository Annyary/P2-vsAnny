/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.controller;

import com.cci.model.Usuario;
import com.cci.service.UsuarioDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Bernal Fernandez B. at CCI CONSULTORES INFORMATICOS
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Usuario usuario = new Usuario();
    private boolean logeado = false;

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        Usuario usuarioDao = new UsuarioDao().verificarUsuario(this.getUsuario().getCorreo(), this.getUsuario().getContrasenna());

        if (usuarioDao != null) {
            logeado = true;
            usuario.setId(usuarioDao.getId());
            usuario.setNombre(usuarioDao.getNombre());
            usuario.setPrimerApellido(usuarioDao.getPrimerApellido());
            usuario.setSegundoApellido(usuarioDao.getSegundoApellido());
            usuario.setFechaNacimiento(usuarioDao.getFechaNacimiento());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuarioDao.getNombreCompleto());
        } else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no validas");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", logeado);
        // context.addCallbackParam("nombre", usuarioDao.getNombre());
        if (logeado) {
            //context.addCallbackParam("view", "pf/gauge.xhtml");
            context.addCallbackParam("view", "faces/bienvenida.xhtml");
        }
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
            logeado = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void redirect(String url) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            + "/faces/" + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrar() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = new Usuario(this.usuario.getCorreo(), this.usuario.getContrasenna(), this.usuario.getId(), this.usuario.getNombre(), this.usuario.getPrimerApellido(), this.usuario.getSegundoApellido(), this.usuario.getFechaNacimiento());
            usuarioDao.insert(usuario);
        } catch (NullPointerException nul) {

        }
        return "login";

    }
    public void salir(){
        try{
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
            
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            +"/faces/index.xhtml?faces-redirect=true");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
