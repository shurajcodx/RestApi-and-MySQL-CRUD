package com.shuraj.restapidemo.util;

import java.sql.*;

public class JdbcConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "system";
	private static final String DBNAME = "restdb";
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName(DRIVERNAME);
		Connection conn = DriverManager.getConnection(URL+DBNAME,USERNAME,PASSWORD);
		return conn;
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(!conn.isClosed() && conn != null)
			conn.close();
	}
	
	public static void closeAll(PreparedStatement ps) {
		try {
			if(ps != null && !ps.isClosed())
				ps.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
