<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="eStoreProduct.ExceptionUser.Emptywalletexception" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wallet Exception</title>
</head>
<body>
<div>
	<h1>Oops......</h1>
	<P>${err.msg}</P>
    <p>Amount in your Wallet is:${err.amount}</p>
    <p>Go for online payment..</p>
    </div>
	
</body>
</html>
