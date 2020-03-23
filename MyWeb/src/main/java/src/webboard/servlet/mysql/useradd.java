package src.webboard.servlet.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.webboard.tabl.User_account;


public class useradd {
	
	public static void userADD(Connection conn, User_account user_account) throws SQLException {
        String sql = "Insert into user_account(user_name,  email, password, date) values (?,?,?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
 
        add.setString(1, user_account.getuser_name());
        add.setString(2, user_account.getemail());
        add.setString(3, user_account.getpassword());
        add.setString(4, user_account.getus_Date());
 
        add.executeUpdate();
	
	
}
}