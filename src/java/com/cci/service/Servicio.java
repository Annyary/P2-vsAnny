/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anny Mora
 */
public abstract class Servicio {

    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/proyecto2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//  Database credentials
    String USER = "root";
    String PASS = "";
    Connection conn = null;
    protected PreparedStatement paInsertar;
    protected Statement stmt = null;

    
  
    
    public void conectar() {

        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se puedo registrar el driver...");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se puedo conectar...");
        }
    }


    public void desconectar() {
        try {           
            if (!conn.isClosed()) {
                conn.close();
            }

        } catch (Exception ex) {
            System.out.println("No se pudo desconectar");
        }
    }

    public void demeConexion() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        if (conn != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Desconectado");
        }
    }
}
