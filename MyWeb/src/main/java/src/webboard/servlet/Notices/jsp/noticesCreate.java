package src.webboard.servlet.Notices.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.webboard.servlet.Notices.mysql.Create;
import src.webboard.servlet.other.date_time;
import src.webboard.tabl.Notices;
import src.webbordlog.logUser;


 
@WebServlet(urlPatterns = { "/createNotices" })
public class noticesCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/createNoticesView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Connection conn = logUser.getStoredConnection(request);
    	String user_name = logUser.getlogUser(request.getSession()).getuser_name();
    	request.setAttribute("name", user_name);
    	
         
        String content = (String) request.getParameter("content");
        Integer notices_id = null;
        String roles = null;
        
        String notices_date = date_time.date();
//        System.out.println("notices_date: " + notices_date);
        
        Notices noticescreate = new Notices(notices_id, user_name, notices_date, content, roles);
 
        String errorString = null;
 
        if (errorString == null) {
            try {
            	Create.noticescreate(conn, noticescreate);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("user_add", noticescreate);
 
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/createNoticesView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/notices");
        }
    }
 
}