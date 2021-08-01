/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import com.cci.model.Biblioteca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class ServicioBiblioteca extends Servicio {

    public void agregarArchivo(Biblioteca b) {
  ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
           
            String sql;
            sql = "INSERT INTO biblioteca (idbiblioteca,extension,nombre,path)  VALUES (?,?,?,?);";
            stmt = conn.prepareStatement(sql);
           
            stmt.setInt(1, b.getId());
            stmt.setString(2, b.getExtension());
           stmt.setString(3, b.getNombre());
           stmt.setString(4, b.getPathArchivo());
            

            stmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("No se pudo subir el documento..");
        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }

                if (!stmt.isClosed()) {
                    stmt.close();
                }

                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("\nNo pude cerrar...");
            }
        }
    }

    public List<Biblioteca> obtenerListaDocumentos() {

        List<Biblioteca> lista = new ArrayList();
        ResultSet rs = null;
        Statement stmt = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
stmt= conn.createStatement();
            String sql;
            sql = "SELECT * FROM biblioteca";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String pathArchivo = rs.getString("path");
                String extension = rs.getString("extension");
                Biblioteca b = new Biblioteca(id, nombre, pathArchivo, extension);
                lista.add(b);
            }
        } catch (Exception ex) {
            System.out.println("No se puedo realizar la consulta de Archivos...");
        } finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("No pude cerrar...");
            }
        }
        return lista;
    }
}