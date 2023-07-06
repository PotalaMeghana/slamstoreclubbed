<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="eStoreProduct.model.admin.entities.orderModel,java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <title>Order List</title>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/GSTReports.css">

 
    <script src="./js/GSTReports.js"></script>
  
</head>
<body>
<%List<orderModel> orders=(List<orderModel>)request.getAttribute("orders");
System.out.println("jello\n"+orders.get(0).getGst());%>
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Bill Number</th>
                <th>Order Date</th>
                <th>Total</th>
                <th>GST</th>
                <th>Payment Reference</th>
              <!--   <th>Payment Mode</th>
                <th>Payment Status</th>
                <th>Shipping Pincode</th> -->
                <th>Processed By</th>
            </tr>
        </thead>
        <tbody>
        <% double gstTotal = 0;
        double grandTotal = 0;
        for (orderModel viewModel : orders) {
            gstTotal += viewModel.getGst();
            grandTotal += viewModel.getTotal();
        %>
            <tr onclick="toggleDropdownGST('<%= viewModel.getId() %>')">
                <td><%= viewModel.getId() %></td>
                <td><%= viewModel.getOrdr_cust_id() %></td>
                <td><%= viewModel.getBillNumber() %></td>
                <td><%= viewModel.getOrderDate() %></td>
                <td><%= viewModel.getTotal() %></td>
                <td><%= viewModel.getGst() %></td>
                <td><%= viewModel.getPaymentReference() %></td>
              <%--   <td><%= viewModel.getPaymentMode() %></td>
                <td><%= viewModel.getPaymentStatus() %></td>
                <td><%= viewModel.getShippingPincode() %></td> --%>
                <td><%= viewModel.getOrdr_processedby() %></td>
            </tr>
            <tr>
                <td colspan="11" class="dropdown-content" id="dropdown-<%= viewModel.getId() %>">
                    <!-- Dropdown content here -->
                    <div id="orderproducts-<%= viewModel.getId() %>"></div> <!-- Container to hold the order products -->
                </td>
            </tr>
        <% } %>
            <tr class="total-row">
                <td colspan="4">Total</td>
                <td><%= grandTotal %></td>
                <td><%= gstTotal %></td>
                <td colspan="5"></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
