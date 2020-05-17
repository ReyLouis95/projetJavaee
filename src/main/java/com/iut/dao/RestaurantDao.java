package com.iut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iut.IDao;
import com.iut.connection.DbConnection;
import com.iut.modeles.Plat;
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
		int id;
		String nom, adresse, type;
		String req = "Select restaurant.id, restaurant.nom, restaurant.adresse, type_restaurant.nom from restaurant join type_restaurant on restaurant.type = type_restaurant.id";
		PreparedStatement ps = connection.prepareStatement(req);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			id = rs.getInt(1);
			nom = rs.getString(2);
			adresse = rs.getString(3);
			type = rs.getString(4);
			reponse.add(new Restaurant(id, nom, adresse, type));
		}
		return reponse;
	}

	@Override
	public Restaurant readById(int id) throws SQLException {
		String type;
		String nom, adresse;
		String req = "Select restaurant.id, restaurant.nom, restaurant.adresse, type_restaurant.nom from restaurant join type_restaurant on restaurant.type= type_restaurant.id where restaurant.id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		nom = rs.getString(2);
		adresse = rs.getString(3);
		type = rs.getString(4);
		return new Restaurant(id, nom, adresse, type);
	}

	@Override
	public boolean create(Restaurant restaurant) throws SQLException {
		String req = null;
		if(existeDeja(restaurant, read())) {
			return false;
		}
		if(restaurant.getId() == 0) {
			req = "insert into restaurant (nom, adresse, type) values (?, ?, ?)";
		}
		else {
			req = "insert into restaurant (id, nom, adresse, type) values (" + restaurant.getId() + ",?, ?, ?)";
		}
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, restaurant.getNom());
		ps.setString(2, restaurant.getAdresse());
		ps.setInt(3, getIntType(restaurant.getType()));
		int rep = ps.executeUpdate();
		if(rep > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(Restaurant restaurant) throws SQLException {
		String req = "update restaurant set nom = ?, adresse = ?, type = ? where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, restaurant.getNom());
		ps.setString(2, restaurant.getAdresse());
		ps.setInt(3, getIntType(restaurant.getType()));
		ps.setInt(4, restaurant.getId());
		int rep = ps.executeUpdate();
		if(rep>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) throws SQLException {
		String req="delete from restaurant where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		int rep = ps.executeUpdate();
		if(rep > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * convertit le type en int
	 * @param type
	 * @return le type correspondant en int
	 * @throws SQLException
	 */
	private int getIntType(String type) throws SQLException {
		String req = "select id from type_restaurant where nom = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public List<Plat> getEntrees(int id) throws SQLException{
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		String nom, typePlat;
		int idPlat;
		double prix;
		String req = "select plat.id, plat.nom, type_plat.nom, plat.prix from plat join type_plat on plat.typeplat = type_plat.id where plat.id_restaurant = ? and type_plat.id = 1";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			idPlat = rs.getInt(1);
			nom = rs.getString(2);
			typePlat = rs.getString(3);
			prix = rs.getDouble(4);
			listePlats.add(new Plat(idPlat, nom, typePlat, id, prix));
		}
		return listePlats;
	}
	
	public List<Plat> getPlats(int id) throws SQLException{
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		String nom, typePlat;
		double prix;
		int idPlat;
		String req = "select plat.id, plat.nom, type_plat.nom, plat.prix from plat join type_plat on plat.typeplat = type_plat.id where plat.id_restaurant = ? and type_plat.id = 2";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			idPlat = rs.getInt(1);
			nom = rs.getString(2);
			typePlat = rs.getString(3);
			prix = rs.getDouble(4);
			listePlats.add(new Plat(idPlat, nom, typePlat, id, prix));
		}
		return listePlats;
	}
	
	public List<Plat> getDesserts(int id) throws SQLException{
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		int idPlat;
		String nom, typePlat;
		double prix;
		String req = "select plat.id, plat.nom, type_plat.nom, plat.prix from plat join type_plat on plat.typeplat = type_plat.id where plat.id_restaurant = ? and type_plat.id = 3";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			idPlat = rs.getInt(1);
			nom = rs.getString(2);
			typePlat = rs.getString(3);
			prix = rs.getDouble(4);
			listePlats.add(new Plat(idPlat, nom, typePlat, id, prix));
		}
		return listePlats;
	}
	
	public List<Plat> getAllPlats(int id) throws SQLException{
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		int idPlat;
		String nom, typePlat;
		double prix;
		String req = "select plat.id, plat.nom, type_plat.nom, plat.prix from plat join type_plat on plat.typeplat = type_plat.id where plat.id_restaurant = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			idPlat = rs.getInt(1);
			nom = rs.getString(2);
			typePlat = rs.getString(3);
			prix = rs.getDouble(4);
			listePlats.add(new Plat(idPlat, nom, typePlat, id, prix));
		}
		return listePlats;
	}
	
	/**
	 * verifie si un restaurant existe deja
	 * @param restaurantACreer
	 * @param listeRestaurants
	 * @return true si le restaurant existe deja, sinon false
	 */
	private boolean existeDeja(Restaurant restaurantACreer, List<Restaurant> listeRestaurants) {
		for(Restaurant restaurant: listeRestaurants) {
			if(restaurant.getNom().equals(restaurantACreer.getNom()) || restaurant.getAdresse().equals(restaurantACreer.getAdresse())) {
				return true;
			}
		}
		return false;
	}
}
