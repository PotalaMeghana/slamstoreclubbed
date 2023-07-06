<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.utility.dashboardUtilityClass" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard Example</title>
	  <link rel="stylesheet" type="text/css" href="./css/admin.css">
	
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="./js/admin.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    
</head>
<body>
    <div class="dashboard" id="dashboard">
        <h2>Dashboard</h2>
        <ul>
            
            <li><a href="#" class="profile-link">Profile</a></li>
            <li><a href="#" class="orders-link">Orders</a></li>
			<li><a href="#" class="Shipments-SubOptions">Shipments</a>
				 <ul class="sub-menu" >
	                <li><a href="#" class="see-shipping-orders">In Progress</a></li>
	                <li><a  href="#" class="track-shipments">Shipped</a></li>
            	</ul>
			</li>
			
			<li><a href="#" class="Master-Entry-SubOptions">Master Entry</a>
			  
            <ul class="sub-menu" >
                <li><a href="#" class="Master-Entry-Link">Update Stocks</a></li>
                <li><a href="#" class="price-review-Link">Price Review</a></li>
                <li><a  href=# class="add-new-product-link">Add New Product</a></li>
                <li><a href="#" id="add-new-category-link">Add New Category</a></li>
            </ul>
			</li>
			<li><a href="#" class="stocks-Link">Stocks</a></li>
            <li><a href="#" class="payments-link">payments</a></li>
             <li class="dropdown">
            <a href="#" class="dropdown-toggle" onclick="toggleDropdown()">Settings</a>
            <ul class="dropdown-menu" id="settingsDropdown" style="background-color: #212529">
                <li><a href="#" class="Email-Configuration">Email Configuration</a></li>
                <li><a href="#" class="Shipping-Config">Shipping Area Config</a></li>
                <li><a href="#" class="Master-Entry-SubOptions">shipping charges</a>
                <ul class="sub-menu" >
                <li><a href="#" class="OrderValueWise">OrderValueWise</a></li>
              
            </ul>
			</li>
            </ul>
        </li>
        	 <li><a href="#" class="GST-Report">GST Report</a></li>
        <li><a href="#" class="CAT-Report">Category wise Report</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </div>
    
    <div class="menu-icon" onclick="toggleMenu()">
        <span></span>
        <span></span>
        <span></span>
    </div>
    
    <div class="content" id="content">
    <div class="dashboard-mine">
        <h1>DashBoard</h1>
        <p>view Stocks and sales</p>
        <% dashboardUtilityClass dash = (dashboardUtilityClass) session.getAttribute("dash"); %>
        <div class="data-visualization">
            <div class="item">
                <h3>Orders</h3>
                <p><%=dash.getNoOfOrders() %></p>
            </div>
            <div class="item">
                <h3>Products</h3>
                <p><%=dash.getNoOfProducts() %></p>
            </div>
            <div class="item">
                <h3>Registered Customers</h3>
                <p><%=dash.getNoOfCustomers() %></p>
            </div>
        </div>
        </div>
        <div class="graph-container">
  <canvas id="productGraph"></canvas>
</div>
        
    </div>
</body>
</html>