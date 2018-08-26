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
conn = DriverManager.getConnection("jdbc:mysql://localhost/","root", "");//test is default database of xampp("url","user","password")
System.out.print("Database is connected !\n");
System.out.println("Creating database...");

//Create a statement object to perform a query.
stmt = conn.createStatement();

//SQL Query
String sql = "CREATE DATABASE TEST";
//Execute Query
stmt.executeUpdate(sql);
System.out.println("Created database...");


//close connection
conn.close();

}
catch(Exception e)
{
System.out.print("Cannot connect to DB - Error:"+e);
}
}
}