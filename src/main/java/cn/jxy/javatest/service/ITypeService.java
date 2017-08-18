package cn.jxy.javatest.service;

import cn.jxy.javatest.entity.Type;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月10日 下午4:12:57   
 * @Description: 
 * 
 */
public interface ITypeService {
	
	public boolean add(Type type);
	
	public boolean delete(Type type);
	
	public boolean update(Type type);
	
	public Type get(int userId);
		
	public PageCut<Type> getPage(int pageSize,int page,Object ...objects);
		
}
