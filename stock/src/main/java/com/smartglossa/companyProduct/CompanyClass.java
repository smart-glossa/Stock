package com.smartglossa.companyProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CompanyClass {
	Connection con = null;
	Statement stat = null;
	ResultSet res = null;

	public CompanyClass() throws Exception {
		openConnection();
	}
 public void addcompany(String prodid ,String prodname, String parid) throws SQLException{
	 try {
		String qry="insert into "
	} finally {
		closeConnection();
	}
 }

	private void openConnection() throws Exception {
		Class.forName(CompanyConstant.MYSQL_DRIVER);
		// String URL = "jdbc:mysql://" + StockConstant.MYSQL_SERVER + "/" +
		// StockConstant.DATABASE_NAME;
		String URL = "jdbc:mysql://localhost:3306/storesoft";
		con = DriverManager.getConnection(URL, CompanyConstant.USERNAME, CompanyClass.PASSWORD);
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