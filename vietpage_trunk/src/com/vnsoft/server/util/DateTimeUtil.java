package com.vnsoft.server.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.vnsoft.server.biz.TrackingBean;

public class DateTimeUtil {
	public static List<String> getHoursOfToday(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		String today = TrackingBean.yyyyMMdd.format(Calendar.getInstance().getTime());
		List<String> hours = new ArrayList<>();
		for (int i = 0; i < 24; i++) {
			if (i < 10) {
				hours.add(prefix +today + " 0" + i);
				System.out.println(prefix +today + " 0" + i);
			} else {
				hours.add(prefix +today + " " + i);
				System.out.println(prefix +today + " " + i);
			}
		}
		return hours;
	}
	public static List<String> getHoursOfYesterDay(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day - 1);
		String yesterday = TrackingBean.yyyyMMdd.format(c.getTime());
		List<String> hours = new ArrayList<>();
		for (int i = 0; i < 24; i++) {
			hours.add(prefix +yesterday + " " + i);
		}
		return hours;
	}
	public static List<String> getDaysOfThisWeek(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		int weekDay = c.get(Calendar.DAY_OF_WEEK);
		List<String> days = new ArrayList<>();
		while (weekDay > 0) {
			c.set(Calendar.DAY_OF_MONTH, day - (weekDay - 1));
			String tmp = TrackingBean.yyyyMMdd.format(c.getTime());
			days.add(prefix +tmp);
			weekDay--;
		}
		return days;
	}
	public static List<String>  getDayOfLastWeek(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		Calendar c = Calendar.getInstance();
		int weekDay = c.get(Calendar.DAY_OF_WEEK);
		c.setTimeInMillis(c.getTimeInMillis() - (((weekDay - 1) * 24 * 60 * 60 * 1000) + (7 * 24 * 60 * 60 * 1000)));
		System.out.println(TrackingBean.yyyyMMdd.format(c.getTime()));
		List<String> days = new ArrayList<>();
		String tmp = TrackingBean.yyyyMMdd.format(c.getTime());
		days.add(tmp);
		for (int i = 1; i < 7; i++) {
			c.setTimeInMillis(c.getTimeInMillis() + 24 * 60 * 60 * 1000);
			tmp = TrackingBean.yyyyMMdd.format(c.getTime());
			days.add(prefix +tmp);
			System.out.println(tmp);
		}
		return days;
	}
	public static List<String> getDayOfThisMonth(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, 0);
		List<String> days = new ArrayList<>();
		for (int i = 0; i < day; i++) {
			c.setTimeInMillis(c.getTimeInMillis() + 24 * 60 * 60 * 1000);
			String tmp = TrackingBean.yyyyMMdd.format(c.getTime());
			days.add(prefix +tmp);
			System.out.println(prefix +tmp);
		}
		return days;
	}
	public static List<String> getDayOfLastMonth(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
		c.set(Calendar.DAY_OF_MONTH,0);
		int daysOfLastMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(daysOfLastMonth);
		List<String> days = new ArrayList<>();
		String tmp = TrackingBean.yyyyMMdd.format(c.getTime());
		for(int i=0;i<daysOfLastMonth;i++){
			c.setTimeInMillis(c.getTimeInMillis() + 24*60*60*1000);
			tmp = TrackingBean.yyyyMMdd.format(c.getTime());
			days.add(prefix +tmp);
			System.out.println(tmp);
		}
		return days;
	}
	public static List<String> getMonthsOfThisYear(String prefix){
		if(prefix != null && !prefix.isEmpty())
			prefix = prefix + "_";
		if(prefix == null)
			prefix = "";
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		List<String> days = new ArrayList<>();
		for (int i = 1; i < month + 1; i++) {
			if (i < 10) {
				days.add(prefix +year + "-0" + i);
			} else {
				days.add(prefix +year + "-" + i);
			}
		}
		return days;
	}
	public List<String> getMonthsOfLastYear(){
		return null;
	}
}
