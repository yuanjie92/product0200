package com.product.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
	private final String URL = "jdbc:oracle:thin:@192.168.0.107:1521:XE";
	private final String NAME = "oracle";
	private final String PASSWORD = "oracle";
	private Connection conn;

	public Connection getConnection() {
		return conn;
	}

	public ConnectionDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (conn == null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
