<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign In</title>
      <link rel="stylesheet" type="text/css" href="./css/signinup.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/signinup.js"></script>
  
</head>
<body>
 <div class="container">
      <!--Data or Content-->
      <div class="box-1">
          <div class="content-holder">
              <h2>Hello!</h2>
             
              <button class="button-1" >USER</button>
              
          </div>
      </div>

      
      <!--Forms-->
      <div class="box-2">
          <div class="userlogin-form-container" align="center">
              <h1>Login Form</h1>
              <div id="emailVerify"></div>
              <form action="signOk">
              <input type="email" placeholder="Email" name="em" id="email" class="input-field" oninput="validateEmailsignin()">
              <br><br>
              <input type="password" placeholder="Password" class="input-field" name="ps">
              <br><br>
              <button class="login-button" type="submit">Sign In</button>
              </form>
                   <div>
          <br>
          <br>
         <a href="forgotPassword">Forget Password</a>
          </div>
          </div>



</div>
      </div>
 

</body>
</html>
 --%>
 
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <title>Sign In</title>
      <link rel="stylesheet" type="text/css" href="./css/signinup.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/signinup.js"></script>
  


<body>
 <div class="container">
      <!--Data or Content-->
      <div class="box-1">
          <div class="content-holder">
              <h2>Hello!</h2>
             
              <button class="button-1" >USER</button>
              
          </div>
      </div>

      
      <!--Forms-->
      <div class="box-2">
          <div class="userlogin-form-container" align="center">
              <h1>Login Form</h1>
              
              <form action="signOk">
              <input type="email" placeholder="Email" name="em" id="email" class="input-field">
              <br><br>
              <input type="password" placeholder="Password" class="input-field" name="ps" id="pass">
              <br><br>
              <button class="login-button" type="submit">Sign In</button>
               <div id="password" class="password"></div>
              </form>
                   <div>
          <br>
          <br>
         <a href="forgotPassword">Forget Password</a>
          </div>
          </div>



</div>
      </div>
 

</body>
</html>