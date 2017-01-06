package com.smartglossa.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;


public class ProductClass {
	Connection conn = null;
	Statement sta = null;
	ResultSet rs = null;

	public ProductClass() throws ClassNotFoundException, SQLException {
		openConnection();

	}

	public void addproducts(String pId, String pName, int companyId) throws SQLException, ClassNotFoundException, JSONException {
		try {
			String query = "Insert into product(productId,productName,companyId)values('" + pId + "','" + pName + "','"
					+ companyId + "')";
			sta.execute(query);
		} finally {
			closeConnection();
		}
	}
	public void updateProduct(String pId, String pName, int companyId) throws SQLException, ClassNotFoundException, JSONException {
		try {
			String query = "update product set productName='" + pName + "',companyId=" + companyId +"' where productId='" + pId +"'"; 
			sta.execute(query);
		} finally {
			closeConnection();
		}
	}

	private void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName(ProductConstact.MYSQL_DRIVER);
		conn = DriverManager.getConnection(ProductConstact.MYSQL_SERVER + "/" + ProductConstact.DATABASE,
				ProductConstact.USERNAME, ProductConstact.PASSWORD);
		sta = conn.createStatement();

	}

	private void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();

		}
		if (sta != null) {
			sta.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
