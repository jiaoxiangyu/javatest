package cn.jxy.javatest.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;

import cn.jxy.javatest.service.IQuestionService;
import cn.jxy.javatest.service.IResponseService;
import cn.jxy.javatest.service.ITestDetailsService;
import cn.jxy.javatest.service.ITypeService;
import cn.jxy.javatest.service.IUserService;

/**
 * @author: 焦
 * @date:   createDate：2017年8月10日 下午4:11:37   
 * @Description: 
 * 
 */
public class BaseController {
	
	
	@Resource
	protected IQuestionService questionService;
	
	@Resource
	protected IResponseService responseService;
	
	@Resource
	protected ITestDetailsService testDetailsService;
	
	@Resource 
	protected ITypeService typeService;
	
	@Resource 
	protected IUserService userService;
	
}
