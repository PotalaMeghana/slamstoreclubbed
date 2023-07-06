<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="eStoreProduct.model.admin.entities.adminModel,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Profile Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
   
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="./css/adminProfile.css">

 
    <script src="./js/adminProfile.js"></script>

  
</head>
<body>
    <div class="container">
        <div id="content">
            <h1>Admin Profile</h1>
            <hr>
            <% adminModel am = (adminModel) session.getAttribute("admin"); %>
            <%-- Replace the following lines with your server-side code to retrieve admin profile information --%>
            <% int id=am.getId(); %>
            <% String adminName = am.getTitle(); %>
            <% String adminEmail = am.getEmail(); %>
            <% String adminRole = am.getDesignation(); %>

            <div class="card">
                <div class="card-body">
                	<h6 class="card-title">Id: <%= id %></h6>
                    <p class="card-title">Name: <%= adminName %></p>
                    <p class="card-text">Email: <%= adminEmail %></p>
                    <p class="card-text">Role: <%= adminRole %></p>
                </div>
            </div>

            <br>
            <a href="#" id="edit-profile" class="btn btn-primary">Edit Profile</a>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
