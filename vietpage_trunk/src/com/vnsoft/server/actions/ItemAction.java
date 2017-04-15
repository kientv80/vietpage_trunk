package com.vnsoft.server.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.util.JSONHelper;

public class ItemAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 131946202203004582L;

	private String itemImage;
	String name;
	String desc;
	Double price;
	private String code;
	private boolean ismain;
	private String format;
	private String isCargo;
	private Item item;
	private String menuId;
	private Logger logger = Logger.getLogger(ItemAction.class);
	public String execute() {
		try {
			logger.debug("Item action action="+getAction()+" id=" + getId() + " comid=" + getComId());
			if (getComId() == null || getComId().isEmpty()) {
				return "nocompanyid";
			}
			if(AuthorizationInterceptor.EDIT.equals(getAction())){
				editItem();
			}if("getItem".equals(getAction())){
				getAjaxItem();
				return null;
			}else if("getItems".equals(getAction())){
				getAjaxItems();
				return null;
			}else if("delete".equals(getAction())){
				if(Integer.valueOf(getId()) != 0){
					MenuBean.getInstance().deleteMenuItem(Integer.valueOf(getId()), Integer.valueOf(getComId()));
				}
			}else if("getItemObject".equals(getAction()) || "viewItem".equals(getAction())){
				getItemObject();
			}
		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		}
		super.execute();
		String view = SUCCESS;
		if(isMobilePhone(getHttpServletRequest())){
			return "m_"+view;
		}
		return view;
	}

	private void getItemObject() throws Exception {
		if(getId() != null && !getId().isEmpty()){
			setItem(MenuBean.getInstance().getItem(Integer.valueOf(getId())));
			if(getComId()!=null && isNumber(getComId())){
				CompanyInfo c = CompanyBean.getInstance().getCompanyInfo(Long.valueOf(getComId()));
				if(c != null){
					String visistorId = getVisistorId();
					TrackingBean.getInstance().trackingUserInterested(visistorId, c.getServiceTypeId(), c.getLocationId());
				}
			}
			TrackingBean.getInstance().itemViewCount(getId());
		}else{
		}
	}

	private void getAjaxItems() throws Exception, JSONException, IOException {
		if(Integer.valueOf(getComId()) != 0){
			List<Item> items = MenuBean.getInstance().getItems(Integer.valueOf(getComId()));
			System.out.println(">>>>>>>>>>>>>>>>>.."+getMenuId());
			if(getMenuId()!=null && isNumber(getMenuId()) && !"-1".equals(getMenuId().trim())){
				System.out.println(">>>>>>>>>>>>>>>>>OK OK OK ");
				Integer menuid = Integer.valueOf(getMenuId());
				for(Item i : items){
					i.setIsmain(false);
					if(i.getMenuId().equals(menuid)){
						i.setIsmain(true);
					}
				}
			}
			String item = JSONHelper.toJSONArray(items).toString();
			getHttpServletResponse().setContentType("application/json;charset=utf-8");
			PrintWriter writer = getHttpServletResponse().getWriter();
			String result ="{\"results\":"+item+"}";
			writer.write(getCallback()+"("+result+")");
			writer.close();
			trackingVisit(getComId());
		}else{
		}
	}

	private void getAjaxItem() throws JSONException, Exception, IOException {
		if(getId() != null && !getId().isEmpty()){
			String item = JSONHelper.toJSONObject(MenuBean.getInstance().getItem(Integer.valueOf(getId()))).toString();
			getHttpServletResponse().setContentType("application/json;charset=utf-8");
			PrintWriter writer = getHttpServletResponse().getWriter();
			writer.write(item);
			writer.close();
			trackingVisit(getComId());
		}else{
		}
	}

	private void editItem() throws Exception {
		String imageSeperator = "/";
		if (itemImage.indexOf("\\") > 0)
			imageSeperator = "\\";
		String fileName = "item_" + getComId()+"_" + System.currentTimeMillis()+".jpg";
		Map<String,String> images = uploadFile(fileName,getComId(),UPLOAD_OBJECT.ITEM);
		Item item = new Item();
		item.setName(name);
		item.setDescription(desc);
		if(isCargo != null && isCargo.equals("true")){
			item.setIsCargo(true);
			item.setPrice(Double.valueOf(price));
		}else{
			item.setPrice(0d);
		}
		item.setPrice(price);
		if(images != null && images.size() > 0){
			item.setImagePath(images.get(StandarLayout.IMAGE));
			item.setThumbImage(images.get(StandarLayout.THUMBNAIL));
		}
		item.setId(Integer.valueOf(getId()));
		item.setIsmain(isIsmain());
		item.setComId(Long.valueOf(getComId()));
		item.setCode(getCode());
		if(isCargo != null && isCargo.equals("true")){
			item.setIsCargo(true);
		}else{
			item.setIsCargo(false);
		}
		MenuBean.getInstance().updateMenuItem(item);
	}
	@Override
	protected boolean loadItem() {
		if("viewItem".equals(getAction()))
				return false;
		return true;
	}
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public boolean isIsmain() {
		return ismain;
	}

	public void setIsmain(boolean ismain) {
		this.ismain = ismain;
	}

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getIsCargo() {
		return isCargo;
	}

	public void setIsCargo(String isCargo) {
		this.isCargo = isCargo;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
