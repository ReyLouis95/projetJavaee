<%@ page import="com.iut.dao.*" %>
<%@ page import="com.iut.modeles.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    RestaurantDao restaurantDao = new RestaurantDao();
    Restaurant restaurant = new Restaurant();
    TypePlatDao typePlatDao = new TypePlatDao();
    int id = 0;
    if(request.getParameter("id") != null){
    	id = Integer.parseInt(request.getParameter("id"));
        restaurant = restaurantDao.readById(id); 
    }
    else{
    	response.sendRedirect("index.jsp");
    }
    List<Plat> listeEntrees = restaurantDao.getEntrees(restaurant.getId());
    List<Plat> listePlats = restaurantDao.getPlats(restaurant.getId());
    List<Plat> listeDesserts = restaurantDao.getDesserts(restaurant.getId());
    List<TypePlat> listeTypePlats = typePlatDao.read();
    List<Plat> listeAllPlats = restaurantDao.getAllPlats(restaurant.getId());
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="styles/Cache.css" rel="stylesheet" />
</head>
<body>
<h1>Detail du restaurant <% out.write(restaurant.getNom()); %></h1>
<p>Adresse: <% out.write(restaurant.getAdresse()); %></p>
 <p>Type: <% out.write(restaurant.getType()); %> </p>
 <br />
 <br />
 <label> Entrées: </label> <br />
<% for(Plat plat: listeEntrees){
	out.write("<label>" + "Id:" + plat.getId() + " " +  plat.getNom() +  " " + Double.toString(plat.getPrix()) + "euros </label> <br />");
	}%>
<br />
 <label> Plats: </label> <br />
<% for(Plat plat: listePlats){
	out.write("<label>" + "Id:" + plat.getId() + " " + plat.getNom() + " " + Double.toString(plat.getPrix()) + "euros </label> <br />");
	}%>
<br />
 <label> Desserts: </label> <br />
<% for(Plat plat: listeDesserts){
	out.write("<label>" + "Id:" + plat.getId() + " " + plat.getNom() + " " + Double.toString(plat.getPrix()) + "euros </label> <br />");
	}%>
	
	
<h3>Ajouter un plat à ce restaurant:</h3>
<form method="post" action="ajouterPlat">
<label>Nom du plat</label>
<input type="text" name="nom" />
<br />
<label>Type de plat:</label>
<select name = "typePlat">
<% for(TypePlat typePlat: listeTypePlats){
	out.write("<option>" + typePlat.getNom() + "</option>");
	} %>
</select>
<br />
<label>Prix:</label>
<input type="number" name="prix">
<input type="text" name="idResto" class="cache" value=<%out.write(Integer.toString(restaurant.getId())); %> />
<br />
<input type="submit" value="Valider" />
</form>

<h3>Modifier un plat:</h3>
<form method="post" action="modifierPlat">
<label>Id du plat à modifier:</label>
<select name="id">
<% for(Plat plat: listeAllPlats){
	out.write("<option>" + plat.getId() + "</option>");
	} %>
</select> <br />
<label>Changer le nom du plat:</label>
<input type="text" name="nom" />
<br />
<label>Changer le type de plat</label>
<select name = "typePlat">
<% for(TypePlat typePlat: listeTypePlats){
	out.write("<option>" + typePlat.getNom() + "</option>");
	} %>
</select>
<br />
<label>Changer le prix du plat:</label>
<input type="number" name="prix">
<input type="text" name="idResto" class="cache" value=<%out.write(Integer.toString(restaurant.getId())); %> />
<br />
<input type="submit" value="Valider" /> <br />
</form>
<h3>Supprimer un plat</h3>
<form method="post" action = "supprimerPlat">
<label>Id du plat à supprimer:</label>
<select name="id">
<% for(Plat plat: listeAllPlats){
	out.write("<option>" + plat.getId() + "</option>");
	} %>
</select> <br />
<input type="submit" value="Valider"/>
</form>
</body>
</html>