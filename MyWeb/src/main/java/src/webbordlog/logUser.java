package src.webbordlog;
 
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import src.webboard.tabl.User_account;
 
 
public class logUser {
 
    private static int REDIRECT_ID = 0;
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
 
    
    public static void storeConnection(ServletRequest request, Connection conn) {
    	System.out.println("Write log for Connection (JAVA):" + conn);
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    
    public static Connection getStoredConnection(ServletRequest request) {
    	System.out.println("Read conn - " + request.getAttribute(ATT_NAME_CONNECTION));
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
    
    
    
    public static void storelogUser(HttpSession session, User_account logUser) { 
    	System.out.println("Write logUser for " + logUser.getuser_name() + "(JAVA)");
        session.setAttribute("logUser", logUser);
    }
 
   
    public static User_account getlogUser(HttpSession session) {
        User_account logUser = (User_account) session.getAttribute("logUser");
        if (logUser == null) {
        	System.out.println("No User Info");
        } else {
        	System.out.println("session.getId: - " + session.getId());
        	System.out.println("To read logUser for " + logUser.getuser_name());
        }
        
        return logUser;
    }
 
    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
    	System.out.println("Write id for " + requestUri);
        Integer id = uri_id_map.get(requestUri);
        if (id == null) {
            id = REDIRECT_ID++;
 
            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }
 
        return id;
    }
 
    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = id_uri_map.get(redirectId);
        if (url != null) {
        	System.out.println("getRedirectAfterLoginUrl return: - " + url);
            return url;
        }
        System.out.println("getRedirectAfterLoginUrl return null");
        return null;
    }
 
}