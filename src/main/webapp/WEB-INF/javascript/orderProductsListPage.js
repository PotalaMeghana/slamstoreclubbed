
$(document).on('click', '#updateBtn', function (event) {
    event.preventDefault();
    var selectedStatus = $(this).closest("tr").find("#statusSelect").val();
    var orderId = $(this).closest("tr").find("#orderId").attr("value");
    var productId = $(this).closest("tr").find("#productId").attr("value");
    console.log(selectedStatus);
    // Perform further actions with the selected status
    updateOrderProductStatus(selectedStatus, orderId, productId);
});



function updateOrderProductStatus(selectedStatus, orderId, productId){
    console.log("in Updating status Orders Products specific order id");
    $.ajax({
        url: "updateOrderProductStatus",
        method: 'POST',
        data: { shipment_status: selectedStatus, ordr_id: orderId, prod_id: productId },
        success: function(response) {
            $('#load-content').html(response); // Set the response HTML as the inner HTML of the select element
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error: ' + error);
        }
    });
}

