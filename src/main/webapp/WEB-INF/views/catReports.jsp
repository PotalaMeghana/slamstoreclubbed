<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="eStoreProduct.model.admin.entities.*,java.util.*,eStoreProduct.model.admin.output.*"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/catReports.css">

 
    <script src="./js/catReports.js"></script>

</head>
<body>
<% List<CategoryReportViewModel> report = (List<CategoryReportViewModel>) request.getAttribute("categoryReport"); %>
<% 
    int totalProducts = 0;
    double totalGST = 0.0;
    long totalSales = 0;
    double totalAmount = 0.0;
    for (CategoryReportViewModel viewModel : report) {
        totalProducts += viewModel.getTotal_products();
        totalGST += viewModel.getTotal_gst();
        totalSales += viewModel.getTotal_sales();
        totalAmount += viewModel.getTotal_amount();
    }
%>
<table>
    <thead>
        <tr>
            <th >Category ID</th>
            <th>Category Name</th>
            <th>Total Products</th>
            <th onclick="totalGST()">Total GST</th>
            <th onclick="totalSales()">Total Sales</th>
            <th onclick="totalAmount()">Total Amount</th>
        </tr>
    </thead>
    <tbody>
        <% for (CategoryReportViewModel viewModel : report) { %>
            <tr>
                <td><%= viewModel.getPtct_id() %></td>
                <td><%= viewModel.getPtct_name() %></td>
                <td><%= viewModel.getTotal_products() %></td>
                <td><%= viewModel.getTotal_gst() %></td>
                <td><%= viewModel.getTotal_sales() %></td>
                <td><%= viewModel.getTotal_amount() %></td>
            </tr>
        <% } %>
        <tr class="total-row">
            <td colspan="2">Total</td>
            <td><%= totalProducts %></td>
            <td><%= totalGST %></td>
            <td><%= totalSales %></td>
            <td><%= totalAmount %></td>
        </tr>
    </tbody>
</table>
</body>
</html>
