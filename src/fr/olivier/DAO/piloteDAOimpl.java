package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.olivier.bean.Pilote;


public class piloteDAOimpl implements PiloteDAO {
	
	private DAOContext daoContext;
	private Connection connexion;
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private final String listePilote = "select * from VOL.Pilote";

	public piloteDAOimpl(DAOContext daoContext) {

	}

	@Override
	public void ajouter(Pilote pilote) {
		
		
	}

	@Override
	public void supprimer(Pilote pilote) {
		
		
	}

	@Override
	public void modifier(Pilote pilote) {
		
		
	}

	

	@Override
	public List<Pilote> listerPilote() {
		
		List<Pilote> Lpilote = new ArrayList<Pilote>();
		
		try {
			connexion = DAOContext.get_connection();
			preparedStatement = connexion.prepareStatement(this.listePilote);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt(1);
				String nom = result.getString(2);
				String site= result.getString(3);
				
				Pilote pilote = new Pilote();
				
				pilote.setId(id);
				pilote.setNom(nom);
				pilote.setSite(site);
				
				Lpilote.add(pilote);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			
	try {
				if(connexion!= null) {
					
					connexion.close();
				}
			}catch(SQLException ignore) {
				
				ignore.printStackTrace();
			}
		}
			
		return Lpilote;
	}

	
	@Override
	public Pilote findbyId(int id_pilote) {
	
		return null;
	}

	

}
