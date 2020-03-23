package src.webboard.servlet.Notices.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.webboard.tabl.Notices;


public class Info {
	
	public static List<Notices> infonotices(Connection conn) throws SQLException {
        String sql = "Select notices.notices_id, user_account.user_name, notices.date, notices.content " + // 
                      "from notices, user_account " + //
                      "where notices.user_id=user_account.user_id";
        System.out.println("Search info notices in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Notices> list = new ArrayList<Notices>();
        while (rs.next()) {
        	
        	Integer notices_id = rs.getInt("notices_id");
        	String user_name = rs.getString("user_name");
        	String notices_date = rs.getString("date");
            String content = rs.getString("content");
            String roles = null;
            
            Notices notices = new Notices(notices_id, user_name, notices_date, content, roles);
            
            notices.setnotices_id(notices_id);
            notices.setuser_name(user_name);
            notices.setnotices_date(notices_date);
            notices.setcontent(content);
            notices.setroles(roles);
            list.add(notices);
        }
        return list;	
}
	
	public static Integer find2(Connection conn, //
			Integer notices_id) throws SQLException {
 
        String sql = "Select user_id from notices where notices_id = ?";
        System.out.println("Find2 (" + notices_id + ") in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, notices_id);
        ResultSet rs = pstm.executeQuery();
        Integer Finduser_id = null;
        while (rs.next()) {
        Finduser_id = rs.getInt("user_id");
        }
        System.out.println("Finduser_id: " + Finduser_id);
        return Finduser_id; 
	}
	
	public static Notices find3(Connection conn, //
			Integer notices_id) throws SQLException {
 
        String sql = "Select notices.notices_id, user_account.user_name, notices.date, notices.content " + // 
                "from notices, user_account " + //
                "where notices_id = ? and notices.user_id=user_account.user_id";
        System.out.println("Find3 (" + notices_id + ") in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, notices_id);
        ResultSet rs = pstm.executeQuery();
        
        String user_name = null, content = null, roles = null;
        String notices_date = null;
            while (rs.next()) {
             user_name = rs.getString("user_name");
             notices_date = rs.getString("date");
             content = rs.getString("content");
             roles = null;
            }
            Notices notices_find3 = new Notices(notices_id, user_name, notices_date, content, roles);
            notices_find3.setnotices_id(notices_id);
            notices_find3.setuser_name(user_name);
            notices_find3.setnotices_date(notices_date);
            notices_find3.setcontent(content);
            notices_find3.setroles(roles);
            
            return notices_find3;
       
	}
	
}
	
