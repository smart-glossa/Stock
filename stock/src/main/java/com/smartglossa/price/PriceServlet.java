package com.smartglossa.price;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class PriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		if (op.equals("priceAdd")) {
			JSONObject obj = new JSONObject();
			
			int prodid = Integer.parseInt(request.getParameter("prodId"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			float bprice = Float.parseFloat(request.getParameter("bPrice"));
			float sprice = Float.parseFloat(request.getParameter("sPrice"));
			try {
				PriceClass price = new PriceClass();
				price.priceAdd(prodid, qty, bprice, sprice);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				obj.put("message", e.getMessage());

			}
			response.getWriter().print(obj);
		} else if (op.equals("getPrice")) {
			int priceid = Integer.parseInt(request.getParameter("priceId"));
			JSONObject get = new JSONObject();
			try {
				PriceClass getprice = new PriceClass();
				get = getprice.getPrice(priceid);
				get.put("status", 1);
			} catch (Exception e) {
				get.put("status", 0);
				e.printStackTrace();
				get.put("message", e.getMessage());
			}
			response.getWriter().println(get);
		}
	}

}
