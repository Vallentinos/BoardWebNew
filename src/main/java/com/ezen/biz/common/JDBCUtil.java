package com.ezen.biz.common;

import java.sql.*;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "spring_user";
		String pass = "ora123";
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			if(rs != null) try {
				rs.close();
			} catch(SQLException e1) {}
			if(stmt != null) try {
				stmt.close();
			} catch(SQLException e1) {}
			if(conn != null) try {
				conn.close();
			} catch(SQLException e1) {}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) try {
				stmt.close();
			} catch(SQLException e1) {}
			if(conn != null) try {
				conn.close();
			} catch(SQLException e1) {}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
