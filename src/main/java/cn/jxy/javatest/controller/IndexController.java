package cn.jxy.javatest.controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jxy.javatest.base.BaseController;
import cn.jxy.javatest.entity.User;
import cn.jxy.javatest.util.CheckCode;
import cn.jxy.javatest.util.DateSwitch;
import cn.jxy.javatest.util.SendEmail;

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
	 *进入登录页面
	 * @return jsp/index.jsp
	 * @throws Exception 
	 */
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(HttpServletRequest request){	
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null && cookies.length>0){
			for(Cookie c:cookies){
				if(c.getName().equals("username")){
					request.setAttribute("username", c.getValue());
				}
				else if(c.getName().equals("password")){
					request.setAttribute("password", c.getValue());
				}
			}			
		}
		return "index";
	}
	
	/**
	 * 获得验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/code",method=RequestMethod.GET)
	public void code(HttpServletRequest request,HttpServletResponse response) throws Exception{		
			new CheckCode().post(request, response);
		
	}
	
	/**登录
	 * @return login result
	 * @param username,password
	 * 
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,String code,String remember,HttpServletResponse response,HttpSession session,ModelMap model){
		String checkcCode=(String)session.getAttribute("checkcode");
		if(checkcCode.equals(code)){
			/*user.setUsername("12345678910");
			user.setPassword("password");*/
			
			user.setPhone(user.getUsername());
			user=userService.login(user);
			System.out.println(user);
			if(user!=null){
				//记住密码
				if(remember!=null && remember.equals("on")){
					Cookie username=new Cookie("username",user.getUsername());
					Cookie password=new Cookie("password",user.getPassword());
					// 设置cookie过期时间为24小时。
					username.setMaxAge(60*60*24); 
					password.setMaxAge(60*60*24); 

				    // 在响应头部添加cookie
				    response.addCookie(username);
				    response.addCookie(password);
				}
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
		}else{
			model.addAttribute("msg","验证码错误");
			return "index";
		}
		

	}
	
	/**
	 * 注销登录
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpSession session,ModelMap model){
		User user=(User)session.getAttribute("user");
		User admin=(User)session.getAttribute("admin");
		if(user!=null){
			session.removeAttribute("user");
		}else if(admin!=null){
			session.removeAttribute("admin");
		}
		
		session.invalidate();
		
		//删除cookie
		Cookie[] cookies=request.getCookies();
		
		if(cookies.length>0){
			for(Cookie c:cookies){
				if(c.getName().equals("username")){
					c.setMaxAge(0);
				}
				else if(c.getName().equals("password")){
					c.setMaxAge(0);
				}
			}			
		}
		return "redirect:/index/toIndex";
	}
	
	/**
	 * 注册
	 * @param user
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user,HttpSession session,ModelMap model) throws Exception{
		User tb_user=userService.check(user.getUsername());
		if(tb_user!=null){
			model.addAttribute("msg","该用户名已存在");
		}else{
			
			String name=new String(user.getName().getBytes("ISO-8859-1"),"UTF-8");
			user.setName(name);
			user.setCreateDate(new DateSwitch().toString());
			user.setRegister(1);
			user.setType("user");
			String pswd=getStringRandom(6);
			user.setPassword(pswd);
			boolean bool=userService.add(user);
			if(bool==true){
				//发邮箱
				try{
					String content=user.getUsername()+"用户你好！ 欢迎使用Java算法练习系统，你已注册成功。用户名是"+user.getUsername()+"，密码是"+user.getPassword();
					new SendEmail(user,"注册成功通知",content).send();
				}catch (Exception e) {
					userService.deleteUser(user);
					model.addAttribute("msg","注册失败,邮箱错误");
					return "index";
				}
								
				model.addAttribute("msg","注册成功,请查看邮箱");
			}else{
				
			}
		}
	
		return "index";
	}
	
	/**
	 * 忘记密码
	 * @param request
	 * @param session
	 * @param model
	 * @return forget.jsp
	 */
	@RequestMapping(value="/forget",method=RequestMethod.GET)
	public String forget(HttpServletRequest request,HttpSession session,ModelMap model){
		
		return "forget";
	}
	
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public String find(User user,String by,String code,HttpSession session,ModelMap model) throws Exception{
		String checkcCode=(String)session.getAttribute("checkcode");		
		if(checkcCode.equals(code)){
			if(by.equals("email")){
				if(user.getUsername()!=null){
					String email=user.getEmail();
					user=userService.check(user.getUsername());
					if(email.equals(user.getEmail())){
						String content=user.getUsername()+"用户你好！ 欢迎使用Java算法练习系统，你的密码已成功找回。用户名是"+user.getUsername()+"，密码是"+user.getPassword();
						new SendEmail(user,"密码找回通知",content).send();
						model.addAttribute("msg","成功找回，请查看邮箱");
					}else{
						model.addAttribute("msg","邮箱错误");
					}
				}
			}else if(by.equals("phone")){
				model.addAttribute("msg","手机号找回功能暂时关闭");
			}
		}else{
			model.addAttribute("msg","验证码错误");
		}
		
		
		return "forget";
	}
	
	
	//生成随机数字和字母,  
    public String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  
}
