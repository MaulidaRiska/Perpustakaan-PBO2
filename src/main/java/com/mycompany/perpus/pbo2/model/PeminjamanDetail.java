/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.perpus.pbo2.model;

import com.mycompany.perpus.pbo2.db.Database;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class PeminjamanDetail {
    private int id;
    private Peminjaman peminjaman;
    private Buku buku;
    private double hargaPimjam;
    private int jumlah;
    
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
    
    public ArrayList<PeminjamanDetail> read(){
        return null;
    }
    
    public ArrayList<PeminjamanDetail> search(String keywords){
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku barang) {
        this.buku = buku;
    }

    public double getHargaPeminjaman() {
        return hargaPimjam;
    }

    public void setHargaPeminjaman(double hargaPeminjaman) {
        this.hargaPimjam = hargaPeminjaman;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
