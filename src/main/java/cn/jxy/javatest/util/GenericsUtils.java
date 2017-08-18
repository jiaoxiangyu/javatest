package cn.jxy.javatest.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 * @author 焦
 *
 */
public class GenericsUtils {
	
	
	/**
	 * 通过反射获取指定类的父类的泛型参数的实际类型 
	 * 如 UserService extends BaseDao<User>获得User
	 * @param clazz 指定的类 该类必须继承泛型父类
	 * @param index 泛型参数类型的数组下标
	 * @return 返回一个泛型参数类型的数组
	 * 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 
     *         只有Object.class的数组
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenericType(Class clazz , int index){
		
		Type type = clazz.getGenericSuperclass();//获得父类
		
		
		if(!(type instanceof ParameterizedType)){
			
			return Object.class;
		}
		
		Type[] params = ((ParameterizedType)type).getActualTypeArguments();
		
		return (Class)params[index];
	}

}
