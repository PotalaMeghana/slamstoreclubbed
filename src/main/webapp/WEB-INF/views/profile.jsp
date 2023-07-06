<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.customer.input.custCredModel" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
    <link rel="stylesheet" type="text/css" href="./css/profile.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/profile.js"></script>

</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 


<body>

     <div class="sidebar">
         <div class="user-info">
              <img src="https://tse4.mm.bing.net/th?id=OIP.CUmXK7A3sWtCO2KP_yPztgAAAA&pid=Api&P=0&h=180" alt="User Icon">
               <h1>Hey! ${cust != null ? cust.custName : ""}</h1>
         </div>
         <ul>                
                <li><a href="#" class="checkCustomerOrders">&#128142; Orders</a></li>    
                
    <li><a href="#" class="cart-button" id="cart-button">&#128722; Cart</a></li>
             <li><a href="#" class="Wishlist-button" id="Wishlist-button">&#10084; WishList</a></li>
             
               <li><a href="logout">LogOut</a></li>
                <li><a href="loggedIn">Home</a></li>
            </ul>
     </div>
     <div class="content" id="content"> 
       <div style="display: flex; justify-content: space-between; align-items: center;">
             <h1>Welcome to the the store</h1>
       </div>
       <div id="payment">
         <div id="edit">
            <h1>Customer Profile</h1>
            <table>
                <tr>
                    <th>Customer ID</th>
                    <td>${cust != null ? cust.custId : ""}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${cust != null ? cust.custName : ""}</td>
                </tr>
                <tr>
                    <th>Mobile</th>
                    <td>${cust != null ? cust.custMobile : ""}</td>
                </tr>
                <tr>
                
                    <th>Location</th>
                    <td>${cust != null ? cust.custLocation : ""}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${cust != null ? cust.custEmail : ""}</td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>${cust != null ? cust.custAddress : ""}</td>
                </tr>
                <tr>
                    <th>Pincode</th>
                    <td>${cust != null ? cust.custPincode : ""}</td>
                </tr>
                <tr>
                    <th>Shipping Address</th>
                    <td>${cust != null ? cust.custSAddress : ""}</td>
                </tr>
                <tr>
                    <th>Shipment Pincode</th>
                    <td>${cust != null ? cust.custSpincode : ""}</td>
                </tr>
                <tr>
                    <th>Last Login Date</th>
                    <td>${cust != null ? cust.custLastLoginDate : ""}</td>
                </tr>
            </table> 
<button onclick="editprofile()">EDIT-PROFILE</button>
        </div>
        </div>
  </div>
<script>

function editprofile() {
    var ele = document.getElementById("edit");
    ele.innerHTML = `
    <form action="updateProfile" method="post">    
        <label>CustomerId:</label>
        <input type="text" id="custId" name="custId" value="${cust != null ? cust.custId : ""}" readonly><br>

        <label for="custName">Name:</label>
        <input type="text" id="custName" name="custName" value="${cust != null ? cust.custName : ""}"><br>

        <label for="custMobile">Mobile:</label>
        <input type="text" id="custMobile" name="custMobile" value="${cust != null ? cust.custMobile : ""}"><br>

        <label for="custLocation">Location:</label>
        <input type="text" id="custLocation" name="custLocation" value="${cust != null ? cust.custLocation : ""}"><br>

        <label for="custAddress">Address:</label>
        <input type="text" id="custAddress" name="custAddress" value="${cust != null ? cust.custAddress : ""}"><br>
        
        <label for="custPincode">Pincode:</label>
        <input type="text" id="custPincode" name="custPincode" value="${cust != null ? cust.custPincode : ""}"><br>

        <label for="custSAddress">Shipping Address:</label>
        <input type="text" id="custSAddress" name="custSAddress" value="${cust != null ? cust.custSAddress : ""}"><br>

        <label for="custsPincode">Shipment Pincode:</label>
        <input type="text" id="custsPincode" name="custSpincode" value="${cust != null ? cust.custSpincode : ""}"><br>

        <input type="submit" value="Update Profile">
    </form>`;
}
</script>
</body>
</html>