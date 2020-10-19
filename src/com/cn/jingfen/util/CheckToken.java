package com.cn.jingfen.util;

import org.json.JSONObject;

import com.alibaba.fastjson.JSONException;









/**
 * Created by Administrator on 2017/12/26 0026.
 */
public class CheckToken
{
public String checkToken(String token,String host){
		
		String url = "http://"+host+"/portal/sso-api/api/sso/checkToken";
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~url="+url);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~param=token="+token);
		String jsonStr = RestfulClient.doGet(url, "token="+token, "");
        //String userId = "";	
        String mainAccount = "";
        String res = "";
		try {
			JSONObject rootObj = new JSONObject(jsonStr);
			res = rootObj.getString("result");
			String userInfo = rootObj.get("userInfo").toString();
			JSONObject userObj = new JSONObject(userInfo);			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=res="+res);
			if("suc".equals(res)){
				//userId = userObj.getString("userId");
				mainAccount = userObj.getString("mainAccount");
			}else{
				//userId = "";
				mainAccount = "";
			}			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=mainAccount="+mainAccount);
			
		} catch (JSONException e1) {
			//userId = "";
			mainAccount = "";
			System.out.println(e1);
		}
		//return userId;
		return mainAccount;
	}	  
}
