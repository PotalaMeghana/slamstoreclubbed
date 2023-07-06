<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Account Created Successfully</title>
  <style>
    /* Add your custom styles here */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      background-color: #f2f2f2;
    }
    
    .container {
      max-width: 520px;
      padding: 40px;
      background-color: #fff;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    
    h2 {
      margin-bottom: 20px;
    }
    
    p {
      font-size: 18px;
      margin-bottom: 30px;
    }
    
    a {
      display: inline-block;
      color: #333;
      text-decoration: none;
      border: 1px solid #333;
      padding: 10px 20px;
      border-radius: 5px;
      transition: background-color 0.3s;
    }
    
    a:hover {
      background-color: #333;
      color: #fff;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Account Created Successfully</h2>
    <p>Your account has been created successfully. You can now proceed to the login page to access your account.</p>
    <a href="signIn">Back to Login</a>
  </div>
</body>
</html>