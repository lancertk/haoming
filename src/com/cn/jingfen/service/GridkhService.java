package com.cn.jingfen.service;

import java.util.List;
import java.util.Map;

import com.cn.jingfen.vo.Grid;


public interface GridkhService {
	
	
	//流量出账收入日报
	List  selectGrid1info1(Map<String,Object> map);
	List  selectGrid1info2(Map<String,Object> map);
	List  selectGrid1info3(Map<String,Object> map);
	List  selectGrid1info4(Map<String,Object> map);
	

}
