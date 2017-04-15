package com.vnsoft.server.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7117986192738583251L;
	Integer id;
	private Integer menuId;
	String name;
	String description;
	Double price;
	String imagePath;
	private boolean ismain;
	private String menuName;
	private long comId;
	private boolean isDiscount;
	private int discountPercent;
	private Double priceAfterDiscount;
	private String companyName;
	private String companyUrl;
	private String code;
	private boolean isCargo;
	String address;
	String phone;
	int goodCount;
	int quiteGoodCount;
	int mediumCount;
	int weakCount;
	private int viewCount;
	private int companyRating;
	private String goodcmts;
	private String quitegoodcmts;
	private String mediumcmts;
	private String weakcmts;
	private String thumbImage;

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

	public int getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}

	public int getQuiteGoodCount() {
		return quiteGoodCount;
	}

	public void setQuiteGoodCount(int quiteGoodCount) {
		this.quiteGoodCount = quiteGoodCount;
	}

	public int getMediumCount() {
		return mediumCount;
	}

	public void setMediumCount(int mediumCount) {
		this.mediumCount = mediumCount;
	}

	public int getWeakCount() {
		return weakCount;
	}

	public void setWeakCount(int weakCount) {
		this.weakCount = weakCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean getIsmain() {
		return ismain;
	}

	public void setIsmain(boolean ismain) {
		this.ismain = ismain;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public long getComId() {
		return comId;
	}

	public void setComId(long comId) {
		this.comId = comId;
	}

	public boolean getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getGoodAssessmentPercent() {
		int sum = goodCount + quiteGoodCount + mediumCount + weakCount;
		if (sum != 0)
			return (goodCount * 100) / sum;
		else
			return 0;
	}

	public int getQuiteGoodAssessmentPercent() {
		int sum = goodCount + quiteGoodCount + mediumCount + weakCount;
		if (sum != 0)
			return (quiteGoodCount * 100) / sum;
		else
			return 0;
	}

	public int getMediumAssessmentPercent() {
		int sum = goodCount + quiteGoodCount + mediumCount + weakCount;
		if (sum != 0)
			return (mediumCount * 100) / sum;
		else
			return 0;
	}

	public int getWeakAssessmentPercent() {
		int sum = goodCount + quiteGoodCount + mediumCount + weakCount;
		if (sum != 0)
			return (weakCount * 100) / sum;
		else
			return 0;
	}

	@Override
	public String toString() {
		String content = "";
		content = getName() + ":" + getDescription();
		if (isCargo) {
			content = content + " " + getPrice() + "(VND):";
			if (isDiscount) {
				content = content + " giảm giá " + getDiscountPercent() + " %" + " giá mới " + getPriceAfterDiscount() + "(VND)";
			}
		}
		return content;
	}

	public boolean getIsCargo() {
		return isCargo;
	}

	public void setIsCargo(boolean isCargo) {
		this.isCargo = isCargo;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getCompanyRating() {
		return companyRating;
	}

	public void setCompanyRating(int companyRating) {
		this.companyRating = companyRating;
	}

	public String getGoodcmts() {
		return goodcmts;
	}

	public void setGoodcmts(String goodcmts) {
		this.goodcmts = goodcmts;
	}

	public String getQuitegoodcmts() {
		return quitegoodcmts;
	}

	public void setQuitegoodcmts(String quitegoodcmts) {
		this.quitegoodcmts = quitegoodcmts;
	}

	public String getMediumcmts() {
		return mediumcmts;
	}

	public void setMediumcmts(String mediumcmts) {
		this.mediumcmts = mediumcmts;
	}

	public String getWeakcmts() {
		return weakcmts;
	}

	public void setWeakcmts(String weakcmts) {
		this.weakcmts = weakcmts;
	}

	public String getThumbImage() {
		if (thumbImage != null)
			return thumbImage;
		else
			return imagePath;
	}

	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			if(((Item)(obj)).getId().intValue()==this.getId().intValue())
				return true;
		}
		return false;
	}
}
