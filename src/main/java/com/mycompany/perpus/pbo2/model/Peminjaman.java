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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Peminjaman {
    private int id;
    private String tanggal;
    private Pengguna pengguna;
    private String status;
    
    private Database database;
    private Connection connection;
    
    
    public boolean create(){
        return false;
    }

    public boolean update(){
        return false;
    }
    
    public boolean delete(){
        return false;
    }
    
    public ArrayList<Peminjaman> read(){
        ArrayList<Peminjaman> list = new ArrayList<>();
        
        String selectSQL = "SELECT J.*, G.namalengkap FROM peminjaman J\n" +
            "INNER JOIN pengguna G ON J.idpengguna = G.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Peminjaman j = new Peminjaman();
                
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getString("tanggal"));
                j.setStatus(rs.getString("status"));
                
                Pengguna g = new Pengguna();
                g.setId(rs.getInt("idpengguna"));
                g.setNamaLengkap(rs.getString("namalengkap"));
                
                j.setPengguna(g);
                
                list.add(j);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Peminjaman> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Peminjaman> list = new ArrayList<>();
        
        String selectSQL = "SELECT peminjaman.*, pengguna.namalengkap FROM peminjaman \n" +
"INNER JOIN pengguna ON peminjaman.idpengguna = pengguna.id "
                + "WHERE namalengkap like ? OR username like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
 
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Peminjaman j = new Peminjaman();
                
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getString("tanggal"));
                j.setStatus(rs.getString("status"));
                
                Pengguna g = new Pengguna();
                g.setId(rs.getInt("idpengguna"));
                g.setNamaLengkap(rs.getString("namalengkap"));
                
                j.setPengguna(g);
                
                list.add(j);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
