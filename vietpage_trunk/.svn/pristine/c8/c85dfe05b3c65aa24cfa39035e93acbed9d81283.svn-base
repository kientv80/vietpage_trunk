package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.model.PageVisit;
import com.vnsoft.server.model.User;
import com.vnsoft.server.tags.yui.ChartData;
import com.vnsoft.server.util.DateTimeUtil;

public class ReportPageVisitAction extends StandarLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5825724635052851290L;
	private List<PageVisit> data;
	private List<ChartData> chartData = new ArrayList<>();
	private List<KeyValue> reportTime = null;
	private List<KeyValue> pages = new ArrayList<>();
	private String time;
	private String pageId;
	private String total;
	private Logger logger = Logger.getLogger(ReportPageVisitAction.class);
	@Override
	public String execute() {
		long sum =0;
		initReportTime();
		
		try {
			initPages();
			String id = getPageId();
			boolean f = authorize();
			if ("today".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getHoursOfToday(id+"")));
				for (PageVisit u : data) {
					ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "), u.getId().length()), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("yesterday".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getHoursOfYesterDay(id+"")));
				for (PageVisit u : data) {
					System.out.println(u.getId().substring(u.getId().lastIndexOf(" "), u.getId().length()));
					ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "), u.getId().length()), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("thisweek".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getDaysOfThisWeek(id+"")));
				for (PageVisit u : data) {
					System.out.println(u.getId());
					ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().substring(u.getId().indexOf("_")+1, u.getId().length()).replace("-", ",")), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("lastweek".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getDayOfLastWeek(id+"")));
				for (PageVisit u : data) {
					System.out.println(u.getId());
					ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().substring(u.getId().indexOf("_")+1, u.getId().length()).replace("-", ",")), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("thismonth".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getDayOfThisMonth(id+"")));
				for (PageVisit u : data) {
					System.out.println(u.getId());
					ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().substring(u.getId().indexOf("_")+1, u.getId().length()).replace("-", ",")), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("lastmonth".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getDayOfLastMonth(id+"")));
				for (PageVisit u : data) {
					ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().substring(u.getId().indexOf("_")+1, u.getId().length()).replace("-", ",")), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("thisyear".equals(getTime())) {
				if(!authorize()){
					return AuthorizationInterceptor.ACCESS_DENINED;
				}
				setData(TrackingBean.getInstance().getPageVisitTracking(DateTimeUtil.getMonthsOfThisYear(id+"")));
				for (PageVisit u : data) {
					ChartData cd = new ChartData(TrackingBean.yyyyMM2.parse(u.getId().substring(u.getId().indexOf("_")+1, u.getId().length()).replace("-", ",")), u.getVisitCount());
					getChartData().add(cd);
					sum = sum + u.getVisitCount();
				}
			} else if ("lastyear".equals(getTime())) {

			} else if ("picktime".equals(getTime())) {

			}
			setTotal(sum +"");
		} catch (Exception ex) {
			logger.error("", ex);
			ex.printStackTrace();
		}
		return SUCCESS;
	}


	private boolean authorize() {
		logger.debug("pageId=" + pageId);
		if(isNumber(pageId)){
			CompanyInfo com = (CompanyInfo)getHttpServletRequest().getSession().getAttribute(LoginAction.COMPANY_INFO);
			logger.debug("pageId=" + pageId + " com.getId()=" + com.getId());
			if(com != null && com.getId() == Long.valueOf(pageId).longValue()){
				return true;
			}
		}else{
			logger.debug("pageId is not a number");
		}
		logger.debug("authorize Failed");
		return false;
	}


	private void initPages() throws Exception {
		User user = (User)getHttpServletRequest().getSession().getAttribute(LoginAction.USER);
		if("admin".equals(user.getRole())){
			for(CompanyInfo c : CompanyBean.getInstance().getAllPages()){
				pages.add(new KeyValue(c.getId()+"", c.getName()));
			}
			pages.add(new KeyValue("vietpage_home", "Viet Page"));
			pages.add(new KeyValue("vietpage_search", "Viet Page Search"));
		}else{
			CompanyInfo com = (CompanyInfo)getHttpServletRequest().getSession().getAttribute(LoginAction.COMPANY_INFO);
			pages.add(new KeyValue(com.getId()+"", com.getName()));
			super.execute();
		}
		
	}


	private void initReportTime() {
		reportTime = new ArrayList<>();
		getReportTime().add(new KeyValue("today", "Today"));
		getReportTime().add(new KeyValue("yesterday", "Yesterday"));
		getReportTime().add(new KeyValue("thisweek", "This Week"));
		getReportTime().add(new KeyValue("lastweek", "Last Week"));
		getReportTime().add(new KeyValue("thismonth", "This Month"));
		getReportTime().add(new KeyValue("lastmonth", "Last Month"));
		getReportTime().add(new KeyValue("thisyear", "This Year"));
//		getReportTime().add(new KeyValue("lastyear", "Last Year"));
	}


	public List<PageVisit> getData() {
		return data;
	}

	public void setData(List<PageVisit> data) {
		this.data = data;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<KeyValue> getReportTime() {
		return reportTime;
	}

	public void setReportTime(List<KeyValue> reportTime) {
		this.reportTime = reportTime;
	}

	public List<ChartData> getChartData() {
		return chartData;
	}

	public void setChartData(List<ChartData> chartData) {
		this.chartData = chartData;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public List<KeyValue> getPages() {
		return pages;
	}

	public void setPages(List<KeyValue> pages) {
		this.pages = pages;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}

}
