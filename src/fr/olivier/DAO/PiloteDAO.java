package fr.olivier.DAO;

import java.util.List;

import fr.olivier.bean.Pilote;

public interface PiloteDAO {
	
	void ajouter(Pilote pilote);
	void supprimer(Pilote pilote);
	void modifier(Pilote pilote);
	public Pilote findbyId(int id_pilote);
	List<Pilote> listerPilote();

}
