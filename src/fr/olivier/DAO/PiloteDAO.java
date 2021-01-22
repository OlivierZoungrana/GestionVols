package fr.olivier.DAO;

import java.util.List;

import fr.olivier.bean.Pilote;
import fr.olivier.bean.Vol;

public interface PiloteDAO {
	
	void ajouter(Pilote pilote);
	void supprimer(Pilote pilote);
	void modifier(Pilote pilote);
	public Pilote findbyId(int id_pilote);
	List<Pilote> listerPilote();
	List<Vol>pilotebyVol(int id_pilote);

}
