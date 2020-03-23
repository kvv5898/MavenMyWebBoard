package webboard.conn;
 
//STEP 1. Import required packages
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class JDBCPostgreSQL {
 
   //  Database credentials
      static final String DB_URL = "jdbc:postgresql://ec2-54-247-125-38.eu-west-1.compute.amazonaws.com/dfbrf8vjj6ns2c";
      static final String USER = "rivcgepabtokby";
      static final String PASS = "53c839ddca87030cb893f7fc660bde9207892aba0889566cced1e540d76fba21";
 
      public static Connection conni () throws SQLException,
      ClassNotFoundException {
 
	System.out.println("Testing connection to PostgreSQL JDBC");
 
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		
	}
 
	System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection(DB_URL, USER, PASS);
 
	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}
 
	if (connection != null) {
		System.out.println("You successfully connected to database now");
	} else {
		System.out.println("Failed to make connection to database");
	}
	return connection;
      }
     }