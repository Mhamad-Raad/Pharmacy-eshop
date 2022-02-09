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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author hamar
 */
public class bNotify extends HttpServlet {

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
        boolean pharmacist = false;

        Class.forName(driver);
       
        Connection cn = DriverManager.getConnection(url,dbnamee,dbpass); 
        Statement stmt = cn.createStatement();

        String q;
            if(user.getType().equals("Pharmacist")){
                pharmacist = true;
                q = "select * from pnot where pid =" + user.getId();
              
                
            }
            else{
         
                q =  "select * from cnot where ownerid = "+user.getId();
            }
            
          ResultSet rs = stmt.executeQuery(q);
        out.print(user.getId());
           ArrayList<Pid> plist=new ArrayList<>();
           ArrayList<Cid> clist=new ArrayList<>();
          while(rs.next()){ 
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("mid"));
                medicine.setName(rs.getString("mname"));
                medicine.setdescription(rs.getString("mdescription"));
                
                
                
              if(pharmacist == true){
                  Pid pid = new Pid(medicine, user.getName(), user.getId(),rs.getInt("orderid"));
                    plist.add(pid);
                    session.removeAttribute("plist");
                    session.setAttribute("plist", plist);
              }
              
              else{
                  Cid cid = new Cid(medicine, rs.getString("status"), user.getId(), rs.getInt("orderid"));
                  clist.add(cid);
                  session.removeAttribute("clist");
                  session.setAttribute("clist", clist);
                  clist.get(0).getOid();
              }
          }
         
          response.sendRedirect("notify.jsp");
          
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(bNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   

}
