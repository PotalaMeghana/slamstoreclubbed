function navigateToPage(page) {
    var nextPage = parseInt(page) + 1;
 	nextPage-=1;
    console.log('in navigation next',nextPage);
    /*window.location.href = "/listOrders?page=" + nextPage;*/
    
      $.ajax({
    		    url: "listStocksForPagination",
    		    method: 'GET',
    		    data: { nextPage: nextPage },
    		    success: function(response) {
    		    	 $('#content').html(response);
    		    },
    		    error: function(xhr, status, error) {
    		      console.log('AJAX Error: ' + error);
    		    }
    		  });
}
