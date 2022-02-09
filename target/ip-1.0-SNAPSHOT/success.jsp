<%-- 
    Document   : success
    Created on : Jan 10, 2022, 6:27:58 PM
    Author     : hamar
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   User user = (User) session.getAttribute("user");
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
         body{
    background: #71C9CE;
}
   .center {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
 
    text-align: center;
}     
    </style>
    <body>
        <div class="center" style="width: 100%;">
            <img
                src="https://www.pngall.com/wp-content/uploads/8/Green-Check-Mark-PNG-Image.png"
                alt="Sample photo"
                class="img-fluid"
                style=" height: 300px; "
              />
            <h4 style="color: white; margin-top: 1%">Operation has been Successful</h4>
        </div>
       
    </body>
</html>
