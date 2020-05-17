<%@ page import="com.iut.dao.*" %>
<%@ page import="com.iut.modeles.*" %>
<%@ page import="java.util.*" %>

<html>
<body>
<h2>Hello World!</h2>
<h3>test</h3>
<%! RestaurantDao restaurantDao = new RestaurantDao();%>
<% Restaurant restaurant = restaurantDao.readById(1); %>
<%List<Restaurant> listeRestaurants = restaurantDao.read(); %>
<% out.write(restaurant.getNom()); %>
<% for(Restaurant resto : listeRestaurants){
	out.write(Integer.toString(resto.getType()));
} %>
</body>
</html>
