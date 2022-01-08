/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.perpus.pbo2.libs;
import java.util.prefs.Preferences;
import com.mycompany.perpus.pbo2.model.Pengguna;


/**
 *
 * @author lenovo
 */
public class Pref {
    
    public void reset(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        pref.put("username", "");
        pref.putInt("id", 0);
        pref.putBoolean("isAdmin", false);
    }
    
    public void save(String username, int id, boolean isAdmin){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        pref.put("username", username);
        pref.putInt("id", id);
        pref.putBoolean("isAdmin", isAdmin);
    }
    
    public String getUsername(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        return pref.get("username", "");
    }
    
    public boolean isAdmin(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        return pref.getBoolean("isAdmin", false);
    }
        public void hapus(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        preferences.putInt("id", 0);
        preferences.put("username", "");
        preferences.put("nama_lengkap", "");
        preferences.putBoolean("is_admin", false);
    }
        public Pengguna ambil(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        
        Pengguna pengguna = new Pengguna();
        
        pengguna.setId(preferences.getInt("id",0));
        pengguna.setUsername(preferences.get("username", ""));
        pengguna.setNamaLengkap(preferences.get("nama_lengkap", ""));
        pengguna.setIsAdmin(preferences.getBoolean("is_admin", false));
        
        return pengguna;
        
    }
}
