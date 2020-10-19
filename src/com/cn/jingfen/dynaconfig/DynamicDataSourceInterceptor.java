package com.cn.jingfen.dynaconfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * @ClassName DynamicDataSourceInterceptor
 * @Description: 数据源切换拦截器
 * @Author Jason
 * @Date 2020/3/18  17:32
 * @Version V1.0
 **/
public class DynamicDataSourceInterceptor {
    private static final Logger LOG = Logger.getLogger(DynamicDataSourceInterceptor.class);
    /**
     * @Author Jason
     * @Description 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     * @Date 2020/3/18 17:39
     * @Param [point]
     * @return void
     **/
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * @Author Jason
     * @Description 提取目标对象方法注解和类型注解中的数据源标识
     * @Date 2020/3/18 17:40
     * @Param [clazz, method]
     * @return void
     **/
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource source = clazz.getAnnotation(TargetDataSource.class);
                DynamicDataSourceContextHolder.setDataSource(source.value());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource source = m.getAnnotation(TargetDataSource.class);
                DynamicDataSourceContextHolder.setDataSource(source.value());
            }
            //如果为空的话，默认数据库为dataSource。
            if(StringUtils.isBlank(DynamicDataSourceContextHolder.get())){
            	 DynamicDataSourceContextHolder.setDataSource("dataSource");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author Jason
     * @Description 执行方法后清除数据源设置
     * @Date 2020/3/18 21:26
     * @Param [joinPoint, targetDataSource]
     * @return void
     **/
    public void afterIntercept(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?>[] types = signature.getParameterTypes();
        Class<?> target = point.getTarget().getClass();
        try {
            Method m = target.getMethod(signature.getName(), types);
            if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource source = m.getAnnotation(TargetDataSource.class);
                LOG.info("当前数据源"+ source.value()+ "执行清理方法");
            }
            else{
                LOG.info("当前数据源"+ DynamicDataSourceContextHolder.get()+ "执行清理方法");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSourceContextHolder.clear();
    }
}
