package cn.jxy.javatest.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.ResponseMapper;
import cn.jxy.javatest.entity.Response;
import cn.jxy.javatest.service.IResponseService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 上午8:31:26   
 * @Description: 
 * 
 */
@Service("responseService")
public class ResponseServiceImpl extends BaseDao<Response, Serializable> implements IResponseService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResponseMapper responseDao;

	@Override
	public boolean add(Response response) {
		this.insertEntity(response);
		return true;
	}

	@Override
	public boolean delete(Response response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Response response) {
		this.updateEntity(response);
		return true;
	}

	@Override
	public Response get(int id) {
		// TODO Auto-generated method stub
		return this.selectOneEntity(id);
	}

	@Override
	public PageCut<Response> getPage(int pageSize, int page, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countNum(int userId, int typeId) {
		
		return responseDao.countNum(userId, typeId);
	}

	@Override
	public Response getByUserIdAndQtIdForNew(int userId, int qtId) {
		// TODO Auto-generated method stub
		List<Response> list=responseDao.getByUserIdAndQtId(userId, qtId);
		if(list.size()>0){
			return (Response)list.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public Response getForResId(int userId, int qtId) {
		List<Response> list=responseDao.getForResId(userId, qtId);
		if(list.size()>0){
			return (Response)list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Response> getByUserId(int userId) {
		
		return responseDao.getByUserId(userId);
	}

	@Override
	public List<Response> getByUserIdAndQtId(int userId, int qtId) {
		
		return responseDao.getByUserIdAndQtId(userId, qtId);
	}

}
