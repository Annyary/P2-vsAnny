/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Respuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anny Mora
 */
public class RespuestaDao extends Servicio implements IDao<Respuesta> {

    @Override
    public List<Respuesta> getAll() {
        ResultSet rs = null;
        Statement stmt = null;
        List<Respuesta> lista = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM respuesta";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name  
                String info = rs.getString("info");
                Date fecha = rs.getDate("fecha");
                Respuesta respuesta = new Respuesta( info, fecha);
                lista.add(respuesta);
            }
         } catch (Exception ex) {
            System.out.println("No se puedo realizar la consulta del foro...");
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
                Logger.getLogger(Respuesta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    
    }

    @Override
    public void insert(Respuesta data) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO respuesta(info, fecha) VALUES (?,?)");

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, data.getInfo());
            stmt.setDate(2, new java.sql.Date(data.getFecha().getTime()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: No se puedo agregar la respuesta");
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
                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void delete(Respuesta data) {
// ResultSet rs = null;
// Statement stmt = null;
// try { this.conectar();            //STEP 3: Execute a query      stmt = conn.createStatement();
// String sql = "DELETE FROM respuesta where idPregunta =" + data.getIdPregunta() + " AND idUsuarioRespuesta = " + data.getIdUsuarioR() + "AND info = " + data.getInfo() + "AND fecha ='" + data.getFecha() + "'";
// rs = stmt.executeQuery(sql);           //STEP 3.1: Extract data from result set
// } catch (Exception ex) {           System.out.println("No se pudo eliminar");
// } finally {            try {             if (!stmt.isClosed()) {                    stmt.close();
// } if (!rs.isClosed()) {            rs.close();
// } this.desconectar();
// } catch (SQLException ex) {
// Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
// }  }
    }

    @Override
    public void update(Respuesta data) {
    }

    public Respuesta imprimirRespuesta() {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM respuesta";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name                           
                   
                String info = rs.getString("info");
                Date fecha = rs.getDate("fecha");
                Respuesta respuesta = new Respuesta( info, (java.sql.Date) fecha);
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
                Logger.getLogger(PreguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }
public Respuesta agregarRespuesta(Respuesta resp){
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO respuesta(info, fecha) VALUES (?,?");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, resp.getInfo());
            stmt.setDate(2, new java.sql.Date(resp.getFecha().getTime()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: No se puedo agregar la nueva pregunta");
            e.printStackTrace();

        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
               
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
}
