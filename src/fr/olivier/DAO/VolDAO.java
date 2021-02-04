package fr.olivier.DAO;

import java.util.List;

import fr.olivier.bean.Pilote;
import fr.olivier.bean.Vol;

public interface VolDAO {
	
	void ajouterVol(Vol vol);
	void modifierVol(Vol vol);
	void supprimerVol(Vol vol);
	List<Vol> Lvol();
	public Vol findbyId(String id_vol);

}
