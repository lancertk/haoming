package com.cn.jingfen.util;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作信息bean
 * Copyright: Copyright (c) 2018  Asiainfo
 * @ClassName: OprInfo.java
 * @Description: 
 * @version: v1.0.0
 * @author: baoyu
 * @date: 2018-10-23   下午2:43:15 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018-10-23      baoyu           v1.0.0               创建
 */
public final class OprInfo implements Serializable {

    /**
	 * 序列化
	 */
	private static final long serialVersionUID = -8477237878611872928L;

	/**
     * 操作流水
     */
    private Long opAccept;

    /**
     * 操作代码
     */
    private String opCode;

    /**
     * 操作名称
     */
    private String opName;

    /**
     * 操作类型
     */
    private String opType;

    /**
     * 操作时间
     */
    private Date opTime;

    /**
     * 操作信息
     */
    private String opMsg;

    /**
     * 创建一个新的实例 OprInfo.
     * <p>操作时间取当前系统时间</p>
     */
    public OprInfo() {
        opTime = new Date();
    }

    /**
     * 获取操作代码
     * @return opCode 操作代码
     * @throws
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * 设置操作代码
     * @param  opCode 操作代码
     * @return
     * @throws
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    /**
     * 获取操作名称
     * @return opName 操作名称
     * @throws
     */
    public String getOpName() {
        return opName;
    }

    /**
     * 设置操作名称
     * @param  opName 操作名称
     * @return
     * @throws
     */
    public void setOpName(String opName) {
        this.opName = opName;
    }

    /**
     * 获取操作类型
     * @return opType 操作类型
     * @throws
     */
    public String getOpType() {
        return opType;
    }

    /**
     * 设置操作类型
     * @param  opType 操作类型
     * @return
     * @throws
     */
    public void setOpType(String opType) {
        this.opType = opType;
    }

    /**
     * 获取操作时间
     * @param
     * @return opTime 操作时间
     * @throws
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * 设置操作时间
     * @param  opTime 操作时间
     * @return
     * @throws
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 获取操作信息
     * @return opMsg 操作信息
     * @throws
     */
    public String getOpMsg() {
        return opMsg;
    }

    /**
     * 设置操作信息
     * @param  opMsg 操作信息
     * @return
     * @throws
     */
    public void setOpMsg(String opMsg) {
        this.opMsg = opMsg;
    }

    /**
     * 获取操作流水
     * @return opAccept 操作流水
     * @throws
     */
    public Long getOpAccept() {
        return opAccept;
    }

    /**
     * 设置操作流水
     * @param  opAccept 操作流水
     * @return
     * @throws
     */
    public void setOpAccept(Long opAccept) {
        this.opAccept = opAccept;
    }

	@Override
	public String toString() {
		return "OprInfo [opAccept=" + opAccept + ", opCode=" + opCode
				+ ", opName=" + opName + ", opType=" + opType + ", opTime="
				+ opTime + ", opMsg=" + opMsg + "]";
	}
    
}
