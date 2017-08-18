
package cn.jxy.javatest.service;

import cn.jxy.javatest.entity.User;
import cn.jxy.javatest.util.PageCut;
/**        
 * @author: 焦
 * @date:   createDate：2017年8月8日 下午5:42:42   
 * @Description:  
 * 
 */  

public interface IUserService {
	
	public User login(User user);
	
	public boolean add(User user);
	
	public boolean delete(User user);
	
	public boolean update(User user);
	
	public User get(int userId);
	
	public PageCut<User> getPage(int pageSize,int page,Object ...objects);
}
