/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anny Mora
 */
public class ServicioCorreo extends Servicio implements IDao {

    @Override
    public List getAll() {
        return null;

    }

    @Override
    public void insert(Object data) {
    }

    @Override
    public void delete(Object data) {
    }

    @Override
    public void update(Object data) {

    }

    public Usuario CorreoUsuario(String Correo) {
        List<Usuario> lstUsuario = this.buscarTodos();
        Usuario correoEncontrado = null;
        for (Usuario u : lstUsuario) {
            String correocomp = u.getCorreo();
            if (u.getCorreo().equals(Correo)) {
                correoEncontrado = u;

            }
        }
        return correoEncontrado;
    }

    public List<Usuario> buscarTodos() {
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

    public int actualizarContrasena(String Correo, String Contrasenna) throws SQLException {
        Usuario usuario = null;
        Statement stmt = null;
        int cambiocontrasena = 0;

        try {
            this.conectar();
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE usuario Set contrasena = '" + Contrasenna + "' WHERE correo='" + Correo + "'";
            System.out.println(sql);

            cambiocontrasena = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("no se pudo actualizar la contrasena");

        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }

                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cambiocontrasena;

    }
}
