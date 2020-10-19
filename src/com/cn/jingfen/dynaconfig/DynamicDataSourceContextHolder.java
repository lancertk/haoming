package com.cn.jingfen.dynaconfig;

import org.apache.log4j.Logger;

/**
 * @ClassName DynamicDataSourceContextHolder
 * @Description: TODO
 * @Author Jason
 * @Date 2020/3/18  12:15
 * @Version V1.0
 **/
public class DynamicDataSourceContextHolder {
    private  static  final Logger LOG=Logger.getLogger(DynamicDataSourceContextHolder.class);
    private static final ThreadLocal<String> currenDataSource=new ThreadLocal<>();
    /**
     * @Author Jason
     * @Description //清除当前数据源
     * @Date 2020/3/18 12:19
     * @Param
     * @return
     **/
    public static  void clear(){
        currenDataSource.remove();
    }
   /**
    * @Author Jason
    * @Description //Description
    * @Date 2020/3/18 20:50
    * @Param []
    * @return java.lang.String
    **/
    public static String get(){
        return currenDataSource.get();
    }

    /**
     * @Author Jason
     * @Description 设置数据源
     * @Date 2020/3/18 15:49
     * @Param []
     * @return void
     **/
    public static void setDataSource(String datasource) {
        currenDataSource.set(datasource);
    }
}
