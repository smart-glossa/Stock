package com.smartglossa.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ProweightClass {
	Connection conn = null;
	Statement statment = null;
	ResultSet rse = null;

	public ProweightClass () throws ClassNotFoundException, SQLException {
		openConnection();
		}
		public void addProweight(float costKg, float totalKg, int brandId) throws SQLException, ClassNotFoundException, JSONException {
			JSONObject obj = new JSONObject();
			try {
				String query = "insert into productweight(costPerkg,totalPerkg,brandId)values(" + costKg+ ","+ totalKg+","+brandId+")";
				 statment.execute(query);
				obj.put("status", "1");
			} finally {
				closeConnection();
			}
		}
	 

		public JSONArray getAll() throws SQLException, ClassNotFoundException, JSONException {
			JSONArray result = new JSONArray();
			try {
				String query = "select * from productweight";
				rse =statment.executeQuery(query);
				while (rse.next()) {
					JSONObject get = new JSONObject();
					get.put("costKg", rse.getInt("costKg"));
					get.put("totalKg", rse.getString("totalKg"));
					get.put("brandId", rse.getInt("brandId"));
					
					result.put(get);
				}
				return result;
			} finally {
				closeConnection();
			}
		}
	
			private void openConnection() throws SQLException, ClassNotFoundException {
				Class.forName(ProductConstact.MYSQL_DRIVER);
				conn = DriverManager.getConnection(ProductConstact.MYSQL_SERVER + "/" + ProductConstact.DATABASE,
						ProductConstact.USERNAME, ProductConstact.PASSWORD);
				statment = conn.createStatement();

			}

			private void closeConnection() throws SQLException {
				if (conn != null) {
					conn.close();

				}
				if (statment != null) {
					statment.close();
				}
				if (rse != null) {
					rse.close();
				}
			}
		
	}

	

