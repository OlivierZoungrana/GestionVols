package fr.olivier.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.olivier.DAO.AvionDAO;
import fr.olivier.DAO.DAOContext;
import fr.olivier.bean.Avion;

/**
 * Servlet implementation class ListerAvion
 */
@WebServlet(urlPatterns = "/ListerAvion", loadOnStartup = 1)
public class ListerAvion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AvionDAO avionDao;
	
    public ListerAvion() {
        super();
        
    }
    
  
    public void init() throws ServletException {
    	DAOContext daoContext = new DAOContext();
    	this.avionDao = daoContext.getAvionDAO();
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Lavion", avionDao.listerAvion());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listeAvion.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Avion avion =null;
		List<Avion> avion_a = null;
		
		String action = request.getParameter("action");
		int id_avion = Integer.parseInt(request.getParameter("id_avion"));
		request.setAttribute("Lavion", avionDao.listerAvion());
		
		if(action.equals("modifier")) {
			avion = avionDao.findbyId(id_avion);
			request.setAttribute("avion", avion);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/AjouterAvion.jsp").forward(request, response);
		}else {
			avion =new Avion();
			avion.setId_avion(id_avion);
			avionDao.supprimer(avion);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listeAvion").forward(request, response);
		}
		
	}

}
