package com.vnsoft.server.model;

import java.io.Serializable;

public class Service implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7868372151967853671L;
	long comid;
	String content;
	
	public long getComid() {
		return comid;
	}
	public void setComid(long comid) {
		this.comid = comid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
