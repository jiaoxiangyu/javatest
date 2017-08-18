package cn.jxy.javatest.service;

import java.util.List;

import cn.jxy.javatest.entity.TestDetails;
import cn.jxy.javatest.entity.User;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月10日 下午4:21:56   
 * @Description: 
 * 
 */
public interface ITestDetailsService {

	public boolean add(TestDetails testDetails);
	
	public boolean delete(TestDetails testDetails);
	
	public boolean update(TestDetails testDetails);
	
	public TestDetails get(int id);
	
	public PageCut<TestDetails> getPage(int pageSize,int page,Object ...objects);
	
	//根据resId查询
	public List<TestDetails> getByRseId(int resId);
}
