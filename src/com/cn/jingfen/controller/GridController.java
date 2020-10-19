package com.cn.jingfen.controller;
import java.util.ArrayList;
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
import com.cn.jingfen.service.GridService;
import com.cn.jingfen.service.UserService;
import com.cn.jingfen.util.CheckToken;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.Grid;
import com.cn.jingfen.vo.Kdgrid1;
import com.cn.jingfen.vo.User;
import com.linkage.securer.client.CResult;
import com.linkage.securer.client.Client;
import com.linkage.util.EncodeUtil;


@Controller
public class GridController extends Gridme{
	
	@Autowired
	private GridService gridService;
	
	@Autowired
	private UserService userService;
	
	//验证4A
	@RequestMapping("/query4Alogin")
	@ResponseBody
	public JSONObject query4Alogin(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String username="BIANFENGSHUO"; //从账户
		User user = userService.findUserByUserName(username);
		json.put("username", username);
		json.put("user",user);  //为了拿到citycode
		
		StringBuffer sb = new StringBuffer();
		sb.append("username="+username);
		
		json.put("sss", sb.toString());
		try {
			if (username!=null) {
				System.out.println("++++++认证通过++++++");
				json.put("result4a", "true");
				json.put("msg", "认证通过");
			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}

		return json;
	}
	
	//验证4A
		@RequestMapping("/query4Alogin111")
		@ResponseBody
		public JSONObject query4Alogin111(HttpServletRequest request,
				HttpServletResponse response) {
			JSONObject json = new JSONObject();
			//String ip = request.getRemoteAddr();
			String ip ="";  //客戶段IP
			String username=""; //从账户
			String MAIN_ID="";  //4A帐号
			String ticket="";   //票据
			String fromTag="";  //请求来源
			String path = this.getClass().getClassLoader().getResource("").getPath();
			//String path = str.substring(1, str.length());
			String pname=request.getParameter("pname");
			String url=EncodeUtil.decodeURL(pname);
			
			if((!("".equals(url)))&&(url.contains("&"))){
				String[] newStr_1 = split(url, "&");
				if(4==newStr_1.length){
					fromTag = newStr_1[3].substring(newStr_1[3].indexOf("=")+1,newStr_1[3].length()).trim();
					ip = "127.225.3.4";
				}else{
					ip = request.getRemoteAddr();
				}
				
				username=newStr_1[0].substring(newStr_1[0].indexOf("=")+1,newStr_1[0].length()).trim();
				MAIN_ID=newStr_1[1].substring(newStr_1[1].indexOf("=")+1,newStr_1[1].length()).trim();
				ticket=newStr_1[2].substring(newStr_1[2].indexOf("=")+1,newStr_1[2].length()).trim();
			}
			System.out.println("***************path="+path);
			System.out.println("***************pname="+pname);
			System.out.println("***************username="+username);
			System.out.println("***************MAIN_ID="+MAIN_ID);
			System.out.println("***************ticket="+ticket);
			System.out.println("***************ip="+ip);
			System.out.println("***************fromTag="+fromTag);
			User user = userService.findUserByUserName(username);
			if(null!=user){
				json.put("username", username);
				json.put("user",user);  //为了拿到citycode
			}else{
				json.put("username", "");
			}
			StringBuffer sb = new StringBuffer();
			sb.append("username="+username);
			sb.append("MAIN_ID="+MAIN_ID);
			sb.append("ticket="+ticket);
			sb.append("path="+path);
			sb.append("ip="+ip);
			sb.append("fromTag="+fromTag);
			json.put("sss", sb.toString());
			try {
				if (ticket != null) {
					// 这里用相对路经
					Client client = Client.getInstance(path);
					CResult result = client.doSSO(MAIN_ID,username, ticket, "10.131.34.136",
							9999, ip);
					System.out.println("********************认证开始***********************");
					if (result.getResultCode() == 0) {
						System.out.println("++++++认证通过++++++");
						json.put("result4a", "true");
						json.put("msg", result.getResultMsg());
					} else if (result.getResultCode() == -1) {
						System.out.println("认证不通过！原因："+result.getResultMsg());
						json.put("result4a", "false");
						json.put("msg", result.getResultMsg());
					} else {
						System.out.println("认证不通过！原因：" + result.getResultMsg());
						json.put("result4a", "false");
						json.put("msg", result.getResultMsg());
					}
					System.out.println("********************认证结束***********************");

				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			return json;
		}
	
	
	//手机经分验证
		@RequestMapping("/querybyname")
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
		
	//新门户验证
		@RequestMapping("/checkNewDoor")
		@ResponseBody
		public JSONObject checkNewDoor(HttpServletRequest request,
				HttpServletResponse response) {
			String host =  "10.131.117.212:8888";
		    String token = request.getParameter("token");
		    //CheckToken cT = new CheckToken();
		    //String user_id=cT.checkToken(token,host);//调用新门户方法通过token拿到userid
		    String user_id = "BIANFENGSHUO";
		    User user = null;
		    JSONObject json = new JSONObject();
		    if(null!=user_id){
				user = userService.findUserByUserName(user_id);
			}
		    if(null!=user){
				json.put("result", "success");
				json.put("msg", "用户存在");				
				//将user对象返回，为了拿到citycode。
				json.put("user",user);
			}else{
				json.put("result", "fail");
				json.put("msg", "用户不存在");				
			}
		    
		    return json;
		}
		
		//新门户验证
				@RequestMapping("/checkNewDoor666")
				@ResponseBody
				public JSONObject checkNewDoor666(HttpServletRequest request,
						HttpServletResponse response) {
					String host =  "10.131.117.212:8888" ;
				    String token = request.getParameter("token");
				    CheckToken cT = new CheckToken();
				    String user_id=cT.checkToken(token,host);//调用新门户方法通过token拿到userid
				    User user = null;
				    JSONObject json = new JSONObject();
				    if(null!=user_id){
						user = userService.findUserByUserName(user_id);
					}
				    if(null!=user){
						json.put("result", "success");
						json.put("msg", "用户存在");				
						//将user对象返回，为了拿到citycode。
						json.put("user",user);
					}else{
						json.put("result", "fail");
						json.put("msg", "用户不存在");				
					}
				    
				    return json;
				}

	//查看网格分类
		@RequestMapping("/querygrid")
		@ResponseBody
		public JSONObject querygrid(HttpServletRequest request,HttpServletResponse response){
			int typeNum = 0;
			List<Map> listdata = new ArrayList<Map>();
			List list = gridService.selctGridType();
			List<Grid> listgrid = gridService.selectAllGrid();
			JSONObject json = new JSONObject();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("gridtype", list);
			map.put("listgrid", listgrid);
			listdata.add(map);
			json.put("data",listdata);
			json.put("status","success");
			json.put("message","查询成功");
			return json;
		}
		
		// 查看网格分类
		@RequestMapping("/querygrid1")
		@ResponseBody
		public JSONObject querygrid1(HttpServletRequest request,
				HttpServletResponse response) {
			//判断该用户是啥类型
			String datetime = request.getParameter("datetime");
			String username = request.getParameter("username");
			User user = userService.findUserByUserName(username);
			Map<String,Object> map1 = userType(user);
			String unitcode = (String)map1.get("unitCode");
			int typeNum = (Integer)map1.get("typeNum");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("datetime", datetime);
			//map.put("username", username);
			map.put("unitcode", unitcode);
			String path = request.getSession().getServletContext().getRealPath("file/grid1.txt");
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
	
		// 查看网格分类
		@RequestMapping("/querygrid2")
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
			String path = request.getSession().getServletContext().getRealPath("file/grid1.txt");
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
		
		// 查看网格分类
				@RequestMapping("/queryrefreshtime")
				@ResponseBody
				public JSONObject queryrefreshtime(HttpServletRequest request,
						HttpServletResponse response) {
			
					//判断该用户是啥类型
					String func_id = request.getParameter("func_id");
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("func_id", func_id);
					List list = gridService.selectrefreshtime(map);					
					JSONObject json = new JSONObject();
					json.put("refreshtime", list);
					json.put("status", "success");
					json.put("message", "查询成功");
					return json;
				}
				
	
			
			
	
}
