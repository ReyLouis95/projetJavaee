package com.iut.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDbConnection {

	private Connection connection;
	private DbConnection dbConnection;
	
	@Before
	public void setUp() throws SQLException {
		connection = dbConnection.getConnection();
	}
}
