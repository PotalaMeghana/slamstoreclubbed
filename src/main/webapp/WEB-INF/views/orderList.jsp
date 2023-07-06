<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="eStoreProduct.model.admin.entities.orderModel,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
<link rel="stylesheet" type="text/css" href="./css/orderList.css">

 
    <script src="./js/orderList.js"></script>
</head>
<body>

<div class="container mt-5">
    <h2>Order List</h2>
    <div class="filters">
        <label for="dateRangeFilter">Date Range Filter:</label>
        <select id="dateRangeFilter" onchange="changeByDate()">
            <option value="All">All</option>
            <option id="daily" value="daily">Daily</option>
            <option id="weekly" value="weekly">Weekly</option>
            <option id="monthly" value="monthly">Monthly</option>
        </select>
        <label for="processedStatusFilter">Processed Status Filter:</label>
        <select id="processedStatusFilter" onchange="processedStatusFilter()">
            <option value="">All</option>
            <option id="processed" value="processed">Processed</option>
            <option id="unprocessed" value="unprocessed">Unprocessed</option>
        </select>
    </div>
</div>

<div class="container mt-5">
    <table id="tableData" class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr  class="order-row" >
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Bill Number</th>
                <th>Order Date</th>
                <th>Total</th>
                <th>GST</th>
                <th>Payment Reference</th>
                <th>Payment Mode</th>
                <th>Payment Status</th>
                <th>Shipment Status</th>
                <th>Shipping Address</th>
                <th>Shipping Pincode</th>
         
                <th>Shipment Date</th>
                <th>Processed By</th>
            </tr>
        </thead>
        <tbody>
         <% List<orderModel> orders=(List<orderModel>)request.getAttribute("orders"); %>
            <% for (orderModel order : orders) {%>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getOrdr_cust_id() %></td>
                <td><%= order.getBillNumber() %></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.getTotal() %></td>
                <td><%= order.getGst() %></td>
                <td><%= order.getPaymentReference() %></td>
                <td><%= order.getPaymentMode() %></td>
                <td><%= order.getPaymentStatus() %></td>
                 <td><%= order.getShipment_status() %></td>
                <td><%= order.getShippingAddress() %></td>
                <td><%= order.getShippingPincode() %></td>
           
                <td><%= order.getShipmentDate() %></td>
                <td>
                    <% if (order.getOrdr_processedby() == null) { %>
                        <button id="red-button" class="btn btn-danger" data-order-id="<%= order.getId() %>">Unprocessed</button>
                    <% } else { %>
                        <button class="btn <%= (order.getOrdr_processedby() == null) ? "btn-danger" : "btn-success" %>" data-order-id="<%= order.getId() %>"><%= order.getOrdr_processedby() %></button>
                    <% } %>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <div class="pagination">
    <c:if test="${page > 0}">
        <a href="javascript:navigateToPage(${page - 1})">Previous</a>
    </c:if>
    
    <c:forEach var="pageNumber" begin="0" end="${totalPages - 1}">
        <c:choose>
            <c:when test="${pageNumber == page}">
                <span class="current-page">${pageNumber + 1}</span>
            </c:when>
            <c:otherwise>
                <a href="javascript:navigateToPage(${pageNumber})">${pageNumber + 1}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
    <c:if test="${page < totalPages - 1}">
        <a href="javascript:navigateToPage(${page + 1})">Next</a>
    </c:if>
</div>
</div>

 


</body>
</html>
