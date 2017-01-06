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

	public void addstock(int companyId, String companyName, String address, String tinNo, String proprietor)
			throws SQLException, ClassNotFoundException, JSONException {
		try {
			String query = "insert into companyDetail(companyId,companyName,address,tinNumber,proprietor)values(" + companyId + ",'"
					+ companyName + "','" + address + "'," + tinNo + ",'" + proprietor + "')";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public JSONArray getall() throws SQLException, ClassNotFoundException, JSONException {
		JSONArray result = new JSONArray();
		try {
			String query = "select * from companyDetail";
			rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject get = new JSONObject();
				get.put("companyId", rs.getInt("companyId"));
				get.put("companyName", rs.getString("companyName"));
				get.put("address", rs.getString("address"));
				get.put("tinNo", rs.getInt("tinNumber"));
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
			String query = "select * from companyDetail where companyId=" + companyId;
			rs = stat.executeQuery(query);
			if (rs.next()) {
				one.put("companyName", rs.getString("companyName"));
				one.put("address", rs.getString("address"));
				one.put("tinNo", rs.getInt("tinNumber"));
				one.put("proprietor", rs.getString("proprietor"));
			}

		} finally {
			closeConnection();
		}
		return one;

	}

	public void updateStock(int companyId, String companyName, String address, String tinNo, String proprietor)
			throws SQLException, ClassNotFoundException, JSONException {
		try {
			String query = "update companyDetail set companyName='" + companyName + "',address='" + address + "',tinNumber='"
					+ tinNo + "',proprietor='" + proprietor + "' where companyId=" + companyId;
			stat.execute(query);

		} finally {

			closeConnection();
		}
	}

	public void deleteStock(int companyId) throws SQLException, ClassNotFoundException {
		try {
			String query = "delete from companyDetail where companyId=" + companyId;
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	private void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://" + StockConstants.MYSQL_SERVER + "/" + StockConstants.DATABASE,
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
