 //method to validate email
  function validateEmail()
   {
	   var email = $("#email").val();
	   console.log("email in verification "+email);
	   $.ajax({
   	    type: "POST",
   	    url: "emailValid",
   	    data: { email: email },
   	    success: function(response) {
   	      console.log("response of email verification " + response);
   	      if (response !== "no") {
   	    	 $("#emailCheck").text("Account already existed with this mail");
   	    	 $("#email").val("");
   	    	setTimeout(function() {
   	         $("#emailCheck").text("");
   	       }, 2000);
   	      }
   	      },error: function() {
	            alert("Error occurred. Please try again later.");
          }
        });
   }
   //method to validate the sign in mail  is already sihn in or not
function validateEmailsignin()
{
	   var email = $("#email").val();
	   console.log("email in verification "+email);
	   $.ajax({
	    type: "POST",
	    url: "emailValid",
	    data: { email: email },
	    success: function(response) {
	      console.log("response of email verification " + response);
	         if (response == "no") {
	    	 $("#emailVerify").text("Please enter valid email");
	    	
	    	setTimeout(function() {
	         $("#emailVerify").text("");
	       }, 2000);
	    	$("#email").val("");} 
	       //console.log("signin email verification response "+response);
	         
	      },error: function() {
	            alert("Error occurred. Please try again later.");
       }
     });
}
   //function to validate the password is right or wrong
    function validatePassword() {
      var passwordInput = document.getElementById("password").value;
      console.log("Password: " + passwordInput);
      var confirmPassword = document.getElementById("confirm-password").value;
      var message = document.getElementById("confirm-password-message");
      
      if (passwordInput !== confirmPassword) {
        message.style.color = "red";
        message.innerHTML = "Passwords do not match";
        return false;
      } else {
        message.style.color = "green";
        message.innerHTML = "Passwords match";
        return true;
      }
    }
    //method for event listeners
function usersignin()
{
    document.querySelector(".userlogin-form-container").style.cssText = "display: none;";
    document.querySelector(".adminlogin-form-container").style.cssText = "display: block;";
    document.querySelector(".container").style.cssText = "background: linear-gradient(to bottom, rgb(56, 189, 149),  rgb(28, 139, 106));";
    document.querySelector(".button-1").style.cssText = "display: none";
    document.querySelector(".button-2").style.cssText = "display: block";

};



$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();

        var email = $('#email').val();
        var password = $('#pass').val();
        console.log(email+"  email");
        console.log(password+"  password");

        $.ajax({
            url: 'signOk',
            type: 'get',
            data: {
                em: email,
                ps: password
            },
            success: function(response) {
            	console.log("response of signok "+response);
                if (response === 'valid') {
                    window.location.href = 'loggedIn';
                } else if (response === 'invalid') {
                	$("#password").text("UserEmail or Pasword is wrong");
                	setTimeout(function() {
           	         $("#password").text("");
           	       }, 2000);
           	    	$("#pass").val("");
                } else {
                    alert('An error occurred.');
                }
            },
            error: function() {
                alert('An error occurred.');
            }
        });
    });
});
