import java.sql.*;

public class JDBCTester
{
	public static void main(String[] args) throws SQLException
	{

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@nora:1521:oracle", "wochingm", "wochingm");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM pflanzen");

		int cols = rset.getMetaData().getColumnCount();

		while (rset.next())
		{
			for(int i = 1; i < cols; i++)
			{
				System.out.print(rset.getString(i) + "\t\t");
			}
			System.out.println();
		}
		// end while

	}// end main
}
