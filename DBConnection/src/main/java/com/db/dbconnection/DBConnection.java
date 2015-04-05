package com.db.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to create database connection to an Oracle DB using pure JDBC.
 * 
 */
public class DBConnection {
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:test";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	private static Connection conn = null;
	
	/**
	 * This method returns the static connection instance
	 * @return connection
	 */
	public static Connection getConnection() {
		try {
			// Register JDBC driver and connect to DB
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			System.err.println("Error: Class cannot be found!");
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Error: Cannot connect to database, sql exception occured!");
			e.printStackTrace();
			System.exit(1);
		}
		return conn;
	}
	
	/**
	 * This method closes the open static connection instance.
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Error: Cannot close the connection!");
				e.printStackTrace();
				System.exit(1);
			}
	}
	
	/**
	 * This method closes the open static statement instance.
	 * @param stmt
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("Error: Cannot close the statement!");
				e.printStackTrace();
				System.exit(1);
			}
	}

}
