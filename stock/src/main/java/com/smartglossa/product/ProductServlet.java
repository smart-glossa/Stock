package com.smartglossa.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("addProduct")) {
			JSONObject object = new JSONObject();
			String pId = request.getParameter("pId");
			String pName = request.getParameter("pName");
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			
			try {
				ProductClass products = new ProductClass();
				products.addproducts(pId, pName, companyId);
				object.put("status", 1);
			} catch (Exception e) {
				object.put("status", 0);
				object.put("message", e.getMessage());

				e.printStackTrace();
			}
			response.getWriter().print(object);
		}else if(operation.equals("updateProduct")){
			JSONObject obj = new JSONObject();
			String pId = request.getParameter("pId");
			String pName = request.getParameter("pName");
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			try {
				ProductClass products = new ProductClass();
				products.updateProduct(pId, pName, companyId);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());

				e.printStackTrace();
			}
			response.getWriter().print(obj);
		} else if(operation.equals("getOneProduct")){
			JSONObject obj = new JSONObject();
		}

	}
}

