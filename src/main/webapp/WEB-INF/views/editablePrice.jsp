<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.admin.output.stockSummaryModel,java.util.List" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Price Review</title>
<link rel="stylesheet" type="text/css" href="./css/editablePrice.css">
</head>
<body>
<table id="tableData" class="table table-bordered table-hover">
    <thead class="thead-dark">
        <tr>
            <th>Product ID</th>
            <th>Product Title</th>
            <th>Product Category ID</th>
            <th>Product GST Category ID</th>
            <th>Product Brand</th>
            <th>Product MRP</th>
            <th>Product Price</th>
            <th>EDIT</th>
        </tr>
    </thead>
    <tbody>
        <% List<stockSummaryModel> stock2=(List<stockSummaryModel>)request.getAttribute("stocks1"); %>
        <% for (stockSummaryModel stock : stock2) { %>
         <tr <% if (stock.getReorderLevel() > stock.getStock()) { %>class="warning"<% } %>>
            <td name="prod_id"><%=stock.getId()%></td>
            <td><%= stock.getTitle() %></td>
            <td><%= stock.getProductCategory() %></td>
            <td id="prodGstcId-input" name="prod_gstc_id">
                <%= stock.getHsnCode() %>
            </td>
            <td><%= stock.getBrand() %></td>
            <td id="prodMrp-input"  name="prod_mrp">
               <%= stock.getMrp() %>
            </td>
             <td>
                <input type="text" id="prodPrice-input-<%= stock.getId() %>"  name="prod_price" value="<%= stock.getPrice() %>">
            </td>
            <td>
                <button id="editprice-button" class="btn btn-success"  
                        data-price-id="<%= stock.getPrice() %>"
                        data-prod-id="<%= stock.getId() %>"
                        data-mrp-id="<%= stock.getMrp() %>">UPDATE</button>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>

<script src="./js/jquery.min.js"></script>
<script>
	  $(document).on('click', '#editprice-button', function(event) {
	    event.preventDefault();
		var oldp=$(this).data('price-id');
	    var $row = $(this).closest('tr');
	    var prod_id = $(this).data('prod-id');
	    var prod_mrp = parseFloat($(this).data('mrp-id'));
	    var prod_price = parseFloat($('#prodPrice-input-'+prod_id).val());

	    
	    if (isNaN(prod_price)) {
	        alert("Invalid price value!");
	        return;
	     }
	    else if (prod_price > prod_mrp) {
	      $row.addClass('warning');
	      alert("Price cannot be greater than MRP!");
	    updatePriceReview(prod_id, prod_mrp, oldp);

	      
	      
	      return;
	    }
	    else{
	    	 updatePriceReview(prod_id, prod_mrp, prod_price);
	    }
	    

	   
	  });

	  function updatePriceReview(prod_id, prod_mrp, prod_price) {
	    $.ajax({
	      url: "updatePriceReview",
	      method: 'GET',
	      data: {
	        id: prod_id,
	        price: prod_price,
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
	

</script>

</body>
</html>
