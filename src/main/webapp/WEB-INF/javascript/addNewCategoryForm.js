/**
 * 
 */

   
	function clear(){
		 document.getElementById("createNewCategory").reset();	
	}
    $(document).on('click', '#clr', function(event) {
    event.preventDefault();
    clear();
    });

 
