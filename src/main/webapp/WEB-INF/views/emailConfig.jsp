<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="./css/emailConfig.css">

 
    <script src="./js/emailConfig.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <form>
        <label for="email">New Email:</label>
        <input type="text" id="email" placeholder="Enter your new email" name="email">

        <label for="pwd">Password:</label>
        <input type="text" id="pwd" placeholder="Enter your password" name="pwd">

        <input type='button' onclick="getemail()" value="Submit">
    </form>
    <p id="p"></p>
</body>
</html>