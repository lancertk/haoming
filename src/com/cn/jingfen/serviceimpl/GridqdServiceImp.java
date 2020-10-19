package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.jingfen.mapper.GridqdMapper;
import com.cn.jingfen.service.GridqdService;



@Service("gridqdService")
public class GridqdServiceImp implements GridqdService {
	
	@Autowired
	private GridqdMapper gridMapper;

	@Override
	public List selectGrid1info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd1Grid1(map);
	}

	@Override
	public List selectGrid1info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd1Grid2(map);
	}

	@Override
	public List selectGrid1info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd1Grid3(map);
	}

	@Override
	public List selectGrid1info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd1Grid4(map);
	}
	
	@Override
	public List selectGrid1info5(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd1Grid5(map);
	}

	@Override
	public List selectGrid2info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd2Grid1(map);
	}

	@Override
	public List selectGrid2info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd2Grid2(map);
	}

	@Override
	public List selectGrid2info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd2Grid3(map);
	}

	@Override
	public List selectGrid2info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd2Grid4(map);
	}
	
	@Override
	public List selectGrid2info5(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd2Grid5(map);
	}


	@Override
	public List selectGrid3info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd3Grid1(map);
	}

	@Override
	public List selectGrid3info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd3Grid2(map);
	}

	@Override
	public List selectGrid3info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd3Grid3(map);
	}

	@Override
	public List selectGrid3info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd3Grid4(map);
	}

	@Override
	public List selectGrid3info5(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctqd3Grid5(map);
	}

}
