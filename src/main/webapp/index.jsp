<%@ page import="com.iut.dao.*" %>
<%@ page import="com.iut.modeles.*" %>
<%@ page import="java.util.*" %>
<script type="text/javascript" src="scripts/Jquery-min.js"></script>
<script type="text/javascript" src="scripts/DataTables.js"></script>
<script type="text/javascript" src="scripts/Accueil.js"></script>
<link href="styles/DataTables.css" rel="stylesheet" />
<link href="styles/bootstrap.css" rel="stylesheet" />
<link href="styles/Content.css" rel="stylesheet" />
<html>
<body>
<h2>Hello World!</h2>
<h3>test</h3>

<%! RestaurantDao restaurantDao = new RestaurantDao();%>
<%List<Restaurant> listeRestaurants = restaurantDao.read(); %>
<% List<TypeRestaurant> listeTypeRestaurant = new TypeRestaurantDao().read(); %>
<h3>Liste de tous les restaurants</h3>
<table id="restaurants" class="table table-striped table-bordered">
	<thead>
		<tr>
		<td>Id</td>
		<td>Nom</td>
		<td>Adresse</td>
		<td>Type</td>
		</tr>
	</thead>
	<tbody>
	<%for(Restaurant resto: listeRestaurants)
	{
		out.write("<tr class=\"detailResto\" data-href = DetailResto.jsp?id=" + resto.getId()+"><td>" + resto.getId() + "</td><td>" + resto.getNom() + "</td><td>" + resto.getAdresse() + "</td><td>" + resto.getType() + "</td></tr>");	
	} 
	%>
	</tbody>
</table>
<h3>Ajouter un restaurant à la liste:</h3>
<form method="post" action = "ajouterRestau">
<label>Nom</label>
<input type="text" name="nom" />
<br />
<label>Adresse</label>
<input type="text" name="adresse" />
<br />
<label>Type de restaurant</label>
<select name="typeRestaurant">
<% for(TypeRestaurant typeRestaurant: listeTypeRestaurant){
	out.write("<option>" + typeRestaurant.getNom());
} %>
</select>
<input type="submit" value = "Valider" />
</form>


<h3>Modifier un restaurant:</h3>
<form method="post" action="modifierRestau">
<label>Choisir l'id du restaurant à modifier:</label>
<input type="text" name="id">
<br />
<label>Changer le nom:</label>
<input type="text" name="nom" />
<br />
<label>Changer l'adresse:</label>
<input type="text" name="adresse" />
<br />
<label>Changer le type de restaurant:</label>
<select name="typeRestaurant">
<% for(TypeRestaurant typeRestaurant: listeTypeRestaurant){
	out.write("<option>" + typeRestaurant.getNom());
} %>
</select>
<input type="submit" value = "Valider" />
</form>

<h3>Supprimer un restaurant:</h3>
<form method="post" action="supprimerRestau">
<label>Choisir l'id du restaurant à supprimer</label>
<input type="text" name = "id" />
<input type="submit" value="Valider" />
</form>
</body>
</html>
