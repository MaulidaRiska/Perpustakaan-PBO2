/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.perpus.pbo2;
import com.mycompany.perpus.pbo2.libs.Pref;
import com.mycompany.perpus.pbo2.model.Buku;
import com.mycompany.perpus.pbo2.model.JenisBuku;
import com.mycompany.perpus.pbo2.model.Pengguna;
import com.mycompany.perpus.pbo2.frame.Login;
import com.mycompany.perpus.pbo2.frame.MainPublic;
import com.mycompany.perpus.pbo2.frame.admin.BukuViewFrame;
import com.mycompany.perpus.pbo2.frame.admin.JenisBukuViewFrame;
import com.mycompany.perpus.pbo2.frame.admin.MainAdmin;
import com.mycompany.perpus.pbo2.frame.psutakawan.MainPustakawan;
import java.util.ArrayList;
import javax.swing.JOptionPane;




/**
 *
 * @author lenovo
 */
public class Main {
    
      public static void main(String[] args) {
     
        
        Pref pref = new Pref();
        
        String username = pref.getUsername();
        
        if(username.equals("")){
            Login login = new Login();
            login.setVisible(true);
        } else {
            if (pref.isAdmin()){
                MainAdmin mainAdmin = new MainAdmin();
                mainAdmin.setVisible(true);
            } else {
                MainPustakawan mainPustakawan = new MainPustakawan();
                mainPustakawan.setVisible(true);
            }
            
        }
                
        
    }
}
