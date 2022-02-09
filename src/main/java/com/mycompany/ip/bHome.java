/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import model.Medicine;

/**
 *
 * @author hamar
 */
public class bHome extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
      Class.forName ("com.mysql.jdbc.Driver");
       
        
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ip?", "root","");
      
      Statement st = con.createStatement();
      
      
    
    
      
      String sql = "select * from medicine";

      ResultSet rs= st.executeQuery(sql);
      
      
        ArrayList<Medicine> list=new ArrayList<Medicine>();
         
          
          while(rs.next()){
           
           Medicine medicine = new Medicine();
           medicine.setId(rs.getInt("id"));
           medicine.setName(rs.getString("name"));
           medicine.setdescription(rs.getString("description"));
           medicine.setQuantity(rs.getInt("quantity"));
           medicine.setPrice(rs.getDouble("price"));
           medicine.setExp(rs.getString("expired"));
         
           list.add(medicine);
          }
          
            HttpSession session=request.getSession(); 
            session.removeAttribute("hlist");
            session.setAttribute("hlist", list);
            
            response.sendRedirect("home.jsp");
     
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(bRemove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
