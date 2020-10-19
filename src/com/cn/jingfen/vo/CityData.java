package com.cn.jingfen.vo;

import java.util.List;
import java.util.Map;

public class CityData {
	private String code;
	private String name;
	private String pid;
	private List<Map<String, Object>> level;
	
	
	public List<Map<String, Object>> getLevel() {
		return level;
	}
	public void setLevel(List<Map<String, Object>> level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
}
