package com.cn.jingfen.mapper;

import java.util.List;
import java.util.Map;

import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;

public interface CitynewMapper {
	
	public List<AreaData> selectAreaData();
	
	public List<CityData> selectCityData(Map<String, Object> map);
	
	public List<CityData> selectCityData1(String string);
	
	public List<ProvinceData> selectProvinceData(Map<String, Object> map);
	
	
}
