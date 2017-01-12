package com.smartglossa.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

public class ProductClass {
	Connection con = null;
	Statement stat = null;
	ResultSet res = null;

	public ProductClass() throws Exception {
		openConnection();
	}

	public void addProd(String prodid, String prodname, String parid) throws SQLException {
		try {
			String qry = "insert into product(productId,productName,parentProductId)values('" + prodid + "','"
					+ prodname + "','" + parid + "') ";
			stat.execute(qry);
		} finally {
			closeConnection();
		}
	}

	public void updateProd(String prdid, String prodname, String parid) throws SQLException {
		try {
			String query = "update set product productName='" + prodname + "',parentProductId='" + parid
					+ "' where productId='" + prdid + "'";
			stat.execute(query);

		} finally {
			closeConnection();
		}
	}

	public JSONObject getProduct(String prdid) throws SQLException {
		JSONObject prod = new JSONObject();
		try {
			String query = "select * from product where productId=" + prdid;
			res = stat.executeQuery(query);
			if (res.next()) {
				prod.put("prodid", res.getString(1));
				prod.put("prodName", res.getString(2));
				prod.put("parid", res.getString(3));
			}
		} finally {
			closeConnection();
		}
		return prod;
	}

	private void openConnection() throws Exception {
		Class.forName(ProductConstant.MYSQL_DRIVER);
		// String URL = "jdbc:mysql://" + StockConstant.MYSQL_SERVER + "/" +
		// StockConstant.DATABASE_NAME;
		String URL = "jdbc:mysql://localhost:3306/storesoft";
		con = DriverManager.getConnection(URL, ProductConstant.USERNAME, ProductConstant.PASSWORD);
		stat = con.createStatement();

	}

	private void closeConnection() throws SQLException {
		if (con != null) {
			con.close();

		}
		if (stat != null) {
			stat.close();
		}
		if (res != null) {
			res.close();
		}

	}
}
