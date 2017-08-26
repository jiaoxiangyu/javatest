package cn.jxy.javatest.util;

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
	
	protected String rootPath;
	protected String username;
	
	
	public MyClassLoader() {
		super();
	}
	
	public MyClassLoader(String rootPath,String username){
		this.rootPath=rootPath;
		this.username=username;
	}
	
	@Override  
	protected  Class<?> findClass(String classPath) {  
		 
		 	Path path=null;
		 	byte[] cLassBytes = null ;
			try {
				// "G:\\workspace\\javatest\\src\\main\\webapp\\uploadFile\\JavaFile\\username\\Mian.class";
				String strUrl=rootPath+StringUtil.generateUri("uploadFile","JavaFile",username)
						+"Main.class";
				File file=new File(strUrl);
				path = Paths.get(file.toURI());
				cLassBytes =  Files.readAllBytes(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 		  
	        
	     
	          
	       
	        Class<?> cLazz = defineClass(null,cLassBytes, 0, cLassBytes.length);  
	        return cLazz;  
	    
	}  	
	 public static void main(String[] args) throws ClassNotFoundException {
		 //Class<?> clazz=Class.forName("Main", true, new MyClassLoader("username"));  
		//System.out.println(clazz.getName());
	}
}
