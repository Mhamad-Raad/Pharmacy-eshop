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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pid;

/**
 *
 * @author hamar
 */
public class BResponse extends HttpServlet {


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
        
             
             
             Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
    
         
              int orderid = Integer.parseInt(request.getParameter("orderid"));
              String  q= "update cnot set status =? where orderid =" +orderid;  
              PreparedStatement statement = cn.prepareStatement(q);
              statement.setString(1, "denied");
              statement.executeUpdate();
                  
              PreparedStatement st = cn.prepareStatement("DELETE FROM `pnot` WHERE orderid = " + orderid);
              
              st.executeUpdate();
              
              HttpSession session=request.getSession(); 
              ArrayList<Pid> plist = (ArrayList)session.getAttribute("plist");
              
              for(int i=0; i<plist.size();i++){
                  if(plist.get(i).getOid() == orderid){
                      plist.remove(i);
                  }
              }
              
              
              
                response.sendRedirect("success.jsp");
       
    }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    



}
