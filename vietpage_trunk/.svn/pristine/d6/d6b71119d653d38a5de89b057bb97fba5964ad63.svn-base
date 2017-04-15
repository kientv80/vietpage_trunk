package com.vnsoft.server.worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.JDBCConnection;

public class FeedTrackingWorker implements Runnable{
	public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("YYYY-MM");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("YYYY-MM-dd");
	public static final SimpleDateFormat yyyyMMdd2 = new SimpleDateFormat("yyyy,MM,dd");
	public static final SimpleDateFormat yyyyMM2 = new SimpleDateFormat("yyyy,MM");
	public static final SimpleDateFormat yyyyMMddWW = new SimpleDateFormat("YYYY-MM-dd-WW");
	public static final SimpleDateFormat yyyyMMddHH = new SimpleDateFormat("YYYY-MM-dd HH");
	private final BlockingQueue<Long> trackingQueue   = new LinkedBlockingQueue<Long>(6000);
	Logger log = Logger.getLogger(FeedTrackingWorker.class);
	
	public void viewFeed(Long feedId){
		try {
			if(feedId != null)
				trackingQueue.put(feedId);
			else
				log.warn(">>>>>>>> FeedTrackingWorker key is null");
		} catch (InterruptedException e) {
			log.error("", e);
		}
	}
	@Override
	public void run() {
		while(true){
			try {
				tracking(trackingQueue.take());
			} catch (InterruptedException e) {
				log.error("", e);
			} catch (Exception e) {
				log.error("", e);
			}
		}
		
	}
	private void tracking(Long feedId) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("update feed set view_count=view_count+1 where id=?");
			stm.setLong(1, feedId);
			stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
	}
}
