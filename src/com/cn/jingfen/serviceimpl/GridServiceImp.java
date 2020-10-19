package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.jingfen.mapper.GridMapper;
import com.cn.jingfen.service.GridService;
import com.cn.jingfen.vo.Grid;


@Service("gridService")
public class GridServiceImp implements GridService {
	
	@Autowired
	private GridMapper gridMapper;

	@Override
	public List selctGridType() {
		// TODO Auto-generated method stub
		return gridMapper.selctGridType();
	}

	@Override
	public List<Grid> selectAllGrid() {
		// TODO Auto-generated method stub
		return gridMapper.selectAllGrid(); 
	}

	@Override
	public List selectGrid1() {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid1();
	}
	
	@Override
	public List selectGrid2() {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid2();
	}

	@Override
	public List selectGridTest1(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGridtest1(map);
	}
	
	@Override
	public List selectGridTest2(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGridtest2(map);
	}

	@Override
	public List selectGridTest3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGridtest3(map);
	}

	@Override
	public List selectGridTest4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGridtest4(map);
	}

	@Override
	public List selectrefreshtime(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctrefreshtime(map);
	}


}
