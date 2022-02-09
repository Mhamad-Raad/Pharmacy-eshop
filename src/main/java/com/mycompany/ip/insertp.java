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
public class insertp extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            
            
            
            
       
          
            HttpSession session=request.getSession(); 
            
              User user = (User) session.getAttribute("user");
              Medicine m = (Medicine) session.getAttribute("medicine");
              
              
              
              
              String name = (String)session.getAttribute("name");
              String description = (String)session.getAttribute("d");
              int ownerid = (int) session.getAttribute("ownerid");
              int orderid = (int) session.getAttribute("orderid");
                
              
              
              
              
              
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";
      
       
        Class.forName(driver);
        
      
             
        Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
         PreparedStatement ps=cn.prepareStatement("insert into pnot values(?,?,?,?,?,?,?)");  
  
               ps.setString(1,name);       
               ps.setInt(2,m.getId());  
               ps.setInt(3,1);  out.print(user.getName());
               ps.setString(4, user.getName());
               ps.setInt(5,ownerid);  
               ps.setString(6,description);  
               ps.setInt(7,orderid);  
  
                ps.executeUpdate();  
              

       
          
           

                
          
        response.sendRedirect("insertc");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(insertp.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
