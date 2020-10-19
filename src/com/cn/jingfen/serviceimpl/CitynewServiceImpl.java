package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.jingfen.mapper.CitynewMapper;
import com.cn.jingfen.service.CitynewService;
import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;
@Service("citynewService")
public class CitynewServiceImpl implements CitynewService {
	@Autowired
	private CitynewMapper CitynewMapper;
	@Override
	public List<AreaData> selectAreaData() {
		// TODO Auto-generated method stub
		return CitynewMapper.selectAreaData();
	}

	@Override
	public List<CityData> selectCityData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return CitynewMapper.selectCityData(map);
	}

	@Override
	public List<ProvinceData> selectProvinceData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return CitynewMapper.selectProvinceData(map);
	}

	@Override
	public List<CityData> selectCityData1(String string) {
		// TODO Auto-generated method stub
		return CitynewMapper.selectCityData1(string);
	}

}
