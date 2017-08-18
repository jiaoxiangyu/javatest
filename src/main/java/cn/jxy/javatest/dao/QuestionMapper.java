package cn.jxy.javatest.dao;

import java.util.List;

import cn.jxy.javatest.entity.Question;

public interface QuestionMapper {
	
	//获得一试题集题数
	int getNumByTypeId(int typeid);
	
    List<Question>  selectByTypeId(int typeid);
}