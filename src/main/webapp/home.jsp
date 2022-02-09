<%-- 
    Document   : home
    Created on : Jan 10, 2022, 7:26:24 PM
    Author     : Sara
--%>


<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Medicine"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<%
User user = (User) session.getAttribute("user");
if(user.getType().equals("Pharmacist")){
%>
<%@include file="header.html"%>

<%} else {%>
<%@include file="cheader.html"%>
<%}%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
      .navbar-brand:hover{
    background-color: #93D3E5;
}

.nav-item1:hover{
    background-color: #93D3E5;
}

.nav-item2:hover{
    background-color: #93D3E5;
}

.search{
    border: 2px solid yellow;
}

h1{
    text-shadow: 1px 1px 1px #008B8B,
               2px 2px 1px #008B8B;
    margin-left: 600px;
}

 .parent {
      width: 320px;
      height:200px;;
      border-width: 2px;
      border-style:solid;
      border-color:lightgray;
      margin-left: 90px;
      margin-right: 90px;
      margin-top: 30px;
      margin-bottom: 20px;
      float: right;
      background-color: #008B8B;
      color: white;
      
    }
    .child1 {
      overflow : hidden;
      background: #71c9ce;
      height: 110px;
       margin-right: -1px;
       
    }
        
    h7{
        margin-left: 60px;
    
        margin-left: 80px;
        padding-bottom: -20px;
        
    }
    
    .child2{
        overflow : hidden;
        margin-top: 0px;
        height: 40px;
        margin-right: -1px;
        background-color: #D0D3D4;
        margin-top: -44px;
    }
    
    h5{
        text-align: center;
        padding-top: 30px;
    }
    
    .btn{
        margin-left: 90px;
        margin-top: 1px;
    }
    
    
    .body{
        background-color:#E8F8F5 ;
    }
    
    
    h2{
        text-align: center;
    }

    
   .row1{
        float: left;
        margin-left: 30px;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    
    .row2{
        float: right;
        margin-right: 30px;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    
    .child3{
       padding-top: -130px;
      padding-bottom: 40px;
      margin-top: -60px;
    } 
    
    .c3{
        text-align: center;
        padding-top: 10px;
    }
    
     #myInput{
        margin-left: 43%;
        margin-right: 47%;
      float: left;
    }
    
    #btn{
        margin-left: 62%;
        margin-right: 40%;
        margin-top: -30px;
        margin-bottom: 20px;
        float: right;
    }
    
        </style>
        
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body class="body">

        <div>
            <img src="https://thehill.com/sites/default/files/drugs_pharmacy_istock.jpg" width="1520" height="500px"/>
        </div><br><br><br><br><br>
        <h1>Available Medicines</h1><br><br>

<%
    ArrayList<Medicine> list= (ArrayList) session.getAttribute("hlist");
    for(int i=0; i<list.size();i++){
        if(user.getType().equals("Pharmacist")){
          %>


<div class="parent">
 
    <h2><%= list.get(i).getName() %> </h2>
  
    
    <div class="child1">
        <div class="row1">
            <h6 class="c1">price: <%= list.get(i).getPrice() %></h6>
            
        </div>
            
            <div class="row2">
                <h6 class="c2 ">Quantity: <%= list.get(i).getQuantity() %></h6>
            </div>
            </div>
            
            <div class="child3">
                <h6 style="text-align:center; ">Expiration: <%= list.get(i).getExp() %> </h6>
                <h6 class="c3"><%= list.get(i).getDescription() %></h6>
            </div>
    
            
            
  
    
        
       
        
  </div>
              
              <%
                  }

else{
%>


<div class="parent">
 
    <h2><%= list.get(i).getName() %> </h2>
  
    
    <div class="child1">
        <div class="row1">
            <h6 class="c1">price: <%= list.get(i).getPrice() %></h6>
            
        </div>
            
            <div class="row2">
                <h6 class="c2 ">Quantity: <%= list.get(i).getQuantity() %></h6>
            </div>
            </div>
            
            <div class="child3">
                <h6 style="text-align:center; ">Expiration: <%= list.get(i).getExp() %> </h6>
                <h6 class="c3"><%= list.get(i).getDescription() %></h6>
            </div>
    
            
            
  
    
        
        
            <form class="child2" action="bCnfrm">
                <button type="submit" name="id" class="btn btn-success" value="<%= list.get(i).getId() %>" aria-pressed="true" style="background-color: #008B8B;">Order Medicine</button>  
  </form>
        
        
        
  </div>


<%
    }
}
      %>
      
      
      
      
      
           
    </body>
    
</html>
<c:import url="/footer.html" />