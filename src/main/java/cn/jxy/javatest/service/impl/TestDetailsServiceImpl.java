package cn.jxy.javatest.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.TestDetailsMapper;
import cn.jxy.javatest.entity.TestDetails;
import cn.jxy.javatest.service.ITestDetailsService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 上午8:32:34   
 * @Description: 
 * 
 */
@Service("testDetailsService")
public class TestDetailsServiceImpl extends BaseDao<TestDetails, Serializable> implements ITestDetailsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private TestDetailsMapper testDetailsDao;

	@Override
	public boolean add(TestDetails testDetails) {
		this.insertEntity(testDetails);
		return true;
	}

	@Override
	public boolean delete(TestDetails testDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TestDetails testDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TestDetails get(int id) {
		// TODO Auto-generated method stub
		return this.selectOneEntity(id);
	}

	@Override
	public PageCut<TestDetails> getPage(int pageSize, int page, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestDetails> getByRseId(int resId) {
		
		return testDetailsDao.getByRseId(resId);
	}

}
