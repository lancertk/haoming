package com.cn.jingfen.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {

	//不可逆的加密

	 public static final String KEY_SHA = "SHA"; 
	  public static String getResult(String inputStr)
	  {
	    BigInteger sha =null;
	    System.out.println("=======加密前的数据:"+inputStr);
	    byte[] inputData = inputStr.getBytes(); 
	    try {
	       MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA); 
	       messageDigest.update(inputData);
	       sha = new BigInteger(messageDigest.digest()); 
	       System.out.println("SHA加密后:" + sha.toString()); 
	    } catch (Exception e) {e.printStackTrace();}
	    return sha.toString();
	  }
	  public static void main(String args[])
  {
		  
	  /*  try {
	       String inputStr = "ooo..."; 
	       getResult(inputStr);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }*/
	
	  
	  String  str ="-dvdsgegsdfegseg";
	  String  newstr= str.substring(str.length()-10, str.length());
	  System.out.println(newstr);
  }
}
