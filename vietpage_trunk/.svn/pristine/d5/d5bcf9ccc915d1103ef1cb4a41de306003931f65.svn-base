package com.vnsoft.server.worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.JDBCConnection;
import com.vnsoft.server.biz.TrackingBean;

public class ViewItemTrackingWorker implements Runnable{
	private final BlockingQueue<String> trackingQueue   = new LinkedBlockingQueue<String>(6000);
	Logger log = Logger.getLogger(TrackingBean.class);
	
	public void countViewItem(String key){
		try {
			if(key != null)
				trackingQueue.put(key);
			else
				log.warn(">>>>>>>> TrackingWorker key is null");
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
	private boolean isNumber(String num){
		try {
			Integer.valueOf(num);
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	private void tracking(String id) throws Exception{
		if(!isNumber(id)){
			return;
		}
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("update menuitem set viewcount=viewcount+1 where id=?");
			stm.setInt(1, Integer.valueOf(id).intValue());
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
