
// Handle the click event of the "Close" button inside the modal content
$(document).on('click', '#updateModal .btn-secondary', function () {
    // Close the modal
    $('#updateModal').modal('hide');
});

    $(document).ready(function () {
        var orderId = 0; // Default orderId value
        
        // Handle the click event of the "Update" button
        $(document).on('click', '#update-button', function () {
            orderId = $(this).data("order-id"); // Get the orderId from the clicked button
            $('#updateModal').modal('show');
        });

        // Handle the click event of the "Load Content" button
        $(document).on('click', '.load-content-button', function (event) {
            event.preventDefault();
            console.log("Open orderedProducts specific to that order-id: ", orderId);
            loadOrderProductsContent(orderId);
        });

        function loadOrderProductsContent(orderId) {
            console.log("In viewing Order's Products specific to order ID: ", orderId);
            $.ajax({
                url: "displayProcessedOrderProductsToUpdateStatus",
                method: 'GET',
                data: { orderId: orderId }, // Pass the orderId as data
                success: function (response) {
                    $('#load-content').html(response); // Set the response HTML as the inner HTML of the load-content div
                },
                error: function (xhr, status, error) {
                    console.log('AJAX Error: ' + error);
                }
            });
        }
    });
