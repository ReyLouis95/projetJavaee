package com.iut.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.iut.*;
import com.iut.connection.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getOutputStream().print("defgy\n");
		DbConnection dbConnection = new DbConnection();
		try {
			Connection connection = dbConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
