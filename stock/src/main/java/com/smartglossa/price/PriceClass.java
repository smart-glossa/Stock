package com.smartglossa.price;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

public class PriceClass {
	Connection conn = null;
	ResultSet res = null;
	Statement stat = null;

	public PriceClass() throws Exception {
		openConnection();
	}

	public void priceAdd(int prodid, int qty, float bprice, float sprice) throws SQLException {
		try {
			String query = "insert into productPrice(productId,quantity,buyPrice,sellPrice)values(" + prodid + "," + qty
					+ "," + bprice + "," + sprice + ") ";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public void priceupdate(int priceid, int prodid, int qty, float bprice, float sprice) throws SQLException {
		try {
			String query = "update  productPrice set productId=" + prodid + ",quentity=" + qty + ",buyPrice=" + bprice
					+ ",sellPrice=" + sprice + " where priceId=" + priceid;
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public JSONObject getPrice(int priceid) throws SQLException {
		JSONObject gets = new JSONObject();
		try {
			String query = "select * from productPrice where priceId=" + priceid;
			res = stat.executeQuery(query);
			if (res.next()) {
				gets.put("prodid", res.getInt(1));
				gets.put("prodid", res.getInt(2));
				gets.put("qty", res.getInt(3));
				gets.put("bprice", res.getFloat(4));
				gets.put("sprice", res.getFloat(5));

			}
		} finally {
			closeConnection();
		}
		return gets;
	}

	private void openConnection() throws Exception {
		Class.forName(com.smartglossa.stock.StockConstant.MYSQL_DRIVER);
		// String URL = "jdbc:mysql://" +
		// com.smartglossa.stock.StockConstant.MYSQL_SERVER + "/" +
		// com.smartglossa.stock.StockConstant.DATABASE_NAME;
		String URL = "jdbc:mysql://localhost:3306/storesoft";
		conn = DriverManager.getConnection(URL, com.smartglossa.stock.StockConstant.USERNAME,
				com.smartglossa.stock.StockConstant.PASSWORD);
		stat = conn.createStatement();

	}

	private void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();

		}
		if (stat != null) {
			stat.close();
		}
		if (res != null) {
			res.close();
		}

	}
}
