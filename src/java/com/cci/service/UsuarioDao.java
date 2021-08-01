/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Usuario;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anny Mora
 */
public class UsuarioDao extends Servicio implements IDao<Usuario> {

    @Override
    public List<Usuario> getAll() {

        ResultSet rs = null;
        Statement stmt = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM usuario";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String contrasenna = rs.getString("contraseña");
                String primerApellido = rs.getString("apellido1");
                String segundoApellido = rs.getString("apellido2");
                int id = rs.getInt("id");
                int fechaNcimiento = rs.getInt("fechaNacimiento");
                Usuario usuario = new Usuario(correo, contrasenna, id, nombre, primerApellido, segundoApellido, fechaNcimiento);
                lista.add(usuario);
            }
        } catch (Exception ex) {
            System.out.println("No se puede realizar la consulta de usuarios...");
        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!rs.isClosed()) {
                    rs.close();
                }
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }

    @Override
    public void insert(Usuario data) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO usuario(correo, contraseña, id, nombre, apellido1, apellido2, fechaNacimiento) VALUES (?,?,?,?,?,?,?)");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, data.getCorreo());
            stmt.setString(2, data.getContrasenna());
            stmt.setInt(3, data.getId());
            stmt.setString(4, data.getNombre());
            stmt.setString(5, data.getPrimerApellido());
            stmt.setString(6, data.getSegundoApellido());
            stmt.setInt(7, data.getFechaNacimiento());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: No se puedo agregar");
            e.printStackTrace();

        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!rs.isClosed()) {
                    rs.close();
                }
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void delete(Usuario data) {

    }

    @Override
    public void update(Usuario data) {
    }

    public Usuario verificarUsuario(String correo, String clave) {
        ResultSet rs = null;
        Statement stmt = null;
        Usuario usuario = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM usuario where correo = '" + correo + "' AND contraseña = '" + clave + "'";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                String correobase = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String contrasenna = rs.getString("contraseña");
                String primerApellido = rs.getString("apellido1");
                String segundoApellido = rs.getString("apellido2");
                int id = rs.getInt("id");
                int fechaNcimiento = rs.getInt("fechaNacimiento");
                usuario = new Usuario(correobase, contrasenna, id, nombre, primerApellido, segundoApellido, fechaNcimiento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!rs.isClosed()) {
                    rs.close();
                }
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return usuario;
    }

    public void registrar(String correo, String clave, int id, String nombre, String apellido1, String apellido2, Date fechaNacimiento) {
        ResultSet rs = null;
        Statement stmt = null;
        Usuario usuario = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM usuario where correo = '" + correo + "' AND contraseña = '" + clave + "'AND id'" + id + "'AND nombre'" + nombre + "'AND apellido1'" + apellido1 + "'AND apellido2'" + apellido2 + "'AND fechaNacimiento'" + fechaNacimiento + "'";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                String correobase = rs.getString("correo");
                String nombrebase = rs.getString("nombre");
                String contrasenna = rs.getString("contraseña");
                String primerApellido = rs.getString("apellido1");
                String segundoApellido = rs.getString("apellido2");
                int idbase = rs.getInt("id");
                int fechaNcimiento = rs.getInt("fechaNacimiento");
                usuario = new Usuario(correobase, contrasenna, id, nombre, primerApellido, segundoApellido, fechaNcimiento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!rs.isClosed()) {
                    rs.close();
                }
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException n) {

            }

        }
    }

    public List<Usuario> BuscarUsuario() {

        ResultSet rs = null;
        Statement stmt = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM usuario";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String contrasenna = rs.getString("contraseña");
                String primerApellido = rs.getString("apellido1");
                String segundoApellido = rs.getString("apellido2");
                int id = rs.getInt("id");
                int fechaNcimiento = rs.getInt("fechaNacimiento");
                Usuario usuario = new Usuario(correo, contrasenna, id, nombre, primerApellido, segundoApellido, fechaNcimiento);
                lista.add(usuario);
            }
        } catch (Exception ex) {
            System.out.println("No se puedo realizar la consulta de usuarios...");
        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!rs.isClosed()) {
                    rs.close();
                }
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }
}
