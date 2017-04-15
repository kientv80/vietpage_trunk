package com.vnsoft.server.worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.jcs.JCS;
import org.apache.log4j.Logger;

import com.vnsoft.server.biz.JDBCConnection;
import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.cache.CacheType;
import com.vnsoft.server.cache.JSCCacheManager;

public class PageVisitTrackingWorker implements Runnable{
	public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("YYYY-MM");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("YYYY-MM-dd");
	public static final SimpleDateFormat yyyyMMdd2 = new SimpleDateFormat("yyyy,MM,dd");
	public static final SimpleDateFormat yyyyMM2 = new SimpleDateFormat("yyyy,MM");
	public static final SimpleDateFormat yyyyMMddWW = new SimpleDateFormat("YYYY-MM-dd-WW");
	public static final SimpleDateFormat yyyyMMddHH = new SimpleDateFormat("YYYY-MM-dd HH");
	private final BlockingQueue<String> trackingQueue   = new LinkedBlockingQueue<String>(6000);
	Logger log = Logger.getLogger(TrackingBean.class);
	
	public void pageVisitTracking(String key){
		try {
			if(key != null)
				trackingQueue.put(key);
			else
				log.warn(">>>>>>>> PageVisitTrackingWorker key is null");
		} catch (InterruptedException e) {
			log.error("", e);
		}
	}
	@Override
	public void run() {
		while(true){
			try {
				trackingPageVisit(trackingQueue.take());
//				log.info("trackingPageVisit ...");
			} catch (InterruptedException e) {
				log.error("", e);
			} catch (Exception e) {
				log.error("", e);
			}
		}
		
	}
	private void trackingPageVisit(String pageId) throws Exception{
		Date d = Calendar.getInstance().getTime();
		String keyYYYYMM = pageId+"_"+yyyyMM.format(d);
		String keyYYYYMMDD = pageId+"_"+yyyyMMdd.format(d);
		String keyYYYYMMddww = pageId+"_"+yyyyMMddWW.format(d);
		String keyYYYYMMddHH = pageId+"_"+yyyyMMddHH.format(d);
		Connection con = null;
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
//		JCS cache = JSCCacheManager.getInstace().getCache(CacheType.TRACKING);
		String pre = "TRACK_PAGE_VISIT";
		try {
			con = JDBCConnection.getInstance().getConnection();
			//TODO: handle insert
			con.setAutoCommit(false);
			stm = con.prepareStatement("insert into trk_page_visit (id,visit_count) values(?,0)");
			stm2 = con.prepareStatement("update trk_page_visit set visit_count = (visit_count+1) where id in (?,?,?,?)");
			boolean f = false;
				if(!checkKeyExist(keyYYYYMM,"trk_page_visit")){
					stm.setString(1, keyYYYYMM);
					stm.addBatch();
					f = true;
				}
				if(!checkKeyExist(keyYYYYMMDD,"trk_page_visit")){
					stm.setString(1, keyYYYYMMDD);
					stm.addBatch();
					f = true;
				}
				if(!checkKeyExist(keyYYYYMMddww,"trk_page_visit")){
					stm.setString(1, keyYYYYMMddww);
					stm.addBatch();
					f = true;
				}
				if(!checkKeyExist(keyYYYYMMddHH,"trk_page_visit")){
					stm.setString(1, keyYYYYMMddHH);
					stm.addBatch();
					f = true;
				}

			if(f){
				stm.executeBatch();
			}
			stm2.setString(1, keyYYYYMM);
			stm2.setString(2, keyYYYYMMDD);
			stm2.setString(3, keyYYYYMMddww);
			stm2.setString(4, keyYYYYMMddHH);
			stm2.executeUpdate();
			
			stm.executeBatch();
			con.commit();
			con.setAutoCommit(true);
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally{
			if (stm != null)
				stm.close();
			if (stm2 != null)
				stm2.close();
			if (con != null)
				con.close();
		}
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
}
