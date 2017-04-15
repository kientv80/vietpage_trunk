package com.vnsoft.server.model;

import java.io.Serializable;

public class ContactInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7596310629625943478L;
	private long comId;
	private String phone;
	private String email;
	private String address;
	private String info;
	
	public long getComId() {
		return comId;
	}
	public void setComId(long comId) {
		this.comId = comId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	
}
