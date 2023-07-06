
    $(document).on('click', '.add-region', function(event) {
	    event.preventDefault();
	   console.log("enteredadd-region");
	    addRegion();
 });
function addRegion(){
	console.log("in displayShippingConfig");
	var regionName = document.getElementById("name").value;
		var regionPinFrom = document.getElementById("pinFrom").value;
		var regionPinTo = document.getElementById("pinTo").value;
		var regionSurcharge = document.getElementById("surCharge").value;
		var regionPriceWaiver = document.getElementById("priceWavier").value;
	  $.ajax({
	      url: "addRegion",
	      method: 'POST',
	      data:{
	    	 regionId:1,
	  		regionName: regionName,
	  		regionPinFrom : regionPinFrom,
	  		regionPinTo : regionPinTo,
	  		regionSurcharge : regionSurcharge,
	  		regionPriceWaiver : regionPriceWaiver
	      },
	      success: function(response) {
	      console.log(response) ;
	      dis();// Set the response HTML as the inner HTML of the select element
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    }); 
}
/* $(document).on('click', '.removereg', function(event) {
    event.preventDefault();
   console.log("enteredadd-region");
    remRegion();
}); */
function removereg(id){
	//var regionName = document.getElementById("name").value;
	 console.log(id);
	 $.ajax({
	      url: "remRegion",
	      method: 'POST',
	      data:{
	    	 regionId:id
	      },
	      success: function(response) {
	      console.log(response);
	      	// Set the response HTML as the inner HTML of the select element
	      dis();
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    }); 
}
function dis(){
	 $.ajax({
	      url: "ShippingRedirect",
	      method: 'GET',
	      success: function(response) {
	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    });
}

  