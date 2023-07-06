<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="eStoreProduct.model.admin.entities.adminModel,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Profile Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/editableAdminProfile.css">

 
    <script src="./js/editableAdminProfile.js"></script>
   
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
        <%String password=am.getPassword(); %>
	<form  >
        <div class="card">
            <div class="card-body">
            <h6 class="card-title"> ID:
            <input id="adminId" type="text" class="form-control" name="id" value="<%= id %>" readonly >

            </h6>
                <p class="card-title">Name:
                    <input id="adminName" type="text" class="form-control" name="title" value="<%= adminName %>" >
                </p>
                <p class="card-text">Email:
                    <input id="adminEmail" type="email" class="form-control" name="email" value="<%= adminEmail %>" >
                </p>
                <p class="card-text">Role:
                    <input id="adminRole" type="text" class="form-control" name="designation" value="<%= adminRole %>" >
                </p>
                
               <%--  <p class="card-text">Password:
                    <input id="adminPassword" type="text" class="form-control" name="password" value="<%= password %>" >
                </p> --%>
                
            </div>
        </div>

        <br>
       <input type="submit" value="update" id="update-button">
       </form>
    </div>
</div>
</body>
</html>
