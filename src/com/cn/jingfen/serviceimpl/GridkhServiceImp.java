package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.jingfen.mapper.GridkhMapper;
import com.cn.jingfen.service.GridkhService;



@Service("gridkhService")
public class GridkhServiceImp implements GridkhService {
	
	@Autowired
	private GridkhMapper gridMapper;

	@Override
	public List selectGrid1info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkh1Grid1(map);
	}

	@Override
	public List selectGrid1info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkh1Grid2(map);
	}

	@Override
	public List selectGrid1info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkh1Grid3(map);
	}

	@Override
	public List selectGrid1info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctkh1Grid4(map);
	}

}
