<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="eStoreProduct.model.admin.output.stockSummaryModel,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Summary</title>
<link rel="stylesheet" type="text/css" href="./css/stocksummary.css">

 
    <script src="./js/stockSummary.js"></script>
</head>
<body>

<div class="container mt-5">
    <table id="tableData" class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>Product ID</th>
                <th>Product Title</th>
                <th>Product Category ID</th>
                <th>Product GST Category ID</th>
                <th>Product Brand</th>
                <th>Image URL</th>
               <!--  <th>Product Description</th> -->
                <th>Reorder Level</th>
                <th>Product Category Title</th>
                <th>SGST</th>
                <th>IGST</th>
                <th>CGST</th>
                <th>GST</th>
                <th>Product Price</th>
                <th>Product Stock</th>
                <th>Product MRP</th>
            </tr>
        </thead>
        <tbody>
         <% List<stockSummaryModel> stocks=(List<stockSummaryModel>)request.getAttribute("stocks"); %>
            <% for (stockSummaryModel stock : stocks) { %>
             <tr <% if (stock.getReorderLevel() > stock.getStock()) { %>class="warning"<% } %>>
                    <td><%= stock.getId() %></td>
                    <td><%= stock.getTitle()%></td>
                    <td><%= stock.getProductCategory() %></td>
                    <td><%= stock.getHsnCode() %></td>
                    <td><%= stock.getBrand() %></td>
                    <td><%= stock.getImageUrl() %></td>
                    <%-- <td><%= stock.getDescription() %></td> --%>
                    <td><%= stock.getReorderLevel() %></td>
                    <td><%= stock.getPrct_title()%></td>
                    <td><%= stock.getSgst() %></td>
                    <td><%= stock.getIgst() %></td>
                    <td><%= stock.getCgst() %></td>
                    <td><%= stock.getGst() %></td>
                    <td><%= stock.getPrice() %></td>
                    <td><%= stock.getStock() %></td>
                    <td><%= stock.getMrp() %></td>
                </tr>
                <% } %>
        </tbody>
    </table>
</div>

<div class="pagination">
    <c:if test="${page > 0}">
        <a href="javascript:navigateToPage(${page - 1})">Previous</a>
    </c:if>
    
    <c:forEach var="pageNumber" begin="0" end="${totalPages - 1}">
        <c:choose>
            <c:when test="${pageNumber == page}">
                <span class="current-page">${pageNumber + 1}</span>
            </c:when>
            <c:otherwise>
                <a href="javascript:navigateToPage(${pageNumber})">${pageNumber + 1}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
    <c:if test="${page < totalPages - 1}">
        <a href="javascript:navigateToPage(${page + 1})">Next</a>
    </c:if>
</div>

</body>
</html>
