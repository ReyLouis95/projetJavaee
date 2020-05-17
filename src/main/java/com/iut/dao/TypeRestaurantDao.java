package com.iut.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iut.IDao;
import com.iut.connection.DbConnection;
import com.iut.modeles.*;
public class TypeRestaurantDao implements IDao<TypeRestaurant>{
	DbConnection dbConnection = new DbConnection();
	private static Connection connection;
	
	public TypeRestaurantDao() {
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
	public List<TypeRestaurant> read() throws SQLException {
		ArrayList<TypeRestaurant> reponse = new ArrayList<TypeRestaurant>();
		int id;
		String req = "select id, nom from type_restaurant";
		String nom, adresse, type;
		PreparedStatement ps = connection.prepareStatement(req);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			id = rs.getInt(1);
			nom = rs.getString(2);
			reponse.add(new TypeRestaurant(id, nom));
		}
		return reponse;
	}

	@Override
	public TypeRestaurant readById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(TypeRestaurant objet) throws SQLException {
		String req = "insert into type_restaurant (nom) values ?";
		PreparedStatement ps = connection.prepareStatement(req);
		int rep = ps.executeUpdate();
		if(rep > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(TypeRestaurant objet) throws SQLException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) throws SQLException {
		return false;
		// TODO Auto-generated method stub
		
	}

}
