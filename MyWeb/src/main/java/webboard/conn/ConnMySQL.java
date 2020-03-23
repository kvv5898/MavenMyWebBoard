package webboard.conn;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class ConnMySQL {
  
  
 public static Connection conni () throws SQLException,
         ClassNotFoundException {
	 
	 String hostName = "localhost";
     String dbName = "webboard";
     String userName = "root";
     String password = "1234";
     Class.forName("com.mysql.jdbc.Driver");
  
    
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName +
             "?verifyServerCertificate=false"+
             "&useSSL=false"+
             "&requireSSL=false"+
             "&useLegacyDatetimeCode=false"+
             "&amp"+
             "&serverTimezone=UTC";
;
  
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     System.out.println("Connection DB MySQL");
     return conn;
 }
}