package com.vnsoft.server.model;

import java.io.Serializable;
import java.util.Date;

public class Comment  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3165408235519034921L;
	int id;
	int comid;
	String content;
	private String postedBy;
	private String emailOfPoster;
	private Date postedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getEmailOfPoster() {
		return emailOfPoster;
	}
	public void setEmailOfPoster(String emailOfPoster) {
		this.emailOfPoster = emailOfPoster;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
}
