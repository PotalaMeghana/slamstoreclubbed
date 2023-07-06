 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>
<%@ page import="eStoreProduct.utility.ProductStockPriceForCust" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Catalog</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/proddescription.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row mt-4">
        <%-- Iterate over the products and render the HTML content --%>
        <%
            List<ProductStockPriceForCust> products = (List<ProductStockPriceForCust>) request.getAttribute("products");
        	//ProdStockDAO ps = new ProdStockDAOImp();
            for (ProductStockPriceForCust product : products) {
        %>
        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="javascript:void(0)" onclick="showProductDetails('<%= product.getProd_id() %>')">
                    <img class="card-img-top" src="<%= product.getImage_url() %>" alt="<%= product.getProd_title() %>">
                </a>
                <div class="card-body">
                    <h5 class="card-title"><%= product.getProd_title() %></h5>
                    <p class="card-text"><%= product.getProd_desc() %></p>
                     <%if(product.getProduct_stock()<=5 && product.getProduct_stock()>0){ %>
		                            <input type="hidden" id="stockval" value="<%=product.getProduct_stock() %>">
					                    <p class="card-text" ><i><b>Only <%=product.getProduct_stock() %> are left..Hurry Up!! </i></b></p>
					                    <%}else if(product.getProduct_stock()>5){
					                    	
					                    } else{%>
					                    	
					                    <b><p class="stockp">Out of Stock</p></b>
					                    <%}%>
					                        <p class="card-text"><%= product.getPrice() %></p>
					                        
                    
                    <button class="btn btn-primary addToCartButton" data-product-id="<%= product.getProd_id() %>"data-quantity="<%= product.getQuantity() %>">Add To Cart</button>
                    <button class="btn btn-secondary addToWishlistButton" data-product-id="<%= product.getProd_id() %>">Add to Wishlist</button>
                </div>
            </div>
        </div>
        
        <%
            }
        %>
    </div>
</div>
</body>
</html>