package cn.jxy.javatest.dao;

import java.util.List;

import cn.jxy.javatest.entity.Response;

public interface ResponseMapper {
	//查询该用户做了该试题集数量
    int countNum(int userId,int typeId);
    
    //根据userId和qtId查询
  	public List<Response> getByUserIdAndQtId(int userId,int qtId);
    
    //根据userId和qtId获得答案为空的回答
    List<Response> getForResId(int userId,int qtId);
    
    //根据userId查询
  	public List<Response> getByUserId(int userid);
  	
  	//根据userId和raceId查询
  	public List<Response> getByUserIdAndRaceId(int userId,int raceId);
  	
  	//根据userId、raceId和qtId查询
  	public Response getByUserRaceQt(int userId,int raceId,int qtId);
  	
  	//根据userId、raceId和qtId查询
  	public List<Response> getAllByUserRaceQt(int userId,int raceId,int qtId);
}