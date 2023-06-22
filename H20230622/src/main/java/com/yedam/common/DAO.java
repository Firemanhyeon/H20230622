package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;

//데이터베이스기능
public class DAO {
	// jdbc driver 체크
	static String url = "jdbc:oracle:thin:@13.125.208.108:1521/xe";
	static String user = "proj";
	static String pass = "proj";
	static Connection conn;

	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
