package com.smartglossa.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

public class StockClass {
	Connection con = null;
	Statement stat = null;
	ResultSet res = null;

	public StockClass() throws Exception {
		openConnection();
	}

	public void addcompanyDetail(int comid, String comname, String tno, String prop, String addr) throws SQLException {
		try {
			String qry = "insert into companyDetail(cmpid,cmpName,tinNo,proprietor,addr)values(" + comid + ",'"
					+ comname + "','" + tno + "','" + prop + "','" + addr + "')";
			stat.execute(qry);
		} finally {
			closeConnection();
		}

	}

	public void updateDetail(int ucomid, String ucomname, String utno, String uprop, String uaddr) throws SQLException {
		try {
			String qry = "update companyDetail set cmpName='" + ucomname + "',tinNo='" + utno + "',proprietor='" + uprop
					+ "',addr='" + uaddr + "' where cmpid=" + ucomid + "";
			stat.execute(qry);

		} finally {
			closeConnection();
		}
	}

	public JSONObject getOne(int ucomid) throws SQLException {
		JSONObject one = new JSONObject();
		try {
			String qry = "select * from companyDetail where cmpid=" + ucomid;
			res = stat.executeQuery(qry);
			if (res.next()) {
				one.put("cid", res.getInt(1));
				one.put("cname", res.getString(2));
				one.put("tno", res.getString(3));
				one.put("prop", res.getString(4));
				one.put("addr", res.getString(5));
			}
		} finally {
			closeConnection();
		}
		return one;

	}

	private void openConnection() throws Exception {
		Class.forName(StockConstant.MYSQL_DRIVER);
		// String URL = "jdbc:mysql://" + StockConstant.MYSQL_SERVER + "/" +
		// StockConstant.DATABASE_NAME;
		String URL = "jdbc:mysql://localhost:3306/storesoft";
		con = DriverManager.getConnection(URL, StockConstant.USERNAME, StockConstant.PASSWORD);
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
