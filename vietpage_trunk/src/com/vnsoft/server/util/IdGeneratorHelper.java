package com.vnsoft.server.util;

public class IdGeneratorHelper {
	static String lock = "";
	public static long getGenId(){
		synchronized (lock) {
			long currentId = System.nanoTime();
			return currentId;
		}
	}
}
