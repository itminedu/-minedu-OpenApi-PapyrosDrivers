package gr.modus.papyros.protocol.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DateUtils {
	
	public  String formatDate(Date date){
    	String output = null;
    	if(date!=null){
	    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    	output = df.format(date);	
    	}
    	return output;
    }
	
	public  String formatDateTime(Date date){
    	String output = null;
    	if(date!=null){
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	output = df.format(date);	
    	}
    	return output;
    }
	public  String formatTimestamp(Date date){
		String output = null;
    	if(date!=null){
    		
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	    	output = df.format(date);	
    	}
    	return output;
    }
	
	public  Date convertStr2Date(String date) throws ParseException{
    	Date output = null;
    	if(date!=null){
    		date=date.replace("/", "-");//Αντιμετώπηση προβλήματος με format.
	    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    	output = df.parse(date);	
    	}
    	return output;
    }
	
	public  Date convertStr2DateTime(String date) throws ParseException{
    	Date output = null;
    	if(date!=null){
    		date=date.replace("/", "-");//Αντιμετώπηση προβλήματος με format.
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	output = df.parse(date);	
    	}
    	return output;
    }
	public  Date convertStr2Timestamp(String date) throws ParseException{
    	Date output = null;
    	if(date!=null){
    		//replace / with -
    		date=date.replace("/", "-");//Αντιμετώπηση προβλήματος με format.
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	    	output = df.parse(date);	
    	}
    	return output;
    }

}
