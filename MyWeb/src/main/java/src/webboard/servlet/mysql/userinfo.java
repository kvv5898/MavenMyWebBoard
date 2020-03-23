package src.webboard.servlet.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.webboard.tabl.User_account;


public class userinfo {
	
	public static List<User_account> infouser(Connection conn) throws SQLException {
        String sql = "Select user_id, user_name,  email, password, date from user_account";
        System.out.println("Search info users in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<User_account> list = new ArrayList<User_account>();
        while (rs.next()) {
        	
        	Integer user_id = rs.getInt("user_id");
        	String user_name = rs.getString("user_name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String us_Date = rs.getString("Date");
            String[] roles = null;
            
            User_account us = new User_account(user_id, user_name, email, password, us_Date, roles);
            
//            System.out.println("user_id - " + user_id);
//            System.out.println("user_name - " + user_name);
//            System.out.println("email - " + email);
//            System.out.println("password - " + password);
//            System.out.println("us_Date - " + us_Date);
            
            us.setuser_id(user_id);
            us.setuser_name(user_name);
            us.setemail(email);
            us.setpassword(password);
            us.setus_Date(us_Date);
            list.add(us);
        }
        return list;
	
	
}
}