package com.smartglossa.products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartglossa.stock.StockConstants;

public class productClass {
	
	 Connection conn = null;
	 Statement sta = null;
	 ResultSet rs = null;
	 
	 public productClass() throws ClassNotFoundException, SQLException {
	        openConnection();

	 }
		
		public void addproducts(int pId, String pName, int tinNo,int brandId, String brandName,int id,float qty, float costprice,float sellprice)
	            throws SQLException, ClassNotFoundException, JSONException {
	        JSONObject objec = new JSONObject();
	        try {
	            String query = "insert into product(productId,productName,tinNo)values('"+pId+"','"+pName+"','"+tinNo+"')";
	            String query1 = "insert into productbrand(brandId,brandName,productId)values(" + brandId + ",'"
	                    + brandName + "'," + pId+")";
	            String  query2="insert into productprice(id,brandId,quantity,costprice,sellprice)values("+id+","+brandId+","+qty+","+costprice+","+sellprice+")";
	            rs = sta.executeQuery(query);
	            objec.put("status", "1");
	        } finally {
	            closeConnection();   
		    }
		} private void openConnection() throws SQLException, ClassNotFoundException {
	        Class.forName(StockConstants.MYSQL_DRIVER);
	        conn = DriverManager.getConnection(StockConstants.MYSQL_SERVER + "/" + StockConstants.DATABASE,
	                StockConstants.USERNAME, StockConstants.PASSWORD);
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
