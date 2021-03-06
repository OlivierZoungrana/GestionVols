package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.olivier.bean.Pilote;
import fr.olivier.bean.Vol;


public class piloteDAOimpl implements PiloteDAO {

	private DAOContext daoContext;
	private Connection connexion;
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private final String listePilote = "select * from VOL.Pilote";
	private final String listebyVol ="select Pilote.nom_pilote, vol.id_vol,vol.site_depart,vol.site_arrive, vol.heure_depart, vol.heure_arrivee from VOL.Pilote inner join VOL.vol on (Pilote.id_pilote=vol.id_pilote) where pilote.id_pilote=?";
	private final String AjouterPilote ="insert into VOL.Pilote(nom_pilote, site) values (?, ?)";
	private final String SupprimerPilote ="DELETE FROM VOL.Pilote where id_pilote=?";
	private final String ModifierPilote= "UPDATE VOL.Pilote set nom_pilote=?,site=? WHERE id_pilote=?";
	public piloteDAOimpl(DAOContext daoContext) {

	}

	@Override
	public void ajouter(Pilote pilote) {
		
		try {
			
			connexion = DAOContext.get_connection();
			preparedStatement = connexion.prepareStatement(this.AjouterPilote);
			preparedStatement.setString(1, pilote.getNom());
			preparedStatement.setString(2, pilote.getSite());
			int nombre = preparedStatement.executeUpdate();
			System.out.println(nombre);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Pilote pilote) {
		
		try {
			
			connexion = DAOContext.get_connection();
			preparedStatement = connexion.prepareStatement(this.SupprimerPilote);
			preparedStatement.setInt(1, pilote.getId());
			preparedStatement.execute();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(this.connexion!= null) {
					connexion.close();
				}
			
			
		}catch (Exception e2) {
			e2.printStackTrace();
		}

		}
	}
	

	@Override
	public void modifier(Pilote pilote) {
		
		try {
			
			connexion = DAOContext.get_connection();
			preparedStatement= connexion.prepareStatement(this.ModifierPilote);
			preparedStatement.setString(1, pilote.getNom());
			preparedStatement.setString(2, pilote.getSite());
			preparedStatement.setInt(3, pilote.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(this.connexion!= null) {
					connexion.close();
				}
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}


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



	public Pilote findbyId(int id_pilote) {

		Pilote pilote = null;

		try {
			connexion = DAOContext.get_connection();
			PreparedStatement etat = connexion.prepareStatement("select * from Pilote where id_pilote=?");
			etat.setInt(1, id_pilote);
			result= etat.executeQuery();
			
			if(result.next()) {
				pilote = new Pilote();
				pilote.setId(id_pilote);
				pilote.setNom(result.getString("nom_pilote"));
				pilote.setSite(result.getString("site"));
			}else {

				System.out.println("Aucun pilote");
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try 
			{
				if (connexion!= null)
				{
					connexion.close();
				}
			}
			catch(SQLException ignore)

			{
				ignore.printStackTrace();
			}
		}

		return pilote;
	}


	public List<Vol> pilotebyVol(int id_pilote) {

		List<Vol> lBVol = new ArrayList<>();
		try {

			connexion = DAOContext.get_connection();
			preparedStatement = connexion.prepareStatement(this.listebyVol);
			preparedStatement.setInt(1, id_pilote);
			result = preparedStatement.executeQuery();

			while(result.next()) {

				String nom_pilote= result.getString(1);
				String id_vol= result.getString(2);
				String siteDepart = result.getString(3);
				String sitearrive= result.getString(4);
				Time heureDepart = result.getTime(5);
				Time heurearrive = result.getTime(6);


				Vol vol = new Vol();


				vol.setNom_pilote(nom_pilote);
				vol.setId_vol(id_vol);
				vol.setSite_depart(siteDepart);
				vol.setSite_arrive(sitearrive);
				vol.setHeure_depart(heureDepart);
				vol.setHeure_arrivee(heurearrive);


				lBVol.add(vol);

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


		return lBVol;
	}



}
