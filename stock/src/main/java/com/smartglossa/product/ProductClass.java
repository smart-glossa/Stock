package com.smartglossa.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductClass {
	Connection con = null;
	Statement stat = null;
	ResultSet res = null;

	public ProductClass() throws Exception {
		openConnection();
	}

	public void addProd(String prodname) throws SQLException {
		try {

			String qry = "insert into product(productName)values('" + prodname + "')";
			stat.execute(qry);
		} finally {
			closeConnection();
		}
	}

	public void addProduct(String prodname, int parentid) throws SQLException {
		try {
			String query = "insert into product(productName,parentProductId)values('" + prodname + "'," + parentid
					+ ")";
			stat.execute(query);
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
	public JSONArray getParent() throws SQLException{
		JSONArray parent=new JSONArray();
		try {
			String query="SELECT productId,productName FROM product where parentProductId IS null";
			res=stat.executeQuery(query);
			while(res.next()){
				JSONObject ss=new JSONObject();
				ss.put("prodid",res.getInt(1));
				ss.put("prodname", res.getString(2));
				parent.put(ss);
			}
		} finally {
			closeConnection();
			
		}
		return parent;
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
