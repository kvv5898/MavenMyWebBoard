package src.webboard.servlet.other;



import java.text.SimpleDateFormat;
import java.util.Date;


public class date_time {
	
	public static String date () {
     
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date dateN = new Date();  
        String us_Date = format.format(dateN);
//        System.out.println("date_time: " + us_Date);
	return us_Date;
}
}