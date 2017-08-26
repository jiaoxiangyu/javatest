package cn.jxy.javatest.util;

import java.io.File;

/**
 * @author: 焦
 * @date:   createDate：2017年8月23日 上午11:16:12   
 * @Description: 字符串工具类
 * 
 */
public class StringUtil {
	
	public static String separator=File.separator;//当前系统文件夹分隔符
	
	public static String generateUri(String... strings){
		StringBuilder uri=new StringBuilder();
		for(int i=0;i<strings.length;i++){
			if(strings[i]!="" && strings[i]!=null){
				uri.append(strings[i]+separator);
			}
		}
		return uri.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.generateUri("src","java","main"));
	}
}
