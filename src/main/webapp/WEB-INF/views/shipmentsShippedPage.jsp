<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.admin.entities.orderModel, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Add jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="./css/shipmentsShippedPage.css">

 
    <script src="./js/shipmentsShippedPage.js"></script>

<!-- Add Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>
<!-- Add jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Add Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>


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
        <label for="processedStatusFilter">Order Value</label>
        <select id="processedStatusFilter" onchange="processedStatusFilter()">
            <option value="">All</option>
            <option id="processed" value="processed">High to Low</option>
            <option id="unprocessed" value="unprocessed">Low to High</option>
        </select>
    </div>
</div>

<div class="container mt-5">
    <table id="tableData" class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Bill Number</th>
                <th>Order Date</th>
                <th>Total</th>
                <th>GST</th>
                <th>Shipment Date</th>
                <th>Shipment Status</th>
            </tr>
        </thead>
        <tbody>
        <% List<orderModel> orders=(List<orderModel>)request.getAttribute("orders"); %>
        <% for (orderModel order : orders) { 
            if (order.getOrdr_processedby() != null) { 
            if((order.getShipment_status().equalsIgnoreCase("delivered")) ||(order.getShipment_status().equalsIgnoreCase("cancelled"))){%>
                <tr>
                    <td class="orderId" data-order-id="<%= order.getId() %>"><%= order.getId() %></td>

                    <td><%= order.getOrdr_cust_id() %></td>
                    <td><%= order.getBillNumber() %></td>
                    <td><%= order.getOrderDate() %></td>
                    <td><%= order.getTotal() %></td>
                    <td><%= order.getGst() %></td>
                    <td><%= order.getShipmentDate() %></td>
                    <td>
                        <button class="btn btn-success update-button" data-bs-toggle="modal" data-bs-target="#updateModal" data-order-id="<%= order.getId() %>">View</button>
                    </td>
                </tr>
        <% }} } %>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateModalLabel">view Order Products</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="load-content">
                    <button class="btn btn-success load-content-button">Load Content</button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>



</body>
</html>
