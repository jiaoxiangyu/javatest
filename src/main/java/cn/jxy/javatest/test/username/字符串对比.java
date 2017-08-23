package cn.jxy.javatest.test.username;


import java.util.Date;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class 字符串对比 {
	 public static void main(String[] args) {  
		
	        Scanner scanner = new Scanner(System.in);  
	  
	        while (scanner.hasNext()) {  
	            String s1 = scanner.nextLine();  
	            String s2 = scanner.nextLine();  
	  
	            int result;  
	            if (s1.length() != s2.length()) {  
	                result = 1;  
	            } else {  
	                if (s1.equals(s2)) {  
	                    result = 2;  
	                } else if (s1.toLowerCase().equals(s2.toLowerCase())) {  
	                    result = 3;  
	                } else {  
	                    result = 4;  
	                }  
	            }  
	  
	            System.out.println(result);  
	          
	        } 
	       
	    }  
}
