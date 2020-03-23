package src.webboard.servlet.jsp;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
@WebServlet(urlPatterns = { "/exit" })
public class ExitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ExitServlet() {
        super();
    }
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
            
            System.out.println("exit session.invalidate(): " + session);  
           
           
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }