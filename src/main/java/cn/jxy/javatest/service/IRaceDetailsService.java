package cn.jxy.javatest.service;

import java.util.List;

import cn.jxy.javatest.entity.RaceDetails;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月20日 下午8:36:55   
 * @Description: 
 * 
 */
public interface IRaceDetailsService {

	public boolean add(RaceDetails raceDetails);
	
	public boolean delete(RaceDetails raceDetails);
	
	public boolean update(RaceDetails raceDetails);
	
	public RaceDetails get(int raceDetailsId);
	
	public PageCut<RaceDetails> getPage(int pageSize,int page,Object ...objects);
	
	public List<RaceDetails> getByRaceId(int raceId);
}
