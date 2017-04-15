package com.vnsoft.server.actions;

import java.util.Map;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.model.Address;
import com.vnsoft.server.model.CompanyInfo;

public class AddressAction extends EditRegisterInfoAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875736383789368874L;
	/**
	 * 
	 */
	int pageId;
	private int addressId;
	String address;
	String phone;
	String email;
	String map;
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	private Logger logger = Logger.getLogger(AddressAction.class);

	@Override
	public String execute() {
		try {
			Address ads = new Address();
			ads.setAddress(address);
			ads.setPhone(phone);
			ads.setEmail(email);
			ads.setId(addressId);
			ads.setPageId(getPageId());
			ads.setLocationId(getLocationId());
			System.out.println(address+phone+email+pageId+":"+addressId+getAction()+getLocationId());
			CompanyInfo com = (CompanyInfo)getHttpServletRequest().getSession().getAttribute(LoginAction.COMPANY_INFO);
			if ("edit".equals(getAction())) {
				if(com.getId() != ads.getPageId()){
					return "access_denined";
				}
				if(file != null){
					Map<String,String> newmap = uploadFile(System.nanoTime()+"_map.jpg", ads.getPageId()+"",UPLOAD_OBJECT.OTHERS);
					ads.setMap(newmap.get(StandarLayout.IMAGE));
				}
				CompanyBean.getInstance().updateAdress(ads);
				CompanyInfo tmp = CompanyBean.getInstance().getCompanyInfo(pageId);
				getHttpServletRequest().getSession(true).setAttribute(LoginAction.COMPANY_INFO,tmp);
			} else if ("add".equals(getAction())) {
				if(file != null){
					Map<String,String> newmap = uploadFile(System.nanoTime()+"_map.jpg", com.getId()+"",UPLOAD_OBJECT.OTHERS);
					ads.setMap(newmap.get(StandarLayout.IMAGE));
				}
				CompanyBean.getInstance().addAdress(com.getId(), ads);
				CompanyInfo tmp = CompanyBean.getInstance().getCompanyInfo(com.getId());
				getHttpServletRequest().getSession(true).setAttribute(LoginAction.COMPANY_INFO,tmp);
			}else if ("delete".equals(getAction())) {
				if(com.getId() != getPageId()){
					return "access_denined";
				}
				CompanyBean.getInstance().deleteAddress(addressId, getPageId());
				CompanyInfo tmp = CompanyBean.getInstance().getCompanyInfo(com.getId());
				getHttpServletRequest().getSession(true).setAttribute(LoginAction.COMPANY_INFO,tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("", e);
		}
		return super.execute();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
