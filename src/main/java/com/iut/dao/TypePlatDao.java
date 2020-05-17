package com.iut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iut.IDao;
import com.iut.connection.DbConnection;
import com.iut.modeles.TypePlat;

public class TypePlatDao implements IDao<TypePlat>{

	private DbConnection dbConnection = new DbConnection();
	private Connection connection;
	
	public TypePlatDao() {
		if(connection == null) {
			try {
				connection = dbConnection.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<TypePlat> read() throws SQLException {
		ArrayList<TypePlat> reponse = new ArrayList<TypePlat>();
		int id;
		String nom;
		String req = "Select id, nom from type_plat";
		PreparedStatement ps = connection.prepareStatement(req);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			id = rs.getInt(1);
			nom = rs.getString(2);
			reponse.add(new TypePlat(id, nom));
		}
		return reponse;
	}

	@Override
	public TypePlat readById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(TypePlat objet) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypePlat objet) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
