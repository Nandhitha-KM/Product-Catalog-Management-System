package com.wipro.product.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.wipro.product.bean.ProductBean;
import com.wipro.product.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

	public String addRecord(HttpServletRequest request) {

	    ProductBean bean = new ProductBean();

	    bean.setProductName(request.getParameter("productName"));
	    bean.setCategory(request.getParameter("category"));
	    bean.setPrice(Double.parseDouble(request.getParameter("price")));
	    bean.setStock(Integer.parseInt(request.getParameter("stock")));

	    String dateStr = request.getParameter("addedDate");
	    java.sql.Date sqlDate = java.sql.Date.valueOf(dateStr);
	    bean.setAddedDate(sqlDate);

	    bean.setRemarks(request.getParameter("remarks"));

	    Administrator admin = new Administrator();
	    return admin.addRecord(bean);
	}


    public ProductBean viewRecord(HttpServletRequest request) {

        String productName = request.getParameter("productName");
        String dateStr = request.getParameter("addedDate");

        java.sql.Date addedDate = java.sql.Date.valueOf(dateStr);

        Administrator admin = new Administrator();
        return admin.viewRecord(productName, addedDate);
    }


    public List<ProductBean> viewAllRecords(HttpServletRequest request) {

        Administrator admin = new Administrator();
        return admin.viewAllRecords();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String operation = req.getParameter("operation");

        if(operation.equals("newRecord")) {

            try {
                String result = addRecord(req);
                if(result.equals("FAIL") || result.equals("INVALID INPUT") || result.equals("INVALID PRODUCT NAME") || result.equals("INVALID PRICE") || result.equals("INVALID STOCK VALUE") ||
                 result.equals("ALREADY EXISTS")) {

                		    resp.sendRedirect("error.html");
                		}
                		else {
                		    resp.sendRedirect("success.html");
                		}
                
            }
            catch(Exception e) {
                resp.sendRedirect("error.html");
            }
        }

        else if(operation.equals("viewRecord")) {

            ProductBean bean = viewRecord(req);

            if(bean == null) {
                req.setAttribute("msg","No matching records exists! Please try again!");
                RequestDispatcher rd = req.getRequestDispatcher("displayProduct.jsp");
                rd.forward(req, resp);
            }
            else {
                req.setAttribute("product", bean);
                RequestDispatcher rd = req.getRequestDispatcher("displayProduct.jsp");
                rd.forward(req, resp);
            }
        }

        else if(operation.equals("viewAllRecords")) {

            List<ProductBean> list = viewAllRecords(req);

            if(list == null || list.isEmpty()) {
                req.setAttribute("msg", "No records available!");
                RequestDispatcher rd = req.getRequestDispatcher("displayAllProducts.jsp");
                rd.forward(req, resp);
            }
            else {
                req.setAttribute("list", list);
                RequestDispatcher rd =  req.getRequestDispatcher("displayAllProducts.jsp");
                rd.forward(req, resp);
            }
        }
    }
}
