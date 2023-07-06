<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="eStoreProduct.model.customer.input.custCredModel" %>
<!DOCTYPE html>
<html>
<head>
  <title>SLAM Store</title>

    <link rel="stylesheet" type="text/css" href="./css/home.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="./js/home.js"></script>
 <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
  
<script>
toastr.options = {
		  "closeButton": false,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-bottom-right",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		};
  var customerSession = {
    customer: '<%= session.getAttribute("customer") %>'
  };
</script>
</head>
<body >
  <header>
  <h1><i class="fas fa-shopping-cart"></i> SLAM</h1>
  <nav>
    <ul>
      <li ><a href="loggedIn" style="font-weight: bold;">Home</a></li>
      <li><a href="#" style="font-weight: bold;">About Us</a></li>
      <li><a href="#" style="font-weight: bold;">Contact</a></li>
      <li>
        <form action="/process-category" method="POST">
          <select name="catg" id="catg"></select>
        </form>
      </li>
      <li style="margin-left: auto;"><button type="button" id="cart-button" class="btn btn-primary" style="background-color: '#047bd5'; color: white; font-weight: bold;">Cart</button></li>
      <li><button type="button" id="Wishlist-button" class="btn btn-primary" style="background-color: '#047bd5'; color: white; font-weight: bold;">Wishlist</button></li>
      
      <li class="profile-dropdown">
      
	  <% if (session.getAttribute("customer")==null) { %>
	  
	   <!-- <i class="fas fa-user"></i> -->
	   
		<div style="background-color:#047bd5; display: inline-block; padding: 5px;">
		
		
			
			<svg xmlns="http://www.w3.org/2000/svg" width="26" height="36" fill="currentColor" class="bi bi-person-heart" viewBox="0 0 16 16">
			  <path d="M9 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-9 8c0 1 1 1 1 1h10s1 0 1-1-1-4-6-4-6 3-6 4Zm13.5-8.09c1.387-1.425 4.855 1.07 0 4.277-4.854-3.207-1.387-5.702 0-4.276Z"/>
			</svg>
		</div>
	
	
	    <div class="dropdown-content" style="margin-left: -30px;">
	      <a href="signUp" style="background-color: navy; color: white; font-weight: bold;">Sign Up</a>
	      <a href="signIn" style="background-color: navy; color: white; font-weight: bold;">Sign In</a>
	    </div>
	  <% } else { %>
	    <!-- <i class="fas fa-user"></i> -->
	    <div style="background-color:#047bd5; display: inline-block; padding: 5px;">
	    	<svg xmlns="http://www.w3.org/2000/svg" width="26" height="36" fill="currentColor" class="bi bi-person-heart" viewBox="0 0 16 16">
			  <path d="M9 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-9 8c0 1 1 1 1 1h10s1 0 1-1-1-4-6-4-6 3-6 4Zm13.5-8.09c1.387-1.425 4.855 1.07 0 4.277-4.854-3.207-1.387-5.702 0-4.276Z"/>
			</svg>
		</div>
	    <div class="dropdown-content" style="margin-left: -30px;">
	      <a href="profilePage" style="background-color: navy; color: white; font-weight: bold;">My Profile</a>
	      <a href="logout" style="background-color: navy; color: white; font-weight: bold;">Log Out</a>
	    </div>
	  <% } %>
	</li>
      
    </ul>
  </nav>
</header>
 <div id="payment"> 
  <div class="search-bar">
    <form>
      <input type="search" placeholder="Search..." id="search">
      <button type="submit" id="searchbtn">Search</button>
    </form>
    <br>
    
    
  </div>
  <main>
  <div id="maindiv">
  <div class="text-center">
    <b><label for="sortSelect">Sort By </label></b>
    <select id="sortSelect" onchange="sortProducts()" class="form-select">
        <option value="default">Default</option>
        <option value="lowToHigh">Price (Low to High)</option>
        <option value="highToLow">Price (High to Low)</option>
    </select>
	
	<b><label for="filterSelect">Filter By </label></b>
    <select id="filterSelect" onchange="filterProducts()" class="form-select">
        <option value="default">All</option>
        <option value="0-500">Price (Rs. 0-500)</option>
        <option value="500-1000">Price (Rs. 500-1000)</option>
        <option value="1000-2000">Price (Rs. 1000-2000)</option>
        <option value="2000-4000">Price (Rs. 2000-4000)</option>
    </select>
</div>
  <div id="prod"> 
        <div id="transitionSlideShowPage">
                     <div class="slideshow-container">
                         <div class="slide active">
                             <img  src="https://static.digit.in/default/848e74e131ed5b8172357de25c0afb9bf691029c.jpeg?tr=w-1200" />
                         </div>
                         <div class="slide">
                             <img src="https://mobirise.com/extensions/commercem4/assets/images/3.jpg" alt="Slide 2">
                        </div>
                        <div class="slide">
                               <img src="https://t4.ftcdn.net/jpg/03/38/88/59/240_F_338885943_qQRG84nyD1CcTdXuVD4UbzMz1xBGWjBC.jpg" alt="Slide 3">
                        </div>
                        <div class="slide">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRBQy58C3pHvO6tN7zHCeTqq4L2t2-Kc5ENA&usqp=CAU" alt="Slide 5">
                        </div>
                    </div>
       </div>
    <div id="productsdisplay"></div></div>
   
    </div>
    </div>
    </main>
    
  <footer>
    <!-- <p>&copy; 2023 SLAM Store. All rights reserved.</p> -->
  </footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>