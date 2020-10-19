package com.cn.jingfen.service;

import java.util.List;

import com.cn.jingfen.vo.Muser;
import com.cn.jingfen.vo.User;

public interface UserService {
	
	public List<Muser> findAll();
	
	public User findUserByUserName(String username);

}
