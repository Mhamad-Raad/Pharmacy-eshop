<%-- 
    Document   : pprofile
    Created on : Jan 5, 2022, 10:28:25 AM
    Author     : Sara
--%>


<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
   <script src="//code.jquery.com/jquery.min.js"></script>
        <style>
body {
    background-color: #f9f9fa
}

/*.padding {
    padding: 6rem;
}*/

.col-sm-4{
    background-color: #008B8B;
    width: 55%;
/*    margin-top: -100px;*/
    -webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
    height: 400px;
}



.card-block{
/*    margin-top: -400px;*/

    margin-left: 1000px;
   width: 50%;
   height: 400px;
/*   height: 80%;*/
   -webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);

}

.page-content{
/*    background-color: red;*/
    height: 70%;
    margin-top: 6%;
    width: 65%;
}

.m-b-20{
    margin-top: 20px;
}


.form-check{
    margin-top: 20px;
}

.g{
    margin-left: 90px;
    margin-top: -35px;
}

.u{
    margin-left: 100px;
    margin-top: -35px;
}

h6{
    margin-left: 20px;
    margin-top: 20px;
}

.c{
    margin-left: 100px;
    margin-top: -40px;
}

.ad{
    margin-left: 100px;
    margin-top: -35px;
}

.e{
    margin-left: 100px;
    margin-top: -35px;
}

.n{
    margin-left: 190px;
    margin-top: -100px;
    color: white;
}

.ge{
    margin-left: 6px;
}

.a{
    
    margin-left: 180px;
}

h6{
    padding-bottom: 10px;
}

h5{
    margin-left: 15px;
  
}

        </style>
        


   </head>

  
   <body>

     
      <div class="page-content" id="page-content">
<!--       <div class="padding">-->
           <div class="row container d-flex justify-content-center">
              
               
                    
                        
                        
                        
               <div class="col-sm-4  user-profile side" style="width:50%">
                            
                 
                                
                                <div class="a"> <img height="330px" width="100px" src="https://cdn1.designhill.com/assets/dh/images/launch-popup/single-designer.svg?ver=2.12.2" class="img-radius image" alt="User-Profile-Image"> </div>
                                
                                
                                
                                <h6 class="n f-w-400 name"><% out.print(user.getName()); %></h6> <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>                     
                        </div>
                        
                  
                        
                     
                            <div class="card-block" style="width:60%; margin-top: -42.5%">
                                <h5 class="m-b-20 p-b-5 b-b-default f-w-600" style="margin-bottom:6%">general Information</h5>
                                <div class="row">
                                    
                                    
                     <div class="form-check form-check-inline">
                         <h6 class="ge">Gender:</h6>
                         <h6 class="g text-muted f-w-400 gender"><% out.print(user.getGender()); %></h6>
                     </div> 
                     
                     <div>
                         <h6>Usertype:</h6>
                         <h6 class="u text-muted f-w-400 type"><% out.print(user.getType()); %></h6>
                     </div>
                                    
                      <div>
                         <h6>City:</h6>
                         <h6 class="c text-muted f-w-400 city"><% out.print(user.getCity()); %></h6>
                     </div>
                                    
                                    
                     <div>
                         <h6>Address:</h6>
                         <h6 class="ad text-muted f-w-400 address"><%out.print(user.getAddress());  %></h6>
                     </div>
                                    
                                    
                       <div>
                         <h6>Email:  </h6> 
                         <h6 class="e text-muted f-w-400 email"><% out.print(user.getEmail()); %> </h6>
                     </div>
                          
                                
                        </div>
                    </div>
                </div>
            
        </div>
                     <div style="margin-bottom: 100px;"></div>

      
           
           
               
    </body>
</html>
<c:import url="/footer.html" />