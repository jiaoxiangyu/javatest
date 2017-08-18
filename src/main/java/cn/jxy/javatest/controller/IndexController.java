package cn.jxy.javatest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jxy.javatest.base.BaseController;
import cn.jxy.javatest.entity.User;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 上午8:39:57   
 * @Description: 
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController{	
	/**
	 *
	 * @return jsp/index.jsp
	 */
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(){
		
		return "index";
	}
	
	/**
	 * @return login result
	 * @param username,password
	 * 
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpSession session,ModelMap model){
		
		user.setUsername("user");
		user.setPassword("user");
		
		user=userService.login(user);
		System.out.println(user);
		if(user!=null){
			if(user.getType().equals("user")){
				session.setAttribute("user", user);				
				return "redirect:/front/index";
			}else if(user.getType().equals("admin")){
				session.setAttribute("admin", user);				
				return "redirect:back/index";
			}else{
				model.addAttribute("msg","用户名或密码错误");
				return "index";
			}			
		}else{		
			model.addAttribute("msg","用户名或密码错误");
			return "index";
		}
		
		
	}
}
