package src.webboard.tabl;


import java.util.ArrayList;
import java.util.List;

public class User_account {

	   private Integer user_id;
	   private String user_name;
	   private String email;
	   private String password;
	   private String us_Date;
	   
	   private List<String> roles;
	    
	 
	   public User_account(Integer user_id, String user_name, String email, String password, String us_Date, String[] roles) {
		   this.user_id = user_id;
		   this.user_name = user_name;
		   this.email = email;
	       this.password = password;
	       this.us_Date = us_Date;
	       
	       this.roles = new ArrayList<String>();
	       if (roles != null) {
	          for (String r : roles) {
	             this.roles.add(r);
	          }
	       }
	   }
	    
	   public User_account() {
		// TODO Auto-generated constructor stub
	}

	public Integer getuser_id() {
	       return user_id;
	   }
	 
	   public void setuser_id(Integer user_id) {
	       this.user_id = user_id;
	   }
	 
	   public String getuser_name() {
	       return user_name;
	   }
	 
	   public void setuser_name(String user_name) {
	       this.user_name = user_name;
	   }
	 
	   
	   public String getemail() {
	       return email;
	   }
	 
	   public void setemail(String email) {
	       this.email = email;
	   }
	   
	   
	   public String getpassword() {
	       return password;
	   }
	 
	   public void setpassword(String password) {
	       this.password = password;
	   }
	   public String getus_Date() {
	       return us_Date;
	   }
	 
	   public void setus_Date(String us_Date) {
	       this.us_Date = us_Date;
	   }
	   
	   public List<String> getroles() {
		      return roles;
		   }
		 
		   public void setroles(List<String> roles) {
		      this.roles = roles;
		   }
	   
}
