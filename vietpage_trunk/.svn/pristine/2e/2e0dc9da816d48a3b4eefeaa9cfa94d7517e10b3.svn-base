package com.vnsoft.server.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigurationHelper {
	private static ConfigurationHelper instance;
	Logger log = Logger.getLogger(ConfigurationHelper.class);
	private Properties config = null;
	public static ConfigurationHelper getInstance(){
		if(instance == null)
			instance = new ConfigurationHelper();
		
		return instance;
	}
	private ConfigurationHelper() {
		config = new Properties();
		try {
			config.load(new FileInputStream("production.properties"));
		} catch (FileNotFoundException e) {
			log.error("", e);
		} catch (IOException e) {
			log.error("", e);
		}
	}
	public String getValue(String key){
		return config.getProperty(key);
	}
}
