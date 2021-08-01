/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Pregunta;
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
public class PreguntaDao extends Servicio implements IDao<Pregunta> {

    @Override
    public List<Pregunta> getAll() {
        ResultSet rs = null;
        Statement stmt = null;
        List<Pregunta> lista = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pregunta";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name      
                String info = rs.getString("info");
                Date fecha = rs.getDate("fecha");
                Pregunta gunta = new Pregunta(info, fecha);
                lista.add(gunta);
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
                Logger.getLogger(Pregunta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }

    @Override
    public void insert(Pregunta data) {
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO pregunta(info, fecha, tags) VALUES (?,?,?)");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, data.getInfo());
            stmt.setDate(2, new java.sql.Date(data.getFecha().getTime()));
            stmt.setString(3, data.getTags());
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

    }

    @Override
    public void delete(Pregunta data) {
    }

    @Override
    public void update(Pregunta data) {
    }

    public Pregunta imprimirPregunta() {
        ResultSet rs = null;
        Statement stmt = null;
        Pregunta pregunta = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pregunta"; 
            rs = stmt.getGeneratedKeys();

            //STEP 3.1: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                String info= rs.getString("info");
                String tags= rs.getString("tags");
                Date fecha= rs.getDate("fecha");
                Pregunta pregunta2 = new Pregunta(info, tags, fecha);
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
        return pregunta;
    }
    
    public Pregunta agregarPreguntas(Pregunta preg){
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO pregunta(info, fecha, tags) VALUES (?,?,?)");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, preg.getInfo());
            stmt.setDate(2, new java.sql.Date(preg.getFecha().getTime()));
            stmt.setString(3, preg.getTags());
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
        return preg;
    }
    
    public List<Pregunta> verListaPreguntas() {
        ResultSet rs = null;
        Statement stmt = null;
        List<Pregunta> listaP = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pregunta";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name      
                String info = rs.getString("info");
                Date fecha = rs.getTimestamp("fecha");
                Pregunta gunta = new Pregunta(info, fecha);
                listaP.add(gunta);
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
                Logger.getLogger(Pregunta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaP;
    }
}
