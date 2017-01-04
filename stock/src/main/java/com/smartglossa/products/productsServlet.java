package com.smartglossa.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.smartglossa.stock.stockClass;


public class productsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public productsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String operation = request.getParameter("operation");
		if (operation.equals("addproducts")) {
			JSONObject object = new JSONObject();
			int pId = Integer.parseInt(request.getParameter("pId"));
			String pName = request.getParameter("pName");
			int tinNo=Integer.parseInt(request.getParameter("tinNo"));
			int brandId =Integer.parseInt( request.getParameter("brandId"));
	        String brandName = request.getParameter("brandName");
	      int Id=Integer.parseInt(request.getParameter("Id"));
	      float costprice = Float.parseFloat(request.getParameter("cPrice"));
			float sellprice = Float.parseFloat(request.getParameter("sPrice"));
			float qty = Float.parseFloat(request.getParameter("qty"));
			try {
				productClass stock = new productClass();
		      stock.addproducts(pId, pName, tinNo, brandId, brandName, Id, qty, costprice, sellprice);
					
				object.put("status",1);
			} catch (Exception e) {
				object.put("status",0);
				object.put("message",e.getMessage());
				
				e.printStackTrace();
			}
			response.getWriter().print(object);
			
	}else if (operation.equals("addBrand")) {
		
        
	}

	}
}
