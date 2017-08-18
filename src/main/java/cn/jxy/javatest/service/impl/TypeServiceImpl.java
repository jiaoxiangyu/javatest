package cn.jxy.javatest.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.TypeMapper;
import cn.jxy.javatest.entity.Type;
import cn.jxy.javatest.service.ITypeService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月11日 上午8:33:06   
 * @Description: 
 * 
 */
@Service("typeService")
public class TypeServiceImpl extends BaseDao<Type, Serializable> implements ITypeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private TypeMapper typeDao;

	@Override
	public boolean add(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageCut<Type> getPage(int pageSize, int page, Object... objects) {
		PageCut<Type> p=new PageCut<Type>();
		if(pageSize==0 && page==0 && objects.length==0){//查询所有				
			p.setData(this.selectAllEntity());			
			
		}else if(pageSize==0 && page==0 && objects.length!=0){//条件查询所有
			return null;
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

	

}
