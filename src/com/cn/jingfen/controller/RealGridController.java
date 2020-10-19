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
import com.cn.jingfen.service.RealGridService;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.Kdgrid1;
import com.cn.jingfen.vo.User;

@Controller
public class RealGridController extends Gridme{
	
	@Autowired
	private RealGridService gridService;
	
	@Autowired
	private UserService userService;
	
	//4g净增日报（仿照版）
	@RequestMapping("/querygrid4grr1")
	@ResponseBody
	public JSONObject querygrid4grr1(HttpServletRequest request,
			HttpServletResponse response) {
		//判断该用户是啥类型
		System.out.println("执行了吗");
		String datetime = request.getParameter("datetime");
		String username = request.getParameter("username");
		User user = userService.findUserByUserName(username);
		Map<String,Object> map1 = userType(user);
		String unitcode = (String)map1.get("unitCode");//map1有  user,有两个属性，unitcode和typeNum
		int typeNum = (Integer) map1.get("typeNum");//
		System.out.println("============================="+typeNum);
		System.out.println("================================"+unitcode);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("datetime", datetime);
		map.put("unitcode", unitcode);//新建一个map把属性放进去
		String path = request.getSession().getServletContext().getRealPath("file/realgrid001.txt");
		String str = readfile(path);
		JSONObject jsStr = JSONObject.parseObject(str);
		String rowname =jsStr.getString("rowname");
		List<Kdgrid1> listgrid =null;
		if(1==typeNum){
			listgrid = gridService.selectGrid4infoo1(map);
		}else if(2==typeNum){
			listgrid = gridService.selectGrid4infoo2(map);
		}else if(3==typeNum){
			listgrid = gridService.selectGrid4infoo3(map);
		}else if(4==typeNum){
			listgrid = gridService.selectGrid4infoo4(map);
		}
		JSONObject json = new JSONObject();
		json.put("data", listgrid);
		System.out.println("================"+json+"==========================");
		json.put("rowname", rowname);
		json.put("status", "success");
		json.put("message", "查询成功");
		return json;
	}
	
	@RequestMapping("/querygrid4grr2")
	@ResponseBody
	public JSONObject querygrid4grr2(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("===============/queryrgrid4grr2,执行了吗");
		//判断该用户是啥类型
		String datetime = request.getParameter("datetime");
		String unitcode = request.getParameter("unitcode");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("datetime", datetime);
		map.put("unitcode", unitcode);
		int unitcodeSize = unitcode.length();
		String path = request.getSession().getServletContext().getRealPath("file/realgrid001.txt");
		String str = readfile(path);
		JSONObject jsStr = JSONObject.parseObject(str);
		String rowname =jsStr.getString("rowname");
		List<Kdgrid1> listgrid =null;
		if(2==unitcodeSize){
			//查询某个地市下的所有区县
			listgrid = gridService.selectGrid4infoo2(map);
		}else if(4==unitcodeSize){
			//查询某个区县下的所有片区
			listgrid = gridService.selectGrid4infoo3(map);
		}else if(7==unitcodeSize){
			//查询某个片区下的所有网格
			listgrid = gridService.selectGrid4infoo4(map);
		}
		JSONObject json = new JSONObject();
		json.put("data", listgrid);
		json.put("rowname", rowname);
		json.put("status", "success");
		json.put("message", "查询成功");
		return json;
	}
		// 账务收入日报
		@RequestMapping("/queryrgrid1")
		@ResponseBody
		public JSONObject querygrid1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(1==typeNum){
				listgrid = gridService.selectGridTest1(map);
			}else if(2==typeNum){
				listgrid = gridService.selectGridTest2(map);
			}else if(3==typeNum){
				listgrid = gridService.selectGridTest3(map);
			}else if(4==typeNum){
				listgrid = gridService.selectGridTest4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
	
		// 账务收入日报
		@RequestMapping("/queryrgrid2")
		@ResponseBody
		public JSONObject querygrid2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(2==unitcodeSize){
				//查询某个地市下的所有区县
				listgrid = gridService.selectGridTest2(map);
			}else if(4==unitcodeSize){
				//查询某个区县下的所有片区
				listgrid = gridService.selectGridTest3(map);
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGridTest4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		// 流量出账收入日报
		@RequestMapping("/queryrgrid1gr1")
		@ResponseBody
		public JSONObject queryrgrid1gr1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid1.txt");
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
			}else if(4==typeNum){
				listgrid = gridService.selectGrid1info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
	
		// 流量出账收入日报
		@RequestMapping("/queryrgrid1gr2")
		@ResponseBody
		public JSONObject queryrgrid1gr2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid1.txt");
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
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGrid1info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		// GPRS流量日报
		@RequestMapping("/queryrgrid2gr1")
		@ResponseBody
		public JSONObject queryrgrid2gr1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid2.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(1==typeNum){
				listgrid = gridService.selectGrid2info1(map);
			}else if(2==typeNum){
				listgrid = gridService.selectGrid2info2(map);
			}else if(3==typeNum){
				listgrid = gridService.selectGrid2info3(map);
			}else if(4==typeNum){
				listgrid = gridService.selectGrid2info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
			
	    // GPRS流量日报
		@RequestMapping("/queryrgrid2gr2")
		@ResponseBody
		public JSONObject queryrgrid2gr2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid2.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(2==unitcodeSize){
				//查询某个地市下的所有区县
				listgrid = gridService.selectGrid2info2(map);
			}else if(4==unitcodeSize){
				//查询某个区县下的所有片区
				listgrid = gridService.selectGrid2info3(map);
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGrid2info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		// 新增通信客户日报
		@RequestMapping("/queryrgrid3gr1")
		@ResponseBody
		public JSONObject queryrgrid3gr1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid3.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(1==typeNum){
				listgrid = gridService.selectGrid3info1(map);
			}else if(2==typeNum){
				listgrid = gridService.selectGrid3info2(map);
			}else if(3==typeNum){
				listgrid = gridService.selectGrid3info3(map);
			}else if(4==typeNum){
				listgrid = gridService.selectGrid3info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
			
	    // 新增通信客户日报
		@RequestMapping("/queryrgrid3gr2")
		@ResponseBody
		public JSONObject queryrgrid3gr2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid3.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(2==unitcodeSize){
				//查询某个地市下的所有区县
				listgrid = gridService.selectGrid3info2(map);
			}else if(4==unitcodeSize){
				//查询某个区县下的所有片区
				listgrid = gridService.selectGrid3info3(map);
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGrid3info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		
		//4G客户净增日报
		@RequestMapping("/queryrgrid4gr1")
		@ResponseBody
		public JSONObject queryrgrid4gr1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid4.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(1==typeNum){
				listgrid = gridService.selectGrid4info1(map);
			}else if(2==typeNum){
				listgrid = gridService.selectGrid4info2(map);
			}else if(3==typeNum){
				listgrid = gridService.selectGrid4info3(map);
			}else if(4==typeNum){
				listgrid = gridService.selectGrid4info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
			
	    //4G客户净增日报
		@RequestMapping("/queryrgrid4gr2")
		@ResponseBody
		public JSONObject queryrgrid4gr2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid4.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(2==unitcodeSize){
				//查询某个地市下的所有区县
				listgrid = gridService.selectGrid4info2(map);
			}else if(4==unitcodeSize){
				//查询某个区县下的所有片区
				listgrid = gridService.selectGrid4info3(map);
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGrid4info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		//移动用户融合率日报
		@RequestMapping("/queryrgrid5gr1")
		@ResponseBody
		public JSONObject queryrgrid5gr1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/realgrid5.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(1==typeNum){
				listgrid = gridService.selectGrid5info1(map);
			}else if(2==typeNum){
				listgrid = gridService.selectGrid5info2(map);
			}else if(3==typeNum){
				listgrid = gridService.selectGrid5info3(map);
			}else if(4==typeNum){
				listgrid = gridService.selectGrid5info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
			
	    //移动用户融合率日报
		@RequestMapping("/queryrgrid5gr2")
		@ResponseBody
		public JSONObject queryrgrid5gr2(HttpServletRequest request,
				HttpServletResponse response) {
	
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext().getRealPath("file/realgrid5.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname =jsStr.getString("rowname");
			List<Kdgrid1> listgrid =null;
			if(2==unitcodeSize){
				//查询某个地市下的所有区县
				listgrid = gridService.selectGrid5info2(map);
			}else if(4==unitcodeSize){
				//查询某个区县下的所有片区
				listgrid = gridService.selectGrid5info3(map);
			}else if(7==unitcodeSize){
				//查询某个片区下的所有网格
				listgrid = gridService.selectGrid5info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		
		//语音出账收入日报
				@RequestMapping("/queryrgrid6gr1")
				@ResponseBody
				public JSONObject queryrgrid6gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid6.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid6info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid6info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid6info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid6info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //语音出账收入日报
				@RequestMapping("/queryrgrid6gr2")
				@ResponseBody
				public JSONObject queryrgrid6gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid6.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid6info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid6info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid6info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//新业务出账收入日报
				@RequestMapping("/queryrgrid7gr1")
				@ResponseBody
				public JSONObject queryrgrid7gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid7.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid7info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid7info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid7info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid7info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //新业务出账收入日报
				@RequestMapping("/queryrgrid7gr2")
				@ResponseBody
				public JSONObject queryrgrid7gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid7.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid7info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid7info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid7info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//新发展客户日报
				@RequestMapping("/queryrgrid8gr1")
				@ResponseBody
				public JSONObject queryrgrid8gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid8.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid8info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid8info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid8info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid8info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //新发展客户日报
				@RequestMapping("/queryrgrid8gr2")
				@ResponseBody
				public JSONObject queryrgrid8gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid8.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid8info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid8info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid8info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//通信客户净增日报
				@RequestMapping("/queryrgrid9gr1")
				@ResponseBody
				public JSONObject queryrgrid9gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid9.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid9info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid9info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid9info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid9info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //通信客户净增日报
				@RequestMapping("/queryrgrid9gr2")
				@ResponseBody
				public JSONObject queryrgrid9gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid9.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid9info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid9info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid9info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				
				//移动用户融合率日报
				@RequestMapping("/queryrgrid10gr1")
				@ResponseBody
				public JSONObject queryrgrid10gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid10.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid10info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid10info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid10info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid10info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //移动用户融合率日报
				@RequestMapping("/queryrgrid10gr2")
				@ResponseBody
				public JSONObject queryrgrid10gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid10.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid10info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid10info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid10info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				
				//话务量日报
				@RequestMapping("/queryrgrid11gr1")
				@ResponseBody
				public JSONObject queryrgrid11gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid11.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid11info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid11info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid11info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid11info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //话务量日报
				@RequestMapping("/queryrgrid11gr2")
				@ResponseBody
				public JSONObject queryrgrid11gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid11.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid11info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid11info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid11info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//家庭V网日报
				@RequestMapping("/queryrgrid12gr1")
				@ResponseBody
				public JSONObject queryrgrid12gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid12.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid12info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid12info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid12info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid12info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //家庭V网日报
				@RequestMapping("/queryrgrid12gr2")
				@ResponseBody
				public JSONObject queryrgrid12gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid12.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid12info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid12info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid12info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//大流量产品发展日报
				@RequestMapping("/queryrgrid13gr1")
				@ResponseBody
				public JSONObject queryrgrid13gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid13.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid13info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid13info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid13info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid13info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //大流量产品发展日报
				@RequestMapping("/queryrgrid13gr2")
				@ResponseBody
				public JSONObject queryrgrid13gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid13.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid13info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid13info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid13info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//通服权益包发展日报
				@RequestMapping("/queryrgrid14gr1")
				@ResponseBody
				public JSONObject queryrgrid14gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid14.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid14info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid14info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid14info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid14info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //通服权益包发展日报
				@RequestMapping("/queryrgrid14gr2")
				@ResponseBody
				public JSONObject queryrgrid14gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid14.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid14info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid14info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid14info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				
				//咪咕阅读发展日报
				@RequestMapping("/queryrgrid15gr1")
				@ResponseBody
				public JSONObject queryrgrid15gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid15.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid15info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid15info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid15info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid15info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕阅读发展日报
				@RequestMapping("/queryrgrid15gr2")
				@ResponseBody
				public JSONObject queryrgrid15gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid15.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid15info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid15info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid15info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				
				//咪咕视频发展日报
				@RequestMapping("/queryrgrid16gr1")
				@ResponseBody
				public JSONObject queryrgrid16gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid16.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid16info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid16info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid16info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid16info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕视频发展日报
				@RequestMapping("/queryrgrid16gr2")
				@ResponseBody
				public JSONObject queryrgrid16gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid16.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid16info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid16info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid16info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//净收入月报
				@RequestMapping("/queryrgrid17gr1")
				@ResponseBody
				public JSONObject queryrgrid17gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String dd = request.getParameter("datetime");
					String datetime = dd.replace("-", "").substring(0, 6);
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid17.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid17info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid17info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid17info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid17info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //净收入月报
				@RequestMapping("/queryrgrid17gr2")
				@ResponseBody
				public JSONObject queryrgrid17gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String dd = request.getParameter("datetime");
					String datetime = dd.replace("-", "").substring(0, 6);
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid17.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid17info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid17info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid17info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//净收入月报
				@RequestMapping("/queryrgrid18gr1")
				@ResponseBody
				public JSONObject queryrgrid18gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid18.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid18info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid18info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid18info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid18info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕视频发展日报
				@RequestMapping("/queryrgrid18gr2")
				@ResponseBody
				public JSONObject queryrgrid18gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid18.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid18info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid18info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid18info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//净收入月报
				@RequestMapping("/queryrgrid19gr1")
				@ResponseBody
				public JSONObject queryrgrid19gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid19.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid19info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid19info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid19info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid19info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕视频发展日报
				@RequestMapping("/queryrgrid19gr2")
				@ResponseBody
				public JSONObject queryrgrid19gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid19.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid19info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid19info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid19info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				
				//净收入月报
				@RequestMapping("/queryrgrid20gr1")
				@ResponseBody
				public JSONObject queryrgrid20gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid20.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid20info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid20info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid20info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid20info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕视频发展日报
				@RequestMapping("/queryrgrid20gr2")
				@ResponseBody
				public JSONObject queryrgrid20gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid20.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid20info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid20info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid20info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
				//净收入月报
				@RequestMapping("/queryrgrid21gr1")
				@ResponseBody
				public JSONObject queryrgrid21gr1(HttpServletRequest request,
						HttpServletResponse response) {
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String username = request.getParameter("username");
					User user = userService.findUserByUserName(username);
					Map<String,Object> map1 = userType(user);
					String unitcode = (String)map1.get("unitCode");
					int typeNum = (Integer) map1.get("typeNum");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					String path = request.getSession().getServletContext().getRealPath("file/realgrid21.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(1==typeNum){
						listgrid = gridService.selectGrid21info1(map);
					}else if(2==typeNum){
						listgrid = gridService.selectGrid21info2(map);
					}else if(3==typeNum){
						listgrid = gridService.selectGrid21info3(map);
					}else if(4==typeNum){
						listgrid = gridService.selectGrid21info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
					
			    //咪咕视频发展日报
				@RequestMapping("/queryrgrid21gr2")
				@ResponseBody
				public JSONObject queryrgrid21gr2(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String datetime = request.getParameter("datetime");
					String unitcode = request.getParameter("unitcode");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("datetime", datetime);
					map.put("unitcode", unitcode);
					int unitcodeSize = unitcode.length();
					String path = request.getSession().getServletContext().getRealPath("file/realgrid21.txt");
					String str = readfile(path);
					JSONObject jsStr = JSONObject.parseObject(str);
					String rowname =jsStr.getString("rowname");
					List<Kdgrid1> listgrid =null;
					if(2==unitcodeSize){
						//查询某个地市下的所有区县
						listgrid = gridService.selectGrid21info2(map);
					}else if(4==unitcodeSize){
						//查询某个区县下的所有片区
						listgrid = gridService.selectGrid21info3(map);
					}else if(7==unitcodeSize){
						//查询某个片区下的所有网格
						listgrid = gridService.selectGrid21info4(map);
					}
					JSONObject json = new JSONObject();
					json.put("data", listgrid);
					json.put("rowname", rowname);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
}
