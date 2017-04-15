package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vnsoft.server.actions.StandarLayout.UPLOAD_OBJECT;
import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.Item;

public class ManageMenuItemAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 131946202203004582L;
	private String itemImage;
	private String name;
	private String desc;
	private String price;
	private List<Item> items = new ArrayList<>();
	private String buttons = "";
	private String ismain;
	private String selectedMenuId;
	private String targetUrl;
	private String discount;
	private String discountPercent;
	private String discountPrice;
	private String code;
	private String isCargo;
	private Logger logger = Logger.getLogger(ManageMenuItemAction.class);
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static String imagePath = null;

	public String execute() {
		buttons = "";
		try {
			if (getComId() == null || getComId().isEmpty()) {
				return "nocompanyid";
			}
			System.out.println("ManageMenuItemAction actionnnnn " + getAction());
			if ("POST".equalsIgnoreCase(getHttpServletRequest().getMethod())) {

				if (AuthorizationInterceptor.EDIT.equals(getAction())) {
					errorMessage = validateData();
					if (errorMessage == null) {
						String fileName = "item_" + Calendar.getInstance().getTimeInMillis() + ".jpg";//itemImage.substring(itemImage.lastIndexOf(imageSeperator) + 1, itemImage.length());
						Map<String,String> itemImages = null;
						if (file != null)
							itemImages = uploadFile(fileName, getComId(),UPLOAD_OBJECT.ITEM);

						System.out.println("itemImage " + itemImage);
						Item item = new Item();
						item.setName(name);
						item.setDescription(desc);
						item.setMenuId(Integer.valueOf(selectedMenuId));
						if(isCargo != null && isCargo.equals("true")){
							item.setIsCargo(true);
							item.setPrice(Double.valueOf(price));
						}else{
							item.setIsCargo(false);
						}
						if(itemImages != null){
							item.setImagePath(itemImages.get("image"));
							item.setThumbImage(itemImages.get("thumbnail"));
						}

						item.setCode(getCode());
						if (getId() != null && !getId().isEmpty())
							item.setId(Integer.valueOf(getId()));
						if ("true".equals(getIsmain()))
							item.setIsmain(true);
						else
							item.setIsmain(false);
						if ("true".equals(discount) && discountPrice != null && !discountPrice.isEmpty() && discountPercent != null && !discountPercent.isEmpty()) {
							item.setIsDiscount(true);
							item.setPriceAfterDiscount(Double.valueOf(discountPrice));
							item.setDiscountPercent(Integer.valueOf(discountPercent));
						} else {
							item.setIsDiscount(false);
							item.setPriceAfterDiscount(0d);
							item.setDiscountPercent(0);
						}
						item.setComId(Long.valueOf(getComId()));
						if(isCargo != null && isCargo.equals("true")){
							item.setIsCargo(true);
						}else{
							item.setIsCargo(false);
						}
						MenuBean.getInstance().updateMenuItem(item);
					}
				} else if ("new".equals(getAction())) {
					errorMessage = validateData();
					logger.debug("errorMessage=" + errorMessage);
					if (errorMessage == null) {
						CompanyInfo com = (CompanyInfo) getHttpServletRequest().getSession(true).getAttribute(LoginAction.COMPANY_INFO);
						if (isNumber(getComId()) && CompanyBean.getInstance().getCurrentItemNum(Long.valueOf(getComId())) <= com.getMaxItem()) {
							logger.debug("create item -> upload image");
							String ext = "jpg";
							Map<String,String> itemImages = uploadFile("item_" + Calendar.getInstance().getTimeInMillis() + "." + ext, getComId(),UPLOAD_OBJECT.ITEM);
							logger.debug("create item -> END upload image");
							Item item = new Item();
							item.setName(name);
							item.setDescription(desc);
							item.setImagePath(itemImages.get("image"));
							item.setThumbImage(itemImages.get("thumbnail"));
							item.setComId(Long.valueOf(getComId()));
							item.setMenuId(Integer.valueOf(selectedMenuId));
							item.setCode(getCode());
							if ("true".equals(getIsmain()))
								item.setIsmain(true);
							
							if(isCargo != null && isCargo.equals("true")){
								item.setIsCargo(true);
								item.setPrice(Double.valueOf(price));
							}else{
								item.setIsCargo(false);
							}
							
							if (item.getIsCargo() && "true".equals(discount) && discountPrice != null && !discountPrice.isEmpty() && discountPercent != null && !discountPercent.isEmpty()) {
								item.setIsDiscount(true);
								if(isDouble(discountPrice))
									item.setPriceAfterDiscount(Double.valueOf(discountPrice));
								if(isNumber(discountPercent))
									item.setDiscountPercent(Integer.valueOf(discountPercent));
							} else {
								item.setIsDiscount(false);
								item.setPriceAfterDiscount(0d);
								item.setDiscountPercent(0);
							}
							
							logger.debug("create item -> selectedMenuId=" + selectedMenuId);
							if (selectedMenuId != null && selectedMenuId != "") {
								item.setMenuId(Integer.valueOf(selectedMenuId));
								MenuBean.getInstance().addNewMenuItem(item);
							}
							logger.debug("END create item");
						} else {
							if(com != null)
								setErrorMessage("You only can create "+com.getMaxItem()+" items, please remove the old one or contact vietpage to extend the max item can created");
						}
					}
				}else if("delete".equals(getAction())){
					if(Integer.valueOf(getId()) != 0){
						MenuBean.getInstance().deleteMenuItem(Integer.valueOf(getId()), Integer.valueOf(getComId()));
					}
				}
			}
			// load menu items
			setItems(MenuBean.getInstance().getAllMenuItems(Integer.valueOf(getComId())));
			if (getItems() != null)
				for (Item i : getItems()) {
					buttons = buttons + "btn_" + i.getMenuId() + "_" + i.getId() + ",";
				}

		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		}
		super.execute();
		if (getTargetUrl() != null && !getTargetUrl().isEmpty()) {
			if(isMobilePhone(getHttpServletRequest()))
				return "m_"+getTargetUrl();
			
			return getTargetUrl();
		} else {
			if(isMobilePhone(getHttpServletRequest()))
				return "m_"+SUCCESS;
			return SUCCESS;
		}
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getIsmain() {
		return ismain;
	}

	public void setIsmain(String ismain) {
		this.ismain = ismain;
	}

	public String getButtons() {
		return buttons;
	}

	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getSelectedMenuId() {
		return selectedMenuId;
	}

	public void setSelectedMenuId(String selectedMenuId) {
		this.selectedMenuId = selectedMenuId;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void validate() {
		if (name == null || name.isEmpty()) {
			addFieldError("name", "Item name is required.");
		}
		if (desc == null || desc.isEmpty()) {
			addFieldError("desc", "Item description is required.");
		}
		System.out.println("isCargo==" + isCargo);
		if(isCargo != null && "true".equals(isCargo)){
			if (price == null) {
				addFieldError("price", "Price is required");
			} else {
				if (!isDouble(price)) {
					addFieldError("price", "Price must be a number");
				}
			}
		}

	}

	private String validateData() {
		String error = null;
		if (code == null || code.isEmpty()) {
			error = "Item code is required.";
		}
		if (name == null || name.isEmpty()) {
			error = "Item name is required.";
		}
		if (desc == null || desc.isEmpty()) {
			error = "Item description is required.";
		}
		System.out.println("isCargo==" + isCargo);
		if(isCargo!=null && "true".equals(isCargo)){
			if (price == null) {
				error = "Price is required";
			} else {
				if (!isDouble(price)) {
					error = "Price must be a number";
				}
			}
		}
		return error;
	}

	public String getIsCargo() {
		return isCargo;
	}

	public void setIsCargo(String isCargo) {
		this.isCargo = isCargo;
	}
}
