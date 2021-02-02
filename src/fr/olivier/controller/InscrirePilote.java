package fr.olivier.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.olivier.DAO.DAOContext;
import fr.olivier.DAO.PiloteDAO;
import fr.olivier.bean.Pilote;

/**
 * Servlet implementation class InscrirePilote
 */
@WebServlet(urlPatterns = "/InscrirePilote", loadOnStartup = 1)
public class InscrirePilote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PiloteDAO piloteDao;
    
   
    	public void init() throws ServletException {
    	DAOContext daoContext = new DAOContext();
    	this.piloteDao = daoContext.getPiloteDao();
    	}
    
    
    public InscrirePilote() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Lpilote", piloteDao.listerPilote());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/InscriptionPilote.jsp").forward(request, response);;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		if(!request.getParameter("id_pilote").equals("")||
				!request.getParameter("nom").equals("")||
				!request.getParameter("site").equals(""))
				 {
			
		if(!request.getParameter("id_pilote").equals(""))
			
		{
			Pilote pilote = new Pilote();
			pilote.setNom(request.getParameter("nom"));
			pilote.setSite(request.getParameter("site"));
			pilote.setId(Integer.parseInt(request.getParameter("id_pilote")));
			System.out.println(request.getParameter("id_pilote"));
			piloteDao.modifier(pilote);
			
		}
		
		else {
			
			Pilote pilote = new Pilote();
			pilote.setNom(request.getParameter("nom"));
			pilote.setSite(request.getParameter("site"));
			piloteDao.ajouter(pilote);
			
		}
		request.setAttribute("Lpilote", piloteDao.listerPilote());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listePilote.jsp").forward(request, response);
			
		}
	}

}
