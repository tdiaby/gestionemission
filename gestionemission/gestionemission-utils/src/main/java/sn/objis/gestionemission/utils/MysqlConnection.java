package sn.objis.gestionemission.utils;
/**
 * Cette classe permet de mettre en oeuvre le design pattern singleton
 * elle permet de restreindre les acc�s � la base en une et une seule instance de
 * connection
 * @version 1
 * @author Gassama
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MysqlConnection {
	private static String url="jdbc:mysql://localhost/gestionemission?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userDb="root";
	private static String pwdDb="";
	private static Connection conn= null;
	
	//Constructeur priv� pour blocquer la cr�ation d'instance de la classe
	private MysqlConnection() {
		super();
	}
	/**
	 * Cette methode retourne l'unique instance de connection avec la base
	 * @return conn
	 */
	public static Connection getInstanceConnection(){
		try {
			if(conn==null) {
				conn=DriverManager.getConnection(url, userDb, pwdDb);
				System.out.println("Connexion �tablie avec la base");
			}
		} catch (SQLException e) {
			System.out.println("Probl�me de connexion");
			e.printStackTrace();
		}
		return conn;
	}
}
