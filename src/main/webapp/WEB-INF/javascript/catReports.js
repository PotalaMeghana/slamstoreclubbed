
function totalGST(){
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


