package cn.jxy.javatest.dao;

import java.util.List;

import cn.jxy.javatest.entity.RaceDetails;

public interface RaceDetailsMapper {
	public List<RaceDetails> getByRaceId(int raceid);
}