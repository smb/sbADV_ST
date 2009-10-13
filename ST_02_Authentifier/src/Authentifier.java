import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentifier {

	private static Connection con = null;
	private static String DATABASE = "jdbc:oracle:thin:@nora:1521:oracle";
	private static String USERNAME = "buehls";
	private static String PASSWORD = "buehls";
	private static String TABLE = "ST_02_AUTHENTIFIER_TUSER";

	private static int ANZAHL_VERSUCHE = 3;

	public static void main(String[] args) {

		int z_login_Versuch = 0;
		boolean isAngemeldet = false;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbankverbindungsaufbau");
		}

		if (con != null) {
			do {
				System.out.print("Benutzername: ");
				String username = ConsolReader.readString();
				System.out.print("Kennwort: ");
				String password = ConsolReader.readString();
				System.out.println("");
				isAngemeldet = isUserRegistriert(username, password);
				z_login_Versuch++;
			} while (!isAngemeldet && z_login_Versuch < ANZAHL_VERSUCHE);
		}

		if (isAngemeldet) {
			System.out.print("Sie haben sich erfolgreich angemeldet");
		} else {
			System.out.print("Sie konnten leider nicht angemeldet werden.");
		}

	}

	private static boolean isUserRegistriert(String userid, String password) {

		boolean isRegistriert = false;

		try {
			String strSql = "SELECT COUNT(id) FROM " + TABLE
					+ " WHERE id = ? AND password = ?";

			PreparedStatement stmt = con.prepareStatement(strSql);

			stmt.setString(1, userid);
			stmt.setString(2, password);

			ResultSet rset = stmt.executeQuery();

			rset.next();

			int numResults = rset.getInt(1);

			if (numResults == 1) {
				isRegistriert = true;
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff");
		}
		return isRegistriert;
	}
}
