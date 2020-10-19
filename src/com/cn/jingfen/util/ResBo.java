package com.cn.jingfen.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 服务响应结果
 * Copyright: Copyright (c) 2018  Asiainfo
 * @ClassName: ResBo.java
 * @Description: 
 * @version: v1.0.0
 * @author: baoyu
 * @date: 2018-10-23   下午2:45:10 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018-10-23      baoyu           v1.0.0               创建
 */
public class ResBo implements Serializable {

    /**
	 * 序列化串
	 */
	private static final long serialVersionUID = 8061238152400108017L;

	/**
     * 错误类型成功
     */
    public static final int ERROR_TYPE_SUCCESS = 0;

    /**
     * 错误类型系统异常
     */
    public static final int ERROR_TYPE_SYSTEM = 1;

    /**
     * 错误类型业务异常
     */
    public static final int ERROR_TYPE_BUSINESS= 2;

    /**
     * 是否成功
     */
    private boolean isSuccess = true;

    /**
     * 错误类型
     */
    private int errorType = ERROR_TYPE_SUCCESS;

    /**
     * 错误代码
     */
    private String errCd = "";

    /**
     * 错误信息
     */
    private String errMsg = "";

    /**
     * 参数Map
     */
    private Map<String, Object> resultMap = new HashMap<String, Object>();

    /**
     * <p>获取参数Map</p>
     * @return 响应Map
     */
    public Map<String, Object> getResultMap() {
        return this.resultMap;
    }

    /**
     * <p>添加响应参数</p>
     * @param paramKey 参数key
     * @param paramObject 参数值
     */
    public void addResult(String paramKey, Object paramObject) {
        resultMap.put(paramKey, paramObject);
    }

    /**
     * <p>获取参数</p>
     * @param paramKey 参数key
     * @return 参数值
     */
    public Object getResult(String paramKey) {
        return resultMap.get(paramKey);
    }

    /**
     * <p>获取服务调用是否成功</p>
     * @return 服务调用是否成功
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * <p>设置服务调用是否成功</p>
     * @param _isSuccess 服务调用结果
     */
    public void setSuccess(boolean _isSuccess) {
        this.isSuccess = _isSuccess;
    }

    /**
     * <p>获取错误编码</p>
     * @return 错误编码
     */
    public String getErrCd() {
        return errCd;
    }

    /**
     * <p>设置错误编码</p>
     * @param _errCd 错误编码
     */
    public void setErrCd(String _errCd) {
        this.errCd = _errCd;
    }

    /**
     * <p>获取错误信息</p>
     * @return 错误信息
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * <p>设置错误信息</p>
     * @param _errMsg 错误信息
     */
    public void setErrMsg(String _errMsg) {
        this.errMsg = _errMsg;
    }

    /**
     * 获取错误类型
     * @return
     */
    public int getErrorType() {
        return errorType;
    }

    /**
     * 获取错误类型
     * @param errorType
     */
    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    /**
     * <p>重写toString方法</p>
     * @return 错误信息
     */
    public String toString() {
        
    	StringBuffer paramMapStr = new StringBuffer("[");
		if(resultMap != null && resultMap.size() > 0){
			Iterator<String> it = resultMap.keySet().iterator();
			String key;
			while(it.hasNext()){
				key = it.next();
				paramMapStr.append("key=");
				paramMapStr.append(resultMap.get(key).toString());
				if(it.hasNext()){
					paramMapStr.append(", ");
				}
			}
			paramMapStr.append("]");
		}
    	
    	StringBuilder sb = new StringBuilder();
        sb.append("isSuccess=");
        sb.append(isSuccess);
        sb.append("|");
        sb.append("errorType=");
        sb.append(errorType);
        sb.append("|");
        sb.append("ErrorCode=");
        sb.append(errCd);
        sb.append("|");
        sb.append("errMsg=");
        sb.append(errMsg);
        sb.append("|resultMap=");
        sb.append(paramMapStr.toString());
        return sb.toString();
    }

	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
    
}
