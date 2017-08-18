package cn.jxy.javatest.service;

import cn.jxy.javatest.entity.Question;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月10日 下午4:16:37   
 * @Description: 
 * 
 */
public interface IQuestionService {
	
	public boolean add(Question question);
	
	public boolean delete(Question question);
	
	public boolean update(Question question);
	
	public Question get(int  id);
	
	public PageCut<Question> getPage(int pageSize,int page,Object ...objects);
	
	//获得一试题集题数
	public int getNumByTypeId(int typeId);
	
}
