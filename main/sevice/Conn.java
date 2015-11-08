package main.sevice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private Connection connect;
	private final String URL = "jdbc:hsqldb:hsql://localhost/";
	
	public Conn() {
		try {
			connect = DriverManager.getConnection(URL);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connect;
	}
}
