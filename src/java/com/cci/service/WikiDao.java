/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Wiki;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class WikiDao extends Servicio implements IDao<Wiki> {

    @Override
    public List<Wiki> getAll() {
        ResultSet rs = null;
        Statement stmt = null;
        List<Wiki> lista = new ArrayList<>();

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM wiki";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name      
                int idTema = rs.getInt("idTema");
                String nombreTema = rs.getString("nombreTema");
                String descripcionTema = rs.getString("descripcionTema");
                
                Wiki wiki = new Wiki(nombreTema, descripcionTema, idTema);
                lista.add(wiki);
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
                Logger.getLogger(Wiki.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }

    @Override
    public void insert(Wiki data) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO wiki(nombreTema, descripcionTema) VALUES (?,?)");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, data.getNombreTema());
            stmt.setString(2, data.getDescripcionTema());
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
                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void delete(Wiki data) {
        ResultSet rs = null;
        Statement stmt = null;

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "DELETE FROM wiki where idTema =" + data.idTema + "'";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
        } catch (Exception ex) {
            System.out.println("No se puedo realizar la consulta del Wiki...");
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
    public void update(Wiki data) {
        
    }
    
    
    public Wiki agregarWiki(Wiki wiki){
         ResultSet rs = null;
        PreparedStatement stmt = null;
        try {

            this.conectar();
            String sql = ("INSERT INTO wiki(nombreTema, descripcionTema) VALUES (?,?)");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, wiki.getNombreTema());
            stmt.setString(2, wiki.getDescripcionTema());
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
                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return wiki;
    }
}
