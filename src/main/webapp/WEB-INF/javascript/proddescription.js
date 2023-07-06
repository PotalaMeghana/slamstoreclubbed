  document.addEventListener('DOMContentLoaded', function() {
    var button = document.getElementById("buynow");
    var stockValue = document.getElementById("psd").value; // Assuming you have retrieved the stock value as explained in the previous response
if (stockValue <= 5) {
    console.log("button disabled");
    
    button.setAttribute("disabled", "true");
    button.innerHTML = "Out of Stock";
  }
  });
$(document).ready(function(){
	  var pin=$("#custPincode");
	  console.log(pin.val());
	  checkPincodeAvailability(pin.val());
	  
	});


    $(document).ready(function() {
        $('#shipment-form').submit(function(e) {
            e.preventDefault();
            var submitButton = $(this).find('input[type="submit"]');
            console.log("shipment address");

            var name = $("#custName").val();
            var add = $("#custSAddress").val();
            var pin = $(".custPincode").val(); // Corrected id here
            console.log(pin);

            $.ajax({
                type: 'POST',
                url: 'updateshipment',
                data: { name: name, custSAddress: add, custSpincode: pin },
                success: function(response) {
                    console.log(response);
                    if (response === "Valid") {
                        submitButton.val("Changed");
                    } else {
                        alert("Shipment is Not available for this Address");
                    }
                },
                error: function(error) {
                    console.error(error);
                }
            });
        });
    });

    function buyproduct(productId) {
        var qty = $("#qtyinp").val();
        console.log(qty + " quantity");
        var notAvailable = $(".not-available");
if (notAvailable.length > 0) {
            alert("Please check the availability of Shipment Location ");
        }  
        
        else{
        $.ajax({
            url: "checkloginornot",
            method: 'GET',
            data: { productId: productId },
            success: function(response) {
                if (response === "true") {
                    window.location.href = "buythisproduct?productId=" + productId + "&qty=" + qty;
                } else {
                    alert("Please sign in");

                    window.location.href = "signIn";
                }
            },
            error: function(xhr, status, error) {
                console.log('AJAX Error: ' + error);
            }
        });
        }
    }

    $(document).ready(function() {
        $(document).on('click', '.buynow', function(event) {
            event.preventDefault();
            var productId = $(this).data('product-id');
            buyproduct(productId);
        });
    });
  


    function checkPincodeAvailability(pincode) {
        console.log("Checking pincode availability for Product ID: "+pincode);

        $.ajax({
            type: "POST",
            url: "checkPincode",
            data: { pincode: pincode },
            success: function(response) {
                var availabilityElement = $("#availability");
                console.log(response);
                if (response=="true") {
                    availabilityElement.text("Available").removeClass("not-available").addClass("available");
                } else {
                    availabilityElement.text("Not Available").removeClass("available").addClass("not-available");
                }
            },
            error: function(error) {
                console.error(error);
            }
        });
    }


   function showProductDetails(productId) {
        window.location.href = "prodDescription?productId=" + productId;
        console.log(productId);
    }

