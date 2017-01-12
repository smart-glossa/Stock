package com.smartglossa.companyProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("companyprodAdd")) {
			JSONObject obj=new JSONObject();
          int comId=Integer.parseInt(request.getParameter("comId"));
          int priceid=Integer.parseInt(request.getParameter("priceId"));
          try {
			CompanyClass add=new CompanyClass();
			add.addcompany(comId, priceid);
			obj.put("status",1);
		} catch (Exception e) {
            obj.put("status",0);
            e.printStackTrace();
            obj.put("message",e.getMessage());
		}
          response.getWriter().print(obj);
          
		}
	}

}
