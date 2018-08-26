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


//Update Query
 System.out.print("Updating Records !\n");
 String sql = "UPDATE Registration " +
                   "SET age = 30 WHERE id =101";
	   
//Execute query
 stmt.executeUpdate(sql);
 System.out.print("updated !\n");

//SQL Query
sql = "SELECT id, first, last, age FROM Registration";
System.out.print("Fetching Records !\n");
 //execute Query
 ResultSet rs = stmt.executeQuery(sql);
 
 
 //Extract data from result set
while(rs.next())
{
  //Retrieve by column name
    int id  = rs.getInt("id");
    int age = rs.getInt("age");
    String first = rs.getString("first");
    String last = rs.getString("last");

    //Display values
     System.out.print("ID: " + id);
     System.out.print(", Age: " + age);
     System.out.print(", First Name: " + first);
     System.out.println(", Last Name: " + last);
}

//close result set
rs.close();


//close connection
conn.close();

}
catch(Exception e)
{
System.out.print("Cannot connect to DB - Error:"+e);
}
}
}