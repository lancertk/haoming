package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.jingfen.mapper.GridfwMapper;
import com.cn.jingfen.service.GridfwService;



@Service("gridfwService")
public class GridfwServiceImp implements GridfwService {
	
	@Autowired
	private GridfwMapper gridMapper;

	@Override
	public List selectGrid1info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw1Grid1(map);
	}

	@Override
	public List selectGrid1info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw1Grid2(map);
	}

	@Override
	public List selectGrid1info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw1Grid3(map);
	}

	@Override
	public List selectGrid1info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw1Grid4(map);
	}

	@Override
	public List selectGrid2info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw2Grid1(map);
	}

	@Override
	public List selectGrid2info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw2Grid2(map);
	}

	@Override
	public List selectGrid2info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw2Grid3(map);
	}

	@Override
	public List selectGrid2info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw2Grid4(map);
	}

	@Override
	public List selectGrid3info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw3Grid1(map);
	}

	@Override
	public List selectGrid3info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw3Grid2(map);
	}

	@Override
	public List selectGrid3info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw3Grid3(map);
	}

	@Override
	public List selectGrid3info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw3Grid4(map);
	}

	@Override
	public List selectGrid4info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw4Grid1(map);
	}

	@Override
	public List selectGrid4info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw4Grid2(map);
	}

	@Override
	public List selectGrid4info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw4Grid3(map);
	}

	@Override
	public List selectGrid4info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw4Grid4(map);
	}

	@Override
	public List selectGrid5info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw5Grid1(map);
	}

	@Override
	public List selectGrid5info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw5Grid2(map);
	}

	@Override
	public List selectGrid5info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw5Grid3(map);
	}

	@Override
	public List selectGrid5info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw5Grid4(map);
	}

	@Override
	public List selectGrid6info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw6Grid1(map);
	}

	@Override
	public List selectGrid6info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw6Grid2(map);
	}

	@Override
	public List selectGrid6info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw6Grid3(map);
	}

	@Override
	public List selectGrid6info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw6Grid4(map);
	}

	@Override
	public List selectGrid7info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw7Grid1(map);
	}

	@Override
	public List selectGrid7info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw7Grid2(map);
	}

	@Override
	public List selectGrid7info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw7Grid3(map);
	}

	@Override
	public List selectGrid7info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctfw7Grid4(map);
	}

}
