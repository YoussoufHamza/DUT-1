package exo_G_restaurant;

public class Client {
	private int id;
	private String nom;
	private String telephone;
	private String email;
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(int ID) {
		this.id = ID;
	}
	
}
