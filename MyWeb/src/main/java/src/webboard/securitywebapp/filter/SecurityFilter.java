package src.webboard.securitywebapp.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import src.webboard.conn.JDBCPostgreSQL;
import src.webboard.tabl.User_account;
import src.webboardSecurityAcsses.SecurityAcsses;
import src.webboardUserRole.UserRoleRequestWrapper;
import src.webbordlog.logUser;
 
 
@WebFilter("/*")
public class SecurityFilter implements Filter {
 
    public SecurityFilter() {
    }
 
    public void destroy() {
    }
 
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        System.out.println("Security Filter works");
        
        String servletPath = request.getServletPath();
        
        Connection conn = null;
        User_account logUs = logUser.getlogUser(request.getSession());
        if (logUser.getStoredConnection(request) == null & logUser.getlogUser(request.getSession()) != null) 
        {
        	
				try {
					conn = JDBCPostgreSQL.conni();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
        	logUser.storeConnection(request, conn);
        }
        
        if (servletPath.equals("/login")) {
        	System.out.println("Security Filter transfer to - " + servletPath +".java");
            chain.doFilter(request, response);
            return;
        }
        

        HttpServletRequest wrapRequest = request;
        
        if (logUs != null) {
        	System.out.println("Login (" + logUs.getuser_name() + ") OK!!!");
            String user_name = logUs.getuser_name();
            
            List<String> roles = logUs.getroles();
            
            wrapRequest = new UserRoleRequestWrapper(user_name, roles, request);
            
            logUser.storeConnection(wrapRequest, conn);

        }
        System.out.println("request: " + request);
        if (SecurityAcsses.isSecurityPage(request)) {
            if (logUs == null) {
            	System.out.println("Redirect in login");
                String requestUri = request.getRequestURI();

                int redirectId = logUser.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
 
                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }
 
            
            boolean hasPermission = SecurityAcsses.hasPermission(wrapRequest);
            if (!hasPermission) {
            	System.out.println(request.getServletPath() + " - for " + logUs.getuser_name() + " access close");
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accessDeniedView.jsp");
 
                dispatcher.forward(request, response);
                return;
            }
        }
        System.out.println("Security Filter request in " + servletPath);
        chain.doFilter(wrapRequest, response);
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
}