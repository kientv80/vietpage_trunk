package com.vnsoft.server.actions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vnsoft.server.biz.LocationBean;
import com.vnsoft.server.biz.ServiceTypeBean;
import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.biz.VisistorBean;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.util.UAgentInfo;

public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4820487003426420317L;
	private String action;
	protected String errorMessage;
	private String currentPage;
	private List<KeyValue> city = new ArrayList<>();
	private List<KeyValue> location = new ArrayList<>();
	private List<KeyValue> serviceType = new ArrayList<>();
	private String searchText;
	private boolean showLeftSideAds;
	private boolean showRightSideAds;
	private List<KeyValue> hotservices;
	private List<KeyValue> mobileHotservices = new ArrayList<>();
	private String debug;
	Logger log = Logger.getLogger(BaseAction.class);
	protected HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return request;
	}

	protected HttpServletResponse getHttpServletResponse() {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("utf-8");
		return response;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isNumber(String comId) {
		try {
			Integer.valueOf(comId);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public boolean isDouble(String comId) {
		try {
			Double.valueOf(comId);
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	public String getVisistorId(){
		return VisistorBean.getInstance().getVisistorId(getHttpServletRequest(),getHttpServletResponse());
	}
	public String getCookie(String name){
		String cookie = "";
		if(getHttpServletRequest().getCookies()!=null && getHttpServletRequest().getCookies().length >0){
			for(Cookie a : getHttpServletRequest().getCookies()){
				if(name.equals(a.getName())){
					cookie = a.getValue();
					break;
				}
			}
		}
		return cookie;
	}
	
	public void trackingVisit(String comid) {
		try {
			TrackingBean.getInstance().trackingPageVisit(comid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void trackRecentVisitPages(String comid) {
		VisistorBean.getInstance().trackRecentVisitPages(getHttpServletRequest(), getHttpServletResponse(), comid);
	}
	public void loadSearchCategories(int cityId, boolean limit) throws Exception {
		city = new ArrayList<>();
		city.add(new KeyValue("0", "-- Chọn Thành Phố --"));
		city.addAll(1, LocationBean.getInstance().getCity());
		location = new ArrayList<>();
		location.add(new KeyValue("0", "-- Chọn vị trí --"));
		if(cityId > 0){
			location.addAll(1, LocationBean.getInstance().getLocation(cityId,limit));
		}else{
			location.addAll(1, LocationBean.getInstance().getLocation());
		}
		
		serviceType = new ArrayList<>();
		serviceType.add(new KeyValue("0", "-- Chọn dịch vụ --"));
		serviceType.addAll(1,ServiceTypeBean.getInstance().getServiceType());
	}
	public void shottenItemDesc(List<Item> items){
		if(items == null || items.size() ==0)
			return;
		for(Item i:items){
			String desc = i.getDescription();
			if(desc != null && desc.length() > 80){
				desc = desc.substring(0,80)+" ...";
				i.setDescription(desc);
			}
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getCurrentPage() {
		return ActionContext.getContext().getName();
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public List<KeyValue> getCity() {
		return city;
	}


	public void setCity(List<KeyValue> city) {
		this.city = city;
	}


	public List<KeyValue> getLocation() {
		return location;
	}


	public void setLocation(List<KeyValue> location) {
		this.location = location;
	}
	public List<KeyValue> getServiceType() {
		return serviceType;
	}


	public void setServiceType(List<KeyValue> serviceType) {
		this.serviceType = serviceType;
	}


	public boolean getShowRightSideAds() {
		String screenWidth = getCookie("screenWidth");
		if(screenWidth != null && isNumber(screenWidth)){
			if(Integer.valueOf(screenWidth) > 1024+160*2){
				showRightSideAds =  true;
			}else{
				showRightSideAds = false;
			}
		}else{
			showRightSideAds = false;
		}
		return showRightSideAds;
	}

	public void setShowRightSideAds(boolean showRightSideAds) {
		this.showRightSideAds = showRightSideAds;
	}

	public boolean getShowLeftSideAds() {
		String screenWidth = getCookie("screenWidth");
		if(screenWidth != null && isNumber(screenWidth)){
			if(Integer.valueOf(screenWidth) > 1024+160){
				showLeftSideAds =  true;
			}else{
				showLeftSideAds = false;
			}
		}else{
			showLeftSideAds = false;
		}
		return showLeftSideAds;
	}

	public void setShowLeftSideAds(boolean showLeftSideAds) {
		this.showLeftSideAds = showLeftSideAds;
	}

	public List<KeyValue> getHotservices() {
		if(hotservices == null)
			try {
				hotservices = ServiceTypeBean.getInstance().getHotServiceType();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return hotservices;
	}

	public void setHotservices(List<KeyValue> hotservices) {
		this.hotservices = hotservices;
	}
	public boolean isMobilePhone(HttpServletRequest req){
		try {
			Object deviceType = req.getSession(true).getAttribute("deviceType");
			if(deviceType!=null && "mobile".equals(deviceType)){
				return true;
			}else if(deviceType == null){
				UAgentInfo u = new UAgentInfo(req.getHeader("user-agent"), req.getHeader("accept"));
				if(u.isMobilePhone){
					req.getSession(true).setAttribute("deviceType", "mobile");
					return true;
				}
			}
		} catch (Exception e) {
			log.error("",e);
		}
		return false;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public List<KeyValue> getMobileHotservices() {
		if(hotservices != null && hotservices.size() > 4)
			mobileHotservices = hotservices.subList(0, 4);
		else
			mobileHotservices = hotservices;
		
		return mobileHotservices;
	}
}
