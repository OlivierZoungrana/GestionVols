package fr.olivier.bean;

import java.sql.Time;

public class Vol {
	
	
	private String id_vol;
	private int id_avion;
	private int id_pilote;
	private String site_depart;
	private String site_arrive;
	private Time heure_depart;
	private Time heure_arrivee;
	private String nom_pilote;
	
	public Vol() {
	}


	public Vol(String nom_pilote,String id_vol, int id_avion, int id_pilote, String site_depart, String site_arrive, Time heure_depart,
			Time heure_arrive) {
		super();
		this.nom_pilote= nom_pilote;
		this.id_vol = id_vol;
		this.id_avion = id_avion;
		this.id_pilote = id_pilote;
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.heure_depart = heure_depart;
		this.heure_arrivee = heure_arrivee;
	}

	
	

	public String getNom_pilote() {
		return nom_pilote;
	}


	public void setNom_pilote(String nom_pilote) {
		this.nom_pilote = nom_pilote;
	}


	public String getId_vol() {
		return id_vol;
	}


	public void setId_vol(String id_vol) {
		this.id_vol = id_vol;
	}


	public int getId_avion() {
		return id_avion;
	}


	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}


	public int getId_pilote() {
		return id_pilote;
	}


	public void setId_pilote(int id_pilote) {
		this.id_pilote = id_pilote;
	}


	public String getSite_depart() {
		return site_depart;
	}


	public void setSite_depart(String site_depart) {
		this.site_depart = site_depart;
	}


	public String getSite_arrive() {
		return site_arrive;
	}


	public void setSite_arrive(String site_arrive) {
		this.site_arrive = site_arrive;
	}


	public Time getHeure_depart() {
		return heure_depart;
	}


	public void setHeure_depart(Time heure_depart) {
		this.heure_depart = heure_depart;
	}


	public Time getHeure_arrivee() {
		return heure_arrivee;
	}


	public void setHeure_arrivee(Time heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}


	@Override
	public String toString() {
		return "Vol [nom_pilote=" + nom_pilote + ", id_vol=" + id_vol + ", id_avion=" + id_avion + ", id_pilote="
				+ id_pilote + ", site_depart=" + site_depart + ", site_arrive=" + site_arrive + ", heure_depart="
				+ heure_depart + ", heure_arrivee=" + heure_arrivee + "]";
	}



	
	

}
