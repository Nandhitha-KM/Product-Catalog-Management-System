package com.wipro.product.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.product.bean.ProductBean;
import com.wipro.product.util.DBUtil;

public class ProductDAO {
	public String createRecord(ProductBean bean) {

	    Connection connection = DBUtil.getDBConnection();

	    try {

	        String productId = generateProductID(bean.getProductName(), bean.getAddedDate());
	        bean.setProductId(productId);

	        String query = "INSERT INTO PRODUCT_TB VALUES(?,?,?,?,?,?,?)";
	        PreparedStatement ps = connection.prepareStatement(query);

	        ps.setString(1, bean.getProductId());
	        ps.setString(2, bean.getProductName());
	        ps.setString(3, bean.getCategory());
	        ps.setDouble(4, bean.getPrice());
	        ps.setInt(5, bean.getStock());
	        ps.setDate(6, new java.sql.Date(bean.getAddedDate().getTime()));
	        ps.setString(7, bean.getRemarks());

	        int row = ps.executeUpdate();

	        if (row > 0)
	            return productId;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "FAIL";
	}

	public ProductBean fetchRecord(String productName, Date addedDate) {

	    Connection connection = DBUtil.getDBConnection();

	    String query = "SELECT * FROM PRODUCT_TB WHERE PRODUCTNAME=? AND ADDED_DATE BETWEEN ? AND ?";

	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        java.sql.Date start = new java.sql.Date(addedDate.getTime());
	        java.sql.Date end = new java.sql.Date(addedDate.getTime() + 86400000);

	        ps.setString(1, productName);
	        ps.setDate(2, start);
	        ps.setDate(3, end);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()){
	            ProductBean bean = new ProductBean();

	            bean.setProductId(rs.getString("PRODUCTID"));
	            bean.setProductName(rs.getString("PRODUCTNAME"));
	            bean.setCategory(rs.getString("CATEGORY"));
	            bean.setPrice(rs.getDouble("PRICE"));
	            bean.setStock(rs.getInt("STOCK"));
	            bean.setAddedDate(rs.getDate("ADDED_DATE"));
	            bean.setRemarks(rs.getString("REMARKS"));

	            return bean;
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return null;
	}

    
    public String generateProductID(String productName, Date addedDate) {

        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            int seq = 0;

            if (rs.next()) {
                seq = rs.getInt(1);
            }
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
            String datePart = f.format(addedDate);
            String namePart;
            if(productName.length() >= 2)
                namePart = productName.substring(0,2).toUpperCase();
            else
                namePart = (productName + "X").substring(0,2).toUpperCase();

            return datePart + namePart + seq;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

  
    public boolean recordExists(String productName, Date addedDate) {

        Connection connection = DBUtil.getDBConnection();

        String query = "SELECT PRODUCTID FROM PRODUCT_TB WHERE PRODUCTNAME=? AND ADDED_DATE BETWEEN ? AND ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            java.sql.Date start = new java.sql.Date(addedDate.getTime());
            java.sql.Date end = new java.sql.Date(addedDate.getTime() + 86400000);

            ps.setString(1, productName);
            ps.setDate(2, start);
            ps.setDate(3, end);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
                return true;

        } catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<ProductBean> fetchAllRecords() {

        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT * FROM PRODUCT_TB";

        List<ProductBean> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProductBean bean = new ProductBean();

                bean.setProductId(rs.getString("PRODUCTID"));
                bean.setProductName(rs.getString("PRODUCTNAME"));
                bean.setCategory(rs.getString("CATEGORY"));
                bean.setPrice(rs.getDouble("PRICE"));
                bean.setStock(rs.getInt("STOCK"));
                bean.setAddedDate(rs.getDate("ADDED_DATE"));
                bean.setRemarks(rs.getString("REMARKS"));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list; 
    }
}
