package com.cn.jingfen.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.cn.jingfen.util.Gridme;
import com.linkage.util.EncodeUtil;

public class Test extends Gridme{

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String pname="c3NvX3VzZXJuYW1lPVhJWU9VV0VJMSZNQUlOX0lEPVMwX3hpeW91d2VpMiZ0aWNrZT03ZDVmMTEwZS00ZDkyLTUzMjYyOEROazBBMzYyOVNWMUN5bk9mR3RiV1E9PQ==z&&&fb4";
	       // EncodeUtil encode=new EncodeUtil();
		String url1=EncodeUtil.decodeURL(pname);
		System.out.println("aaa="+EncodeUtil.enURLcode(url1));
		System.out.println("url1="+url1);
		
		String url11 = EncodeUtil.enURLcode(url1);
		System.out.println("bbb="+url11);
		String url = "sso_username=XIAOSA&MAIN_ID=S0_xiaosa&sso_ticket=44454==";
		String[] newStr_1 = split(url1, "&");
		String username=newStr_1[0].substring(newStr_1[0].indexOf("=")+1,newStr_1[0].length()).trim();
		String MAIN_ID=newStr_1[1].substring(newStr_1[1].indexOf("=")+1,newStr_1[1].length()).trim();
		String ticket=newStr_1[2].substring(newStr_1[2].indexOf("=")+1,newStr_1[2].length()).trim();
		System.out.println(username);
		System.out.println(MAIN_ID);
		System.out.println(ticket);
		
		//String pname="c3NvX3VzZXJuYW1lPUFETUlOJk1BSU5fSUQ9UzBfd2FuZ2NoZW5nJnRpY2tlPWMxMjg4YzViLWE1ZjYtMzc3MjkyMjVqNzcxRHAyZU1CNVRqQzNjTER3PT0mZnVuY19pZD1HUklEVVNFUkNFTExORVcwMg==z";
		
//		String pname="bG9naW5OYW1lPWFkbWluJk1BSU5fSUQ9YWRtaW4mdGlja2V0PWZhMGEyOGM1LTRhODMtODcyODY0bURodlRkd3lIU3ZPOVFlUGVnRkhKdz09z&&&700";
       // EncodeUtil encode=new EncodeUtil();
//		String url1=EncodeUtil.decodeURL(pname);
		System.out.println("url1="+url1);
		String aaa="dfdsfsd&jksdjfksd";
		//System.out.println(aaa.contains("&"));

	}

}
