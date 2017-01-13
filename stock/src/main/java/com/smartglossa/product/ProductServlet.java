package com.smartglossa.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
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
		if (operation.equals("prodadd")) {
			JSONObject obj = new JSONObject();
			String prodname = request.getParameter("prodName");
			try {
				ProductClass add = new ProductClass();
				add.addProd(prodname);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				obj.put("message", e.getMessage());
			}
			response.getWriter().print(obj);
		} else if (operation.equals("productAdd")) {
			JSONObject obj = new JSONObject();
			String prodname = request.getParameter("prodName");
			int parentid = Integer.parseInt(request.getParameter("parentid"));
			try {
				ProductClass prodadd = new ProductClass();
				prodadd.addProduct(prodname, parentid);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
			}
			response.getWriter().println(obj);
		} else if (operation.equals("updateprod")) {
			JSONObject obj = new JSONObject();
			String prdid = request.getParameter("uprodid");
			String prodname = request.getParameter("uprodName");
			String parid = request.getParameter("uparid");
			try {
				ProductClass update = new ProductClass();
				update.updateProd(prdid, prodname, parid);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				obj.put("message", e.getMessage());
			}
			response.getWriter().print(obj);
		} else if (operation.equals("getProduct")) {
			JSONObject get = new JSONObject();
			String prdid = request.getParameter("uprodid");
			try {
				ProductClass getPrd = new ProductClass();
				get = getPrd.getProduct(prdid);
				get.put("status", 1);

			} catch (Exception e) {
				get.put("status", 0);
				e.printStackTrace();
				get.put("message", e.getMessage());
			}
			response.getWriter().print(get);
		}else if(operation.equals("getParent")){
			JSONArray obj=new JSONArray();
			int parentid=Integer.parseInt(request.getParameter("parentid"));
			try {
				ProductClass pat=new ProductClass();
				obj=pat.getParent(parentid);
				
			} catch (Exception e) {
				JSONObject error=new JSONObject();
				error.put("states", 0);
				obj.put(error);
				e.printStackTrace();
				error.put("message",e.getMessage());
			
			}
			response.getWriter().print(obj);
		}
	}

}
