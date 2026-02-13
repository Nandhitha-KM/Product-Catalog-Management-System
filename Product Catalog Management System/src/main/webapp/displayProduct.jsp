<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.wipro.product.bean.ProductBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>

<%
    
    ProductBean bean = (ProductBean) request.getAttribute("product");
    String msg = (String) request.getAttribute("msg");

    if(bean != null) {
        out.println("<h3><b>Product Details</b></h3>");
        out.println("Product ID : " + bean.getProductId() + "<br>");
        out.println("Product Name : " + bean.getProductName() + "<br>");
        out.println("Category : " + bean.getCategory() + "<br>");
        out.println("Price : " + bean.getPrice() + "<br>");
        out.println("Stock : " + bean.getStock() + "<br>");
        out.println("Added Date : " + bean.getAddedDate() + "<br>");
        out.println("Remarks : " + bean.getRemarks() + "<br>");
    } else {
        out.println("No matching records exists! Please try again!");
    }
%>

</body>
</html>
