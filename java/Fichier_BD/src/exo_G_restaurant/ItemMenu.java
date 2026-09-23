package exo_G_restaurant;

public class ItemMenu {
	private int id;
	private String nom;
	private String categorie;
	private double prix;
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public void setId(int ID) {
		this.id = ID;
	}
	
}
