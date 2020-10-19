package com.cn.jingfen.vo;

public class User {

	private String STAFF_ID;
	private String STAFF_NAME;
	//地市
	private String CITY_CODE; 
	//区县
	private String COUNTY_CODE;
	//片区
	private String VILLAGE_CODE;
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}
	public String getSTAFF_NAME() {
		return STAFF_NAME;
	}
	public void setSTAFF_NAME(String sTAFF_NAME) {
		STAFF_NAME = sTAFF_NAME;
	}
	
	public String getCITY_CODE() {
		return CITY_CODE;
	}
	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}
	public String getCOUNTY_CODE() {
		return COUNTY_CODE;
	}
	public void setCOUNTY_CODE(String cOUNTY_CODE) {
		COUNTY_CODE = cOUNTY_CODE;
	}
	public String getVILLAGE_CODE() {
		return VILLAGE_CODE;
	}
	public void setVILLAGE_CODE(String vILLAGE_CODE) {
		VILLAGE_CODE = vILLAGE_CODE;
	}

	
}
