
        // JavaScript for hamburger menu toggle
     function toggleMenu() {
            var dashboard = document.getElementById('dashboard');
            var menuIcon = document.querySelector('.menu-icon');
            
            if (dashboard.style.left === '-200px') {
                dashboard.style.left = '0';
                menuIcon.classList.add('active');
            } else {
                dashboard.style.left = '-200px';
                menuIcon.classList.remove('active');
            }
        }
        
      $(document).ready(function() {
    	    $('.Master-Entry-SubOptions').click(function(e) {
    	    	 e.preventDefault();
    	        $(this).next('.sub-menu').slideToggle();
    	    });
    	});

      $(document).ready(function() {
  	    $('.Shipments-SubOptions').click(function(e) {
  	    	 e.preventDefault();
  	        $(this).next('.sub-menu').slideToggle();
  	    });
  	});
      
      function toggleDropdown() {
          var dropdown = document.getElementById('settingsDropdown');
          dropdown.classList.toggle('show');
      }
  	
      
      
   
    
    
    $(document).on('click', '.payments-link', function(event) {
	    event.preventDefault();
	   console.log("entered admin profile");
	   displayPayments();
    });
    
    function displayPayments(){
    	 $.ajax({
    	      url: "viewPayments",
    	      method: 'GET',
    	      success: function(response) {
    	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
    	      },
    	      error: function(xhr, status, error) {
    	        console.log('AJAX Error: ' + error);
    	      }
    	    });
    }
    
    
 /*   <!-- ADMIN PROFILE -->*/
    
    $(document).on('click', '.profile-link', function(event) {
	    event.preventDefault();
	   console.log("entered admin profile");
	   displayProfile();
    });
    
    function displayProfile(){
    	 $.ajax({
    	      url: "displayAdminProfile",
    	      method: 'GET',
    	      success: function(response) {
    	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
    	      },
    	      error: function(xhr, status, error) {
    	        console.log('AJAX Error: ' + error);
    	      }
    	    });
    }
    /*
  <!--OrdersLink--> 
    
*/    
 	
 	$(document).on('click', '.orders-link', function(event) {
	    event.preventDefault();
	   console.log("entered orders");
	    displayOrders();
    });
    
    function displayOrders(){
    	 $.ajax({
    	      url: "listOrders",
    	      method: 'GET',
    	      success: function(response) {
    	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
    	      },
    	      error: function(xhr, status, error) {
    	        console.log('AJAX Error: ' + error);
    	      }
    	    });
    }
    
    
    
	 $(document).on('click', '#red-button', function(event) {
	    event.preventDefault();
		var orderId = $(this).data('order-id'); 
	    
	    console.log('Clicked button with order ID:', orderId);
	   processOrder(orderId);
	 });
	 
	 function processOrder(orderId){
	 	 $.ajax({
		      url: "processOrders",
		      method: 'GET',
		      data: { orderId: orderId,
		    	  adminId:1 },
		      success: function(response) {
		    	  $('#content').html(response);
		    	  console.log('processed order');
		      },
		      error: function(xhr, status, error) {
		        console.log('AJAX Error: ' + error);
		      }
		    });
	 	}
	 	
	 
	 function processedStatusFilter(){
		 console.log("working filter");
	      var selectVal = $("#processedStatusFilter").val();
	      console.log('filterDate: ');
	      $.ajax({
	        url: "loadOrdersByDate",
	        method: 'GET',
	        data: { selectDateFilter: selectVal },
	        success: function(response) {
	          $('#tableData').html(response);
	        },
	        error: function(xhr, status, error) {
	          console.log('AJAX Error: ' + error);
	        }
	      });
	    
	 }
	 
	 function changeByDate(){
		 console.log("working filter");
	      var selectVal = $("#dateRangeFilter").val();
	      console.log('filterDate: ');
	      if(selectVal!=="All"){
	      $.ajax({
	        url: "loadOrdersByDate",
	        method: 'GET',
	        data: { selectDateFilter: selectVal },
	        success: function(response) {
	          $('#tableData').html(response);
	        },
	        error: function(xhr, status, error) {
	          console.log('AJAX Error: ' + error);
	        }
	      });
	      }
	      else{
	    	  $.ajax({
	    	      url: "listOrders",
	    	      method: 'GET',
	    	      success: function(response) {
	    	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
	    	      },
	    	      error: function(xhr, status, error) {
	    	        console.log('AJAX Error: ' + error);
	    	      }
	    	    });
	      }
	    
	 }
	 $(document).on('click', '.stocks-Link', function(event) {
		    event.preventDefault();
		   console.log("entered Stocks");
		    displayStocks();
	    });
	function  displayStocks(){
		 $.ajax({
   	      url: "listStock",
   	      method: 'GET',
   	      success: function(response) {
   	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
   	      },
   	      error: function(xhr, status, error) {
   	        console.log('AJAX Error: ' + error);
   	      }
   	    });
	}
	
	
	

	
 
        //MASTER ENTRY CALLSS-----------------------------------
        
     
	
       $(document).on('click', '.price-review-Link', function(event) {
		    event.preventDefault();
		   console.log("entered Master Entry");
		    displayEditablePrice();
	    });
	 
	 
	function  displayEditablePrice(){
		 $.ajax({
	      url: "showEditablePrice",
	      method: 'GET',
	      success: function(response) {
	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    });
	}
       
       
	 $(document).on('click', '.Master-Entry-Link', function(event) {
		    event.preventDefault();
		   console.log("entered Master Entry");
		    displayEditableStocks();
	    });
	 
	 
	function  displayEditableStocks(){
		 $.ajax({
	      url: "showEditableStocks",
	      method: 'GET',
	      success: function(response) {
	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    });
	}
	
	$(document).on('click', '#edit-button', function(event) {
	    event.preventDefault();
	    
	    var prod_id = $(this).data('prod-id');
	    var prod_gstc_id = $('#prodGstcId-input').val();
	    var image_url = $('#imageUrl-input').val();
	  
	    var prodDesc = $('#prodDesc-input').val();
	    var reorderlevel = $('#reorderlevel-input').val();
	    var prod_stock = parseFloat($('#prodStock-input').val());
	    var prod_mrp = parseFloat($('#prodMrp-input').val());
	    var prod_price=parseFloat($('#prodPrice-input').val());
	    console.log('Clicked button with gstc ID:', prod_gstc_id,prod_stock);
	    updateMasterEntry(prodDesc, image_url, prod_id, reorderlevel, prod_stock, prod_mrp,prod_price);
	});

	function updateMasterEntry(prodDesc, image_url, prod_id, reorderlevel, prod_stock, prod_mrp,prod_price) {
	    $.ajax({
	        url: "updateMasterEntryTables",
	        method: 'GET',
	        data: {
	        	description: prodDesc,
	        	imageUrl: image_url,
	        	id: prod_id,
	            reorderLevel: reorderlevel,
	            stock: prod_stock,
	            price:prod_price,
	           	mrp: prod_mrp
	        },
	        success: function(response) {
	            $('#content').html(response);
	            console.log('In the updation of master entry function');
	        },
	        error: function(xhr, status, error) {
	            console.log('AJAX Error: ' + error);
	        }
	    });
	}
	
	
	
	 $(document).on('click', '.add-new-product-link', function(event) {
		    event.preventDefault();
		   console.log("entered add new product in master  Entry");
		   addNewProduct();
	    });
	 

		function addNewProduct() {
		    $.ajax({
		        url: "addNewProductInTheMasterEntry",
		        method: 'GET',
		        success: function(response) {
		            $('#content').html(response);
		            showCategoriesCatalog();
		            console.log('In the updation of add new product  master entry function');
		        },
		        error: function(xhr, status, error) {
		            console.log('AJAX Error: ' + error);
		        }
		    });
		}
	
	 function showCategoriesCatalog(){
		 $.ajax({
			 url: "CategoriesServlet",
		        method: 'GET',
		        success: function(response) {
		            $('#categoryDropdown').html(response);
		            console.log('Categories are brought');
		        },
		        error: function(xhr, status, error) {
		            console.log('AJAX Error: ' + error);
		        }
		 });
	 }
	
	 $(document).on('change', '#categoryDropdown', function(event) {
		    event.preventDefault();
		    var catg=document.getElementById("categoryDropdown").value;
		   console.log("selected categoryyyyyy"+ catg);
		    
	    });
	 

	 
	 $(document).on('click', '#add-new-category-link', function(event) {
		    event.preventDefault();
		   console.log("entered add new Category in master  Entry");
		   addNewCategory();
	    });
	 

		function addNewCategory() {
		    $.ajax({
		        url: "addNewCategorytInTheMasterEntry",
		        method: 'GET',
		        success: function(response) {
		            $('#content').html(response);
		            showCategoriesCatalog();
		            console.log('In the updation of add new category  master entry function');
		        },
		        error: function(xhr, status, error) {
		            console.log('AJAX Error: ' + error);
		        }
		    });
		}
	 
		
		
		
		//Settings AJAX CALLS
		
		
		
			$(document).on('click', '.Email-Configuration', function(event) {
	    event.preventDefault();
	   console.log("entered Email-Configuration");
	    displayEmailPage();
    });
 function displayEmailPage(){
	 $.ajax({
	      url: "EmailConfigurationPage",
	      method: 'GET',
	      success: function(response) {
	        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
	      },
	      error: function(xhr, status, error) {
	        console.log('AJAX Error: ' + error);
	      }
	    });
 }
	 $(document).on('click', '.Shipping-Config', function(event) {
	    event.preventDefault();
	   console.log("enteredShipping-Config");
	    displayShippingConfig();
 });
function displayShippingConfig(){
	console.log("in displayShippingConfig");
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
	

$(document).on('click', '.OrderValueWise', function(event) {
    event.preventDefault();
   console.log("Entered shipemnents Space ");
    dischar();
});
function dischar(){
console.log("in viewing OrderValueWisePage");
 $.ajax({
      url: "OrderValueWisePage",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}


$(document).on('click', '.ProductWise', function(event) {
    event.preventDefault();
   console.log("Entered shipemnents Space ");
    dispr();
});
function dispr(){
console.log("in viewing ProductWise");
 $.ajax({
      url: "productWisePage",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}


	
//<!-- Shipments Methods      -->

$(document).on('click', '.see-shipping-orders', function(event) {
    event.preventDefault();
   console.log("Entered shipemnents Space ");
    displayProcessedOrders();
});


function displayProcessedOrders(){
console.log("in viewing Orders");
 $.ajax({
      url: "displayProcessedOrdersInShipments",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}

$(document).on('click', '.track-shipments', function(event) {
    event.preventDefault();
   console.log("Entered to see shipped orders  ");
    displayShippedOrders();
});


function displayShippedOrders(){
console.log("in viewing  shipped Orders");
 $.ajax({
      url: "displayShippedOrders",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}



$(document).on('click', '.GST-Report', function(event) {
    event.preventDefault();
   console.log("Entered GST-Report ");
    generateGSTReport();
});
function generateGSTReport(){
console.log("in generateReport");
 $.ajax({
      url: "generateGSTReport",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}

$(document).on('click', '.CAT-Report', function(event) {
    event.preventDefault();
   console.log("Entered CAT-Report ");
    CATReport();
});
function CATReport(){
console.log("in generateReport");
 $.ajax({
      url: "categoryReport",
      method: 'GET',
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}
	


