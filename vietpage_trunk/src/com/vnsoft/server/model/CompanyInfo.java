package com.vnsoft.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompanyInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7382355275147129930L;
	long id;
	private String headerImage;
	private String contentImage;
	private String url;
	private String name;
	private String service;
	private String description;
	private String username;
	private String password;
	private String mapImage = "";
	private int locationId;
	private int serviceTypeId;
	private String address;
	private String phone;
	private boolean ispublish;
	private boolean isapproved;
	private boolean isReview;
	private String email;
	private int ownerId;
	private int maxItem;
	private String about;
	private int companyRating;
	private String thumImage;
	private String thumbHeaderImage;
	private String news;
	private List<Address> addresses = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContentImage() {
		return contentImage;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMapImage() {
		return mapImage;
	}

	public void setMapImage(String mapImage) {
		this.mapImage = mapImage;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}

	public boolean getIspublish() {
		return ispublish;
	}

	public void setIspublish(boolean ispublish) {
		this.ispublish = ispublish;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public boolean getIsReviewed() {
		return isReview;
	}

	public void setIsReviewed(boolean isReview) {
		this.isReview = isReview;
	}

	public int getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public int getCompanyRating() {
		return companyRating;
	}

	public void setCompanyRating(int companyRating) {
		this.companyRating = companyRating;
	}

	@Override
	public String toString() {
		String desc = description;
		if (description != null && description.length() > 100)
			desc = description.substring(0, 100);
		return desc;
	}

	public String getThumImage() {
		if (thumImage != null)
			return thumImage;
		else
			return contentImage;
	}

	public void setThumImage(String thumImage) {
		this.thumImage = thumImage;
	}

	public String getThumbHeaderImage() {
		if (thumbHeaderImage != null)
			return thumbHeaderImage;
		else
			return headerImage;
	}

	public void setThumbHeaderImage(String thumbHeaderImage) {
		this.thumbHeaderImage = thumbHeaderImage;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompanyInfo) {
			CompanyInfo tmp = (CompanyInfo) obj;
			if(tmp.id == this.getId())
				return true;
			else
				return false;
		}
		return super.equals(obj);
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
}
