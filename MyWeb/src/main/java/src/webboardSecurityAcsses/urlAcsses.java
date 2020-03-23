package src.webboardSecurityAcsses;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
public class urlAcsses {
 
    public static final String ROLE_Admin = "Admin";
    public static final String ROLE_User = "User";
 
    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
 
    static {
        init();
    }
 
    private static void init() {
 
        List<String> urlPatterns1 = new ArrayList<String>();
 
//        urlPatterns1.add("/home");
        urlPatterns1.add("/user");
        urlPatterns1.add("/login");
        urlPatterns1.add("/notices");
        urlPatterns1.add("/createNotices");
        urlPatterns1.add("/editNotices");
 
        mapConfig.put(ROLE_User, urlPatterns1);
 
        List<String> urlPatterns2 = new ArrayList<String>();
 
//        urlPatterns2.add("/home");
        urlPatterns2.add("/user");
        urlPatterns2.add("/login");
//        urlPatterns2.add("/adduser");
        urlPatterns2.add("/userdel");
        urlPatterns2.add("/edituser");
        urlPatterns2.add("/notices");
        urlPatterns2.add("/createNotices");
        urlPatterns2.add("/editNotices");


 
        mapConfig.put(ROLE_Admin, urlPatterns2);
    }
 
    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }
 
    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
 
}