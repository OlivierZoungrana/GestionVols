package fr.olivier.DAO;

import java.util.List;

import fr.olivier.bean.Avion;

public interface AvionDAO {
	
	void Ajouter(Avion avion);
	void modifier(Avion avion);
	void supprimer(Avion avion);
	public Avion findbyId(int id_avion);
	List<Avion> listerAvion();

}
