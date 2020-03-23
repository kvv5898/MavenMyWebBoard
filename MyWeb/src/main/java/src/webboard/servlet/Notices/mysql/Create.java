package src.webboard.servlet.Notices.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.webboard.tabl.Notices;


public class Create {
	
	public static void noticescreate(Connection conn, Notices noticescreate) throws SQLException {
        String sql = "Insert into notices (user_id, date, content) values ((Select user_id from  user_account  where user_name=?), ?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
 
        add.setString(1, noticescreate.getuser_name());
//       System.out.println("noticescreate.getnotices_date():" + noticescreate.getnotices_date());
        add.setString(2, noticescreate.getnotices_date());
        add.setString(3, noticescreate.getcontent());
        
        
        add.executeUpdate();
	
	
}
}