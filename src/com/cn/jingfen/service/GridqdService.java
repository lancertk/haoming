package com.cn.jingfen.service;

import java.util.List;
import java.util.Map;

public interface GridqdService {
	
	
	//流量出账收入日报
	List  selectGrid1info1(Map<String,Object> map);
	List  selectGrid1info2(Map<String,Object> map);
	List  selectGrid1info3(Map<String,Object> map);
	List  selectGrid1info4(Map<String,Object> map);
	List  selectGrid1info5(Map<String,Object> map);
	
	//魔百和发展日报
	List  selectGrid2info1(Map<String,Object> map);
	List  selectGrid2info2(Map<String,Object> map);
	List  selectGrid2info3(Map<String,Object> map);
	List  selectGrid2info4(Map<String,Object> map);
	List  selectGrid2info5(Map<String,Object> map);
	
	//宽带装机日报
	List  selectGrid3info1(Map<String,Object> map);
	List  selectGrid3info2(Map<String,Object> map);
	List  selectGrid3info3(Map<String,Object> map);
	List  selectGrid3info4(Map<String,Object> map);
	List  selectGrid3info5(Map<String,Object> map);


}
