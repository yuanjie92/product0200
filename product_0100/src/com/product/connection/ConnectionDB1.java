package com.product.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB1 {
	private final String URL = "jdbc:oracle:thin:@192.168.0.107:1521:orcl";
	private final String NAME = "ORACLE";
	private final String PASSWORD = "tiger";
	private Connection conn;

	public ConnectionDB1() {
		try {
			Class.forName("oracle.jbdc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void colse(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}