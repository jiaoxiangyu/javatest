package cn.jxy.javatest.service;

import java.util.List;

import cn.jxy.javatest.entity.Response;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月10日 下午4:18:29   
 * @Description: 
 * 
 */
public interface IResponseService {

	public boolean add(Response response);
	
	public boolean delete(Response response);
	
	public boolean update(Response response);
	
	public Response get(int id);
	
	public PageCut<Response> getPage(int pageSize,int page,Object ...objects);
	
	//查询该用户做了该试题集数量	
	public int countNum(int userId,int typeId);
	
	//根据userId和qtId查询
	public Response getByUserIdAndQtIdForNew(int userId,int qtId);
	
	//根据userId和qtId查询
	public List<Response> getByUserIdAndQtId(int userId,int qtId);
	
	//根据userId和qtId获得答案为空的回答
	public Response getForResId(int userId,int qtId);
	
	//根据userId查询
	public List<Response> getByUserId(int userId);
	
}
