package com.vnsoft.server.model;

import java.util.Date;

public class HotNews {
	private long id;
	private String link;
	private String title;
	private String content;
	private String thume;
	private Date createdData;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThume() {
		return thume;
	}
	public void setThume(String thume) {
		this.thume = thume;
	}
	public Date getCreatedData() {
		return createdData;
	}
	public void setCreatedData(Date createdData) {
		this.createdData = createdData;
	}
}
