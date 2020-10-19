package com.cn.jingfen.util;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public  class RandomFor {

	public static int Rand(){
		
		Random ran=new Random();
		int r=0;
		m1:while(true){
		    int n=ran.nextInt(10000);
		    r=n;
		    int[] bs=new int[4];
		    for(int i=0;i<bs.length;i++){
		        bs[i]=n%10;
		        n/=10;
		    }
		    Arrays.sort(bs);
		    for(int i=1;i<bs.length;i++){
		        if(bs[i-1]==bs[i]){
		            continue m1;
		        }
		    }
		    break;
		}
		
		return r;
		
	}
	
	
	private  static String getUURandom(){
	       UUID uuid=UUID.randomUUID();
	        String str = uuid.toString(); 
	        String uuidStr=str.replace("-", "");
		
		return uuidStr;
	}
	
	
	public static void main(String[] args) {
		String s=RandomFor.getUURandom();
		System.out.println(s);
	/*	int r=RandomFor.Rand();
		System.out.println(r);*/
	/*String s=	RandomFor.getUUID();
		
		System.out.println(s);*/
    /*    UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
     System.out.println(uuidStr);*/
		
		
	}
}
