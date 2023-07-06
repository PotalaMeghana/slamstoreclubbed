$(document).ready(function() {
	// Function to display the modal
	function displayModal(modalId) {
		var modal = $('#' + modalId);
		modal.css('display', 'block');
	}

	// Function to close the modal
	function closeModal(modalId) {
		var modal = $('#' + modalId);
		modal.css('display', 'none');
	}

	// Function to hide cancel and track order buttons
	function hideButtons(orderproId, orderId) {
		$('.cancel-order-btn[data-orderproid="' + orderproId + '"][data-orderid="' + orderId + '"]').hide();
		$('.track-order-btn[data-orderproid="' + orderproId + '"][data-orderid="' + orderId + '"]').hide();
		$('.view-bill-btn[data-productid="' + orderproId + '"][data-orderid="' + orderId + '"]').hide();
	}


	$('.view-bill-btn').click(function() {
		var orderId = $(this).data('orderid');
		var productId = $(this).data('productid');

		var viewBillButton = $(this);

		$.ajax({

			url: 'viewInvoice',
			type: 'GET',
			data: {
				orderId: orderId,
				productId: productId

			},

			success: function(response) {
				var dataString = response.replace('Invoice ', '');

				// Remove the brackets [ ]
				dataString = dataString.slice(1, -1);

				// Split the string into key-value pairs
				var keyValuePairs = dataString.split(', ');

				// Create an object to store the extracted values
				var invoiceData = {};

				// Iterate over the key-value pairs and extract the values
				for (var i = 0; i < keyValuePairs.length; i++) {
					var pair = keyValuePairs[i].split('=');
					var key = pair[0];
					var value = pair[1];

					// Remove any leading or trailing whitespace
					key = key.trim();
					value = value.trim();
					console.log(value + "keyyy")

					// Assign the value to the corresponding key in the invoiceData object
					invoiceData[key] = value;
				}
				$('#billNo').text(invoiceData.billNo);
				$('#orderId').text(invoiceData.orderId);
				$('#orderDate').text(invoiceData.orderDate);
				$('#paymentMode').text(invoiceData.paymentMode);
				$('#shippingAddress').text(invoiceData.shippingAddress);
				$('#shipmentDate').text(invoiceData.shipmentDate);
				$('#quantity').text(invoiceData.quantity);
				$('#gst').text(invoiceData.gst);
				$('#price').text(invoiceData.price);

		

				displayModal('BillModal');
				/*hideButtons(orderproId, orderId);*/
			},
			error: function(xhr, status, error) {
				console.log(this.url)
				// Handle any errors or display error message
			}
		});
	});

	// Event listener for cancel order button click
	$('.cancel-order-btn').click(function() {
		var orderproId = $(this).data('orderproid');
		var orderId = $(this).data('orderid');
		var cancelButton = $(this);

		$.ajax({
			url: 'cancelOrder',
			type: 'POST',
			data: {
				orderproId: orderproId,
				orderId: orderId
			},
			success: function(response) {
				displayModal('cancelOrderModal');
				hideButtons(orderproId, orderId);
			},
			error: function(xhr, status, error) {
				// Handle any errors or display error message
			}
		});
	});

	// Event listener for track order button click
	$('.track-order-btn').click(function() {
		var orderproId = $(this).data('orderproid');
		var orderId = $(this).data('orderid');
		console.log("orderId:", orderId);

		$.ajax({
			url: 'trackOrder',
			type: 'GET',
			data: {
				orderproId: orderproId,
				orderId: orderId
			},
			success: function(response) {
				updateShipmentStatus(response);
				displayModal('trackOrderModal');
			},
			error: function(xhr, status, error) {
				// Handle the error case
			}
		});
	});


	// Function to update shipment status dots
	function updateShipmentStatus(shipmentStatus) {
		$('.dot').css('background-color', 'gray');
		console.log("track");

		var statusIndex;
		switch (shipmentStatus) {
			case 'Order_Placed':
				statusIndex = 0;
				break;
			case 'Order Processed':
				statusIndex = 1;
				break;
			case 'dispatched':
				statusIndex = 2;
				break;
			case 'Out for Delivery':
				statusIndex = 3;
				break;
			case 'delivered':
				statusIndex = 4;
				break;
			default:
				statusIndex = -1;
				break;
		}

		if (statusIndex >= 0) {
			$('.dot').eq(statusIndex).css('background-color', 'green');
		}
	}


	// Close the modal when the close button is clicked
	$('.close').click(function() {
		var modalId = $(this).closest('.modal').attr('id');
		closeModal(modalId);
	});
});