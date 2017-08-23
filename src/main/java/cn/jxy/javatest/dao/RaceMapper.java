package cn.jxy.javatest.dao;

import cn.jxy.javatest.entity.Race;

public interface RaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Race record);

    int insertSelective(Race record);

    Race selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Race record);

    int updateByPrimaryKey(Race record);
}