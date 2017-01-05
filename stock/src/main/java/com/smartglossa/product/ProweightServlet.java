package com.smartglossa.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class ProweightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation=request.getParameter("operation");
		if (operation.equals("addProduct")) {
			JSONObject obj= new JSONObject();
			float costKg = Float.parseFloat(request.getParameter("costKg"));
			float totalKg= Float.parseFloat(request.getParameter("totalKg"));
			int brandId = Integer.parseInt(request.getParameter("brandId"));
		
	}

}}
