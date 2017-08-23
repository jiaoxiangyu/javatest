package cn.jxy.javatest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.chainsaw.Main;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 下午10:37:55   
 * @Description: 
 * 
 */
public class DateSwitch extends Date{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  
	    * 字符串转换成日期  
	    * @param str  
	    * @return date  
	    */  
	    public static Date StrToDate(String str) {  
	        
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       Date date = null;  
	       try {  
	        date = format.parse(str);  
	       } catch (ParseException e) {  
	        e.printStackTrace();  
	       }  
	       return date;  
	    }  
	    
	    /**  
	     * 字符串转换成日期和时间 
	     * @param str  
	     * @return date  
	     */  
	     public static Date StrToDateTime(String str) {  
	         
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	        Date date = null;  
	        try {  
	         date = format.parse(str);  
	        } catch (ParseException e) {  
	         e.printStackTrace();  
	        }  
	        return date;  
	     }
	     
	     /**Fri Aug 11 00:00:00 CST 2017 转 2017-08-11
	      * 
	      * @return date
	      */
	     public static Date dateToDate(Date date) {	    	  
	    	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    	   String dateString = formatter.format(date);
	    	   System.out.println(dateString);	    	 
	    	   Date date_2=null;
				try {
					date_2 = formatter.parse(dateString);
				} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	    	   return date_2;
	    }
	    @Override
	    public String toString() {
	    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	    	 
	    	return formatter.format(this);
	    }
	     /**
	      * test
	      * @param args
	      */
	    /**
		 * 
		 */
		/*public static void main(String[] args) {
			System.out.println(new Date());
			System.out.println(new DateSwitch().toString());
		}*/
			
		
	     
}
