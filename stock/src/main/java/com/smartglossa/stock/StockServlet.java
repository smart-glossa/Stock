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
		} else if (op.equals("updatedetail")) {
			JSONObject obj = new JSONObject();
			int ucomid = Integer.parseInt(request.getParameter("ucomid"));
			String ucomname = request.getParameter("ucomName");
			String utno = request.getParameter("utinNo");
			String uprop = request.getParameter("uprop");
			String uaddr = request.getParameter("uaddr");
			try {
				StockClass update = new StockClass();
				update.updateDetail(ucomid, ucomname, utno, uprop, uaddr);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				obj.put("message", e.getMessage());
			}
			response.getWriter().print(obj);
		} else if (op.equals("getcompany")) {
			int ucomid = Integer.parseInt(request.getParameter("ucomid"));
			JSONObject obj = new JSONObject();
			try {
				StockClass getone = new StockClass();
				obj = getone.getOne(ucomid);
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
