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
import java.util.ArrayList;
/**
 *
 * @author lenovo
 */
public class JenisBuku {
    
    private int id;
    private String namaJenisBuku;
    
    public Database database;
    public Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJenisBuku() {
        return namaJenisBuku;
    }

    public void setNamaJenisBuku(String namaJenisBuku) {
        this.namaJenisBuku = namaJenisBuku;
    }
    
    
    public boolean create(){
        String insertSQL = "INSERT INTO jenisbuku VALUES (NULL,?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getNamaJenisBuku());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE jenisbuku SET namajenisbuku = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getNamaJenisBuku());
            ps.setInt(2, this.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM jenisbuku WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setInt(1, this.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public ArrayList<JenisBuku> read(){
        String selectSQL = "SELECT * FROM jenisbuku";
        ArrayList<JenisBuku> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                JenisBuku jb = new JenisBuku();
                jb.setId(rs.getInt(1));
                jb.setNamaJenisBuku(rs.getString(2));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    }
    
    public ArrayList<JenisBuku> search(String keywords){
        String searchSQL = "SELECT * FROM jenisbuku WHERE namajenisbuku like ?";
        ArrayList<JenisBuku> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        keywords = "%" + keywords + "%";
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ps.setString(1, keywords);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                JenisBuku jb = new JenisBuku();
                jb.setId(rs.getInt(1));
                jb.setNamaJenisBuku(rs.getString(2));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    }

    
    
}
