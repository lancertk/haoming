package com.cn.jingfen.service;

import java.util.List;
import java.util.Map;

import com.cn.jingfen.vo.Grid;


public interface GridService {
	
	//查看分类
	List selctGridType();
	
	//查询所有分类信息
	List<Grid> selectAllGrid(); 
	
	List selectrefreshtime(Map<String,Object> map);
	
	List  selectGrid1();
	List  selectGrid2();
	List  selectGridTest1(Map<String,Object> map);
	List  selectGridTest2(Map<String,Object> map);
	List  selectGridTest3(Map<String,Object> map);
	List  selectGridTest4(Map<String,Object> map);


}
