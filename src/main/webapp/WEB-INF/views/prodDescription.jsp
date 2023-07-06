<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>
<%@ page import="eStoreProduct.utility.ProductStockPriceForCust" %>
<%@ page import="eStoreProduct.model.customer.input.custCredModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Description</title>
        <link rel="stylesheet" type="text/css" href="./css/productdescription.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/proddescription.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>

<%
ProductStockPriceForCust product = (ProductStockPriceForCust)request.getAttribute("oneproduct");
%>

<body>
<div class="container">
    <h2>Product Description</h2>
    <div class="product-image">
        <img src="<%= product.getImage_url()%>" alt="<%= product.getProd_title() %>">
    </div>
    <div class="product-details">
        <h3 class="product-name"><%= product.getProd_title() %></h3>
        <p class="product-description"><%= product.getProd_desc() %></p>
       <% if (product.getProduct_stock() <= 5 && product.getProduct_stock() > 0) { %>
								    <input type="hidden" id="stockval" value="<%= product.getProduct_stock() %>">
								    <p class="card-text"><i><b>Only <%= product.getProduct_stock() %> are left..Hurry Up!! </b></i></p>
								<% } else if(product.getProduct_stock()>5){
			                    	
			                    } else { %>
								    <b><p class="stockp">Out of Stock</p></b>
								    <script>
								    	disableBuyNow();
								    </script>
								<% } %>
        <p class="product-price">Price: $<%= product.getPrice()%></p>
    </div>
    <div>
        <label>Qty:</label>
        <input type="number" class="btn btn-primary qtyinp input-width" id="qtyinp" value="1" min="1" data-product-id="<%= product.getProd_id() %>">
    </div>
    <div>
        <p>Pincode Availability:</p>
        <p id="availability"></p>

        <form id="shipment-form">
            <p id="ship"></p>
            <table class="shipment-table">
                <tr>
                    <td>Delivery To:</td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="custName" name="custName" value="${cust != null ? cust.custName : ""}"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" id="custSAddress" name="custSAddress" value="${cust != null ? cust.custSAddress : ""}"></td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td>
<input type="number" class="custPincode" id="custPincode" name="custPincode" value="${cust != null ? cust.custSpincode: ""}"  oninput="checkPincodeAvailability(this.value);">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <button class="btn btn-primary buynow" id="buynow" data-product-id="<%= product.getProd_id() %>">Buy Now</button>
    </div>
</div>
</body>
</html>
