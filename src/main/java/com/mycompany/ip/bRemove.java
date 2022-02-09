/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;

import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Medicine;

/**
 *
 * @author hamar
 */
public class bRemove extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        HttpSession session=request.getSession(); 
        User user = (User) session.getAttribute("user");
        
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";
      
       
        Class.forName(driver);
        
             
        Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
        Statement st = cn.createStatement();
       
         
        String q = "select * from medicine where ownerid = " +user.getId();
        ResultSet rs = st.executeQuery(q);
         out.print("fuk;");
       ArrayList<Medicine> list=new ArrayList<Medicine>();
       Medicine medicine = new Medicine();
       while(rs.next()){
           medicine.setId(rs.getInt("id"));
           medicine.setName(rs.getString("name"));
           medicine.setdescription(rs.getString("description"));
           
           list.add(medicine);
       }
       
       session.removeAttribute("mlist");
       session.setAttribute("mlist", list);
        
          response.sendRedirect("remove.jsp");
          
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(bRemove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
}
