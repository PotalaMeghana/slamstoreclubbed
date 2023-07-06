// Function to display the modal
function displayModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
}

// Function to close the modal
function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "none";
}

// Document ready event listener
document.addEventListener('DOMContentLoaded', function () {
    var productDescription = document.querySelector('.product-description');
    var cancelOrderButton = document.querySelector('.cancel-order-btn');
    var trackOrderButtons = document.querySelectorAll('.track-order-btn');

    // Event listener for product description click
    productDescription.addEventListener('click', function () {
        productDescription.classList.toggle('expanded');
    });

    // Event listener for cancel order button click
    $('.cancel-order-btn').click(function () {
        var ordprod = $('#orderproId').val();
        var ordId = $('#orderId').val();

        // Send an AJAX request to the server to cancel the order
        $.ajax({
            url: 'cancelOrder',
            type: 'POST',
            data: {
                orderproId: ordprod,
                orderId: ordId
            },
            success: function (response) {
                // Display the modal
                displayModal('cancelOrderModal');
            },
            error: function (xhr, status, error) {
                // Handle any errors or display error message
            }
        });
    });

    // Event listener for track order button click
    $('.track-order-btn').click(function () {
        var ordprod = $('#orderproId').val();
        var ordId = $('#orderId').val();

        $.ajax({
            url: 'trackOrder',
            type: 'GET',
            data: {
                orderproId: ordprod,
                orderId: ordId
            },
            success: function (response) {
                // Update the track order modal with the shipment status
                var shipmentStatus = response;
                updateShipmentStatus(shipmentStatus);

                // Open the track order modal
                displayModal('trackOrderModal');
            },
            error: function (xhr, status, error) {
                // Handle the error case
                console.log(error);
            }
        });
    });

    // Function to update shipment status dots
    function updateShipmentStatus(shipmentStatus) {
        // Reset all dots to the default color
        $('.dot').css('background-color', 'gray');

        // Determine the index of the current shipment status
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
            case 'Delivered':
                statusIndex = 4;
                break;
            default:
                statusIndex = -1;
                break;
        }

        // Update the color of the corresponding dot
        if (statusIndex >= 0) {
            $('.dot').eq(statusIndex).css('background-color', 'green');
        }
    }

    // Close the modal when the close button is clicked
    $('.close').click(function () {
        var modalId = $(this).closest('.modal').attr('id');
        closeModal(modalId);
    });
});
