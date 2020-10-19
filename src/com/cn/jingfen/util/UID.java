package com.cn.jingfen.util;

import java.util.UUID;

public class UID {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}

	public static void main(String[] args) {
		System.out.println(UID.getUUID());
	}

}
