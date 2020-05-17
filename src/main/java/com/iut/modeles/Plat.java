package com.iut.modeles;

public class Plat {

	private int id;
	private String nom;
	private String typePlat;
	private int idRestaurant;
	private double prix;
	
	
	public Plat(int id, String nom, String typePlat, int idRestaurant, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.typePlat = typePlat;
		this.idRestaurant = idRestaurant;
		this.prix = prix;
	}
	
	public Plat(String nom, String typePlat, double prix, int idRestaurant) {
		this.nom = nom;
		this.typePlat = typePlat;
		this.prix = prix;
		this.idRestaurant = idRestaurant;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTypePlat() {
		return typePlat;
	}
	public void setTypePlat(String typePlat) {
		this.typePlat = typePlat;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setTypeRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
