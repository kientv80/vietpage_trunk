package com.vnsoft.server.model;

import java.io.Serializable;

public class About implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1735151977038486404L;
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
