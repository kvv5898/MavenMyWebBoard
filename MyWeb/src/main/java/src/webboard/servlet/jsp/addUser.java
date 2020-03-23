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
import src.webboard.servlet.mysql.useradd;
import src.webboard.servlet.other.date_time;
import src.webboard.tabl.User_account;
import src.webbordlog.logUser;


@WebServlet(urlPatterns = { "/adduser" })
public class addUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    public addUser() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/addUserView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Connection conn = logUser.getStoredConnection(request);
		
    	if (conn==null) {
    		
				try {
					conn = JDBCPostgreSQL.conni();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
    	}
    	
        String user_name = (String) request.getParameter("user_name");
        String password = (String) request.getParameter("password");
        String email = (String) request.getParameter("email");
        Integer user_id = null;
        String[] roles = null;
        
       
        String us_Date = date_time.date();
//        System.out.println("formatting: " + us_Date);
        
        User_account userADD = new User_account(user_id, user_name, email, password, us_Date, roles);
 
        String errorString = null;
 
        if (errorString == null) {
            try {
            	useradd.userADD(conn, userADD);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("user_add", userADD);
 
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/addUserView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
 
}