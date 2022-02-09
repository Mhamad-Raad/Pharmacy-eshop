/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ip;


import model.User;
import static com.mycompany.ip.Save.id;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class AddMed extends HttpServlet {
static int id = 0;  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try (PrintWriter out = response.getWriter()) {
              
              HttpSession session=request.getSession(); 
               if(session.getAttribute("id") != null)
             id = (int)session.getAttribute("id");
            
               else
                     session.setAttribute("id", id);
                  
          
            
        
          String mname = request.getParameter("mname");
          double price =Double.parseDouble(request.getParameter("price"));
          String manf = request.getParameter("manf");
          String exp = request.getParameter("exp"); 
          String description = request.getParameter("description");
          int quantity = Integer.parseInt(request.getParameter("quantity"));
          User user =(User)session.getAttribute("user"); out.print(id);
           out.print(id);
           session.removeAttribute("id");
           id ++;
             
           session.setAttribute("id", id);
           session.setMaxInactiveInterval(60*60*24*30*12);
           
           
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";

       
        Class.forName(driver);
       
             
           Connection cn = DriverManager.getConnection(url,dbnamee,dbpass); 
           Statement stmt = cn.createStatement();
           String q = "insert into medicine values('" +mname + "',"+ price +","+quantity+",'"+exp+"','" + description + "',"+id+","+user.getId()+",'"+manf  + "')";
            stmt.executeUpdate(q);
            
            response.sendRedirect("success.jsp");
            
         
        } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AddMed.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }

  
}
