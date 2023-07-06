<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.admin.output.orderProductsModel,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/orderProductsTable.css">

 
    <script src="./js/orderProductsTable.js"></script>
</head>

<body>
<%
List<orderProductsModel> orderproducts=(List<orderProductsModel>)request.getAttribute("orderproducts");
%>
<table>
    <thead>
        <tr>
            <th>Order ID</th>
            <th>Product Id</th>
            <th>GST</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <% for (orderProductsModel viewModel : orderproducts) { %>
        <tr>
            <td><%= viewModel.getOrdr_id() %></td>
            <td><%= viewModel.getProd_id() %></td>
            <td><%= viewModel.getOrpr_gst() %></td>
            <td><%= viewModel.getOrpr_qty() %></td>
            <td><%= viewModel.getOrpr_price() %></td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
