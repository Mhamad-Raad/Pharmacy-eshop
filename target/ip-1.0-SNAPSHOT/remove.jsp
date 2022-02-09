<%-- 
    Document   : remove
    Created on : Jan 10, 2022, 8:23:32 PM
    Author     : hamar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Medicine"%>
<%@page import="model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="medicine" scope="session" class="model.Medicine"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
User user = (User) session.getAttribute("user");
ArrayList<Medicine> list= (ArrayList) session.getAttribute("mlist");
if(user.getType().equals("Pharmacist")){
%>
<%@include file="header.html"%>
<%} else {%>
<%@include file="cheader.html"%>
<%}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        .card{
            
            text-align: center;
            background-color: #71C9CE;;
            margin-left: auto;
            margin-right: auto;
            margin-top:30px;
             margin-bottom:20px;
            
        }
        .space{
            margin-top: 6%;
        }
        
        .container{
            width: 100%;
            background-color: white;
            border-radius: 20px;
   
        }
        
        .card-text{
            margin-left: -20px;
        }
    </style>
   
    <body style="background: #71C9CE;">
        <h3 style ="text-align: center; color: white; margin-top: 5%;">Owned Medicines!</h3>
        <div class="space"></div>
        
        
        
        
              <div class="container">
  <div class="row row-cols-1 row-cols-lg-3 g-1 g-lg-3">
            
        <%
           for(int i=0; i<list.size();i++){
                         
    %>
    
   
  
          <div class="card col" style="width: 18rem;">
          <img src="https://assets.nst.com.my/images/articles/bnghy7_1599868808.jpg" class="card-img-top" alt="..." style="width:100%; border-radius: 10px; margin-top: 8px;">
  <div class="card-body ">
      <h5 class="card-title"> <%= list.get(i).getName() %></h5>
      <p class="card-text"> <%= list.get(i).getDescription() %></p>
   
     <form action="delete">
         <button type="submit" name="chosen" value="<%= list.get(i).getId() %>" class="btn btn-primary">remove</button>
    </form>
  </div>
</div>
   
   
   <% } %> 
   
  </div>
</div>
  
  
    </body>
</html>

<c:import url="/footer.html" />