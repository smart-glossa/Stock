package com.smartglossa.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductClass {
	Connection conn = null;
	Statement sta = null;
	ResultSet rs = null;

	public ProductClass() throws ClassNotFoundException, SQLException {
		openConnection();

	}

	public void addproducts(int pId, String pName, int tinNo, int brandId, String brandName, int id, float qty,
			float costprice, float sellprice) throws SQLException, ClassNotFoundException, JSONException {
		JSONObject objec = new JSONObject();
		try {
			String query = "insert into product(productId,productName,tinNo)values('" + pId + "','" + pName + "','"
					+ tinNo + "')";
			sta.execute(query);
			String query1 = "insert into productbrand(brandId,brandName,productId)values(" + brandId + ",'" + brandName
					+ "'," + pId + ")";
			sta.execute(query1);
			String query2 = "insert into productprice(id,brandId,quantity,costprice,sellprice)values(" + id + ","
					+ brandId + "," + qty + "," + costprice + "," + sellprice + ")";
			sta.execute(query2);
			objec.put("status", "1");
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
