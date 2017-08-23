
package cn.jxy.javatest.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.javatest.base.BaseDao;
import cn.jxy.javatest.dao.UserMapper;
import cn.jxy.javatest.entity.User;
import cn.jxy.javatest.service.IUserService;
import cn.jxy.javatest.util.PageCut;

/**        
 * @author: 焦
 * @date:   createDate：2017年8月8日 下午8:48:46   
 * @Description:  
 * 
 */  
@Service("userService")
public class UserServiceImpl extends BaseDao<User, Serializable> implements IUserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserMapper userDao;
	
	/*
	 * 
	 * @see cn.jxy.javatest.service.IUserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}

	/* (non-Javadoc)
	 * @see cn.jxy.javatest.service.IUserService#add(cn.jxy.javatest.entity.User)
	 */
	@Override
	public boolean add(User user) {
		this.insertEntity(user);
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.jxy.javatest.service.IUserService#delete(int)
	 */
	@Override
	public boolean delete(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.jxy.javatest.service.IUserService#update(cn.jxy.javatest.entity.User)
	 */
	@Override
	public boolean update(User user) {
		this.updateEntity(user);
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.jxy.javatest.service.IUserService#get(int)
	 */
	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return this.selectOneEntity(userId);
	}

	/* (non-Javadoc)
	 * @see cn.jxy.javatest.service.IUserService#getPage(int, int, java.lang.Object[])
	 */
	@Override
	public PageCut<User> getPage(int pageSize, int page, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User check(String username) {
		
		return userDao.check(username);
	}


	@Override
	public boolean deleteUser(User user) {
		userDao.deleteUser(user);
		return true;
	}

}
