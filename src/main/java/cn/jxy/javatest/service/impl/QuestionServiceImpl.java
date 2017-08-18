package cn.jxy.javatest.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.QuestionMapper;
import cn.jxy.javatest.entity.Question;
import cn.jxy.javatest.service.IQuestionService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 上午8:30:49   
 * @Description: 
 * 
 */
@Service("questionService")
public class QuestionServiceImpl extends BaseDao<Question, Serializable> implements IQuestionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private QuestionMapper questionDao;

	@Override
	public boolean add(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Question get(int  id) {
		return this.selectOneEntity(id);
	}

	@Override
	public PageCut<Question> getPage(int pageSize, int page, Object... objects) {
		PageCut<Question> p=new PageCut<Question>();
		if(pageSize==0 && page==0 && objects.length==0){//查询所有				
			p.setData(this.selectAllEntity());					
		}else if(pageSize==0 && page==0 && objects.length!=0){//条件查询所有			
			p.setData(questionDao.selectByTypeId((int)objects[0]));			
		}else if(pageSize!=0 && page==0 && objects.length==0){//随机查询一定数量的数据
			return null;
		}else if(pageSize!=0 && page!=0 && objects.length==0){//无条件分页查询
			return null;
		}else if(pageSize!=0 && page!=0 && objects.length!=0){//条件分页查询
			return null;
		}else{
			return null;
		}
		return p;
	}

	@Override
	public int getNumByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return questionDao.getNumByTypeId(typeId);
	}

}
