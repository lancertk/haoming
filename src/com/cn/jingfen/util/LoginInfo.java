package com.cn.jingfen.util;

import java.io.Serializable;

/**
 * 登录信息bean
 * Copyright: Copyright (c) 2018  Asiainfo
 * @ClassName: LoginInfo.java
 * @Description: 
 * @version: v1.0.0
 * @author: baoyu
 * @date: 2018-10-23   下午2:38:47 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018-10-23      baoyu           v1.0.0               创建
 */
public final class LoginInfo implements Serializable {
    
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 2829108157461298302L;

    /**
     * 登录流水
     */
    private Long loginAccept;

    /**
     * 用户Id
     */
    private long userId;

    /**
     * 登录工号
     */
    private String loginName;
    /**
     * 密码
     */
    private String loginPwd;
	public Long getLoginAccept() {
		return loginAccept;
	}
	public void setLoginAccept(Long loginAccept) {
		this.loginAccept = loginAccept;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Override
	public String toString() {
		return "LoginInfo [loginAccept=" + loginAccept + ", userId=" + userId
				+ ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}

}
