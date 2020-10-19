package com.cn.jingfen.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 公共请求信息
 * 1、包含请求的基本信息 2、包含登录的用户信息 3、用户请求参数存放容器
 * Copyright: Copyright (c) 2018  Asiainfo
 * @ClassName: ReqBo.java
 * @Description: 
 * @version: v1.0.0
 * @author: baoyu
 * @date: 2018-10-23   下午2:44:17 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018-10-23      baoyu           v1.0.0               创建
 */
public class ReqBo implements Serializable {

    /**
	 * 序列化串
	 */
	private static final long serialVersionUID = 3443178255272901632L;

	/**
     * 登录工号信息
     */
    private LoginInfo loginInfo;

    /**
     * 操作信息
     */
    private OprInfo oprInfo;

    /**
     * 创建一个新的实例 ReqBo.
     */
    public ReqBo() {
        loginInfo = new LoginInfo();
        oprInfo = new OprInfo();
    }

    /**
     * 参数列表
     */
    private Map<String, Object> paramMap = new HashMap<String, Object>();

    /**
     * 获取参数列表
     * @return 参数列表
     */
    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    /**
     * 添加请求参数
     * @param paramKey 参数key
     * @param paramObject 参数值
     */
    public void addParam(String paramKey, Object paramObject) {
        paramMap.put(paramKey, paramObject);
    }

    /**
     * 获取参数
     * @param paramKey 参数key
     * @return 参数值
     */
    public Object getParam(String paramKey) {
        return paramMap.get(paramKey);
    }

    /**
     * 获取登录工号信息
     * @return 登录工号信息
     */
    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    /**
     * 设置登录工号信息
     * @param loginInfo  登录工号信息
     */
    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取工号操作信息
     * @return 工号操作信息
     */
    public OprInfo getOprInfo() {
        return oprInfo;
    }

    /**
     * 设置工号操作信息
     * @param oprInfo 工号操作信息
     */
    public void setOprInfo(OprInfo oprInfo) {
        this.oprInfo = oprInfo;
    }

	/**
	 * @param paramMap the paramMap to set
	 */
	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	@Override
	public String toString() {
		StringBuffer paramMapStr = new StringBuffer("[");
		if(paramMap != null && paramMap.size() > 0){
			Iterator<String> it = paramMap.keySet().iterator();
			String key;
			while(it.hasNext()){
				key = it.next();
				paramMapStr.append("key=");
				paramMapStr.append(paramMap.get(key).toString());
				if(it.hasNext()){
					paramMapStr.append(", ");
				}
			}
			paramMapStr.append("]");
		}
		return "ReqBo [loginInfo=" + loginInfo.toString() + ", oprInfo=" + oprInfo.toString()
				+ ", paramMap=" + paramMapStr.toString() + "]";
	}
	
	
    
}
