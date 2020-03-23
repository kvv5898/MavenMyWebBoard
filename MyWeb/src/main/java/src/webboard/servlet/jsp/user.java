package src.webboard.servlet.jsp;

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

import src.webboard.servlet.mysql.userinfo;
import src.webboard.tabl.User_account;
import src.webbordlog.logUser;

@WebServlet(urlPatterns = { "/user" })
public class user extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public user() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = logUser.getStoredConnection(request);
        
        String errorString = null;
        List<User_account> list = null;
        try {
            list = userinfo.infouser(conn);
        } catch (SQLException e) {
            e.printStackTrace();
          errorString = e.getMessage();
        }
        
        
 //       System.out.println("user_id - " + list.get(1).getuser_id());
//        System.out.println("user_name - " + list.get(1).getuser_name());
//        System.out.println("getemail - " + list.get(1).getemail());
//        System.out.println("password - " + list.get(1).getpassword());
//        System.out.println("us_Date - " + list.get(3).getus_Date());
      
        request.setAttribute("errorString", errorString);
        request.setAttribute("userinfo", list);
        System.out.println("user.java request in UserView.jsp ");
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/UserView.jsp");
        dispatcher.forward(request, response);
        
    }
}