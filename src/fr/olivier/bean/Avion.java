package fr.olivier.bean;

public class Avion {
	
	private int id_avion;
	private String constructeur;
	private String model;
	private int capacite;
	private String site;
	
	
	public Avion() {
	
	}


	public Avion(int id_avion, String constructeur, String model, int capacite, String site) {
		this.id_avion = id_avion;
		this.constructeur = constructeur;
		this.model = model;
		this.capacite = capacite;
		this.site = site;
	}


	public int getId_avion() {
		return id_avion;
	}


	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}


	public String getConstructeur() {
		return constructeur;
	}


	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	@Override
	public String toString() {
		return "Avion [id_avion=" + id_avion + ", constructeur=" + constructeur + ", model=" + model + ", capacite="
				+ capacite + ", site=" + site + "]";
	}
	
	
	
	
	

}
