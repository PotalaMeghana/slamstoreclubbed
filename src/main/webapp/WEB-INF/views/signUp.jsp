
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="./css/signup.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/signinup.js"></script>
  
</head>
<body>
  <div class="container">
    <h2>Create Account</h2>
    <form action="signInCreateAccount" method="POST" name="form">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="custName" required>
      </div>
   <div class="form-group">
        <label for="email">Email</label>
        <input type="text" id="email" name="custEmail" required onblur="validateEmail()">
        <div id="emailCheck"></div>
   </div>


      <div class="form-group">
        <label for="mobile">Mobile</label>
        <input type="text" id="mobile" name="custMobile" required>
      </div>
            
      <div class="form-group">
        <label for="address">Address</label>
        <input type="text" id="address" name="custAddress" required>
      </div>
      
      <div class="form-group">
        <label for="pincode">Pincode</label>
        <input type="number" id="pincode" name="custPincode" required>
      </div>
      
      <div class="form-group">
        <label for="shipment-address">Shipment Address</label>
        <input type="text" id="shipment-address" name="custSAddress" required>
      </div>
      
      <div class="form-group">
        <label for="spincode">ShipmentPincode</label>
        <input type="number" id="spincode" name="custSpincode" required>
      </div>
      
      <div class="form-group">
        <label for="location">Location</label>
        <input type="text" id="location" name="custLocation" required>
      </div>
      
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="custPassword" required>
      </div>
      
      <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
        <span id="confirm-password-message"></span>
      </div>
      
      <div class="button-container">
        <button onclick="return validatePassword()">Create Account</button>
      </div>
    </form>
  </div>
</body>
</html>




