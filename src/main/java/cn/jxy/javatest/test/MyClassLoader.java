package cn.jxy.javatest.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author: 焦
 * @date:   createDate：2017年8月24日 上午10:00:42   
 * @Description: 
 * 
 */
public class MyClassLoader extends ClassLoader {
	
	
	@Override  
	protected  Class<?> findClass(String classPath) {  
		  Class<?> clazz0 = findLoadedClass("Main");
		  if(clazz0==null){
			  Path path=null;
			 	byte[] cLassBytes = null ;
				try {			
					String classUrl="E:\\java\\Main.class";
					File file=new File(classUrl);
					path = Paths.get(file.toURI());
					cLassBytes =  Files.readAllBytes(path);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		        Class<?> cLazz = defineClass(null,cLassBytes, 0, cLassBytes.length);  
		        return cLazz; 
		  }
		  return clazz0; 	 	    
	}  
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz=Class.forName("Main", true, new MyClassLoader());
		
	}
	 
}
