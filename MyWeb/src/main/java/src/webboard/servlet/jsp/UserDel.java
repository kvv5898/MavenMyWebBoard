package src.webboard.servlet.jsp;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.webboard.servlet.mysql.deluser;
import src.webbordlog.logUser;

@WebServlet("/userdel")
public class UserDel extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
 
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	   Connection conn = logUser.getStoredConnection(request);
 
        String user_idStr = (String) request.getParameter("user_id");
        String user_name = request.getParameter("user_name");

        Integer user_id = null;
        try {
        	user_id = Integer.parseInt(user_idStr);
        } catch (Exception e) {
        }
 
        String errorString = null;
 
        try {
            deluser.userDEL(conn, user_id, user_name);
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
            response.sendRedirect(request.getContextPath() + "/user");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}