package com.iut.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iut.modeles.Restaurant;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestRestaurantDao {

	RestaurantDao restaurantDao;
	Restaurant restaurantExisteDeja;
	Restaurant restaurant;
	Restaurant restaurantUpdate;
	boolean bool;
	
	@Before
	public void setUp() throws SQLException {
		restaurantDao = new RestaurantDao();
		restaurant = new Restaurant(50, "TestNom", "TestAdresse", "Italien");
		restaurantUpdate = new Restaurant(50, "NomUpdate", "AdresseUpdate", "Chinois");
		bool = restaurantDao.create(restaurant);
		List<Restaurant> listeRestaurants = restaurantDao.read();
		
	}
	
	
	@Test
	public void testCreateCheckValues() throws SQLException{
		Restaurant restaurantRead = restaurantDao.readById(restaurant.getId());
		Assert.assertEquals(restaurant, restaurantRead);
	}
	
	@Test
	public void testUpdateCheckValues() throws SQLException{
		restaurantDao.update(restaurantUpdate);
		Restaurant restaurantRead = restaurantDao.readById(restaurantUpdate.getId());
		Assert.assertEquals(restaurantRead, restaurantUpdate);
	}
	
	@Test
	public void testDelete() throws SQLException{
		boolean bool2 = restaurantDao.delete(50);
		Assert.assertEquals(true, bool2);
	}
	
}
