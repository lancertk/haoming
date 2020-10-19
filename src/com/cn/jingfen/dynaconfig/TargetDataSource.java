package com.cn.jingfen.dynaconfig;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @ClassName TargetDataSource
 * @Description: 定义注解
 * @Author Jason
 * @Date 2020/3/18  17:07
 * @Version V1.0
 **/
@Target({ ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public  @interface TargetDataSource {
   String value() ;
}