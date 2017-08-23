package cn.jxy.javatest.controller.front;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import cn.jxy.javatest.base.BaseController;
import cn.jxy.javatest.entity.Question;
import cn.jxy.javatest.entity.Race;
import cn.jxy.javatest.entity.RaceDetails;
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
	 * 首页
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(ModelMap model,HttpSession session){
		
		return "front/index";
	}
	
	/**
	 * 试题集 -- 获得所有试题集
	 * @param model
	 * @param session
	 * @return front index.jsp (include questionType)
	 */
	@RequestMapping(value="/questionType",method=RequestMethod.GET)
	public String toQuestionType(ModelMap model,HttpSession session){
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
	public String toType(ModelMap model,HttpSession session,int typeId){
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
	public String toQuestion(HttpSession session,ModelMap model,int qtId,@RequestParam(value="raceId",defaultValue="0")int raceId){
		if(raceId!=0){			
			session.setAttribute("raceId", raceId);
		}
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
		int raceId=(int)session.getAttribute("raceId");
		if(raceId!=0){
			Race race=raceService.get(raceId);
			response.setRaceId(raceId);
			response.setRaceName(race.getName());
		}
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
		fout.write("package cn.jxy.javatest.test."+user.getUsername()+";"+"\r\n");
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
 		
 		if(result!=0){	
 			//删除生成的错误java文件
 			if(javaFile.exists()){
 				javaFile.delete();
 			}
 			
 			//读取错误想信息 
 	 		char[] c=new char[1024];			
 			FileReader fr=new FileReader(file);
 			int len=fr.read(c);	
 			fr.close();
 			
 			if(len!=-1){
 				String err= new String(c,0,len);	
 				response.setScore(0);
 				response.setStatus("编译错误");
 				response.setAnswer(answer);
 				response.setErr(err);
 				responseService.update(response);
 												
 				model.addAttribute("response", response);
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
		response.setAnswer(answer);
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
	public String submitHistory(HttpSession session,ModelMap model,int qtId,@RequestParam(value="raceId",defaultValue="0")int raceId){
		User user=(User)session.getAttribute("user");
		List<Response> responses=null;
		if(raceId!=0){
			responses=responseService.getAllByUserRaceQt(user.getId(), raceId, qtId);
		}else{
			responses=responseService.getByUserIdAndQtId(user.getId(), qtId);
		}		
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
	/**
	 * java在线工具  暂时屏蔽
	 * @return
	 */
	/*@RequestMapping(value="/compile",method=RequestMethod.GET)
	public String compile(){
		return "front/compile";
	}*/
	
	/**
	 * 算法竞赛
	 * @param model
	 * @return front/race.jsp
	 */
	@RequestMapping(value="/race",method=RequestMethod.GET)
	public String race(ModelMap model,HttpSession session){
		int userId=((User)session.getAttribute("user")).getId();
		
		List<Race> races=raceService.getPage(0, 0).getData();
		int score;
		for(Race r:races){
			score=0;
			Date startDate=DateSwitch.StrToDateTime(r.getStartDate());
			Date endDate=DateSwitch.StrToDateTime(r.getEndDate());
			if(startDate.after(new Date())){
				r.setJoin("未开始");
			}else if(endDate.after(new Date())){
				r.setJoin("竞赛中");
			}else{
				List<Response> responsess=responseService.getByUserIdAndRaceId(userId, r.getId());
				if(responsess.size()>0){
					for(Response res:responsess){
						score=score+res.getScore();
					}
					r.setJoin("已参加");
				}else{
					r.setJoin("未参加");
				}
				r.setScore(score);
			}		
		}
		model.addAttribute("races",races);
		return "front/race";
	}
	
	/**
	 * 竞赛详情
	 * @param session
	 * @param model
	 * @param raceId
	 * @return front/raceDetails.jsp
	 */
	@RequestMapping(value="/raceDetails",method=RequestMethod.GET)
	public String raceDetails(HttpSession session,ModelMap model,int raceId){
		int userId=((User)session.getAttribute("user")).getId();
		List<RaceDetails> raceDetailss=raceDetailsService.getByRaceId(raceId);
		if(raceDetailss.size()>0){
			for(RaceDetails r:raceDetailss){
				Response res=responseService.getByUserRaceQt(userId, raceId, r.getQtId());
				r.setStatus(res.getStatus());
				r.setScore(res.getScore());
				r.setWriteTime(res.getWriteDate());
			}
			model.addAttribute("raceDetailss",raceDetailss);			
		}else{
			model.addAttribute("msg","该竞赛内容为空");
		}		
		return "front/raceDetails";
	}
	
	/**
	 * 用户个人信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public String getUser(HttpSession session,ModelMap model){		
		return "front/getUser";
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(HttpSession session,User user,ModelMap model) throws Exception{	
		int userId=((User)session.getAttribute("user")).getId();
		user.setId(userId);
		String name=new String(user.getName().getBytes("ISO-8859-1"),"UTF-8");
		user.setName(name);
		boolean bool=userService.update(user);
		if(bool==true){
			user=userService.get(userId);			
			model.addAttribute("user",user);
			model.addAttribute("msg","修改成功");
		}else{
			model.addAttribute("msg","修改失败");
		}
		return "front/getUser";
	}
	
	
}
