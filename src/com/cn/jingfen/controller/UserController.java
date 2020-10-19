package com.cn.jingfen.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.jingfen.service.UserService;
import com.cn.jingfen.vo.Muser;
import com.cn.jingfen.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 //查询所有用户
		@RequestMapping("/queryUser")
		@ResponseBody
		public  JSONObject queryUser(HttpServletRequest request,HttpServletResponse response) {
			JSONObject json=new JSONObject();
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			json.put("user", user);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		//查询所有用户
		@RequestMapping("/queryallUser")
		@ResponseBody
		public  JSONObject queryallUser(HttpServletRequest request,HttpServletResponse response) {
			JSONObject json=new JSONObject();
			List<Muser> list = userService.findAll();
			json.put("users", list);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		
		
}
