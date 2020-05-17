package com.iut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iut.IDao;
import com.iut.connection.DbConnection;
import com.iut.modeles.Restaurant;

public class RestaurantDao implements IDao<Restaurant>{
	DbConnection dbConnection = new DbConnection();
	private static Connection connection;
	
	
	public RestaurantDao() {
		try {
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Restaurant> read() throws SQLException {
		ArrayList<Restaurant> reponse = new ArrayList<Restaurant>();
		int id, type;
		String nom, adresse;
		String req = "Select id, nom, adresse, type from restaurant";
		PreparedStatement ps = connection.prepareStatement(req);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			id = rs.getInt(1);
			nom = rs.getString(2);
			adresse = rs.getString(3);
			type = rs.getInt(4);
			reponse.add(new Restaurant(id, nom, adresse, type));
		}
		return reponse;
	}

	@Override
	public Restaurant readById(int id) throws SQLException {
		int type;
		String nom, adresse;
		String req = "Select id, nom, adresse, type from restaurant where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		nom = rs.getString(2);
		adresse = rs.getString(3);
		type = rs.getInt(4);
		return new Restaurant(id, nom, adresse, type);
	}

	@Override
	public void create(Restaurant restaurant) throws SQLException {
		String req = "insert into restaurant (nom, adresse, type) values (?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, restaurant.getNom());
		ps.setString(2, restaurant.getAdresse());
		ps.setInt(3, restaurant.getType());
		ps.execute();
	}

	@Override
	public void update(Restaurant restaurant) throws SQLException {
		String req = "update restaurant set nom = ?, adresse = ?, type = ? where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, restaurant.getNom());
		ps.setString(2, restaurant.getAdresse());
		ps.setInt(3, restaurant.getType());
		ps.execute();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
