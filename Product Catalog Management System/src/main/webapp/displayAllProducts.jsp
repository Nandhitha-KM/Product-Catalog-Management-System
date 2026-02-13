<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.product.bean.ProductBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Products</title>
</head>
<body>
<h3><b>Product Details</b></h3>

<%
List<ProductBean> list = (List<ProductBean>)request.getAttribute("list");

if(list == null || list.size() == 0){
    out.println("No records available!");
}
else{
    for(ProductBean bean : list){
        out.println("Product ID : " + bean.getProductId()+"<br>");
        out.println("Product Name : " + bean.getProductName()+"<br>");
        out.println("Category : " + bean.getCategory()+"<br>");
        out.println("Price : " + bean.getPrice()+"<br>");
        out.println("Stock : " + bean.getStock()+"<br>");
        out.println("Added Date : " + bean.getAddedDate()+"<br>");
        out.println("Remarks : " + bean.getRemarks()+"<br><br>");
    }
}
%>

</body>
</html>
