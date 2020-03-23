package src.webboard.servlet.mysql;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.webboard.tabl.User_account;
 
public class finduser {
 
	public static User_account userFIND(Connection conn, //
            String user_name, String password) throws SQLException {
		
        String sql = "Select user_id, user_name, password from user_account" //
                + " where user_name = ? and password= ?";
        System.out.println("Find (" + user_name + ") in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user_name);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        String result = null;
        if (rs.next()) {
        	Integer user_id = rs.getInt("user_id");
            User_account userfind = new User_account();
            
			userfind.setuser_id(user_id);
            userfind.setuser_name(user_name);
            userfind.setpassword(password);
            List<String> roles= new ArrayList<String>();
            if (user_name.equals("Admin") | user_name.equals("admin")) {
            	roles.add("Admin");
            } else {
            	roles.add("User");
			}
            userfind.setroles(roles);
            result = "Find ok";
//            Log_finduser.find_log(conn, user_name, password,  result);
            return userfind;
        }
        result = "Find fault";
        Log_finduser.find_log(conn, user_name, password, result);
        System.out.println("(" + user_name + ") incorrect");
        return null;
    }
	
	public static User_account userFIND2(Connection conn, //
            Integer user_id) throws SQLException {
 
        String sql = "Select * from user_account where user_id = ?";
        System.out.println("Find (" + user_id + ") in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, user_id);
        ResultSet rs = pstm.executeQuery();
        
        String User_name = null, Email = null, Password = null,  Us_Date = null;
        while (rs.next()) {
    	User_name = rs.getString("user_name");
        Email = rs.getString("email");
        Password = rs.getString("password");
        Us_Date = rs.getString("date");
        }
        User_account User_account_edit = new User_account();
        
        User_account_edit.setuser_id(user_id);
        User_account_edit.setuser_name(User_name);
        User_account_edit.setemail(Email);
        User_account_edit.setpassword(Password);
        User_account_edit.setus_Date(Us_Date);
        return User_account_edit; 
	}
}
