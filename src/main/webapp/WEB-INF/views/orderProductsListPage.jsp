<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.admin.entities.orderModel, eStoreProduct.model.admin.output.orderProductsModel,eStoreProduct.DAO.common.OrderDAO, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/orderProductsListPage.css">

<script src="./js/orderProductsListPage.js"></script>

</head>
<body>
<div class="container-fluid"> 
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>Quantity</th>
                <th>GST </th>
                <th>Price</th>
                <th>Shipment Status</th>
                <th>Change Status</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>

        <% List<orderProductsModel> orderproducts = (List<orderProductsModel>) request.getAttribute("orderproducts"); %>
        <% for (orderProductsModel op : orderproducts) {
            if(op != null) { %>
            <tr>
                <td id="orderId" value="<%= op.getOrdr_id() %>"><%= op.getOrdr_id() %></td>
                <td id="productId" value="<%= op.getProd_id() %>"><%= op.getProd_id() %></td>
                <td><%= op.getOrpr_qty() %></td>
                <td><%= op.getOrpr_gst() %></td>
                <td><%= op.getOrpr_price() %></td>
                <td><%= op.getShipment_status() %></td>
                <td>
                    <% if(!(op.getShipment_status().equalsIgnoreCase("delivered")) && (!(op.getShipment_status().equalsIgnoreCase("cancelled")))) {
                    %>
                        <select id="statusSelect">
                        	<option value="ChangeStatus" selected>Change Status</option>
                            <option value="Dispatched" <%= op.getShipment_status().equalsIgnoreCase("dispatched") ? "selected" : "" %>>Dispatched</option>
                            <option value="OutForDelivery" <%= op.getShipment_status().equalsIgnoreCase("out for delivery") ? "selected" : "" %>>Out For Delivery</option>
                            <option value="Delivered" <%= op.getShipment_status().equalsIgnoreCase("delivered") ? "selected" : "" %>>Delivered</option>
                        </select> 
                        <td>
                            <button class="btn btn-success" id="updateBtn">Update</button>
                        </td>
                    <% } else { %>
                        can't edit
                    <% } %>
                </td>
            </tr>
            <% }} %>

        </tbody>
    </table> 
</div>

<script>
$(document).ready(function() {
    $('select#statusSelect').each(function() {
        var shipmentStatus = $(this).closest('tr').find('td:eq(5)').text();
        var optionsToDisable = [];
        
        if (shipmentStatus === "Dispatched") {
            optionsToDisable = ["Dispatched"];
        } else if (shipmentStatus === "OutForDelivery") {
            optionsToDisable = ["Dispatched", "OutForDelivery"];
        } else if (shipmentStatus === "Delivered") {
            optionsToDisable = ["Dispatched", "OutForDelivery", "Delivered"];
        }
        
        var $options = $(this).find('option');
        
        $options.each(function() {
            if ($.inArray($(this).val(), optionsToDisable) !== -1) {
                $(this).prop('disabled', true);
            }
        });
    });
});
</script>

</body>
</html>
