package cn.jxy.javatest.service;

import cn.jxy.javatest.entity.Race;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月20日 下午8:36:08   
 * @Description: 
 * 
 */
public interface IRaceService {
	
	public boolean add(Race race);
	
	public boolean delete(Race race);
	
	public boolean update(Race race);
	
	public Race get(int raceId);
	
	public PageCut<Race> getPage(int pageSize,int page,Object ...objects);
}
