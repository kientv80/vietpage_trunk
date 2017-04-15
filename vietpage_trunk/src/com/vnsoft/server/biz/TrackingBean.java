package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.PageVisit;
import com.vnsoft.server.model.UserTracking;
import com.vnsoft.server.worker.FeedTrackingWorker;
import com.vnsoft.server.worker.PageVisitTrackingWorker;
import com.vnsoft.server.worker.UserInterestedWorker;
import com.vnsoft.server.worker.UserTrackingWorker;
import com.vnsoft.server.worker.ViewItemTrackingWorker;

public class TrackingBean {
	public static TrackingBean instance;
	public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("YYYY-MM");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("YYYY-MM-dd");
	public static final SimpleDateFormat yyyyMMdd2 = new SimpleDateFormat("yyyy,MM,dd");
	public static final SimpleDateFormat yyyyMM2 = new SimpleDateFormat("yyyy,MM");
	public static final SimpleDateFormat yyyyMMddWW = new SimpleDateFormat("YYYY-MM-dd-WW");
	public static final SimpleDateFormat yyyyMMddHH = new SimpleDateFormat("YYYY-MM-dd HH");
	Logger log = Logger.getLogger(TrackingBean.class);
	UserTrackingWorker userTracking = null;
	PageVisitTrackingWorker pageVisitTrackingWorker = null;
	UserInterestedWorker userInterestedWorker = null;
	ViewItemTrackingWorker viewItemWorker = null;
	FeedTrackingWorker feedTrackingWorker = null;
	private TrackingBean() {
		userTracking = new UserTrackingWorker();
		pageVisitTrackingWorker = new PageVisitTrackingWorker();
		userInterestedWorker = new UserInterestedWorker();
		viewItemWorker = new ViewItemTrackingWorker();
		feedTrackingWorker = new FeedTrackingWorker();
		new Thread(userTracking).start();
		new Thread(pageVisitTrackingWorker).start();
		new Thread(userInterestedWorker).start();
		new Thread(viewItemWorker).start();
		new Thread(feedTrackingWorker).start();
	}
	public static TrackingBean getInstance(){
		if(instance == null)
			instance = new TrackingBean();
		return instance;
	}
	public void feedViewTracking(long feedId){
		feedTrackingWorker.viewFeed(feedId);
	}
	public void trackingNewUser() throws Exception{
		userTracking.userTracking("new_user_count");
	}
	public void trackingUserInterested(String visistorId, int serviceId, int locationId){
		userInterestedWorker.trackUserInterested(visistorId, serviceId,locationId);
	}
	public void trackingUserLogin() throws Exception{
		userTracking.userTracking("user_login_count");
	}
	
	public void trackingPageVisit(String pageId) throws Exception{
		pageVisitTrackingWorker.pageVisitTracking(pageId);
	}
	public void itemViewCount(String itemId){
		viewItemWorker.countViewItem(itemId);
	}
	public List<UserTracking> getUserTrackingUser(List<String> keys) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<UserTracking>  trkInfo = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * from trk_user  where id in(");
			for(int i=0;i<keys.size();i++){
				if(i == keys.size() -1){
					sql.append("?");
				}else{
					sql.append("?,");
				}
			}
			sql.append(")");
			stm = con.prepareStatement(sql.toString());
			for(int i=0;i<keys.size();i++){
				stm.setString(i+1, keys.get(i));
			}
			result = stm.executeQuery();
			while (result.next()) {
				UserTracking u = new UserTracking();
				u.setId(result.getString("id"));
				u.setCreateNewUserCount(result.getLong("new_user_count"));
				u.setUserLoginCount(result.getLong("user_login_count"));
				trkInfo.add(u);
			}
		} catch (Exception e) {
			log.error("", e);
		}finally{
			if (stm != null)
				stm.close();
			if(result != null)
				result.close();
			if (con != null)
				con.close();
		}
		return trkInfo;
	}
	private boolean checkKeyExist(String key,String tableName) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		boolean alreadyExist = false;
		try {
			con = JDBCConnection.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * from "+tableName+"  where id=?");
			stm = con.prepareStatement(sql.toString());
			stm.setString(1, key);
			result = stm.executeQuery();
			while (result.next()) {
				alreadyExist = true;
				break;
			}
		} catch (Exception e) {
			log.error("", e);
			throw e;
		}finally{
			if (stm != null)
				stm.close();
			if(result != null)
				result.close();
			if (con != null)
				con.close();
		}
		return alreadyExist;
	}
	
	
	
	public List<PageVisit> getPageVisitTracking(List<String> keys) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<PageVisit>  trkInfo = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * from trk_page_visit  where id in(");
			for(int i=0;i<keys.size();i++){
				if(i == keys.size() -1){
					sql.append("?");
				}else{
					sql.append("?,");
				}
			}
			sql.append(")");
			stm = con.prepareStatement(sql.toString());
			for(int i=0;i<keys.size();i++){
				stm.setString(i+1, keys.get(i));
			}
			result = stm.executeQuery();
			while (result.next()) {
				PageVisit u = new PageVisit();
				u.setId(result.getString("id"));
				u.setVisitCount(result.getLong("visit_count"));
				trkInfo.add(u);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			if (stm != null)
				stm.close();
			if(result != null)
				result.close();
			if (con != null)
				con.close();
		}
		return trkInfo;
	}
	
}
