package sn.objis.gestionemission.dao;
import sn.objis.gestionemission.domaine.*;
import sn.objis.gestionemission.utils.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Cette classe implemente l'interface IDaoInterfEmission
 * Elle permet d'acceder � une base de donnees et de faire tous les traitements
 * @author Gassama
 *@version 1
 */
public class IDaoImplEmission implements IDaoInterfEmission{
	// Obtention de l'unique instance de connexion avec la base
		Connection con = MysqlConnection.getInstanceConnection();
		private String url="jdbc:mysql://localhost/gestionemission?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		private String user="root";
		private String password ="";
		int i=0;
		/**
		 * Cette methode permet de creer une emission et d'inserer 
		 * les valeurs de proprietes dans  une base de donnee
		 */
		public void create(Emission e) {
			try {
				//Etape1 : Cr�ation de la zone de requ�te
				String sql = "INSERT INTO emission VALUES(?,?,?,?)";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				//Etape 2 : transmission des valeurs aux parametres de la requ�te
				preparedStatement.setInt(1, e.getId());
				preparedStatement.setString(2, e.getNom());
				preparedStatement.setString(3, e.getAnimateur());
				preparedStatement.setInt(4, e.getDuree());
				//Etape 3 : ex�cution de la requ�te
				preparedStatement.executeUpdate();
				System.out.println("Insertion r�ussit");
			}
				catch (SQLException e1) {
					System.out.println("Erreur de mise � jour");
					e1.printStackTrace();
				}
			}
		/**
		 * Cette methode permet de parcourrir les elements de la table emission 
		 * et les stocke dans une liste qu'elle va retouner � la fin
		 * @return list
		 */
		public List<Emission> read() {
			List<Emission> list = new ArrayList<Emission>();
			try {
				//Etape 1 : Cr�ation de la zone de req�te
				String sql = "SELECT * FROM emission";
				Statement statement = con.createStatement();
				//Etape 2: Ex�cution de la requ�te
				ResultSet rs = statement.executeQuery(sql);
				//Traitement du resultat
				
				while(rs.next()) {
					Emission e;
					int idRecup = rs.getInt("idEmission");
					String nomRecup = rs.getString("nom");
					String animRecup = rs.getString("animateur");
					int dureeRecup = rs.getInt("duree");
					e = new Emission(idRecup,nomRecup, animRecup, dureeRecup);
					list.add(e);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		/**
		 * Cette methode permet � jour la table emission apres 
		 * le changement d'un animateur pour une emission donnee 
		 */
		public void update(Emission e) {
			try {
				// Creation de a zone de requete
				String sql="UPDATE emission SET animateur=? WHERE idEmission=?";
				PreparedStatement preparedStatement=con.prepareStatement(sql);
				preparedStatement.setString(1, e.getAnimateur());
				preparedStatement.setInt(2, e.getId());
				preparedStatement.executeUpdate();
				System.out.println("Modification effectu�");
			} catch (SQLException e1) {
				System.out.println("Erreur de mise � jour");
				e1.printStackTrace();
			}
			

		}
		/**
		 * Cette methode permet de supprimer une emission donnee
		 */
		public void delete(Emission e) {
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
			//�tape 2:cr�ation de la zone de requ�te
			String sql="DELETE from  emission where idEmission=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//etape 3 : transmission des valeurs 
			ps.setInt(1,e.getId());
			//�tape 4: execution de la requ�te
			ps.executeUpdate();
			System.out.println("success");
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				System.out.println("failed");
			}

		}
		/**
		 * Cette methode retourne une emission recherchee 
		 * en se basant sur un identifiant donne en parametre
		 * @return em
		 */
		public Emission trouverEmission(int id)
		{
			Emission em = null;
			try {

				Connection con = DriverManager.getConnection(url, user, password);

				// �tape 2:cr�ation de la zone de requ�te
				String sql = "Select * From emission where idEmission=?";
				PreparedStatement ps = con.prepareStatement(sql);

				// etape 3:transmission des valeurs
				ps.setInt(1, id);

				// �tape 4: execution de la requ�te
				ResultSet rs = ps.executeQuery();
				// etape 5: traitement des donn�es du resultat
				while (rs.next()) {
					int idRecup = rs.getInt("idEmission");
					String nomRecup = rs.getString("nom");
					String animRecup = rs.getString("animateur");
					int dureeRecup = rs.getInt("duree");
					em = new Emission(idRecup,nomRecup, animRecup, dureeRecup);

				}
				if(em != null) {
					System.out.println("success");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("failed");
			}
			return em;
		}	
		}
		
