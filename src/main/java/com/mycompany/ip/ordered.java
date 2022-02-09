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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hamar
 */
public class ordered extends HttpServlet {

   String name;
            String description;
            int quantity =1;
            int ownerid;
            static int  orderid =0;

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
              User user = (User) session.getAttribute("user");
             
             Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
             Statement st = cn.createStatement();
             int id = Integer.parseInt(request.getParameter("id"));
             
            String q = "select * from medicine where id = "+id ;
            ResultSet rs = st.executeQuery(q);
            
            

            while(rs.next()){
                name = rs.getString("name");
                description = rs.getString("description");
                ownerid = rs.getInt("ownerid");
                int idd = rs.getInt("id");
            }
           
    orderid ++;
    session.removeAttribute("orderid");
    session.removeAttribute("name");
    session.removeAttribute("description");
    session.removeAttribute("ownerid");
    session.setAttribute("orderid", orderid);
    session.setAttribute("name", name);
    session.setAttribute("d", description);
    session.setAttribute("ownerid", ownerid);
    



          
      response.sendRedirect("insertp");
           
           
           
            
       
             
             
             
             
             
             
             
             
        
            
            
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ordered.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
   

}
