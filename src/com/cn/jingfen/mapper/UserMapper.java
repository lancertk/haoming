package com.cn.jingfen.mapper;

import java.util.List;

import com.cn.jingfen.vo.Muser;
import com.cn.jingfen.vo.User;

public interface UserMapper {
	
public List<Muser> findAll();

//通过名字查询该用户信息
public User findUserByUserName(String username);



 }
