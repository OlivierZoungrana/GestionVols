package fr.olivier.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.olivier.DAO.DAOContext;
import fr.olivier.DAO.VolDAO;

/**
 * Servlet implementation class ListerVol
 */
@WebServlet( urlPatterns = "/ListerVol", loadOnStartup = 1)
public class ListerVol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private VolDAO volDAO;
       
 
    public ListerVol() {
        super();
        
    }
    
    @Override
    	public void init() throws ServletException {
    		DAOContext daoContext = new DAOContext();
    		this.volDAO = daoContext.getVolDAO();
    		
    	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Lvol", volDAO.Lvol());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listeVol.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
