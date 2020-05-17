package com.iut.controleurs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iut.dao.PlatDao;
import com.iut.modeles.Plat;

public class ModifierPlatControleur extends HttpServlet{
	
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message;
		boolean reponse = false;
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String typePlat = request.getParameter("typePlat");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int idRestaurant = Integer.parseInt(request.getParameter("idResto"));
		Plat plat = new Plat(id, nom, typePlat, idRestaurant, prix);
		PlatDao platDao = new PlatDao();
		try {
			reponse = platDao.update(plat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = reponse ? "Le plat a bien été modifié" : "La modification ne s'est pas effectué";
		request.setAttribute( "test", message );
		this.getServletContext().getRequestDispatcher("/Reponse.jsp").forward( request, response );
		
	}
}
