package Pflanzencenter;

import java.sql.*;


public class JDBCTester
{
 public static void main(String[] args) throws SQLException
  {
	  
   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver() );
   Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@nora:1521:oracle", "buck","buck");  
   Statement stmt = con.createStatement();
   ResultSet rset = stmt.executeQuery("SELECT * FROM pflanzen");
     
   
   while (rset.next() )
         {System.out.println(rset.getString(2));
         }
         //end while

  }//end main
}
