package fr.olivier.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.olivier.DAO.DAOContext;
import fr.olivier.DAO.PiloteDAO;

/**
 * Servlet implementation class Listerpilote
 */
@WebServlet(urlPatterns = "/Listerpilote", loadOnStartup = 1)
public class Listerpilote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Listerpilote() {
        super();
      
    }
    
    private static PiloteDAO piloteDao;
    
  
    public void init() throws ServletException {
    	DAOContext daoContext = new DAOContext();
    	this.piloteDao = daoContext.getPiloteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("jentre dans le doget");
		request.setAttribute("Lpilote", piloteDao.listerPilote());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/listePilote.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
