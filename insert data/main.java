//Import JDBC packages.
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;
class main
{
public static void main(String args[])
{
	Connection conn = null;
	Statement stmt = null;
try
{
//Load and register the JDBC driver.	
Class.forName("com.mysql.jdbc.Driver");

//Open a connection to the database.
conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");//test is default database of xampp("url","user","password")
System.out.print("Database is connected !\n");

//Create a statement object to perform a query.
stmt = conn.createStatement();

//SQL Query Execute
 System.out.println("Inserting records into the table...");
	//row 1
      String sql = "INSERT INTO Registration " +
                   "VALUES (100, 'Zara', 'Ali', 18)";
      stmt.executeUpdate(sql);
	  
	  //row 2
      sql = "INSERT INTO Registration " +
                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
      stmt.executeUpdate(sql);
	  
	  //row 3
      sql = "INSERT INTO Registration " +
                   "VALUES (102, 'Zaid', 'Khan', 30)";
      stmt.executeUpdate(sql);
	  
	  //row 4
      sql = "INSERT INTO Registration " +
                   "VALUES(103, 'Sumit', 'Mittal', 28)";
      stmt.executeUpdate(sql);

System.out.println("Inserted records into the table...");


//close connection
conn.close();

}
catch(Exception e)
{
System.out.print("Cannot connect to DB - Error:"+e);
}
}
}