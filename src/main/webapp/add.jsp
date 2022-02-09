<%-- 
    Document   : insert
    Created on : Jan 9, 2022, 8:34:37 PM
    Author     : hamar
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="medicine" scope="session" class="model.Medicine"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   User user = (User) session.getAttribute("user");
if(user.getType().equals("Pharmacist")){
%>
<%@include file="header.html"%>
<%} else {%>
<%@include file="cheader.html"%>
<%}%>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   <style>
        
        body{
    background: #71C9CE;
}
.contact-form{
    border-radius: 15px;
    background: #fff;
    margin-top: 10%;
    margin-bottom: 5%;
    width: 70%;
    height: 10000%;
}
.contact-form .form-control{
    border-radius:1rem;
}
.contact-image{
    text-align: center;
}
.contact-image img{
    border-radius: 6rem;
    width: 11%;
    margin-top: -3%;

}
.contact-form form{
    margin: 0;
    padding: 0%;
}
.contact-form form .row{
    margin-bottom: -7%;
}
.contact-form h3{
    margin-top: 3%;
    margin-bottom: 6%;
    
    text-align: center;
    color: #008B8B;
}
.contact-form .btnContact {
    width: 50%;

margin-top: 13%;
margin-left: 5%;
    display:block;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #008B8B;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
    
}
#quantity{
    margin-left: auto;
    margin-right: auto;
    margin-top: 35px;
    border-radius: 20px;
    width: 25%;
}

    </style>
    </head>
    
    <style>
        
        body{
    background: #71C9CE;
}
.contact-form{
    border-radius: 15px;
    background: #fff;
    margin-top: 10%;
    margin-bottom: 5%;
    width: 70%;
    height: 10000%;
}
.contact-form .form-control{
    border-radius:1rem;
}
.contact-image{
    text-align: center;
}
.contact-image img{
    border-radius: 6rem;
    width: 11%;
    margin-top: -3%;

}
.contact-form form{
    margin: 0;
    padding: 0%;
}
.contact-form form .row{
    margin-bottom: -7%;
}
.contact-form h3{
    margin-top: 3%;
    margin-bottom: 6%;
    
    text-align: center;
    color: #008B8B;
}
.contact-form .btnContact {
    width: 50%;

margin-top: 13%;
margin-left: 5%;
    display:block;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #008B8B;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
    
}
#quantity{
    margin-left: auto;
    margin-right: auto;
    margin-top: 35px;
    border-radius: 20px;
    width: 25%;
}

.container{
    border-color: black;
    
   background-color: #E8F8F5;
}

    </style>
    
    
    <body>

        
        
<div class="container contact-form">
            <div class="contact-image">
                <img src="https://theshuttle.org.uk/wp-content/uploads/pharmacy.png" alt="rocket_contact"/>
            </div>
    <form action="AddMed" method="get">
                <h3>Add Medicine</h3>
               <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="mname" class="form-control" placeholder="Medicine Name"/>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Price" name="price"> 
                            <span class="input-group-text">$</span>
                          </div>
                        </div>
                        <div class="row">
                            <div class="form-group" style="margin-top: 2%;">
                                <span style="margin-left: 4%;">facture:</span>
                                <input type="date" style="margin-left: 1%;"  placeholder="Manf" name="manf"/>
                                <span style="margin-left: 5%;">Exp:</span>
                                <input type="date"style="margin-left: 1%;" name="exp"/>
                            </div>
                            
                            <div class="form-group">
                               
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            
                            <input type="number" id="quantity" name="quantity" min="1" max="100" placeholder="Quantity">
                        </div>
                       
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <textarea name="description" class="form-control" placeholder="Description" style="width: 100%; height: 150px;"></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                     <div class="form-group">
                         <input type="submit" name="btnSubmit"  class="btnContact" style="margin-left: auto; margin-right: auto; " />
                        </div>
                </div>
            </form>
</div>
        <div style="margin-bottom: 200px;"></div>
    </body>

</html>
<c:import url="/footer.html" />