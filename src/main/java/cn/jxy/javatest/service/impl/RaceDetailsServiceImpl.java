package cn.jxy.javatest.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.RaceDetailsMapper;
import cn.jxy.javatest.entity.RaceDetails;
import cn.jxy.javatest.service.IRaceDetailsService;
import cn.jxy.javatest.util.PageCut;

/**
 * @author: 焦
 * @date:   createDate：2017年8月20日 下午8:37:23   
 * @Description: 
 * 
 */
@Service("RaceDetailsService")
public class RaceDetailsServiceImpl extends BaseDao<RaceDetails, Serializable> implements IRaceDetailsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RaceDetailsMapper raceDetailsDao;

	@Override
	public boolean add(RaceDetails raceDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RaceDetails raceDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(RaceDetails raceDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RaceDetails get(int raceDetailsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageCut<RaceDetails> getPage(int pageSize, int page, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RaceDetails> getByRaceId(int raceId) {
		
		return raceDetailsDao.getByRaceId(raceId);
	}

}
