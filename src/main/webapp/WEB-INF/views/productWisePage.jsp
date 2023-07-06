<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List" %>
<%@ page import="eStoreProduct.model.admin.output.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Information</title>
    <link rel="stylesheet" type="text/css" href="./css/productWisePage.css">

 
    <script src="./js/productWisePage.js"></script>
</head>
<body>
<% List<ProductShip> productList=(List<ProductShip>)request.getAttribute("plist"); %>
<h1>Product Information</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Shipping Charge</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%-- Iterate over the product model list and display each product --%>
    <% for (ProductShip product : productList) { %>
    <tr>
        <td><%= product.getProd_id()%></td>
        <td><%= product.getProd_title() %></td>
        <td><%= product.getProd_price() %></td>
        <td>
            <span id="shippingCharges_<%= product.getProd_id()%>"><%= product.getShipment_charges() %></span>
            <input id="shippingChargesInput_<%= product.getProd_id()%>" type="text" style="display: none;">
        </td>
        <td>
            <a href="#" id="editButton_<%= product.getProd_id()%>" class="edit-button" onclick="editProduct(<%= product.getProd_id()%>)">Edit</a>
            <a href="#" id="saveButton_<%= product.getProd_id()%>" class="edit-button" style="display: none;" onclick="saveShippingCharges(<%= product.getProd_id()%>)">Save</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>


</body>
</html>
