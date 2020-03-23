package src.webboard.servlet.Notices.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.webboard.servlet.Notices.mysql.Info;
import src.webbordlog.logUser;

@WebServlet(urlPatterns = { "/notices" })
public class noticesInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
 

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = logUser.getStoredConnection(request);
    	
    	
    	String loginedUser = logUser.getlogUser(request.getSession()).getuser_name();
    	System.out.println("loginedUser: " + loginedUser);
    	 request.setAttribute("user", loginedUser);
        
        String errorString = null;
        List<src.webboard.tabl.Notices> list = null;
        try {
            list = Info.infonotices(conn);
        } catch (SQLException e) {
            e.printStackTrace();
          errorString = e.getMessage();
        }
      
//        System.out.println("getuser_id()" + list.get(0).getuser_id());
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("noticesList", list);
        
        System.out.println("Notices.java request in NoticesView.jsp ");
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/NoticesView.jsp");
        dispatcher.forward(request, response);
        
    }
}