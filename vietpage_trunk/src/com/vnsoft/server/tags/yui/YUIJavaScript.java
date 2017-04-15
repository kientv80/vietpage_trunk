package com.vnsoft.server.tags.yui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class YUIJavaScript {
	enum TYPE{TABLE}
	public static String getJavaScriptPattern(TYPE type){
		StringBuilder result = new StringBuilder();
		BufferedReader f = null;
		try {
			if(TYPE.TABLE.equals(type)){
				f = new BufferedReader(new FileReader(new File("table.js")));
				String sCurrentLine;
				while((sCurrentLine = f.readLine()) != null){
					result.append(sCurrentLine+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(f!=null)
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return result.toString();
	}
}
