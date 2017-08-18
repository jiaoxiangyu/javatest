package cn.jxy.javatest.dao;

import java.util.List;

import cn.jxy.javatest.entity.TestDetails;

public interface TestDetailsMapper {
	//根据resId查询
	public List<TestDetails> getByRseId(int resid);
}