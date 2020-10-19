package com.cn.jingfen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.jingfen.service.GridkhService;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.Kdgrid1;
import com.cn.jingfen.vo.User;

@Controller
public class GridkhController extends Gridme {

		@Autowired
		private GridkhService gridService;
	
		@Autowired
		private UserService userService;

		
		//宽带装机日报
				@RequestMapping("/querykh1grid1")
				@ResponseBody
				public JSONObject querykh1grid1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String dd = request.getParameter("datetime");//在request中取值
					String datetime = dd.replace("-", "").substring(0, 6);//数据格式统一
					String username = request.getParameter("username");//获取request中的uesrname
					User user = userService.findUserByUserName(username);//查找用户
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/khgrid1.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid1info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid1info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid1info3(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				   

				// 查看网格分类
				@RequestMapping("/querykh1grid2")
				@ResponseBody
				public JSONObject querykh1grid2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String dd = request.getParameter("datetime");
					String datetime = dd.replace("-", "").substring(0, 6);
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/khgrid1.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid1info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid1info3(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				

}
