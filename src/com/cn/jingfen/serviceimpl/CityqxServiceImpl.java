package com.cn.jingfen.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.jingfen.mapper.CityqxMapper;
import com.cn.jingfen.service.CityqxService;
import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;
@Service("cityqxService")
public class CityqxServiceImpl implements CityqxService{
	@Autowired
	private CityqxMapper cityqxMapper;
	
	@Override
	public List<AreaData> selectArea() {
		// TODO Auto-generated method stub
		 return cityqxMapper.selectArea();
	}

	@Override
	public List<CityData> selectCity() {
		// TODO Auto-generated method stub
		return cityqxMapper.selectCity();
	}

	@Override
	public List<ProvinceData> selectProvince() {
		// TODO Auto-generated method stub
		return cityqxMapper.selectProvince();
	};
}
