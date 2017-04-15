package com.vnsoft.server;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.vnsoft.server.util.ConfigurationHelper;

public class TomcatServer {
	private static Logger logger = Logger.getLogger(TomcatServer.class);

	public static void main(String[] args) throws LifecycleException, ServletException {
		logger.info(">>>>>>>>>>>>>> Starting TomcatServer >>>>>>>>>...");
		PropertyConfigurator.configure(ConfigurationHelper.getInstance().getValue("log4j"));
		Tomcat t = new Tomcat();
		t.setHostname(ConfigurationHelper.getInstance().getValue("hostname"));
		t.setPort(Integer.valueOf(ConfigurationHelper.getInstance().getValue("port")));
		t.addWebapp("/", ConfigurationHelper.getInstance().getValue("appDir"));
		t.start();
		logger.info(">>>>>>>>>>>>>> Starting TomcatServer Successfully>>>>>>>>>...");
		t.getServer().await();

	}
}
