package cn.jxy.javatest.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.jxy.javatest.util.GenericsUtils;


/**
 * 
 * @author 焦
 *
 * @param <T> 这个泛型通配符用来指定实体类
 * @param <PK> 主键类型
 */
public class BaseDao<T , PK extends Serializable> extends SqlSessionDaoSupport 
             implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private final String SUFFIX = "Mapper"; //后缀  
    
    private final String _INSERT = ".insert";  //添加
    
    private final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";  
  
    private final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";  
    
    private final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";

    private final String _SELECTALL = ".selectAll";
    
    
    //这是为了让父类获得SqlSessionFactory实例以便获得SqlSession，该实例已在spring-mybatis.xml配置
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
         super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    
    //得到***Mapper.xml的命名空间
    public final String getNameSpace(){
    	Class<?> clazz = GenericsUtils.getSuperClassGenericType(this.getClass() , 0);
    	
    	String nameSpace = clazz.getName().replaceFirst("entity", "dao")+SUFFIX;
    	return nameSpace;
    }

    
    
    public final int deleteEntity(PK id){
    	
    	return getSqlSession().delete(
    			this.getNameSpace()+_DELETEBYPRIMARYKEY , id);
    }
    
    
    /**
     * 插入一条记录
     * @param t 对象实例
     * @return 返回受影响的行数
     */
    public final int insertEntity(T record){
    	
    	return getSqlSession().insert(this.getNameSpace()+_INSERT , record);
    }
    
    
    
   
    /**
     * 
     * @param id 
     * @return 根据id返回一个实例
     */
	public final T selectOneEntity(PK id){
    	return getSqlSession().selectOne(
    			this.getNameSpace()+_SELECTBYPRIMARYKEY , id);
    }
    
    
	/**
	 * 
	 * @return 返回所有记录
	 */
    public final List<T> selectAllEntity(){
    	
    	return getSqlSession().selectList(
    			this.getNameSpace()+_SELECTALL);
    }
    


    /**
     * 更新一条记录
     * @param t 对像实例
     * @return 受影响的行数
     */
    public final int updateEntity(T record){
    	
    	return getSqlSession().update(
    			this.getNameSpace()+_UPDATEBYPRIMARYKEY, record);
    }
    
}
