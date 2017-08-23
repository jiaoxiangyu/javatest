package cn.jxy.javatest.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.RaceMapper;
import cn.jxy.javatest.entity.Race;
import cn.jxy.javatest.entity.Type;
import cn.jxy.javatest.service.IRaceService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月20日 下午8:38:22   
 * @Description: 
 * 
 */
@Service("RaceService")
public class RaceServiceImpl extends BaseDao<Race, Serializable> implements IRaceService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RaceMapper raceDao;

	@Override
	public boolean add(Race race) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Race race) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Race race) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Race get(int raceId) {
		
		return this.selectOneEntity(raceId);
	}

	@Override
	public PageCut<Race> getPage(int pageSize, int page, Object... objects) {
		PageCut<Race> p=new PageCut<Race>();
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
