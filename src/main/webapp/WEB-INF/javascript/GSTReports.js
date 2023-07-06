
        function toggleDropdownGST(rowId) {
            var dropdown = document.getElementById('dropdown-' + rowId);
            dropdown.style.display = dropdown.style.display === 'none' ? 'block' : 'none';
            loadOrderProductsContent(rowId);
        } 
        function loadOrderProductsContent(orderId) {
            console.log("In viewing Order's Products specific to order ID: ", orderId);
            $.ajax({
                url: "displayProcessedOrderProducts",
                method: 'GET',
                data: { orderId: orderId }, // Pass the orderId as data
                success: function (response) {
                    $('#orderproducts-' + orderId).html(response); // Set the response HTML as the inner HTML of the orderproducts container
                },
                error: function (xhr, status, error) {
                    console.log('AJAX Error: ' + error);
                }
            });
        }
  
