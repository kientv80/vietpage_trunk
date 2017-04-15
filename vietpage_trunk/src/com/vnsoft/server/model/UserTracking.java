package com.vnsoft.server.model;

public class UserTracking {
	private long createNewUserCount;
	private long userLoginCount;
	private String id;
	public long getCreateNewUserCount() {
		return createNewUserCount;
	}
	public void setCreateNewUserCount(long createNewUserCount) {
		this.createNewUserCount = createNewUserCount;
	}
	public long getUserLoginCount() {
		return userLoginCount;
	}
	public void setUserLoginCount(long userLoginCount) {
		this.userLoginCount = userLoginCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
