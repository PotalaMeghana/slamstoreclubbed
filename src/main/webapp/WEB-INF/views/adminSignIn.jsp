<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Sign In</title>
 <link rel="stylesheet" type="text/css" href="./css/adminSignIn.css">

 
    <script src="./js/adminSignIn.js"></script>
</head>
<body>
  <div class="container">
    <!-- Data or Content -->
    <div class="box-1">
      <div class="content-holder">
        <h2>Hello!</h2>
        <button class="button-2" onclick="adminsignin()">Admin</button>
      </div>
    </div>

    <!-- Forms -->
    <div class="box-2">
      <div class="adminlogin-form-container">
        <h1>Admin Sign In</h1>
        <form action="adminSignOk" method="POST" >
          <input type="email" placeholder="Email" name="email" class="input-field">
          <br><br>
          <input type="password" placeholder="Password" name="password" class="input-field">
          <br><br>
          <button class="login-button" type="submit">Sign In</button>
        </form>
      </div>
    </div>
  </div>

  
</body>
</html>
