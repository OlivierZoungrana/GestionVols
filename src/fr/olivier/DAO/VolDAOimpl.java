package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.olivier.bean.Vol;

public class VolDAOimpl implements VolDAO {
	
		private DAOContext daoContext;
		private PreparedStatement prepareStatement;
		private Connection connexion;
		private ResultSet result;
		private final String listeVol = "select * from VOL.vol";
		private final String AjouterVol ="insert into VOL.vol(nom_pilote, site) values (?, ?)";
		private final String SupprimerVol ="DELETE FROM VOL.vol where id_vol=?";
		private final String ModifierVol= "UPDATE VOL.Pilote set nom_pilote=?,site=? WHERE id_pilote=?";
	
	
	

	public VolDAOimpl(DAOContext daoContext) {
			this.daoContext = daoContext;
		}

	
	

	public void ajouterVol(Vol vol) {
		
		try {
			
			connexion= DAOContext.get_connection();
			prepareStatement= connexion.prepareStatement("");
			prepareStatement.setString(1, vol.getSite_depart());
			prepareStatement.setString(2, vol.getSite_arrive());
			prepareStatement.setTime(3, vol.getHeure_depart());
			prepareStatement.setTime(4, vol.getHeure_arrivee());
			
			int nombre= prepareStatement.executeUpdate();
			System.out.println(nombre);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void modifierVol(Vol vol) {
		
		try {
			
			connexion = DAOContext.get_connection();
			prepareStatement= connexion.prepareStatement("");
			prepareStatement.setString(1, vol.getSite_depart());
			prepareStatement.setString(2, vol.getSite_arrive());
			prepareStatement.setTime(3, vol.getHeure_depart());
			prepareStatement.setTime(4, vol.getHeure_arrivee());
			prepareStatement.setString(5, vol.getId_vol());
			prepareStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void supprimerVol(Vol vol) {
		
		try {
			
			connexion = DAOContext.get_connection();
			prepareStatement= connexion.prepareStatement(this.SupprimerVol);
			prepareStatement.setString(1, vol.getId_vol());
			prepareStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(connexion!=null) {
					connexion.close();
				}
				
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Vol> Lvol() {
		List<Vol> Lvol = new ArrayList<Vol>();
		
		try {
			
			connexion=DAOContext.get_connection();
			prepareStatement= connexion.prepareStatement("select Pilote.nom_pilote, vol.id_vol,vol.id_avion, vol.id_pilote,vol.site_depart,vol.site_arrive, vol.heure_depart, vol.heure_arrivee from VOL.Pilote inner join VOL.vol on (Pilote.id_pilote=vol.id_pilote)");
			result= prepareStatement.executeQuery();
			
			while(result.next()) {
				
				/*
				String id_vol = result.getString(1);
				int id_avion=result.getInt(2);
				int id_pilote = result.getInt(3);
				String Site_depart= result.getString(4);
				String Site_arrive= result.getString(5);
				Time heure_depart = result.getTime(6);
				Time heure_arrive = result.getTime(7); 
				*/
				String nom_pilote= result.getString(1);
				String id_vol= result.getString(2);
				int id_avion = result.getInt(3);
				int id_pilote = result.getInt(4);
				String siteDepart = result.getString(5);
				String sitearrive= result.getString(6);
				Time heureDepart = result.getTime(7);
				Time heurearrive = result.getTime(8);
				
				Vol vol = new Vol();
				
				/*
				vol.setId_vol(id_vol);
				vol.setId_avion(id_avion);
				vol.setId_pilote(id_pilote);
				vol.setSite_depart(Site_depart);
				vol.setSite_arrive(Site_arrive);
				vol.setHeure_depart(heure_depart);
				vol.setHeure_arrivee(heure_arrive);
				*/
				vol.setNom_pilote(nom_pilote);
				vol.setId_vol(id_vol);
				vol.setId_avion(id_avion);
				vol.setId_pilote(id_pilote);
				vol.setSite_depart(siteDepart);
				vol.setSite_arrive(sitearrive);
				vol.setHeure_depart(heureDepart);
				vol.setHeure_arrivee(heurearrive);

				Lvol.add(vol);
				
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
			
		
		
		return Lvol;
	}




	@Override
	public Vol findbyId(String id_vol) {
		
		Vol vol =null;
		
		try {
			
			connexion= DAOContext.get_connection();
			prepareStatement= connexion.prepareStatement("");
			prepareStatement.setString(1, id_vol);
			result = prepareStatement.executeQuery();
			
			if(result.next()) {
				
				vol =new Vol();
				vol.setId_vol(id_vol);
				vol.setId_avion(result.getInt("id_avion"));
				vol.setId_pilote(result.getInt("id_pilote"));
				vol.setSite_depart(result.getString("site_depart"));
				vol.setSite_depart(result.getString("site_arrive"));
				vol.setHeure_depart(result.getTime("heure_depart"));
				vol.setHeure_arrivee(result.getTime("heure_arrivee"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connexion!=null) {
					connexion.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return vol;
	}

}
