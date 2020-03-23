package src.webboard.servlet.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.webboard.servlet.other.date_time;

public class Log_finduser {
	
	public static void find_log(Connection conn, //
        String USER_FIND, String PASSWORD_FIND, String RESULT_FIND) throws SQLException {
        String sql = "Insert into log_finduser(USER_FIND, PASSWORD_FIND, TIME_FIND, RESULT_FIND) values (?,?,?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
 
        add.setString(1, USER_FIND);
        add.setString(2, PASSWORD_FIND);
        add.setString(3, date_time.date());
        add.setString(4, RESULT_FIND);
 
        add.executeUpdate();
	
	
}
}