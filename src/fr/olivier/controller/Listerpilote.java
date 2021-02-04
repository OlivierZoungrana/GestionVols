package fr.olivier.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.olivier.DAO.DAOContext;
import fr.olivier.DAO.PiloteDAO;
import fr.olivier.bean.Pilote;
import fr.olivier.bean.Vol;

/**
 * Servlet implementation class Listerpilote
 */
@WebServlet(urlPatterns = "/Listerpilote", loadOnStartup = 1)
public class Listerpilote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Listerpilote() {
        super();
      
    }
    
    private PiloteDAO piloteDao;
    
  
    public void init() throws ServletException {
    	DAOContext daoContext = new DAOContext();
    	this.piloteDao = daoContext.getPiloteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Lpilote", piloteDao.listerPilote());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listePilote.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pilote pilote =null;
		List<Vol> vol=null;
		
		String action = request.getParameter("action");
		int id_pilote= Integer.parseInt(request.getParameter("id_pilote"));
		System.out.println(id_pilote);
		
		request.setAttribute("Lpilote", piloteDao.listerPilote());
		
		if(action.equals("Affichervol")) {
			
			vol= piloteDao.pilotebyVol(id_pilote);
			request.setAttribute("lBVol", vol );
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/lisbyVol.jsp").forward(request, response);
		} else if(action.equals("modifier")) {
			System.out.println(action);
			System.out.println("infos pilote" +id_pilote);
			pilote = piloteDao.findbyId(id_pilote);
			System.out.println(pilote);
			request.setAttribute("pilote",pilote);
			System.out.println("je modifie");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/InscriptionPilote.jsp").forward(request, response);
			
		}else if(action.equals("supprimer")) {
			
			pilote = new Pilote();
			pilote.setId(id_pilote);
			piloteDao.supprimer(pilote);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listePilote.jsp").forward(request, response);
		}
		
		
	}

}
