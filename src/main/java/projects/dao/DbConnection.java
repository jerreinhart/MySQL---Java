package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {

	private final static String SCHEMA = "projects";
	private final static String USER = "projects";
	private final static String PASSWORD = "projects";
	private final static String HOST = "localhost";
	private final static int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
				PASSWORD);
		System.out.println("Connecting with URL = " + url);

		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection Successful");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			throw new DbException(e);
		}

	}
}
