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

import src.webboard.conn.JDBCPostgreSQL;
import src.webboard.servlet.mysql.finduser;
import src.webboard.tabl.User_account;
import src.webbordlog.logUser;
 
@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Request in LoginView.jsp");
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/LoginView.jsp");
 
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	 Connection conn = null;
 		
 			try {
				conn = JDBCPostgreSQL.conni();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
 			logUser.storeConnection(request, conn);
 		
 		
        String user_name = request.getParameter("userName");
        String password = request.getParameter("password");
        User_account userAccount = null;
		try {
			userAccount = finduser.userFIND(conn, user_name, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        if (userAccount == null) {
            String errorMessage = "Invalid user_name or Password";
 
            request.setAttribute("errorMessage", errorMessage);
 
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/LoginView.jsp");
 
            dispatcher.forward(request, response);
            return;
        }
        
        logUser.storelogUser(request.getSession(), userAccount);
        
        // 
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(request.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = logUser.getRedirectAfterLoginUrl(request.getSession(), redirectId);
        if (requestUri != null) {
            response.sendRedirect(requestUri);
        } else {
        	System.out.println("Request in notices.java");
            response.sendRedirect(request.getContextPath() + "/home");
        }
 
    }
 
}