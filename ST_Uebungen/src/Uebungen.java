import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Uebungen {

	private static Connection con = null;

	private static String DATABASE = "jdbc:oracle:thin:@nora:1521:oracle";

	private static String USERNAME = "buehls";

	private static String PASSWORD = "buehls";

	private static String TABLEPREFIX = "ST_01_PFLANZEN_";

	public static void main(String[] args) {

		// Datenbankverbindung
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		}
		catch (SQLException e) {
			System.out.println("Fehler beim Datenbankverbindungsaufbau");
			e.printStackTrace();
		}

		System.out.println("Übung 8.1:");
		printResult("SELECT COUNT(*) FROM " + TABLEPREFIX + "LIEFERANTEN");

		System.out.println("Übung 8.2:");
		printResult("SELECT AVG(PREIS) FROM " + TABLEPREFIX + "PFLANZEN");

		System.out.println("Übung 8.3:");
		printResult("SELECT MAX(HOEHE) FROM " + TABLEPREFIX + "PFLANZEN");

		System.out.println("Übung 9.13:");
		printResult("SELECT SORTE, MIN(PREIS) FROM " + TABLEPREFIX
				+ "PFLANZEN GROUP BY SORTE");

	}

	private static void printResult(String sqlString) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sqlString);
			ResultSetMetaData meta = rset.getMetaData();

			int colCount = meta.getColumnCount();
			StringBuffer resultString = new StringBuffer();

			for (int i = 1; i <= colCount; i++) {
				resultString.append(meta.getColumnLabel(i));
				if (colCount != i)
					resultString.append(" / ");
			}

			int delimLen = resultString.length();
			String delimiter = "-";

			resultString.append("\n");

			for (int di = 0; di < delimLen; di++) {
				resultString.append(delimiter);
			}

			resultString.append("\n");

			while (rset.next()) {
				for (int i = 1; i <= colCount; i++) {
					resultString.append(rset.getObject(i));
					if (colCount != i)
						resultString.append(" / ");
				}
				resultString.append("\n");
			}

			System.out.println(resultString.toString());

			rset.close();
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff");
			e.printStackTrace();
		}
	}
}