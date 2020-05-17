package com.iut.modeles;

public class Restaurant {

	private int id;
	private String nom;
	private String adresse;
	private int type;
	
	public Restaurant(int id, String nom, String adresse, int type) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
