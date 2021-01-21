package fr.olivier.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOContext {
	
	private static String db_url="jdbc:mysql://localhost:3306/VOL";
	private static String db_name="root";
	private static String db_password="Amour1988";
	
	
	public static Connection get_connection() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connexion = DriverManager.getConnection(db_url,db_name,db_password);
		return connexion;
		
	}
	
	public PiloteDAO getPiloteDao() {
		
		return new piloteDAOimpl(this);
	}

}
