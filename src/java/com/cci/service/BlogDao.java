///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.cci.service;
//
//import com.cci.model.Blog;
//import com.cci.model.Wiki;
//import java.util.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Usuario
// */
//public class BlogDao extends Servicio implements IDao<Blog> {
//
//    @Override
//    public List<Blog> getAll() {
//        ResultSet rs = null;
//        Statement stmt = null;
//        List<Blog> lista = new ArrayList<>();
//
//        try {
//            this.conectar();
//            //STEP 3: Execute a query
//            stmt = conn.createStatement();
//            String sql = "SELECT * FROM blog";
//            rs = stmt.executeQuery(sql);
//
//            //STEP 3.1: Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name      
//                int id = rs.getInt("id");
//                String titulo = rs.getString("titulo");
//                String autor = rs.getString("autor");
//                String contenido = rs.getString("contenido");
//                Date fecha = rs.getDate("fecha");
//                
//                Blog blog = new Blog(id, autor, titulo, contenido, (Timestamp) fecha);
//                lista.add(blog);
//            }
//        } catch (Exception ex) {
//            System.out.println("No se puedo realizar la consulta de usuarios...");
//        } finally {
//            try {
//                if (!stmt.isClosed()) {
//                    stmt.close();
//                }
//                if (!rs.isClosed()) {
//                    rs.close();
//                }
//                this.desconectar();
//            } catch (SQLException ex) {
//                Logger.getLogger(Wiki.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        return lista;
//    }
//
//    @Override
//    public void insert(Blog data) {
//        ResultSet rs = null;
//        PreparedStatement stmt = null;
//        try {
//
//            this.conectar();
//            String sql = ("INSERT INTO blog(id, autor, titulo, contenido, fecha) VALUES (?,?,?,?,?)");
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, data.getId());
//            stmt.setString(2, data.getAutor());
//            stmt.setString(3, data.getTitulo());
//            stmt.setString(4, data.getContenido());
//            stmt.setDate(5, new java.sql.Date(data.getFecha().getTime()));
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("Error: No se puedo agregar");
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (!stmt.isClosed()) {
//                    stmt.close();
//                }
//                if (!rs.isClosed()) {
//                    rs.close();
//                }
//                this.desconectar();
//            } catch (SQLException ex) {
//                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }
//
//    @Override
//    public void delete(Blog data) {
//        ResultSet rs = null;
//        Statement stmt = null;
//
//        try {
//            this.conectar();
//            //STEP 3: Execute a query
//            stmt = conn.createStatement();
//            String sql = "DELETE FROM wiki where idTema =" + data.idTema + "'";
//            rs = stmt.executeQuery(sql);
//
//            //STEP 3.1: Extract data from result set
//        } catch (Exception ex) {
//            System.out.println("No se puedo realizar la consulta del Wiki...");
//        } finally {
//            try {
//                if (!stmt.isClosed()) {
//                    stmt.close();
//                }
//                if (!rs.isClosed()) {
//                    rs.close();
//                }
//                this.desconectar();
//            } catch (SQLException ex) {
//                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//    }
//
//    @Override
//    public void update(Blog data) {
//        
//    }
//    
//    
//    public Blog agregarBlog(Blog blog){
//         ResultSet rs = null;
//        PreparedStatement stmt = null;
//        try {
//
//            this.conectar();
//            String sql = ("INSERT INTO wiki(nombreTema, descripcionTema) VALUES (?,?)");
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, blog.getNombreTema());
//            stmt.setString(2, blog.getDescripcionTema());
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("Error: No se puedo agregar");
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (!stmt.isClosed()) {
//                    stmt.close();
//                }
//                if (!rs.isClosed()) {
//                    rs.close();
//                }
//                this.desconectar();
//            } catch (SQLException ex) {
//                Logger.getLogger(WikiDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return blog;
//    }
//}
