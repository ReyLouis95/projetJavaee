package com.iut.controleurs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iut.dao.PlatDao;
import com.iut.dao.RestaurantDao;
import com.iut.modeles.Plat;
import com.iut.modeles.Restaurant;

public class AjouterPlatControleur extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		String message;
		boolean reponse = false;
		String nom = request.getParameter("nom");
		String typePlat = request.getParameter("typePlat");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int idRestaurant = Integer.parseInt(request.getParameter("idResto"));
		Plat plat = new Plat(nom, typePlat, prix, idRestaurant);
		PlatDao platDao = new PlatDao();
		try {
			reponse = platDao.create(plat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = reponse ? "Le plat a bien été ajouté" : "L'ajout ne s'est pas effectué";
		request.setAttribute( "test", message );
		this.getServletContext().getRequestDispatcher("/Reponse.jsp").forward( request, response );
		
	}
}
