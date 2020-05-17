package com.iut.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/projetjavaee";
	private static final String MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
	
	static {
		try {
			Class.forName(MARIADB_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Unable to instanciate MariaDb driver");
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, "root", "");
	}

}

