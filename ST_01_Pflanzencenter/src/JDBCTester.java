import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTester {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@nora:1521:oracle", "eggere", "eggere");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM pflanzen");

		while (rset.next()) {
			System.out.println(rset.getString(2));
		}

	}
}
