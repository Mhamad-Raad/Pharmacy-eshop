<%-- 
    Document   : notify.jsp
    Created on : Jan 11, 2022, 11:38:36 PM
    Author     : hamar
--%>

<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean ok = false;
   User user = (User) session.getAttribute("user");
    ArrayList<Pid> plist = (ArrayList)session.getAttribute("plist");
    ArrayList<Cid> clist = (ArrayList)session.getAttribute("clist");
   
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
            margin-top: 50px;
            border-radius: 20px;
            /*margin-left: auto;*/
        }
        form {
    margin-left: 13%;
}
.r{
    display: flex;
}

    </style>
    <body style="background: #71C9CE;">
        <% if( plist != null || clist != null){ %>
          <h3 style ="text-align: center; color: white; margin-top: 5%;">Order Notifications!</h3>
          <% 
              ok = true;
              } else{ %>
                   <h3 style ="text-align: center; color: white; margin-top: 5%;">No Notifications Yet!</h3>
          <% } %>
        <div class="container">
            <div class="row row-cols-1 row-cols-lg-3 g-1 g-lg-3">
                
                  <%
         
                  if(user.getType().equals("Pharmacist")){
                      if( ok){
                      
                   for(int i=0;i<plist.size();i++){
    %>
    
      
          <div class="card col" style="width: 18rem;">
          <img src="https://assets.nst.com.my/images/articles/bnghy7_1599868808.jpg" class="card-img-top" alt="..." style="width:100%; border-radius: 10px; margin-top: 8px;">
  <div class="card-body ">
      <h5 class="card-title"> <%= plist.get(i).getMedicine().getName() %></h5>
      <p class="card-text"><b>Quantity:</b> 1 </p><br>
    <div class="r">
     <form action="BResponse" style="float:left;" >
         <button  class="btn btn-danger" type="submit" name="orderid" value="<%=plist.get(i).getOid()%>"  style="padding-left: 18px; padding-right: 18px;">Deny</button>
    </form>
    
    <form action="AResponse" style="float:right;" >
        <button  class="btn btn-success" type="submit" name="orderid" value="<%=plist.get(i).getOid()%>">Accept</button>
    </form>
    </div>
  </div>
</div>
   
   
   <% 
       }
     }
%>

<%
    

}
else if (user.getType().equals("Customer")){
if(ok){

 for(int i=0;i<clist.size();i++){
   %> 
   
        <div class="card col" style="width: 18rem;">
          <img src="https://assets.nst.com.my/images/articles/bnghy7_1599868808.jpg" class="card-img-top" alt="..." style="width:100%; border-radius: 10px; margin-top: 8px;">
  <div class="card-body ">
    <h5 class="card-title"> <%= clist.get(i).getMedicine().getName() %></h5><br>
    <p class="card-text"><b>Quantity:</b> 1</p>
    <% if(clist.get(i).getStatus().equals("accepted")){%>
    <p class="card-text"><b>Status:</b> Accepted</p>
     
     <%} else if(clist.get(i).getStatus().equals("denied")){%>
     <p class="card-text"><b>Status:</b> Denied</p>
   
     <%} else{%>
     <p class="card-text"><b>Status:</b> Pending ...</p>
     <%}%>
  </div>
</div>
   
   
   <%
       }
       }
    }

   %>
      
            </div>
     </div>
  
      
    </body>
</html>
