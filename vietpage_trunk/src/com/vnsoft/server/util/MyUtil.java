package com.vnsoft.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUtil {
	public static void findText(List<String> findTexts) {
		try {
			FileReader f = new FileReader(new File("d:/server.txt"));
			BufferedReader in = new BufferedReader(f);
			String line = "";
			while (in.read() > 0) {
				int count =0;
				line = in.readLine();
				for(String text : findTexts){
					if(line.contains(text)){
						count ++;
					}
				}
				if(count == findTexts.size()){
					System.out.println(line);
				}
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void followZaloPage(File phoneNums, long pageId) {
		try {
			FileReader f = new FileReader(phoneNums);
			BufferedReader in = new BufferedReader(f);
			String phone = "";
			while (in.read() > 0) {
				phone = in.readLine();
				if(hasZaloId(phone)){
					followPage(pageId);
				}else{
					System.out.println(phone + " chua dung Zalo.");
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void followPage(long pageId) {
		// TODO Auto-generated method stub
		
	}
	private static boolean hasZaloId(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		MyUtil.findText(Arrays.asList(new String[]{"Mochi","appId:10084","00:07:35"}));
	}
}
