package com.smartglossa.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	private void openConnection() throws Exception {
		Class.forName(StockConstant.MYSQL_DRIVER);
		 //String URL = "jdbc:mysql://" + StockConstant.MYSQL_SERVER + "/" +
		 //StockConstant.DATABASE_NAME;
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
