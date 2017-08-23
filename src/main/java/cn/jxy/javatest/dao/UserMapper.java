package cn.jxy.javatest.dao;

import cn.jxy.javatest.entity.User;

public interface UserMapper {
	User login(User user);
	
	public User check(String username);
	
	int deleteUser(User user);
}