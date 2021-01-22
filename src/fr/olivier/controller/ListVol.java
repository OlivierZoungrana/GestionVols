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
 * Servlet implementation class ListVol
 */
@WebServlet( urlPatterns = "/ListVol", loadOnStartup = 1)
public class ListVol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListVol() {
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
		int id_pilote= Integer.parseInt(request.getParameter("id_pilote"));
		request.setAttribute("lBVol", piloteDao.pilotebyVol(id_pilote));
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/lisbyVol.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
