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

	public void addcompany(int comid, int priceid) throws SQLException {
		try {
			String qry = "insert into companyProduct(companyId,priceId)values(" + comid + "," + priceid + ")";
			stat.execute(qry);
		} finally {
			closeConnection();
		}
	}

	private void openConnection() throws Exception {
		Class.forName(com.smartglossa.stock.StockConstant.MYSQL_DRIVER);
		// String URL = "jdbc:mysql://" +
		// com.smartglossa.stock.StockConstant.MYSQL_SERVER + "/" +
		// com.smartglossa.stock.StockConstant.DATABASE_NAME;
		String URL = "jdbc:mysql://localhost:3306/storesoft";
		con = DriverManager.getConnection(URL, com.smartglossa.stock.StockConstant.USERNAME,
				com.smartglossa.stock.StockConstant.PASSWORD);
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
