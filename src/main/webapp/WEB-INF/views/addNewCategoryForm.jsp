<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/addNewCategoryForm.css">

 
    <script src="./js/addNewCategoryForm.js"></script>
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Custom Styles -->
   
   

</head>
<body>
    <form action="createNewCategory" id="createNewCategory" method="post">
        
        <div class="container">
            <div class="form-group">
                <label for="prct_title">Category Title:</label>
                <input type="text" class="form-control" id="prct_title" name="prct_title" required>
            </div>
	
            <div class="form-group">
                <label for="prct_desc">Product Description</label>
                <input type="text" class="form-control" id="prct_desc" name="prct_desc" required>
            </div>
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
             <div class="form-group">
                <button id="clr" class="btn btn-secondary">Clear</button>
            </div>
        </div>
    </form>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
