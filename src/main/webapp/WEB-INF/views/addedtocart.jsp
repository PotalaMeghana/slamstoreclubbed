<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
            <link rel="stylesheet" type="text/css" href="./css/addedtocart.css">

<script>
$('button').click(function(){
	  $('.alert').addClass("show");
	  $('.alert').removeClass("hide");
	  $('.alert').addClass("showAlert");
	  setTimeout(function(){
	    $('.alert').removeClass("show");
	    $('.alert').addClass("hide");
	  },5000);
	});
	$('.close-btn').click(function(){
	  $('.alert').removeClass("show");
	  $('.alert').addClass("hide");
	});
</script>
</head>
<body>
<button>Show Alert</button>
<div class="alert hide">
  <span class="fas fa-exclamation-circle"></span>
  <span class="msg">Product added to cartŠ</span>
  <div class="close-btn">
    <span class="fas fa-times"></span>
  </div>
</div>
</body>
</html>