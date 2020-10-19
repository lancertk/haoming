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
import com.cn.jingfen.service.GridqdService;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.Kdgrid1;
import com.cn.jingfen.vo.User;

@Controller
public class GridqdController extends Gridme {

		@Autowired
		private GridqdService gridService;
	
		@Autowired
		private UserService userService;

		//宽带发展日报
		@RequestMapping("/queryqd1grid1")
		@ResponseBody
		public JSONObject queryqd1grid1(HttpServletRequest request,
				HttpServletResponse response) {
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String, Object> map1 = userType(user);
			String unitcode = (String) map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid1.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (1 == typeNum) {
				listgrid = gridService.selectGrid1info1(map);
			} else if (2 == typeNum) {
				listgrid = gridService.selectGrid1info2(map);
			} else if (3 == typeNum) {
				listgrid = gridService.selectGrid1info3(map);
			} else if (4 == typeNum) {
				listgrid = gridService.selectGrid1info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}

		// 查看网格分类
		@RequestMapping("/queryqd1grid2")
		@ResponseBody
		public JSONObject queryqd1grid2(HttpServletRequest request,
				HttpServletResponse response) {
	
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid1.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (2 == unitcodeSize) {
				// 查询某个地市下的所有区县
				listgrid = gridService.selectGrid1info2(map);
			} else if (4 == unitcodeSize) {
				// 查询某个区县下的所有片区
				listgrid = gridService.selectGrid1info3(map);
			} else if (7 == unitcodeSize) {
				// 查询某个片区下的所有网格
				listgrid = gridService.selectGrid1info4(map);
			}else if (10 == unitcodeSize) {
				// 查询某个网格下的所有渠道
				listgrid = gridService.selectGrid1info5(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		
		//魔百和发展日报
		@RequestMapping("/queryqd2grid1")
		@ResponseBody
		public JSONObject queryqd2grid1(HttpServletRequest request,
				HttpServletResponse response) {
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String, Object> map1 = userType(user);
			String unitcode = (String) map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid2.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (1 == typeNum) {
				listgrid = gridService.selectGrid2info1(map);
			} else if (2 == typeNum) {
				listgrid = gridService.selectGrid2info2(map);
			} else if (3 == typeNum) {
				listgrid = gridService.selectGrid2info3(map);
			} else if (4 == typeNum) {
				listgrid = gridService.selectGrid2info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}

		// 查看网格分类
		@RequestMapping("/queryqd2grid2")
		@ResponseBody
		public JSONObject queryqd2grid2(HttpServletRequest request,
				HttpServletResponse response) {
	
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid2.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (2 == unitcodeSize) {
				// 查询某个地市下的所有区县
				listgrid = gridService.selectGrid2info2(map);
			} else if (4 == unitcodeSize) {
				// 查询某个区县下的所有片区
				listgrid = gridService.selectGrid2info3(map);
			} else if (7 == unitcodeSize) {
				// 查询某个片区下的所有网格
				listgrid = gridService.selectGrid2info4(map);
			}else if (10 == unitcodeSize) {
				// 查询某个网格下的所有渠道
				listgrid = gridService.selectGrid2info5(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
		//宽带装机日报
		@RequestMapping("/queryqd3grid1")
		@ResponseBody
		public JSONObject queryqd3grid1(HttpServletRequest request,
				HttpServletResponse response) {
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String, Object> map1 = userType(user);
			String unitcode = (String) map1.get("unitCode");
			int typeNum = (Integer) map1.get("typeNum");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid3.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (1 == typeNum) {
				listgrid = gridService.selectGrid3info1(map);
			} else if (2 == typeNum) {
				listgrid = gridService.selectGrid3info2(map);
			} else if (3 == typeNum) {
				listgrid = gridService.selectGrid3info3(map);
			} else if (4 == typeNum) {
				listgrid = gridService.selectGrid3info4(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}

		// 查看网格分类
		@RequestMapping("/queryqd3grid2")
		@ResponseBody
		public JSONObject queryqd3grid2(HttpServletRequest request,
				HttpServletResponse response) {
	
			// 判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String unitcode = request.getParameter("unitcode");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("datetime", datetime);
			map.put("unitcode", unitcode);
			int unitcodeSize = unitcode.length();
			String path = request.getSession().getServletContext()
					.getRealPath("file/qdgrid3.txt");
			String str = readfile(path);
			JSONObject jsStr = JSONObject.parseObject(str);
			String rowname = jsStr.getString("rowname");
			List<Kdgrid1> listgrid = null;
			if (2 == unitcodeSize) {
				// 查询某个地市下的所有区县
				listgrid = gridService.selectGrid3info2(map);
			} else if (4 == unitcodeSize) {
				// 查询某个区县下的所有片区
				listgrid = gridService.selectGrid3info3(map);
			} else if (7 == unitcodeSize) {
				// 查询某个片区下的所有网格
				listgrid = gridService.selectGrid3info4(map);
			} else if (10 == unitcodeSize) {
				// 查询某个网格下的所有渠道
				listgrid = gridService.selectGrid3info5(map);
			}
			JSONObject json = new JSONObject();
			json.put("data", listgrid);
			json.put("rowname", rowname);
			json.put("status", "success");
			json.put("message", "查询成功");
			return json;
		}
		
}
