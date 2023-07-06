


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Forgot Password</title>
            <link rel="stylesheet" type="text/css" href="./css/forgetpage.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    var otp1;

   
    
    function sendmail() {
    	  console.log("entered mail sending");
    	  var email = $("#email").val();
    	  
    	  $.ajax({
    	    type: "POST",
    	    url: "emailValid",
    	    data: { email: email },
    	    success: function(response) {
    	      console.log("response of email verification " + response);
    	      if (response === "no") {
    	        // Account does not exist
    	        $("#sid").text("Account does not exist");
    	        $("#signup").replaceWith( '<a href="signUp">Sign Up</a>');
    	      } else {
    	        // Account exists, proceed with OTP generation
    	        $.ajax({
    	          type: "POST",
    	          url: "otpAction",
    	          data: { email: email },
    	          success: function(response) {
    	            console.log("response of otp generation " + response);
    	            otp1 = response;
    	          },
    	          error: function() {
    	            alert("Error occurred. Please try again later.");
    	          }
    	        });
    	      }
    	    },
    	    error: function() {
    	      alert("Error occurred. Please try again later.");
    	    }
    	  });
    	}
  


 function validateOTP() {
	  var otp2 = $("#otpTextarea").val();
	  console.log("entered otp checking");
	  $.ajax({
	    type: "POST",
	    url: "validateOTP",
	    data: { otp12: otp2 },
	    success: function(response) {
	      console.log("response for otp validation " + response);
	      if (response === "no") {
	        console.log("entered no response");
	        var sendOtpBtn = $("#sendOtpBtn");
	        sendOtpBtn.text("Resend OTP");
	        //sendOtpBtn.prop("disabled", true);
	        $("#otpdisplay").text("OTP expired");

	        // Refresh the 'otp' div by emptying the OTP input field and hiding the Submit button
	        $("#otpTextarea").val("");
	        //$("#otpSubmitBtn").hide();
	        setTimeout(function() {
	            $("#otpdisplay").text("");
	          }, 2000);
	        
	      } else if (response !== "invalid") {
	        var containerDiv = $("#contId");
	        containerDiv.html('<form action="updatepwd" id="signup-form">' +
	          '<label>Password:</label>' +
	          '<input type="password" class="form-control" id="psd1" name="psd1" required>' +
	          '<label>Confirm Password:</label>' +
	          '<input type="password" class="form-control" id="psd2" name="psd2" required>' +
	          '<div><span id="pmsg"></span></div>' +
	          '<button type="button" onclick="pwd()">Update Password</button>' +
	          '</form>');
	      } else {
	        var errorSpan = $("#sid");
	        errorSpan.text("OTP Mis-Matched");
	      }
	    },
	    error: function() {
	      alert("Error occurred. Please try again later.");
	    }
	  });
	}

    function pwd() {
      var password = $("#psd1").val();
      var confirmPassword = $("#psd2").val();
      var passwordMessage = $("#pmsg");

      if (password !== confirmPassword) {
        passwordMessage.text("Passwords do not match");
        return false;
      } else {
        passwordMessage.text("");
        $("#signup-form").submit();
      }
    }
  </script>
</head>
<body>
  <div class="container" id="contId">
    <h2>Forgot Password</h2><div><span align="center" id="sid">
    <form>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" required>
      </div>
      <button type="button" align="center" class="btn btn-primary" onclick="sendmail()" id="sendOtpBtn">Send OTP</button>
     
    </form>
    <div id="otp">
     <label for="email">OTP</label>
    <input type="text" id="otpTextarea" class="form-control" rows="3" placeholder="Enter OTP">
    <button id="otpSubmitBtn" class="btn btn-primary mt-2" onclick="validateOTP()">Submit</button>
    </div>
    <div align="center" id="otpdisplay"></div>
  </div><div id="signup" align="center"></div> </span></div>
  
 
  <!-- Include Bootstrap JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>