package com.cn.jingfen.controller;


import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

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

import com.alibaba.druid.sql.ast.statement.SQLCreateViewStatement.Level;
import com.alibaba.fastjson.JSONObject;
import com.cn.jingfen.service.CityqxService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;

@Controller
public class cityqxController extends Gridme {
	@Autowired
	private CityqxService CityqxService;
	@RequestMapping("/querycity")
	@ResponseBody
	public JSONObject cityqx(HttpServletRequest request,
			HttpServletResponse response){
			JSONObject json = new JSONObject();
			List<AreaData> alist = CityqxService.selectArea();
			List<CityData> clist = CityqxService.selectCity();
			List<ProvinceData> plist = CityqxService.selectProvince();
			List<Map<String, Object>> list4 =new ArrayList<>();
			Map<String,Object> map4 = new HashMap<>();
			map4.put("code", "0");
			map4.put("name", "无");
			map4.put("level", "0");
			list4.add(map4);
			System.out.println(plist.size());
			
			List <Map<String, Object>> list1 = new ArrayList<>();
			for(int i=0;i<alist.size();i++) {
				Map<String,Object> map = new HashMap<>();
				map.put("code", alist.get(i).getCode());
				map.put("name", alist.get(i).getName());
				List <Map<String, Object>> list2 = new ArrayList<>();
				for(int j=0;j<clist.size();j++) {
					if (clist.get(j).getPid().equals(alist.get(i).getCode())){
						System.out.println("===============================");
						Map<String,Object> map1 = new HashMap<>();
						map1.put("code", clist.get(j).getCode());
						map1.put("name", clist.get(j).getName());
						List <Map<String, Object>> list3 = new ArrayList<>();
						for(int k=0;k<plist.size();k++) {
							if(plist.get(k).getPid().equals(clist.get(j).getCode())) {
								System.out.println("+++++++++++++++++++++++++++++");
								Map<String,Object> map2 = new HashMap<>();
								map2.put("code", plist.get(k).getCode());
								map2.put("name", plist.get(k).getName());
								map2.put("level", "1");
								list3.add(map2);
							}
								
						}
						if(list3.size()!=0){
						map1.put("level", list3);}
						else {
							map1.put("level", list4);
						}
						list2.add(map1);
					}
				}
				map.put("level", list2);
				list1.add(map);
			}
			json.put("node", list1);
			
			
		return json;
	}
	
	
	static List<Map<String, Object>> aaa() {
		return null;
		
	}
}
