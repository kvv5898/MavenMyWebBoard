package src.webboard.servlet.Notices.mysql;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class Delete {
 
	public static void noticesDEL(Connection conn, Integer notices_id) throws SQLException {
        String sql = "Delete From notices where notices_id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, notices_id);
 
        pstm.executeUpdate();
        System.out.println("(" + notices_id + ") removed from the database ");
    }
}