package com.vnsoft.server.actions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.model.UserTracking;
import com.vnsoft.server.tags.yui.ChartData;
import com.vnsoft.server.util.DateTimeUtil;


public class ReportUserAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5825724635052851290L;
	private List<UserTracking> data;
	private List<ChartData> chartData = new ArrayList<>();
	private List<KeyValue> reportTime = null;
	private String time;
	private String reportType;
	private String total;
	private Logger logger = Logger.getLogger(ReportUserAction.class);
	@Override
	public String execute() {
		long sum = 0;
		reportTime = new ArrayList<>();
		getReportTime().add(new KeyValue("today", "Today"));
		getReportTime().add(new KeyValue("yesterday", "Yesterday"));
		getReportTime().add(new KeyValue("thisweek", "This Week"));
		getReportTime().add(new KeyValue("lastweek", "Last Week"));
		getReportTime().add(new KeyValue("thismonth", "This Month"));
		getReportTime().add(new KeyValue("lastmonth", "Last Month"));
		getReportTime().add(new KeyValue("thisyear", "This Year"));
		getReportTime().add(new KeyValue("lastyear", "Last Year"));
		try {
			if("today".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getHoursOfToday(null)));
				for(UserTracking u : data){
					System.out.println(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()));
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
					total = sum + "";
				}
			}else if("yesterday".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getHoursOfYesterDay(null)));
				for(UserTracking u : data){
					System.out.println(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()));

					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(u.getId().substring(u.getId().lastIndexOf(" "),u.getId().length()), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}
			}else if("thisweek".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getDaysOfThisWeek(null)));
				for(UserTracking u : data){
					System.out.println(u.getId());
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}
			}else if("lastweek".equals(getTime())){

				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getDayOfLastWeek(null)));
				for(UserTracking u : data){
					System.out.println(u.getId());
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}
			}else if("thismonth".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getDayOfThisMonth(null)));
				for(UserTracking u : data){
					System.out.println(u.getId());
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}
				
			}else if("lastmonth".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getDayOfLastMonth(null)));
				for(UserTracking u : data){
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(TrackingBean.yyyyMMdd2.parse(u.getId().replace("-", ",")), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}				
			}else if("thisyear".equals(getTime())){
				setData(TrackingBean.getInstance().getUserTrackingUser(DateTimeUtil.getMonthsOfThisYear(null)));
				for(UserTracking u : data){
					if("userlogin".equals(getReportType())){
						ChartData cd = new ChartData(TrackingBean.yyyyMM2.parse(u.getId().replace("-", ",")), u.getUserLoginCount());
						getChartData().add(cd);
						sum = sum + u.getUserLoginCount();
					}else{
						ChartData cd = new ChartData(TrackingBean.yyyyMM2.parse(u.getId().replace("-", ",")), u.getCreateNewUserCount());
						getChartData().add(cd);
						sum = sum + u.getCreateNewUserCount();
					}
				}	
			}else if("lastyear".equals(getTime())){
				
			}else if("picktime".equals(getTime())){
				
			}
			total = sum + "";
		} catch (Exception ex) {
			logger.error("", ex);
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int year = c.get(Calendar.YEAR);
		for(int i = 1;i<month+1;i++){
			try {
				System.out.println(TrackingBean.yyyyMMdd2.parse(year+","+i+",01"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public List<UserTracking> getData() {
		return data;
	}

	public void setData(List<UserTracking> data) {
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


	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
}
