
    function editProduct(productId) {
        var shippingChargesSpan = document.getElementById("shippingCharges_" + productId);
        var shippingChargesInput = document.getElementById("shippingChargesInput_" + productId);
        var editButton = document.getElementById("editButton_" + productId);
        var saveButton = document.getElementById("saveButton_" + productId);

        // Hide the span and show the input field
        shippingChargesSpan.style.display = "none";
        shippingChargesInput.style.display = "inline-block";
        shippingChargesInput.value = shippingChargesSpan.innerText;

        // Hide the edit button and show the save button
        editButton.style.display = "none";
        saveButton.style.display = "inline-block";
    }

    function saveShippingCharges(productId) {
        var shippingChargesSpan = document.getElementById("shippingCharges_" + productId);
        var shippingChargesInput = document.getElementById("shippingChargesInput_" + productId);
        var editButton = document.getElementById("editButton_" + productId);
        var saveButton = document.getElementById("saveButton_" + productId);

        // Get the updated shipping charges value
        var updatedShippingCharges = shippingChargesInput.value;

        // You can perform further validation or processing here before saving the data

        // Simulate saving the shipping charges to the server
        saveShippingChargesToServer(productId, updatedShippingCharges);

        // Update the span with the new value from the input field
        shippingChargesSpan.innerText = updatedShippingCharges;

        // Hide the input field and show the span
        shippingChargesInput.style.display = "none";
        shippingChargesSpan.style.display = "inline-block";

        // Hide the save button and show the edit button
        saveButton.style.display = "none";
        editButton.style.display = "inline-block";
    }
    function saveShippingChargesToServer(productId, shippingCharges) {
        // Replace this with your custom logic to save the shipping charges to the server
        // You can use AJAX, fetch, or any other method to send the data to the server
        // Example code using fetch:
    	$.ajax({
            url: "prodShipUpdate",
            method: 'POST',
            data:{
            	prod_id:productId,
            	shipment_charges:shippingCharges,
            },
            success: function(response) {
                console.log(response);
                // Set the response HTML as the inner HTML of the select element
                // dis();
            },
            error: function(xhr, status, error) {
                console.log('AJAX Error: ' + error);
            }
        });
    }
