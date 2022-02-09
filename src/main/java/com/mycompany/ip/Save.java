/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;

import model.User;
import static com.mycompany.ip.AddMed.id;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hamar
 */
public class Save extends HttpServlet {

    static int id = 0;  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
                  
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";

       
        Class.forName(driver);
         HttpSession session=request.getSession(); 
             
             Connection cn = DriverManager.getConnection(url,dbnamee,dbpass); 
            
        if(session.getAttribute("uid") != null)
             id = (int)session.getAttribute("uid");
            
               else
                     session.setAttribute("uid", id);
             
             
             User user;
            user = new User();
               
            user.setName(request.getParameter("fname") + " " + request.getParameter("lname"));
            user.setAddress(request.getParameter("address"));
            user.setType(request.getParameter("usertype"));
            user.setCity(request.getParameter("city"));
            user.setGender(request.getParameter("gender"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            id ++;
            user.setId(id);
            
            
            String a = "select * from user";
          
            
            Statement stmt = cn.createStatement();
             
            
               
            
            String q1 = "insert into user values('" +user.getName()+ "', '" +user.getPassword()+ "', '" +user.getGender()+
                    "', '" +user.getType()+  "', '" +user.getCity()+ "', '" +user.getAddress()+ "', '" +user.getEmail()+"',"+id+")";
            stmt.executeUpdate(q1);
             
     
            
               
               
               session.removeAttribute("user");
               session.setAttribute("user", user);
               session.removeAttribute("uid");
           
          
           session.setAttribute("uid", id);
           session.setMaxInactiveInterval(60*60*24*30*12);
               
               response.sendRedirect("profile.jsp");
               
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

 }



  
