package com.cn.jingfen.service;

import java.util.List;

import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;


public interface CityqxService {
	public List<AreaData> selectArea();
	
	public List<CityData> selectCity();
	
	public List<ProvinceData> selectProvince();
	

}
