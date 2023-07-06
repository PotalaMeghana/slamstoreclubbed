<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Catalog</title>
            <link rel="stylesheet" type="text/css" href="./css/orders.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/orders.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
 
</head>
<body >
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
                <div class="status">Dispatched</div>
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
      <h2>Orders Catalog</h2>
        <c:forEach var="product" items="${orderProducts}">
            <a href="productDetails?id=${product.getId()}">
               <a href="productDetails?id=${product.getId()}&orderId=${product.getOrdId()}">
 
                    <div class="product-card">
                    <img class="card-img-top" src="${product.getImageUrl()}" alt="${product.getName()}">
                    <div class="product-details">
                        <div class="product-title">${product.getName()}</div>
                        <div class="product-description">${product.getDescription()}</div>
                        <div class="product-price">${product.getPrice()}</div></a>
                        <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'out for delivery' && product.getShipStat() != 'cancelled'}">
                            <button class="btn btn-danger cancel-order-btn" data-orderproid="${product.getId()}"  data-orderid="${product. getOrdId()}" >Cancel Order</button>
                        </c:if>
                        <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'cancelled'}">
                            <button class="btn btn-primary track-order-btn" data-orderproid="${product.getId()}"   data-orderid="${product. getOrdId()}">Track Order</button>
                        </c:if>
                  
                    </div>
                </div>
            
        </c:forEach>
    </div>


  
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Catalog</title>
            <link rel="stylesheet" type="text/css" href="./css/orders.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/orders.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
 
</head>
<body >
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
                <div class="status">Dispatched</div>
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
    
  <div id="BillModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <h2>Invoice</h2>
    <table>

      <tr>
        <th>Bill No:</th>
        <td><span id="billNo"></span></td>
      </tr>
      <tr>
        <th>Order Date:</th>
        <td><span id="orderDate"></span></td>
      </tr>
      <tr>
        <th>Payment Mode:</th>
        <td><span id="paymentMode"></span></td>
      </tr>
      <tr>
        <th>Shipping Address:</th>
        <td><span id="shippingAddress"></span></td>
      </tr>
      <tr>
        <th>Shipment Date:</th>
        <td><span id="shipmentDate"></span></td>
      </tr>
      <tr>
        <th>Quantity:</th>
        <td><span id="quantity"></span></td>
      </tr>
      <tr>
        <th>GST:</th>
        <td><span id="gst"></span></td>
      </tr>
      <tr>
        <th>Price:</th>
        <td><span id="price"></span></td>
      </tr>
    </table>
  </div>
</div>
    

 
    
  <div class="container">
      <h2>Orders Catalog</h2>
        <c:forEach var="product" items="${orderProducts}">
               <a href="productDetails?id=${product.getId()}&orderId=${product.getOrdId()}">
 
                    <div class="product-card">
                    <img class="card-img-top" src="${product.getImageUrl()}" alt="${product.getName()}">
                    <div class="product-details">
                        <div class="product-title">${product.getName()}</div>
                        <div class="product-description">${product.getDescription()}</div>
                        <div class="product-price">${product.getPrice()}</div></a>
                        <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'out for delivery' && product.getShipStat() != 'cancelled'}">
                            <button class="btn btn-danger cancel-order-btn" data-orderproid="${product.getId()}"  data-orderid="${product. getOrdId()}" >Cancel Order</button>
                        </c:if>
                        <c:if test="${product.getShipStat() != 'delivered' && product.getShipStat() != 'cancelled'}">
                            <button class="btn btn-primary track-order-btn" data-orderproid="${product.getId()}"   data-orderid="${product. getOrdId()}">Track Order</button>
                        </c:if>
                   <c:if test="${product.getShipStat() != 'cancelled'}">
                        
                   <button class="btn btn-primary view-bill-btn" data-productid="${product.getId()}" data-orderid="${product.getOrdId()}">View Bill</button>
                       </c:if>
                    </div>
                </div>
            
        </c:forEach>
    </div>


  
</body>
</html>