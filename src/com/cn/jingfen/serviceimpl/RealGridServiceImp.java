package com.cn.jingfen.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.jingfen.mapper.GridMapper;
import com.cn.jingfen.mapper.RealGridMapper;
import com.cn.jingfen.service.GridService;
import com.cn.jingfen.service.RealGridService;
import com.cn.jingfen.vo.Grid;


@Service("realgridService")
public class RealGridServiceImp implements RealGridService {
	
	@Autowired
	private RealGridMapper gridMapper;

	
	@Override
	public List selectGrid4infoo1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selectGrid4infoo1(map);
	}

	@Override
	public List selectGrid4infoo2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selectGrid4infoo2(map);
	}

	@Override
	public List selectGrid4infoo3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selectGrid4infoo3(map);
	}

	@Override
	public List selectGrid4infoo4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selectGrid4infoo4(map);
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
	public List selectGrid1info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid1rb1(map);
	}

	@Override
	public List selectGrid1info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid1rb2(map);
	}

	@Override
	public List selectGrid1info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid1rb3(map);
	}

	@Override
	public List selectGrid1info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid1rb4(map);
	}

	@Override
	public List selectGrid2info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid2rb1(map);
	}

	@Override
	public List selectGrid2info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid2rb2(map);
	}

	@Override
	public List selectGrid2info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid2rb3(map);
	}

	@Override
	public List selectGrid2info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid2rb4(map);
	}

	@Override
	public List selectGrid3info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid3rb1(map);
	}

	@Override
	public List selectGrid3info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid3rb2(map);
	}

	@Override
	public List selectGrid3info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid3rb3(map);
	}

	@Override
	public List selectGrid3info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid3rb4(map);
	}

	@Override
	public List selectGrid4info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid4rb1(map);
	}

	@Override
	public List selectGrid4info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid4rb2(map);
	}

	@Override
	public List selectGrid4info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid4rb3(map);
	}

	@Override
	public List selectGrid4info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid4rb4(map);
	}

	@Override
	public List selectGrid5info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid5rb1(map);
	}

	@Override
	public List selectGrid5info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid5rb2(map);
	}

	@Override
	public List selectGrid5info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid5rb3(map);
	}

	@Override
	public List selectGrid5info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid5rb4(map);
	}

	@Override
	public List selectGrid6info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid6rb1(map);
	}

	@Override
	public List selectGrid6info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid6rb2(map);
	}

	@Override
	public List selectGrid6info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid6rb3(map);
	}

	@Override
	public List selectGrid6info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid6rb4(map);
	}

	@Override
	public List selectGrid7info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid7rb1(map);
	}

	@Override
	public List selectGrid7info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid7rb2(map);
	}

	@Override
	public List selectGrid7info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid7rb3(map);
	}

	@Override
	public List selectGrid7info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid7rb4(map);
	}

	@Override
	public List selectGrid8info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid8rb1(map);
	}

	@Override
	public List selectGrid8info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid8rb2(map);
	}

	@Override
	public List selectGrid8info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid8rb3(map);
	}

	@Override
	public List selectGrid8info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid8rb4(map);
	}

	@Override
	public List selectGrid9info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid9rb1(map);
	}

	@Override
	public List selectGrid9info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid9rb2(map);
	}

	@Override
	public List selectGrid9info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid9rb3(map);
	}

	@Override
	public List selectGrid9info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid9rb4(map);
	}

	@Override
	public List selectGrid10info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid10rb1(map);
	}

	@Override
	public List selectGrid10info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid10rb2(map);
	}

	@Override
	public List selectGrid10info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid10rb3(map);
	}

	@Override
	public List selectGrid10info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid10rb4(map);
	}

	@Override
	public List selectGrid11info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid11rb1(map);
	}

	@Override
	public List selectGrid11info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid11rb2(map);
	}

	@Override
	public List selectGrid11info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid11rb3(map);
	}

	@Override
	public List selectGrid11info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid11rb4(map);
	}

	@Override
	public List selectGrid12info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid12rb1(map);
	}

	@Override
	public List selectGrid12info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid12rb2(map);
	}

	@Override
	public List selectGrid12info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid12rb3(map);
	}

	@Override
	public List selectGrid12info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid12rb4(map);
	}

	@Override
	public List selectGrid13info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid13rb1(map);
	}

	@Override
	public List selectGrid13info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid13rb2(map);
	}

	@Override
	public List selectGrid13info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid13rb3(map);
	}

	@Override
	public List selectGrid13info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid13rb4(map);
	}

	@Override
	public List selectGrid14info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid14rb1(map);
	}

	@Override
	public List selectGrid14info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid14rb2(map);
	}

	@Override
	public List selectGrid14info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid14rb3(map);
	}

	@Override
	public List selectGrid14info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid14rb4(map);
	}

	@Override
	public List selectGrid15info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid15rb1(map);
	}

	@Override
	public List selectGrid15info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid15rb2(map);
	}

	@Override
	public List selectGrid15info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid15rb3(map);
	}

	@Override
	public List selectGrid15info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid15rb4(map);
	}

	@Override
	public List selectGrid16info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid16rb1(map);
	}

	@Override
	public List selectGrid16info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid16rb2(map);
	}

	@Override
	public List selectGrid16info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid16rb3(map);
	}

	@Override
	public List selectGrid16info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid16rb4(map);
	}

	@Override
	public List selectGrid17info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid17rb1(map);
	}

	@Override
	public List selectGrid17info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid17rb2(map);
	}

	@Override
	public List selectGrid17info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid17rb3(map);
	}

	@Override
	public List selectGrid17info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid17rb4(map);
	}
	
	@Override
	public List selectGrid18info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid18rb1(map);
	}

	@Override
	public List selectGrid18info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid18rb2(map);
	}

	@Override
	public List selectGrid18info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid18rb3(map);
	}

	@Override
	public List selectGrid18info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid18rb4(map);
	}
	
	@Override
	public List selectGrid19info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid19rb1(map);
	}

	@Override
	public List selectGrid19info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid19rb2(map);
	}

	@Override
	public List selectGrid19info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid19rb3(map);
	}

	@Override
	public List selectGrid19info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid19rb4(map);
	}
	
	@Override
	public List selectGrid20info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid20rb1(map);
	}

	@Override
	public List selectGrid20info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid20rb2(map);
	}

	@Override
	public List selectGrid20info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid20rb3(map);
	}

	@Override
	public List selectGrid20info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid20rb4(map);
	}
	
	@Override
	public List selectGrid21info1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid21rb1(map);
	}

	@Override
	public List selectGrid21info2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid21rb2(map);
	}

	@Override
	public List selectGrid21info3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid21rb3(map);
	}

	@Override
	public List selectGrid21info4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gridMapper.selctGrid21rb4(map);
	}

	






}
