package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.olivier.bean.Avion;

public class AvionDAOimpl implements AvionDAO {
	
	private DAOContext daoContext;
	private PreparedStatement preparedStatement;
	private Connection connexion;
	private ResultSet result;
	private final String listeAvion = "select * from VOL.Avion";
	private final String AjouterAvion ="insert into VOL.Avion(constructeur, model,capacite,site) values (?, ?,?,?)";
	private final String SupprimerAvion ="DELETE FROM VOL.Avion where id_avion=?";
	private final String ModifierAvion= "UPDATE VOL.Avion set constructeur=?,model=?, capacite=?, site=? WHERE id_avion=?";
	
	
	
	
	public AvionDAOimpl(DAOContext daoContext2) {
		
	}
	

	public void Ajouter(Avion avion) {
		
		try {
			
			connexion = DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement(this.AjouterAvion);
			preparedStatement.setString(1, avion.getConstructeur());
			preparedStatement.setString(2, avion.getModel());
			preparedStatement.setInt(3, avion.getCapacite());
			preparedStatement.setString(4, avion.getSite());
			int nombre = preparedStatement.executeUpdate();
			System.out.println(nombre);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	
	public void modifier(Avion avion) {
		
		try {
			
			connexion= DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement(this.ModifierAvion);
			preparedStatement.setString(1, avion.getConstructeur());
			preparedStatement.setString(2, avion.getModel());
			preparedStatement.setInt(3, avion.getCapacite());
			preparedStatement.setString(4, avion.getSite());
			preparedStatement.setInt(5, avion.getId_avion());
			int nombre= preparedStatement.executeUpdate();
			System.out.println(nombre);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	@Override
	public void supprimer(Avion avion) {
		
		try {
			
			connexion= DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement(this.SupprimerAvion);
			preparedStatement.setInt(1, avion.getId_avion());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
		
	}
	

	public Avion findbyId(int id_avion) {
		Avion avion= null;
		
		try {
			
			connexion= DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement("select * from avion where id_avion=?");
			preparedStatement.setInt(1, id_avion);
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				avion = new Avion();
				avion.setId_avion(id_avion);
				avion.setConstructeur(result.getString("constructeur"));
				avion.setModel(result.getString("model"));
				avion.setCapacite(result.getInt("capacite"));
				avion.setSite(result.getString("site"));
				
			}else {
				System.out.println("aucun avion");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(connexion!=null) {
					
					connexion.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return avion;
	}
	
	
	
	
	public List<Avion> listerAvion() {
		
		List<Avion> Lavion = new ArrayList<Avion>();
		
		try {
			
			connexion = DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement(this.listeAvion);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				int id_avion = result.getInt(1);
				String constructeur = result.getString(2);
				String model = result.getString(3);
				int capacite = result.getInt(4);
				String site = result.getString(5);
				
				
				Avion avion = new Avion();
				
				avion.setId_avion(id_avion);
				avion.setConstructeur(constructeur);
				avion.setModel(model);
				avion.setCapacite(capacite);
				avion.setSite(site);
				
				Lavion.add(avion);
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(connexion!=null) {
					
					connexion.close();
				}
				
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
			
		}
		return Lavion;
	}

}
