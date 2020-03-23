package src.webboard.tabl;


public class Notices {
 
   private Integer notices_id;
   private String user_name;
   private String notices_date;
   private String content;
   private String roles;
 
   public Notices() {
 
   }
 
   public Notices(Integer notices_id, String user_name, String notices_date,  String content, String roles) {
	   this.notices_id = notices_id;
	   this.user_name = user_name;
	   this.notices_date = notices_date;
	   this.content = content;
       this.roles = roles;
   }
 
   public Integer getnotices_id() {
       return notices_id;
   }
 
   public void setnotices_id(Integer notices_id) {
       this.notices_id = notices_id;
   }
   
   
   public String getuser_name() {
       return user_name;
   }
 
   public void setuser_name(String user_name) {
       this.user_name = user_name;
   }
   
   public String getnotices_date() {
       return notices_date;
   }
 
   public void setnotices_date(String notices_date) {
       this.notices_date = notices_date;
   }
 
   public String getcontent() {
       return content;
   }
 
   public void setcontent(String content) {
       this.content = content;
   }
 
   public String getroles() {
       return roles;
   }
 
   public void setroles(String roles) {
       this.roles = roles;
   }
 
}