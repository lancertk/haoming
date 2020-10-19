package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.jingfen.mapper.GridkdMapper;
import com.cn.jingfen.service.GridkdService;



@Service("gridkdService")
public class GridkdServiceImp implements GridkdService {
	
	@Autowired
	private GridkdMapper gridMapper;

	@Override
	public List selectGrid1info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd1Grid1(map);
	}

	@Override
	public List selectGrid1info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd1Grid2(map);
	}

	@Override
	public List selectGrid1info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd1Grid3(map);
	}

	@Override
	public List selectGrid1info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd1Grid4(map);
	}

	@Override
	public List selectGrid2info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd2Grid1(map);
	}

	@Override
	public List selectGrid2info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd2Grid2(map);
	}

	@Override
	public List selectGrid2info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd2Grid3(map);
	}

	@Override
	public List selectGrid2info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd2Grid4(map);
	}

	@Override
	public List selectGrid3info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd3Grid1(map);
	}

	@Override
	public List selectGrid3info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd3Grid2(map);
	}

	@Override
	public List selectGrid3info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd3Grid3(map);
	}

	@Override
	public List selectGrid3info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd3Grid4(map);
	}
	
	@Override
	public List selectGrid4info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd4Grid1(map);
	}

	@Override
	public List selectGrid4info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd4Grid2(map);
	}

	@Override
	public List selectGrid4info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd4Grid3(map);
	}

	@Override
	public List selectGrid4info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd4Grid4(map);
	}

	@Override
	public List selectGrid5info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd5Grid1(map);
	}

	@Override
	public List selectGrid5info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd5Grid2(map);
	}

	@Override
	public List selectGrid5info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd5Grid3(map);
	}

	@Override
	public List selectGrid5info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkd5Grid4(map);
	}


}
