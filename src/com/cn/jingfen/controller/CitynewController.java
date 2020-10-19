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
import com.cn.jingfen.service.CitynewService;
import com.cn.jingfen.util.Gridme;
import com.cn.jingfen.vo.AreaData;
import com.cn.jingfen.vo.CityData;
import com.cn.jingfen.vo.ProvinceData;

@Controller
public class CitynewController extends Gridme{
		@Autowired
		private CitynewService CitynewService;
		@RequestMapping("/querycity1")
		@ResponseBody
		public JSONObject queryCity1(HttpServletRequest request,
				HttpServletResponse response) {
			//list1放map map有三个元素，name，code，level。
			//让list1里的map 和list2相等。
			long startTime = System.currentTimeMillis();  
			JSONObject json = new JSONObject();
			List<Map<String, Object>> list4 =new ArrayList<>();
			Map<String,Object> map4 = new HashMap<>();
			map4.put("code", "0");
			map4.put("name", "无");
			map4.put("level", "0");
			list4.add(map4);
			List<Map<String, Object>> list1= new ArrayList<Map<String, Object>>();
			//查询数据库
			List<AreaData> aList = CitynewService.selectAreaData();
			for(int i=0; i<aList.size(); i++ ) {
			List<Map<String, Object>> list2= new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("code", aList.get(i).getCode());
			map1.put("name", aList.get(i).getName());
			Map<String, Object> amap = new HashMap<String, Object>();
			amap.put("codecity", aList.get(i).getCode());
			List<CityData> clist = CitynewService.selectCityData(amap);
			for(int j=0; j<clist.size();j++) {
				List<Map<String, Object>> list3= new ArrayList<Map<String, Object>>();
				Map<String,Object> map2 = new HashMap<String,Object>();
				map2.put("code", clist.get(j).getCode());
				map2.put("name", clist.get(j).getName());
				Map<String, Object>  cmap = new HashMap<String, Object>();
				cmap.put("codepro", clist.get(j).getCode());
				List<ProvinceData> plist = CitynewService.selectProvinceData(cmap);
				for (int k = 0; k < plist.size(); k++) {
					Map<String,Object> map3 = new HashMap<String,Object>();
					map3.put("code", plist.get(k).getCode());
					map3.put("name", plist.get(k).getName());
					map3.put("level", k);
					list3.add(map3);
				}
				if (list3.size()!=0) {
					map2.put("level", list3);
				}
				else {
					map2.put("level", list4);
				}
				list2.add(map2);
			}
			map1.put("level",list2);
			list1.add(map1);
			}
			json.put("node", list1);
			long endTime = System.currentTimeMillis(); 
			System.out.println("+++++++++");
			System.out.println(endTime-startTime);
			return json;
		}
		@RequestMapping("/queryCity2")
		@ResponseBody
		public JSONObject queryCity2(HttpServletRequest request,
				HttpServletResponse response) {
			String string ="C0";
			List<CityData> clist = CitynewService.selectCityData1(string);
			JSONObject json =new JSONObject();
			json.put("1", clist);
			return json;
		}
}
