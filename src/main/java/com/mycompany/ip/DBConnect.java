/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hamar
 */
public class DBConnect {
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";
        
       public DBConnect(){
        driver= "com.mysql.jdbc.Driver";
        dbname = "ip";
        url = "jdbc:mysql://localhost/"+dbname+"?";
        dbnamee="root";
        dbpass="";    
        }
       
       void connect() throws ClassNotFoundException, SQLException{
            Class.forName(driver);
        
             
             Connection cn =  DriverManager.getConnection(url,dbnamee,dbpass);
             Statement st = cn.createStatement();
       }
       
        
}
