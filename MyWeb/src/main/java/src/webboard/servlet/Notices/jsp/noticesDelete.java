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

import src.webboard.servlet.Notices.mysql.Delete;
import src.webboard.servlet.Notices.mysql.Info;
import src.webbordlog.logUser;

@WebServlet(urlPatterns = { "/deletenotices" })
public class noticesDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	   Connection conn = logUser.getStoredConnection(request);
 
	   Integer user_id = logUser.getlogUser(request.getSession()).getuser_id();
	   
        String notices_idStr = (String) request.getParameter("notices_id");

        Integer notices_id = null;
        try {
        	notices_id = Integer.parseInt(notices_idStr);
        } catch (Exception e) {
        }
 
        Integer Finduser_id = null;
        
        try {
			Finduser_id = Info.find2(conn, notices_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
//        System.out.println("user_id: " + user_id);
//        System.out.println("Finduser_id: " + Finduser_id);
        
        
        if (user_id !=Finduser_id) {
        	
            	System.out.println("Delete " + notices_id + " - for " + logUser.getlogUser(request.getSession()).getuser_name() + " access close");
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accessDeniedView.jsp");
 
                dispatcher.forward(request, response);
 		   return;
 	   }
        else {
        String errorString = null;
 
        try {
            Delete.noticesDEL(conn, notices_id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
        
        if (errorString != null) {

            request.setAttribute("errorString", errorString);
 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/delUserErrorView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/notices");
        }
 
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}