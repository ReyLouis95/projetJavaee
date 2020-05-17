package com.iut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iut.IDao;
import com.iut.connection.DbConnection;
import com.iut.modeles.Plat;

public class PlatDao implements IDao<Plat>{

	DbConnection dbConnection = new DbConnection();
	private Connection connection;
	
	
	public PlatDao() {
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
	public List<Plat> read() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plat readById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Plat objet) throws SQLException {
		String req = "insert into plat (nom, typeplat, id_restaurant, prix) values (?, ?, ?, ?)";
		PreparedStatement ps= connection.prepareStatement(req);
		ps.setString(1, objet.getNom());
		ps.setInt(2, getTypePlat(objet.getTypePlat()));
		ps.setInt(3, objet.getIdRestaurant());
		ps.setDouble(4, objet.getPrix());
		int rep = ps.executeUpdate();
		if(rep>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(Plat objet) throws SQLException {
		String req = "update plat set nom = ?, typeplat = ?, id_restaurant = ?, prix = ? where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setString(1, objet.getNom());
		ps.setInt(2, getTypePlat(objet.getTypePlat()));
		ps.setInt(3, objet.getIdRestaurant());
		ps.setDouble(4, objet.getPrix());
		ps.setInt(5, objet.getId());
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
		String req = "delete from plat where id = ?";
		PreparedStatement ps = connection.prepareStatement(req);
		ps.setInt(1, id);
		int rep = ps.executeUpdate();
		if(rep>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private int getTypePlat(String type) {
		switch(type) {
		case "entree":
			return 1;
		case "plat":
			return 2;
		case "dessert":
			return 3;
		default:
			return -1;
		}
	}

}
