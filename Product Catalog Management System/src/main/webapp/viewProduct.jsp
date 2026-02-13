<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
</head>
<body>
<h3>Search Product</h3>
<form method="post" action="MainServlet">
<input type="hidden" name="operation" value="viewRecord">
Enter Product Name:<input type="text" name="productName"><br><br>
Enter Added Date:<input type="date" name="addedDate"><br><br>
<input type="submit" value="Search">

</form>

</body>
</html>