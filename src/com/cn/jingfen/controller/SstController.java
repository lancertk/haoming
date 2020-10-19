package com.cn.jingfen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.jingfen.service.GridService;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.User;


@Controller
public class SstController extends Gridme{
	
	
	@Autowired
	private UserService userService;
	
			
	//手机经分验证
		@RequestMapping("/querysstbyname")
		@ResponseBody
		public JSONObject querybyname(HttpServletRequest request,
				HttpServletResponse response) {
			JSONObject json = new JSONObject();
			String uname=request.getParameter("uname");
			User user = null;
			if(null!=uname){
				user = userService.findUserByUserName(uname);
			}
			if(null!=user){
				json.put("result", "success");
				json.put("msg", "用户存在");
				json.put("uname", uname);
				//将user对象返回，为了拿到citycode，暂时方案。后面需要和新门户单点登录。
				json.put("user",user);
			}else{
				json.put("result", "fail");
				json.put("msg", "用户不存在");
				json.put("uname", "");
			}
			return json;
		}
	
}
