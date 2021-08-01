/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.controller;

import com.cci.model.Usuario;
import com.cci.service.UsuarioDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "recuperacionController")
@SessionScoped

public class RecuperacionController implements Serializable {
     private String correo;
    private String contrasenna;
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int fechaNacimiento;
   private String nombreCompleto;
   private String auxpass;
   Usuario usuario = new Usuario();
private String veriCodigo , Codigo;
private String user;
   
   public RecuperacionController()
   {}   
   
    /**
     *
     * @return
     * @throws EmailException
     */
    public String emailNuevaContrasena() throws EmailException {
        //credentials for email and email account

        veriCodigo = Integer.toString(((int) (Math.random() * ((9999 - 1010) + 1))));

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("whateverbum04@gmail.com", "corales1"));
        email.setSSLOnConnect(true);
        email.setFrom("whateverbum04@gmail.com");
        email.setSubject("Restablecer Contrasena");
        email.setMsg("Su codigo de verificacion es: " + veriCodigo + " y expirará en 2 horas (not really...).\n");
        email.addTo(this.correo);
        email.send();
        return "NuevaContrasena";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAuxpass() {
        return auxpass;
    }

    public void setAuxpass(String auxpass) {
        this.auxpass = auxpass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getVeriCodigo() {
        return veriCodigo;
    }

    public void setVeriCodigo(String veriCodigo) {
        this.veriCodigo = veriCodigo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}