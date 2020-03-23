package src.webboard.servlet.mysql;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.webboard.tabl.User_account;
 
public class edituser {
 
	public static void userEDIT(Connection conn, User_account edit_user) throws SQLException {
        String sql = "Update user_account set user_name =?, email=?, password =? where user_id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        System.out.println("pstm - " + pstm);
        pstm.setString(1, edit_user.getuser_name());
        pstm.setString(2, edit_user.getemail());
        pstm.setString(3, edit_user.getpassword());
//        pstm.setDate(4, edit_user.getus_Date());
        pstm.setInt(4, edit_user.getuser_id());
        
        pstm.executeUpdate();
    }
}