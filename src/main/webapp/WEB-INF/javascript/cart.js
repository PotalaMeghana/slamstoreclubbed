// Function to execute on document ready
$(document).ready(function() {
  updateCostOnLoad();
});
 function disableBuyNow(){
    	var button = document.getElementById("BuyNow");
    	button.setAttribute("disabled", "true");
    	document.getElementById("outOfStockMsg").innerHTML="Remove the Out of stock products";
    	 //toastr.error("Message", "Title", { disableTimeOut: true, closeButton:true });
    }
// Function to handle "Buy Now" button click
function buynow() {
  var notAvailable = $(".not-available");
  var outstock = $(".stockp");
  console.log("outstock.length=="+outstock.length);
  if (outstock.length>0) {
  alert("Please check the Product Stock Availability");
  } else {
   if (notAvailable.length > 0) {
      alert("Please check the availability of Shipment Location before placing an order!");
    } else {
      $.ajax({
        url: 'buycartitems',
        method: 'GET',
        success: function(response) {
          $('#payment').html(response);
        },
        error: function(xhr, status, error) {
          console.log('AJAX Error: ' + error);
        }
      });
    }  }
}

// Function to update quantity
function updateQuantity(input) {
  var quantity = input.value;
  var productId = input.getAttribute('data-product-id');

  $.ajax({
    url: 'updateQuantity',
    method: 'POST',
    data: { productId: productId, quantity: quantity },
    success: function(response) {
      $("#tcost").html("Total Cost: " + response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to update cost on page load
function updateCostOnLoad() {
  $.ajax({
    url: 'updateCostOnLoad',
    method: 'POST',
    success: function(response) {
      $("#tcost").html("Total Cost: " + response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to show product details
function showProductDetails(productId) {
  window.location.href = "prodDescription?productId=" + productId;
}

// Function to decrease quantity
function decreaseQuantity(input) {
  var quantityInput = input.parentNode.parentNode.querySelector('input[type="text"]');
  var currentQuantity = parseInt(quantityInput.value);

  if (currentQuantity > 1) {
    quantityInput.value = currentQuantity - 1;
    updateQuantity(quantityInput);
  }
}

// Function to increase quantity
function increaseQuantity(input) {
  var quantityInput = input.parentNode.parentNode.querySelector('input[type="text"]');
  var currentQuantity = parseInt(quantityInput.value);

  quantityInput.value = currentQuantity + 1;
  updateQuantity(quantityInput);
}

// Function to check pincode availability on document ready
$(document).ready(function() {
  var pin = $("#custPincode");
  checkPincodeAvailability(pin.val());
});

// Function to check pincode availability
function checkPincodeAvailability(pincode) {
  console.log("Checking pincode availability for Pincode: " + pincode);

  $.ajax({
    type: "POST",
    url: "checkPincode",
    data: { pincode: pincode },
    success: function(response) {
      var availabilityElement = $("#availability");
      console.log(response);
      if (response == "true") {
        availabilityElement.text("Shipment is Available for this Pincode").removeClass("not-available").addClass("available");
      } else {
        availabilityElement.text("Shipment is not Available for this Pincode").removeClass("available").addClass("not-available");
      }
    },
    error: function(error) {
      console.error(error);
    }
  });
}

// Function to handle "Change Address" button click
$(document).ready(function() {
  $('.changeaddress').click(function(e) {
    e.preventDefault();
    var submitButton = $(this);

    var name = $("#custName").val();
    var add = $("#custSAddress").val();
    var pin = $("#custPincode").val();

    $.ajax({
      type: 'POST',
      url: 'updateshipment',
      data: { name: name, custSAddress: add, custSpincode: pin },
      success: function(response) {
        console.log(response);
        if (response === "Valid") {
          toastr.success("Address Changed");
        } else {
          toastr.info("Shipment is Not available for this Address");
        }
      },
      error: function(error) {
        console.error(error);
      }
    });
  });
});
