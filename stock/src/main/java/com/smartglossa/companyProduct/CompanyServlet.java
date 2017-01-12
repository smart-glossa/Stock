package com.smartglossa.companyProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("companyadd")) {
          String prodid=request.getParameter("prodid");
          String prodname=request.getParameter("prodName");
          String parid=request.getParameter("parid");
          try {
			CompanyClass add=new CompanyClass();
			add.
		} catch (Exception e) {
			// TODO: handle exception
		}
          
		}
	}

}
