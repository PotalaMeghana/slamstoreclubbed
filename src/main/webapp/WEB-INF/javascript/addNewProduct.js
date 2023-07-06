 
    $(document).on('change', '#categoryDropdown', function(event) {
        event.preventDefault();
        var ctg_id = document.getElementById("categoryDropdown").value;
        console.log(ctg_id);
        document.getElementById("prod_prct_id").value = parseInt(ctg_id);
    });
	function clear(){
		 document.getElementById("createNewProducts").reset();	
	}
    $(document).on('click', '#clr', function(event) {
    event.preventDefault();
    clear();
    });

 
