package com.cn.jingfen.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.jingfen.dynaconfig.DynamicDataSourceContextHolder;
import com.cn.jingfen.dynaconfig.TargetDataSource;
import com.cn.jingfen.mapper.UserMapper;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.vo.Muser;
import com.cn.jingfen.vo.User;


@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
	

	@Override
	@TargetDataSource("dataSourceE")
	public List<Muser> findAll() {
		return userMapper.findAll();
	}
    
	@Override
	public User findUserByUserName(String username) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserByUserName(username);
		return user;
	}

}
