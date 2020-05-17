package com.iut.controleurs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iut.dao.RestaurantDao;
import com.iut.modeles.Restaurant;

public class ModifierRestaurantControleur extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String message;
		boolean reponse = false;
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String type = request.getParameter("typeRestaurant");
		Restaurant restaurant = new Restaurant(id, nom, adresse, type);
		RestaurantDao restaurantDao = new RestaurantDao();
		try {
			reponse = restaurantDao.update(restaurant);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = reponse ? "Le restaurant a bien été modifé" : "La modification ne s'est pas effectuée, vérifiez que l'id entré existe";
		request.setAttribute( "test", message );
		this.getServletContext().getRequestDispatcher("/Reponse.jsp").forward( request, response );
	}
}
