package com.cn.jingfen.service;

import java.util.List;
import java.util.Map;

import com.cn.jingfen.vo.Grid;


public interface GridkdService {
	
	
	//流量出账收入日报
	List  selectGrid1info1(Map<String,Object> map);
	List  selectGrid1info2(Map<String,Object> map);
	List  selectGrid1info3(Map<String,Object> map);
	List  selectGrid1info4(Map<String,Object> map);
	
	//魔百和发展日报
	List  selectGrid2info1(Map<String,Object> map);
	List  selectGrid2info2(Map<String,Object> map);
	List  selectGrid2info3(Map<String,Object> map);
	List  selectGrid2info4(Map<String,Object> map);
	
	//宽带装机日报
	List  selectGrid3info1(Map<String,Object> map);
	List  selectGrid3info2(Map<String,Object> map);
	List  selectGrid3info3(Map<String,Object> map);
	List  selectGrid3info4(Map<String,Object> map);
	
	//
	List  selectGrid4info1(Map<String,Object> map);
	List  selectGrid4info2(Map<String,Object> map);
	List  selectGrid4info3(Map<String,Object> map);
	List  selectGrid4info4(Map<String,Object> map);	

	//
	List  selectGrid5info1(Map<String,Object> map);
	List  selectGrid5info2(Map<String,Object> map);
	List  selectGrid5info3(Map<String,Object> map);
	List  selectGrid5info4(Map<String,Object> map);	
	
}
