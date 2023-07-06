<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="eStoreProduct.utility.ProductStockPrice" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <div class="container mt-5">
        <h2>Wishlist</h2>
        <div class="row mt-4">
            <%-- Iterate over the products and render the HTML content --%>
            <%
            List<ProductStockPrice> products = (List<ProductStockPrice>) request.getAttribute("products");
            if(products==null)
            {
            	System.out.println("null in wishlist");
            }else{
            //ProdStockDAO ps = new ProdStockDAOImp();
                for (ProductStockPrice product : products) {
                	System.out.println(product);
            %>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100">
                    <img class="card-img-top" src="<%= product.getImage_url() %>" alt="<%= product.getProd_title() %>">
                    <br>
                    
                    <div class="card-body">
                                      
                       <h5 class="card-title"><%= product.getProd_title() %></h5>
                    <p class="card-text"><%= product.getProd_desc() %></p>
                    <p class="card-text"><%= product.getPrice() %></p> 
                        <button class="btn btn-primary removeFromWishlist" data-product-id="<%= product.getProd_id() %>">Remove from Wishlist</button>
                        <button class="btn btn-secondary addToCartButton" data-product-id="<%= product.getProd_id() %>">Add to cart</button>
                    </div>
                </div>
            </div>
            <%
                }}
            %>
        </div>
    </div>
</body>
</html>