package com.smartglossa.stock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class stockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public stockServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		JSONObject obj = new JSONObject();

		if (operation.equals("addStock")) {
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			String companyName = request.getParameter("companyName");
			String address = request.getParameter("address");
			int tinNo = Integer.parseInt(request.getParameter("tinNo"));
			String proprietor = request.getParameter("proprietor");

			try {
				stockClass stock = new stockClass();
				stock.addstock(companyId, companyName, address, tinNo, proprietor);

				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());

				e.printStackTrace();
			}
			response.getWriter().print(obj);

		} else if (operation.equals("updateStock")) {
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			String companyName = request.getParameter("companyName");
			String address = request.getParameter("address");
			int tinNo = Integer.parseInt(request.getParameter("tinNo"));
			String proprietor = request.getParameter("address");
			JSONObject result = new JSONObject();
			try {
				stockClass stock = new stockClass();
				stock.updateStock(companyId, companyName, address, tinNo, proprietor);

				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());

				e.printStackTrace();
			}
			response.getWriter().print(result);

		} else if (operation.equals("deleteStock")) {
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			JSONObject delete = new JSONObject();
			try {
				stockClass stock = new stockClass();
				stock.deleteStock(companyId);
				delete.put("status", 1);
			} catch (Exception e) {
				delete.put("status", 0);
				delete.put("message", e.getMessage());

				e.printStackTrace();
			}
			response.getWriter().print(delete);

		} else if (operation.equals("getStock")) {
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			JSONObject one = new JSONObject();
			try {
				stockClass stock = new stockClass();
				one = stock.getone(companyId);
				obj.put("status", 1);

			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());
				e.printStackTrace();
			}
			response.getWriter().print(one);

		} else if (operation.equals("getAllstock")) {
			JSONArray result = new JSONArray();
			try {
				stockClass stock = new stockClass();
				result = stock.getall();
				obj.put("status", 1);

			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());

				e.printStackTrace();
			}

			response.getWriter().print(result);
		}
	}

}
