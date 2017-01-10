package com.smartglossa.stock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		if (op.equals("Adddetail")) {
			JSONObject obj = new JSONObject();
			int comid = Integer.parseInt(request.getParameter("comid"));
			String comname = request.getParameter("comName");
			String tno = request.getParameter("tinNo");
			String prop = request.getParameter("prop");
			String addr = request.getParameter("addr");
			try {
				StockClass add = new StockClass();
				add.addcompanyDetail(comid, comname, tno, prop, addr);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				obj.put("message", e.getMessage());
			}
			response.getWriter().print(obj);
		}
	}

}
