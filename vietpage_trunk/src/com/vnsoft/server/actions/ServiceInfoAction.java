package com.vnsoft.server.actions;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;

public class ServiceInfoAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5621340794425358426L;
	private String content;
	private Logger logger = Logger.getLogger(ServiceInfoAction.class);
	@Override
	public String execute() {
		try {
//			init();
			if (AuthorizationInterceptor.EDIT.equals(getAction())) {
				CompanyBean.getInstance().updateServices(content, Integer.valueOf(getId()));
			}
		} catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
		}
		return super.execute();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
