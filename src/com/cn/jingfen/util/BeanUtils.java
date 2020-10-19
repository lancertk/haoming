package com.cn.jingfen.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * bean的工具类，包含对bean的操作方法，比如复制等
 * Copyright: Copyright (c) 2018  Asiainfo
 * @ClassName: BeanUtils.java
 * @Description: 
 * @version: v1.0.0
 * @author: baoyu
 * @date: 2018-10-23   下午3:58:11 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018-10-23      baoyu           v1.0.0               创建
 */
public abstract class BeanUtils {
	/**
	 * 复制对象属性
	 * 
	 * @param source
	 *            数据源对象
	 * @param target
	 *            数据目标对象
	 */
	public static void copyProperties(Object source, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(source, target);
	}

	public static void copyProperties(Object source, Object target,
			Class editable) {
		org.springframework.beans.BeanUtils.copyProperties(source, target,
				editable);
	}

	public static void copyProperties(Object source, Object target,
			String[] ignoreProperties) {
		org.springframework.beans.BeanUtils.copyProperties(source, target,
				ignoreProperties);
	}

	/**
	 * 根据信息表复制历史表（包含updateAccept、updateLogin……） 时间仓促较为简单的，细致问题大家一起调整
	 * 
	 * @param
	 * @param
	 * @return
	 * @throws
	 * @author zhoulin
	 * @created 2013-12-19 上午10:13:26
	 * @modify by
	 */
	public static void copyHis(Object obj1, Object obj2,
			Map<String, Object> updateMap) throws Exception 
	{
		try{
		BeanUtils.copyProperties(obj1, obj2);
		Class cl = Class.forName(obj2.getClass().getName());
		Long updateAccept = (Long) updateMap.get("updateAccept");
		java.util.Date updateTime = (Date) updateMap.get("currentTime");
		String updateLogin = (String) updateMap.get("updateLogin");
		String updateType = (String) updateMap.get("updateType");
		String updateCode = (String) updateMap.get("updateCode");
		String updateNote = (String) updateMap.get("updateNote");
		int updateDate = (Integer) updateMap.get("updateDate");
		try {
			Field field = cl.getDeclaredField("updateAccept");
			field.setAccessible(true);
			field.set(obj2, updateAccept);
		} catch (NoSuchFieldException e) {
		}
		try {
			Field field2 = cl.getDeclaredField("updateTime");
			field2.setAccessible(true);
			field2.set(obj2, updateTime);
		} catch (NoSuchFieldException e) {
		}

		try {
			Field field3 = cl.getDeclaredField("updateLogin");
			field3.setAccessible(true);
			field3.set(obj2, updateLogin);
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
		}

		try {
			Field field4 = cl.getDeclaredField("updateType");
			field4.setAccessible(true);
			field4.set(obj2, updateType);
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
		}

		try {
			Field field5 = cl.getDeclaredField("updateCode");
			field5.setAccessible(true);
			field5.set(obj2, updateCode);
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
		}

		try {
			Field field6 = cl.getDeclaredField("updateNote");
			field6.setAccessible(true);
			field6.set(obj2, updateNote);
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
		}


		try {
			Field field8 = cl.getDeclaredField("updateDate");
			field8.setAccessible(true);
			field8.set(obj2, updateDate);

		} catch (NoSuchFieldException e) {
			// TODO: handle exception
		}
		}catch(IllegalAccessException e){
			e.printStackTrace();
			throw new Exception("copyHis方法抛出IllegalAccessException异常");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new Exception("copyHis方法抛出ClassNotFoundException异常");
		}
		
		
		System.out.println();
	}
	
	 /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InstantiationException
     *             如果实例化 JavaBean 失败
     * @throws InvocationTargetException
     *             如果调用属性的 setter 方法失败
     */
    public static Object convertMap(Class type, Map map)
             throws Exception  {
    	Object obj = null;
        BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
	        obj = type.newInstance(); // 创建 JavaBean 对象
	        
	        // 获取类属性

	        // 给 JavaBean 对象的属性赋值
	        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
	        for (int i = 0; i< propertyDescriptors.length; i++) {
	            PropertyDescriptor descriptor = propertyDescriptors[i];
	            String propertyName = descriptor.getName();

	            if (map.containsKey(propertyName)) {
	                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
	                Object value = map.get(propertyName);

	                Object[] args = new Object[1];
	                args[0] = value;

	                descriptor.getWriteMethod().invoke(obj, args);
	            }
	        }	        

		} catch (IntrospectionException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IntrospectionException异常");
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出InstantiationException异常");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IllegalAccessException异常");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IllegalArgumentException异常");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出InvocationTargetException异常");
		}
		
        return obj;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map convertBean(Object bean) throws Exception {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        try {
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
		} catch (IntrospectionException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IntrospectionException异常");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IllegalAccessException异常");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出IllegalArgumentException异常");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception("convertMap方法抛出InvocationTargetException异常");
		}        
        return returnMap;
    }

}
