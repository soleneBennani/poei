package bouton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Bdd {

	public Bdd() {
	}

	public DefaultTableModel getActor() {

		String URL = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		// public static String URL = "jdbc:mysql://localhost:3306/tplogin";
		final String LOGIN = "root";
		final String PASSWORD = "root";

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("actor_id");
		dm.addColumn("first_name");
		dm.addColumn("last_name");
		dm.addColumn("last_update");

		String sql = "SELECT* FROM actor";

		try {

			Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.println("Driver O.K.");
			ResultSet rst = stmt.executeQuery(sql);
			System.out.println(rst);

			while (rst.next()) {
				int actor_id = rst.getInt(1);
				String first_name = rst.getString(2);
				String last_name = rst.getString(3);
				String last_update = rst.getString(4);

				Object[] rowData = { actor_id, first_name, last_name, last_update };
				dm.addRow(rowData);
				System.out.println(rowData);
			}

			return dm;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void insertActor(String first_name, String last_name) {
		try {

			int id = 0;

			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String user = "root";
			String passwd = "root";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			String requete = "INSERT INTO actor( first_name, last_name) VALUES (?,?)";
			PreparedStatement st = conn.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, first_name);
			st.setString(2, last_name);

			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs != null && rs.first()) {
				// on récupère l'id généré
				id = rs.getInt(1);
			}
//			//Création d'un objet Statement
//			Statement statement = conn.createStatement();
//
//			// L'objet ResultSet contient le rÃ©sultat de la requÃªte SQL
//			int result = statement.executeUpdate(
//					"INSERT INTO actor( first_name, last_name, last_update) VALUES (null,?,?,?))");
//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteActor(int id) {
		try {

			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String user = "root";
			String passwd = "root";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			String requete = "DELETE FROM actor WHERE actor_id = ?";
			int affectedrows = 0;
			PreparedStatement stmt = conn.prepareStatement(requete);
			stmt.setInt(1, id);
			int rst = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
