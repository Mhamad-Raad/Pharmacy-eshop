/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;

import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
            
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";
       boolean found = false;
       
        Class.forName(driver);
       
             
             Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
             Statement st = cn.createStatement();
             
           
              User user = new User();
              
              user.setPassword(request.getParameter("password"));
              user.setEmail(request.getParameter("email"));
              
      
       
             String q = "select * from user"; 
             ResultSet rs = st.executeQuery(q);
             HttpSession session=request.getSession(); 
             
             while(rs.next()){
                 if( user.getEmail().equals(rs.getString("email")) &&
                         user.getPassword().equals(rs.getString("password")) ){
                         
                     
                         found = true;
                         
                         user.setName(rs.getString("name"));
                         user.setGender(rs.getString("gender"));
                         user.setType(rs.getString("usertype"));
                         user.setCity  (rs.getString("city"));
                         user.setAddress(rs.getString("address"));
                         user.setId(rs.getInt("id"));
                         
                         session.removeAttribute("user");
                         
                         session.setAttribute("user", user);
                         session.setMaxInactiveInterval(60*60*24*30*12);
                         

                       RequestDispatcher req=request.getRequestDispatcher("profile.jsp");
                       req.include(request, response);
                     
                    
                 }
             }
             
             if( found != true){
                    RequestDispatcher req=request.getRequestDispatcher("index.html");
                    req.include(request, response);
                    out.println("<div class='return main'><p>email or password is incorrect</p>");
             }
             
             
             
             
       
       
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
