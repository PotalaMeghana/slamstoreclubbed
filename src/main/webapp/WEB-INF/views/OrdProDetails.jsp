<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
                <link rel="stylesheet" type="text/css" href="./css/orderproductdetails.css">
    <link rel="stylesheet" href="path/to/your/custom.css"> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/orderproductdetails.js"></script><!-- Include your custom CSS file -->
 
</head>
<body>

<!-- Add this code snippet inside the <body> tag of your JSP page -->

<div id="trackOrderModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h3>Order Tracking</h3>
        <div class="shipment-status-line">
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
        </div>
        <div class="shipment-status-text">
            <div class="status">Order Placed</div>
            <div class="status">Order Processed</div>
            <div class="status">dispatched</div>
            <div class="status">Out for Delivery</div>
            <div class="status">Delivered</div>
        </div>
    </div>
</div>


<div id="cancelOrderModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h3>Your order has been cancelled</h3>
        <p>Insert any additional message or details here.</p>
    </div>
</div>

    <div class="container">
        <h2>Product Details</h2>
        <div class="product-card">
            <img class="card-img-top" src="${product. getImageUrl()}" alt="${product. getName()}">
            <div class="product-details">
                <div class="product-title">${product. getName()}</div>
                <div class="product-description">${product.getDescription()}</div>
                <div class="product-price">${product.getPrice()}</div>
                <!-- Other product details as needed -->
                
                <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'under processing'  && product.getShipStat() != 'cancelled' }">
                    <button class="btn btn-primary track-order-btn">Track Order</button>
                </c:if>
                <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat()!='cancelled'}">
                    <button class="btn btn-danger cancel-order-btn">Cancel Order</button>
                </c:if>
            </div>
        <input type="number" id="orderproId" value="${product.getId()}" hidden>
<input type="number" id="orderId" value="${product.getOrdId()}" hidden>
        </div>
    </div>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
                <link rel="stylesheet" type="text/css" href="./css/orderproductdetails.css">
    <link rel="stylesheet" href="path/to/your/custom.css"> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/orderproductdetails.js"></script><!-- Include your custom CSS file -->
 
</head>
<body>

<!-- Add this code snippet inside the <body> tag of your JSP page -->

<div id="trackOrderModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h3>Order Tracking</h3>
        <div class="shipment-status-line">
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
        </div>
        <div class="shipment-status-text">
            <div class="status">Order Placed</div>
            <div class="status">Order Processed</div>
            <div class="status">dispatched</div>
            <div class="status">Out for Delivery</div>
            <div class="status">Delivered</div>
        </div>
    </div>
</div>


<div id="cancelOrderModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h3>Your order has been cancelled</h3>
        <p>Insert any additional message or details here.</p>
    </div>
</div>

    <div class="container">
        <h2>Product Details</h2>
        <div class="product-card">
            <img class="card-img-top" src="${product. getImageUrl()}" alt="${product. getName()}">
            <div class="product-details">
                <div class="product-title">${product. getName()}</div>
                <div class="product-description">${product.getDescription()}</div>
                <%-- <div class="product-price">${product.getPrice()}</div> --%>
                <!-- Other product details as needed -->
                
                <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'under processing'  && product.getShipStat() != 'cancelled' }">
                    <button class="btn btn-primary track-order-btn">Track Order</button>
                </c:if>
                <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat()!='cancelled'}">
                    <button class="btn btn-danger cancel-order-btn">Cancel Order</button>
                </c:if>
            </div>
        <input type="number" id="orderproId" value="${product.getId()}" hidden>
<input type="number" id="orderId" value="${product.getOrdId()}" hidden>
        </div>
    </div>

</body>
</html>