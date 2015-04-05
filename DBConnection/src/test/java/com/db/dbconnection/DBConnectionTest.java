package com.db.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {
	private static Connection conn;
	private static Statement stmt;
	
	@Before
	public void setUpDB() {
		conn = DBConnection.getConnection();
		System.out.println("Info: DB connection has been established.");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Error: Statement cannot be created!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@After
	public void tearDown() {
		if (stmt != null)
			DBConnection.closeStatement(stmt);
		if (conn != null)
			DBConnection.closeConnection(conn);
	}
	
	@Test
	public void testQuery() {
		String sql = "Select id from myTable";
		try {
			ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("Error: Sql exception has been occured!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
