package com.cn.jingfen.util;

import com.linkage.bace.dt.StringTools;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;



/**
 * Created by Administrator on 2017/12/26 0026.
 */
public class RestfulClient
{
	private static Logger logger = Logger.getLogger(RestfulClient.class);

	/**
	 * http post方式请求
	 * @param url
	 * @param paramList
	 * @param userId
	 * 发出请求的用户编码，便于出问题的时候调试
	 * @return
	 */
//	public static String doPost(String url, List<com.asiainfo.prd.sptl.common.NameValuePair> paramList, String userId){
//		if(StringTools.isNotEmpty(userId)) {
//			userId = "["+userId+"]";
//		}else {
//			userId = "";
//		}
//		logger.info(userId + "开始请求:" + url+",时间戳:"+System.currentTimeMillis());
//		String res = "";
//		CloseableHttpClient client = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		post.setConfig(RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(60000).build());
//		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//		if(null!= paramList){
//			for(com.asiainfo.prd.sptl.common.NameValuePair pairBean : paramList){
//				logger.info(userId + "参数：key="+pairBean.getName()+",value="+pairBean.getValue());
//				formparams.add(new BasicNameValuePair(pairBean.getName(),pairBean.getValue()));
//			}
//		}
//		try {
//			post.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
//			HttpResponse response = client.execute(post);
//			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				HttpEntity entity = response.getEntity();
//				res = EntityUtils.toString(entity, "UTF-8");
//			}else{
//				logger.error(userId + "请求失败:" + url+", "+response.getStatusLine().getStatusCode());
//			}
//
//		} catch (Exception e) {
//			logger.error(e.toString(),e);
//		} finally {
//			if(client != null) {
//				try {
//					client.close();
//				} catch (Exception e) {
//					logger.error(e.toString(),e);
//				}
//			}
//		}
//		logger.info(userId + "请求返回:" + url+",时间戳:"+System.currentTimeMillis());
//		logger.info(userId + "res="+res);
//		return res;
//	}

	/**
	 * http get方式请求,url和param分开传，传入的param参数不需要URLEncoder，方法内会进行URLEncoder
	 * @param url
	 *	不包含参数信息
	 * @param param
	 * 不需要加问号，不需要URLEncoder，方法内会进行URLEncoder
	 * @param userId
	 * 发出请求的用户编码，便于出问题的时候调试
	 * @return
	 */
	public static String doGet(String url, String param,String userId){
		if(StringTools.isNotEmpty(userId)) {
			userId = "[" + userId+ "]";
		}else {
			userId = "";
		}
		logger.info(userId + "开始请求:" + url+",timestamp:"+System.currentTimeMillis());
		logger.info(userId + "param:" + param);
		String res = "";
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			if(StringTools.isNotEmpty(param)) {
				url += "?" + param;
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(10000).build());
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity());
            } else {
                logger.error(userId+"请求失败:" + url+", "+response.getStatusLine().getStatusCode());
            }
		} catch (Exception e) {
			logger.error(e.toString(),e);
		} finally {
			if(client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error(e.toString(),e);
				}
			}
		}
		logger.info(userId+"请求返回:" + url+",时间戳:"+System.currentTimeMillis());
		logger.info(userId+"res="+res);
		return res;
	}
	
	public static String doGetForStaff(String url, String param,String userId){
		if(StringTools.isNotEmpty(userId)) {
			userId = "[" + userId+ "]";
		}else {
			userId = "";
		}
		logger.info(userId + "开始请求:" + url+",timestamp:"+System.currentTimeMillis());
		logger.info(userId + "param:" + param);
		String res = "";
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			if(StringTools.isNotEmpty(param)) {
				url += "?" + param;
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(10000).build());
			HttpResponse response = client.execute(get);
			
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				//res = EntityUtils.toString(response.getEntity());
				res = response.getHeaders("result")[0].getValue();
            } else {
                logger.error(userId+"请求失败:" + url+", "+response.getStatusLine().getStatusCode());
            }
		} catch (Exception e) {
			logger.error(e.toString(),e);
		} finally {
			if(client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error(e.toString(),e);
				}
			}
		}
		logger.info(userId+"请求返回:" + url+",时间戳:"+System.currentTimeMillis());
		logger.info(userId+"res="+res);
		return res;
	}		
	
	public static void main(String []a) {
		//System.out.println(doGet("http://www.baidu.com","tocken=2","ADMIN"));
		//System.out.println("1111111111111");
		//http://10.131.117.212:8888/portal/sxydbq-api/sync/syncUser
		//System.out.println(doGet("http://10.131.117.212:8888/sxydbq-api/sync/syncRole","jobId=1564727170659&flag=1","ADMIN"));
		System.out.println(doGet("http://10.131.117.212:8888/portal/sxydbq-api/sync/syncUser","staffId=LIUCEN1&flag=1","ADMIN"));
	}

}
