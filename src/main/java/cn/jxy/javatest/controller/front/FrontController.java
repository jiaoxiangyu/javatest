package cn.jxy.javatest.controller.front;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jxy.javatest.base.BaseController;
import cn.jxy.javatest.entity.Question;
import cn.jxy.javatest.entity.Response;
import cn.jxy.javatest.entity.TestDetails;
import cn.jxy.javatest.entity.Type;
import cn.jxy.javatest.entity.User;
import cn.jxy.javatest.util.DateSwitch;
import cn.jxy.javatest.util.JavaTest;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 下午4:57:54   
 * @Description: 
 * 
 */
@Controller
@RequestMapping("/front")
public class FrontController extends BaseController{
	/**
	 * 首页 -- 获得所有试题集
	 * @param model
	 * @param session
	 * @return front index.jsp (include questionType)
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(ModelMap model,HttpSession session){
		User user=(User)session.getAttribute("user");
		//获得试题集
		PageCut<Type> p=typeService.getPage(0, 0);
		if(p!=null){
			List<Type> types=p.getData();
			for(Type t:types){
				//总题数
				int qtNum=questionService.getNumByTypeId(t.getId());
				t.setQtNum(qtNum);
				//已解决题数
				int solvedNum =responseService.countNum(user.getId(), t.getId());
				t.setSolvedNum(solvedNum);
			}
			model.addAttribute("types", types);
		}else{
			model.addAttribute("msg", "无试题集");
		}
		
		return "front/questionType";
	}
	/**
	 * 进入试题集
	 * @param model
	 * @param session
	 * @return front/toType.jsp
	 */
	@RequestMapping(value="/toType",method=RequestMethod.GET)
	public String toTye(ModelMap model,HttpSession session,int typeId){
		int userId=((User)session.getAttribute("user")).getId();
		PageCut<Question> p=questionService.getPage(0, 0, typeId);
		if(p!=null){
			List<Question> questions=p.getData();
			for(Question q:questions){
				Response response=responseService.getByUserIdAndQtIdForNew(userId, q.getId());
				if(response!=null){
					q.setStatus(response.getStatus());
				}else{
					q.setStatus("未打开");
				}
			}
			model.addAttribute("questions", questions);
		}else{
			model.addAttribute("msg", "该试题集无试题");
		}				
		return "front/type";
	}
	
	/**
	 * 进入试题
	 * @param model
	 * @param session
	 * @param typeId
	 * @return front/toQuestion.jsp
	 */
	@RequestMapping(value="/toQuestion",method=RequestMethod.GET)
	public String toQuestion(ModelMap model,int qtId){
		Question question=questionService.get(qtId);
		model.addAttribute("question", question);
		return "front/question";
	}	
	
	/**
	 * 提交试题   进行测试
	 * @param model
	 * @param qtId
	 * @return front/toTestDatails.jsp
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(value="/toSubmit",method=RequestMethod.POST)
	public String toSubmit(HttpServletRequest request,HttpSession session,ModelMap model,int qtId,String answer)
	throws Exception{
		Question question=questionService.get(qtId);
		User user=(User)session.getAttribute("user");
		/**
		 * 生成Response类,并先存入数据库
		 */
		Response response=new Response(question.getId(), question.getName(), user.getId(), user.getUsername(), question.getTypeId(), question.getType(), "已打开", new DateSwitch().toString());
		boolean resadd=responseService.add(response);
		if(resadd==true){
			response=responseService.getForResId(user.getId(), question.getId());
		}else{
			model.addAttribute("msg","提交失败");
			return "front/qusetion";
		}
		/**
		 * 先创建要测试程序的java文件
		 */
		answer=new String(answer.getBytes("ISO-8859-1"),"UTF-8");
		String rootpath=request.getSession().getServletContext().getRealPath("/");
		rootpath=rootpath.substring(0,rootpath.length()-17);
		
		//java文件存放路径
		File folder=new File(rootpath+"\\src\\main\\java\\cn\\jxy\\javatest\\test\\"+user.getUsername());
		if(!folder.exists()){
			folder.mkdir();
		}
	
		//生成java文件
		File javaFile=new File(folder.getPath()+"\\"+question.getName()+".java"); 		
		FileWriter fout=new FileWriter(javaFile);
		fout.write("package cn.jxy.javatest.test."+user.getUsername()+";");
		fout.write(answer);
 		fout.close();
 		
 		/**
 		 *  把java文件编译为class文件			 		
 		 */
 		//标准错误输出重定向,把编译class的错误信息输入到文件		
		File file=new File(rootpath+"\\src\\main\\java\\cn\\jxy\\javatest\\test\\"+user.getUsername()+"\\err.txt");
		PrintStream foutErr=new PrintStream(file);
		PrintStream errOut = System.err;
		System.setErr(foutErr);
				
		//java文件编译为class文件
 		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
 		/*int result = javaCompiler.run(null, null, null, "-d", classPath, javaFile.getPath());*/		
 		int result=javaCompiler.run(null, null, null, javaFile.getPath()); 
 		
 		//关闭错误输出流和重定向错误输出为标准错误输出
 		foutErr.close();
 		System.setErr(errOut);
 		
 		if(result!=0){//读取错误想 信息 			
 	 		char[] c=new char[1024];			
 			FileReader fr=new FileReader(file);
 			int len=fr.read(c);	
 			fr.close();
 			
 			if(len!=-1){
 				String err= new String(c,0,len);	
 				response.setScore(0);
 				response.setStatus("编译错误");
 				response.setAnswer(answer);
 				responseService.update(response);
 												
 				model.addAttribute("response", response);
 				model.addAttribute("err", err);
 				return "front/testDetails";
 			}
 		}	
 		
 		/**
 		 * 开始运行测试程序进行测试
 		 */
 		List<TestDetails> testDetailss=new ArrayList<TestDetails>();
 		JavaTest t=new JavaTest(Class.forName("cn.jxy.javatest.test."+user.getUsername()+"."+question.getName()), rootpath,user.getUsername());
 		testDetailss= t.compare(testDetailss);
 		/**
 		 * 处理测试结果
 		 */
 		int score=0;
 		for(TestDetails ts:testDetailss){
 			ts.toInitialize(response.getId(), question.getId(), question.getName(), user.getId(), user.getUsername());
 			testDetailsService.add(ts);
 			score=score+ts.getScore();
 		}
		response.setScore(score);
		if(score>95){
			response.setStatus("正确");
		}else{
			response.setStatus("错误");
		}
		responseService.update(response);
		model.addAttribute("response", response);
		model.addAttribute("testDetailss", testDetailss);
		return "front/testDetails";
	}
	
	/**
	 * 获得该题的提交记录
	 * @param session
	 * @param model
	 * @param qtId
	 * @return front/testHistory.jsp
	 */
	@RequestMapping(value="/submitHistory",method=RequestMethod.GET)
	public String submitHistory(HttpSession session,ModelMap model,int qtId){
		User user=(User)session.getAttribute("user");
		List<Response> responses=responseService.getByUserIdAndQtId(user.getId(), qtId);
		model.addAttribute("responses", responses);
		return "front/testHistory";
	}
	
	/**
	 * 测评状态  -- 即回答记录
	 * @param model
	 * @param session
	 * @return front/testHistory.jsp
	 */
	@RequestMapping(value="/toTestHistory",method=RequestMethod.GET)
	public String toTestHistory(ModelMap model,HttpSession session){
		User user=(User)session.getAttribute("user");
		List<Response> responses=responseService.getByUserId(user.getId());
		model.addAttribute("responses", responses);
		return "front/testHistory";
	}
	
	/**
	 * 测试详情
	 * @param model
	 * @param session
	 * @return front/testDetails.jsp
	 */
	@RequestMapping(value="/toDetails",method=RequestMethod.GET)
	public String toDetails(ModelMap model,int resId){
		Response response=responseService.get(resId);
		List<TestDetails> testDetailss=testDetailsService.getByRseId(resId);
		model.addAttribute("response",response);
		model.addAttribute("testDetailss",testDetailss);
		return "front/testDetails";
	}
	
	/**
	 * 下载测试数据
	 * @param request
	 * @param model
	 * @param temp
	 * @param qtId
	 * @param orderId
	 * @return front/testDetails.jsp
	 */
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public void download(HttpServletRequest request,HttpServletResponse response,ModelMap model,String temp,int qtId,int orderId)
	throws Exception{
		Question question=questionService.get(qtId);		
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		String filePath="";
		if(temp.equals("in")){
			filePath=rootPath+"uploadFile\\testFile\\"+question.getName()+"-input-"+orderId+".txt";
		}else if(temp.equals("out")){
			filePath=rootPath+"uploadFile\\testFile\\"+question.getName()+"-output-"+orderId+".txt";
		}
		File file=new File(filePath);
		FileReader fReader=new FileReader(file);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filePath.substring(filePath.indexOf("testFile")+9), "UTF-8"));
		OutputStream out = response.getOutputStream(); 
		int b;
		while((b=fReader.read())!=-1){
			out.write(b);
		}
		fReader.close();
		out.close();		
	}
}
