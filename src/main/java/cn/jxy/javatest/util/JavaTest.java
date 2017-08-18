package cn.jxy.javatest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import cn.jxy.javatest.entity.TestDetails;


/**
 * @author: 焦
 * @date:   createDate：2017年8月12日 下午4:33:42   
 * @Description:运行要测试程序，并测试程序的正确性 
 * 
 */
public class JavaTest {
	private Class clazz;//测试文件的class
	private String name;//测试题目名称
	private String rootPath;//项目根目录绝对路径
	private String testFilePath;//webapp的绝对路径
	private String username;//用户名
	
	public JavaTest() {
		super();
	}

	public JavaTest(Class clazz,String rootPath,String username) {
		super();
		this.clazz = clazz;
		this.rootPath=rootPath;
		this.testFilePath=rootPath+"\\src\\main\\webapp\\uploadFile\\testFile\\";		
		this.username=username;
		name=clazz.getSimpleName();		
	}

	
	//读取测试输入内容
	public void input(int i) throws IOException{	
		System.out.println("开始输入测试数据");
		char[] c=new char[1024];
		FileReader fr=new FileReader(testFilePath+name+"-"+"input"+"-"+i+".txt");
		int len=fr.read(c);	
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.println("输入测试数据："+new String(c,0,len));
		bw.write(c,0,len);			
	}
	
	//读取测试答案
	public String output(int i) throws IOException{
		char[] c=new char[1024];
		FileReader fr=new FileReader(testFilePath+name+"-"+"output"+"-"+i+".txt");
		int len=fr.read(c);		
		return new String(c,0,len);
	}
	
	//读取用户输出答案
	public String reader() throws IOException{
		char[] c=new char[1024];
		
		FileReader fr=new FileReader(rootPath+"\\src\\main\\java\\cn\\jxy\\javatest\\test\\"+username+"\\myanswer.txt");
		int len=fr.read(c);		
		return new String(c,0,len);
	}
	
	//运行要测试的java文件
	@SuppressWarnings("unchecked")
	public void run() throws Exception{
		Method m1 = clazz.getMethod("main", String[].class);
		m1.invoke(null,(Object) new String[] { } );
	}
	
	/**
	 * 查询该题测试数据有多少条
	 */
	public int countTestNum(){
		int count =0;
		File file=new File(testFilePath);
		String[] filesName=file.list();
		for(String s:filesName){
			if(s.contains(name)){
				count++;
			}
		}
		return count;
	}
	/**
	 * 比对测试答案和用户输出答案
	 * @param testDetails
	 * @return	List<TestDetails>
	 * @throws Exception
	 */
	public List<TestDetails> compare(List<TestDetails> testDetailss) throws Exception{
		int count=countTestNum()/2;
		for(int i=1;i<=count;i++){
			File f=new File(testFilePath+name+"-"+"input"+"-"+i+".txt");			
			if(f.exists()){
				TestDetails testDetails=new TestDetails();
				testDetails.setOrderId(i);
				//标准输入重定向
				FileInputStream fin=new FileInputStream(testFilePath+name+"-"+"input"+"-"+i+".txt");
				System.setIn(fin);
				//标准输出重定向
				File file=new File(rootPath+"\\src\\main\\java\\cn\\jxy\\javatest\\test\\"+username+"\\myanswer.txt");
				PrintStream fout=new PrintStream(file);
				PrintStream out = System.out;				
				System.setOut(fout);
				
				Long startTime=new Date().getTime();
				Long memory=Runtime.getRuntime().freeMemory() / 1024 / 1024;
				run();
				
				//*******************
				fout.flush();
				fin.close();
				fout.close();							
				System.setOut(out);
				//**时间和内存
				System.out.println("time="+(new Date().getTime()-startTime));
				testDetails.setTime((new Long(new Date().getTime()-startTime)).intValue());				
				System.out.println("memory="+(memory-Runtime.getRuntime().freeMemory() / 1024 / 1024)+ "M");
				testDetails.setMemory((new Long(memory-Runtime.getRuntime().freeMemory() / 1024 / 1024)).intValue());
				
								
						
				String answer1=reader();
				String answer2=output(i);
				answer1=answer1.substring(0, answer1.length()-2);
				answer2=answer2.substring(0, answer2.length()-1);	
				System.out.println("a1="+answer1);
				System.out.println("a2="+answer2);
				if(answer1.equals(answer2)){
					testDetails.setResult("正确");
					testDetails.setScore(100/count);
					System.out.println("第"+i+"次测试正确");
				}else{
					testDetails.setResult("错误");
					testDetails.setScore(0);
					System.out.println("第"+i+"次测试正确答案："+answer2);
					
				}
				//System.gc();
				testDetailss.add(testDetails);
			}else{
				break;
			}			
		}		
		return testDetailss;
	
	}
	
	/**
	 * test
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		/*List<TestDetails> testDetails=new ArrayList<TestDetails>();
 		JavaTest t=new JavaTest(Class.forName("cn.jxy.javatest.test.user.字符串对比"), "G:\\workspace\\javatest","user");
 		System.out.println(t.compare(testDetails));
 		*/
 		
 		
	}
}
