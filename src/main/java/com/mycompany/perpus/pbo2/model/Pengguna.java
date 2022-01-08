/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.perpus.pbo2.model;

import com.mycompany.perpus.pbo2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Pengguna {
    
   private int id;
   private String username;
   private String password;
   private String namaLengkap;
   private boolean isAdmin;
   
   private Connection connection;
   private Database database;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
   
    public boolean login(){
        String loginSql = "SELECT * FROM pengguna WHERE username = ? AND password = MD5(?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       try {
           PreparedStatement preparedStatement = this.connection.prepareStatement(loginSql);
           preparedStatement.setString(1,this.username);
           preparedStatement.setString(2,this.password);
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while(resultSet.next()){
               this.id = resultSet.getInt(1);
               this.username = resultSet.getString(2);
               this.namaLengkap = resultSet.getString(4);
               this.isAdmin = resultSet.getBoolean(5);
               return true;
           }
       } catch (SQLException ex) {
           Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return false;
    }
    
}
