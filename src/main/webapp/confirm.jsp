<%-- 
    Document   : confirm
    Created on : Jan 12, 2022, 10:20:09 PM
    Author     : sara
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="medicine" scope="session" class="model.Medicine"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 

<%@include file="cheader.html"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            h3{
                margin-left: 43%;
                margin-bottom: 50px;
                color: #008B8B;
                font-size: 30px;
                text-shadow: 1px 1px 1px black,2px 2px 1px #008B8B;
            }
            
            .container{
                margin-left: 40%;
                margin-top: 5%;
            }
            .btn{
                margin-left: 45%;
            }
            
            body{
                background-color:#E8F8F5 ; 
            }
            

            .card{
                margin-left: auto;
                margin-right: auto;
                margin-bottom: -10px;
            }
        </style>
    </head>
    <body>
        <% if(medicine.getName() != null) {%>
        <h3>Confirm Order</h3>

        
            <div class="container">
            <div class="row row-cols-1 row-cols-lg-3 g-1 g-lg-3">
                    
                 <div class="card col" style="width: 18rem;">
          <img src="https://assets.nst.com.my/images/articles/bnghy7_1599868808.jpg" class="card-img-top" alt="..." style="width:100%; border-radius: 10px; margin-top: 8px;">
          <h2></h2>
          <div class="card-body ">
              <h6 class="card-title">Medicine name: <jsp:getProperty name="medicine" property="name"/></h6>
              <h6 class="card-text" >Medicine Description: <jsp:getProperty name="medicine" property="description"/></h6><br><br><br><Br>
  
    <form action="ordered" >
    
        <button class="btn btn-success" type="submit" name ="id" value="<%= medicine.getId() %>" style="margin-left: 24%;">Confirm Order</button>
    </form>
    </div>
  </div>
</div>
        
     
        
        
        </div>
    
    <%} else{ %>
    
    <h1>Item not available</h1>
    
    <%
        }
    %>
    
      
    </body>
</html>


<c:import url="/footer.html" />