package com.cn.jingfen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.cn.jingfen.vo.User;

public class Gridme {
	//查看用户类型
		public static Map userType(User user){
			int typeNum;
			String unitCode;
			Map<String,Object> map = new HashMap<String,Object>();
			if(user.getCITY_CODE().equals("290")){
				//省用户
				typeNum=1;
				unitCode="290";
			}else if(user.getCOUNTY_CODE().equals("0000")){
				//地市用户
				typeNum=2;
				unitCode=user.getCITY_CODE();
			}else if(user.getVILLAGE_CODE().equals("00000")||user.getVILLAGE_CODE().equals("")||null==user.getVILLAGE_CODE()){
				//区县用户
				typeNum=3;
				unitCode=user.getCOUNTY_CODE();
			}else{
				//网格用户
				typeNum=4;
				unitCode=user.getVILLAGE_CODE();
			}
			map.put("typeNum", typeNum);
			map.put("unitCode", unitCode);
			return map;
			
		}
		
		
		public static String  readfile(String path) {
			
			
			StringBuffer str = new StringBuffer();
			try { 
		        String encoding="UTF-8"; 
		        File file=new File(path); 
		        if(file.isFile() && file.exists()){ //判断文件是否存在 
		          InputStreamReader read = new InputStreamReader( 
		          new FileInputStream(file),encoding);//考虑到编码格式 
		          BufferedReader bufferedReader = new BufferedReader(read); 
		          String lineTxt = null; 
		          while((lineTxt = bufferedReader.readLine()) != null){ 
		        	  str.append(lineTxt);
		          }
		          read.close(); 
		    }else{ 
		      System.out.println("找不到指定的文件"); 
		    } 
		    } catch (Exception e) { 
		      System.out.println("读取文件内容出错"); 
		      e.printStackTrace(); 
		    }
			return str.toString(); 
		}
		
		/** 分割字符串 */
	public	static String[] split(String str, String regex)
		{
			// 存放分割后的字符串
			String newStr[] = new String[str.length()];
			// 临时存放字符串数组的一个元素
			String temp = null;
			// 复制存放分割后的字符串
			String[] result = null;
			// 分隔符所在的下一个索引和当前索引
			int start = 0, end = 0;
			// 字符串数组的索引
			int index = 0;
			
			/** 遍历字符串的每一个字符 */
			for (int i = 0; i < str.length(); i++)
			{
				temp = str.substring(i, i + 1); // 截取一个字符
				// 判断截取的字符是否为分隔符
				if (temp.equals(regex))
				{
					temp = null;
					end = i; // 当前的分隔符的索引(字符串截取的最后位置)
					newStr[index] = str.substring(start, end); // 截取字符串并赋值给字符串数组
					index++;  // 字符串数组索引加1
					start = end + 1; // 当前的分隔符的索引后一索引(字符串截取的开始位置)
				}
			}

			// 最后一个分隔符的索引不等于字符串长度
			if (str.lastIndexOf(regex) != str.length())
			{
				newStr[index] = str.substring(start, str.length());
				index++;
			}
			result = new String[index];
			// 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束
			System.arraycopy(newStr, 0, result, 0, index);
			return result;
		}

}
