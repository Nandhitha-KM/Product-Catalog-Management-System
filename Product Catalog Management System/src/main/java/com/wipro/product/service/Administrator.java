package com.wipro.product.service;

import java.util.Date;
import java.util.List;

import com.wipro.product.bean.ProductBean;
import com.wipro.product.dao.ProductDAO;
import com.wipro.product.util.InvalidInputException;

public class Administrator {
    public String addRecord(ProductBean bean) {

        ProductDAO dao = new ProductDAO();
        if(bean == null || bean.getProductName() == null || bean.getAddedDate() == null){
            return "INVALID INPUT";
        }
        if(bean.getProductName().length() < 2){
            return "INVALID PRODUCT NAME";
        }

        if(bean.getPrice() <= 0){
            return "INVALID PRICE";
        }
        if(bean.getStock() < 0){
            return "INVALID STOCK VALUE";
        }

        if(dao.recordExists(bean.getProductName(), bean.getAddedDate())){
            return "ALREADY EXISTS";
        }

        String id = dao.generateProductID(bean.getProductName(), bean.getAddedDate());
        bean.setProductId(id);
        String result = dao.createRecord(bean);
        if(!result.equals("FAIL")){
            return result;   
        }

        return "FAIL";
    }


    public ProductBean viewRecord(String productName, Date addedDate) {

        ProductDAO dao = new ProductDAO();
        ProductBean bean = dao.fetchRecord(productName, addedDate);
        return bean;
    }


    public List<ProductBean> viewAllRecords() {

        ProductDAO dao = new ProductDAO();
        List<ProductBean> list = dao.fetchAllRecords();
        return list;
    }
}
