<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Products</title>
</head>
<body>
<form method="post" action="MainServlet">
<h3>Add Product Page</h3>
Product Name : <input type="text" name="productName"><br><br>
Category : <input type="text" name="category"><br><br>
Price : <input type="number" step="0.01" name="price"><br><br>
Stock Quantity :<input type="number" name="stock"><br><br>
Added Date : <input type="date" name="addedDate"><br><br>
Remarks :<input type="text" name="remarks"><br><br>
<input type="submit" name="operation" value="newRecord"/>

</form>
</body>
</html>