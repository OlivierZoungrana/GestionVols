package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOContext {
	
	private static String url;
	private static String name;
	private static String password;
	
	
	public static Connection get_connection() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connexion = DriverManager.getConnection(url,name,password);
		return connexion;
		
	}

}
