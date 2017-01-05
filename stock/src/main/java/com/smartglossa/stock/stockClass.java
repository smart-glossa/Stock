package com.smartglossa.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class stockClass {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;

	public stockClass() throws ClassNotFoundException, SQLException {
		openConnection();

	}

	public void addstock(int companyId, String companyName, String address, int tinNo, String proprietor)
			throws SQLException, ClassNotFoundException, JSONException {
		JSONObject objec = new JSONObject();
		try {
			String query = "insert into stocks(companyId,companyName,address,tinNo,proprietor)values(" + companyId + ",'"
					+ companyName + "','" + address + "'," + tinNo + ",'" + proprietor + "')";
			stat.execute(query);
			objec.put("status", "1");
		} finally {
			closeConnection();
		}
	}

	public JSONArray getall() throws SQLException, ClassNotFoundException, JSONException {
		JSONArray result = new JSONArray();
		try {
			String query = "select * from stocks";
			rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject get = new JSONObject();
				get.put("companyId", rs.getInt("companyId"));
				get.put("companyName", rs.getString("companyName"));
				get.put("address", rs.getString("address"));
				get.put("tinNo", rs.getInt("tinNo"));
				get.put("proprietor", rs.getString("proprietor"));
				result.put(get);
			}
			return result;
		} finally {
			closeConnection();
		}
	}

	public JSONObject getone(int companyId) throws SQLException, ClassNotFoundException, JSONException {
		JSONObject one = new JSONObject();
		try {
			String query = "select * from stock where companyId=" + companyId;
			rs = stat.executeQuery(query);
			if (rs.next()) {
				one.put("companyName", rs.getString("companyName"));
				one.put("address", rs.getString("address"));
				one.put("tinNo", rs.getInt("tinNo"));
				one.put("proprietor", rs.getString("proprietor"));
			}

		} finally {
			closeConnection();
		}
		return one;

	}

	public void updateStock(int companyId, String companyName, String address, int tinNo, String proprictor)
			throws SQLException, ClassNotFoundException, JSONException {
		JSONObject update = new JSONObject();
		try {
			String query = "update stock set companyName='" + companyName + "',address='" + address + "',tinNo='"
					+ tinNo + "',proprictor='" + proprictor + "' where companyId=" + companyId;
			stat.execute(query);
			update.put("status", "1");

		} finally {

			closeConnection();
		}
	}

	public void deleteStock(int companyId) throws SQLException, ClassNotFoundException {
		JSONObject delete = new JSONObject();
		try {
			String query = "delete from stock where companyId=" + companyId;
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	private void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StockConstants.MYSQL_DRIVER);
		conn = DriverManager.getConnection(StockConstants.MYSQL_SERVER + "/" + StockConstants.DATABASE,
				StockConstants.USERNAME, StockConstants.PASSWORD);
		stat = conn.createStatement();

	}

	private void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();

		}
		if (stat != null) {
			stat.close();
		}
		if (rs != null) {
			rs.close();
		}

	}
}
