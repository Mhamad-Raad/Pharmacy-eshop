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
public class bCnfrm extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BConfirmm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BConfirmm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try (PrintWriter out = response.getWriter()) {
            
            int id = Integer.parseInt( request.getParameter("id"));
            
        String driver= "com.mysql.jdbc.Driver";
        String dbname = "ip";
        String url = "jdbc:mysql://localhost/"+dbname+"?";
        String dbnamee="root";
        String dbpass="";
      
       
        Class.forName(driver);
        
             
             Connection cn = DriverManager.getConnection(url,dbnamee,dbpass);
             Statement st = cn.createStatement();
             
            String q = "select * from medicine where id = "+id ;
            ResultSet rs = st.executeQuery(q);
            
            
            Medicine medicine = new Medicine();
            while(rs.next()){
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                medicine.setdescription(rs.getString("description"));
            }
      
            HttpSession session=request.getSession(); 
            session.removeAttribute("medicine");
            session.setAttribute("medicine", medicine);
            
          response.sendRedirect("confirm.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(bCnfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
