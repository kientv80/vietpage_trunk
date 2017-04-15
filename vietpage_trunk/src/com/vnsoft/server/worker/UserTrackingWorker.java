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

public class UserTrackingWorker implements Runnable {
	public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("YYYY-MM");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("YYYY-MM-dd");
	public static final SimpleDateFormat yyyyMMdd2 = new SimpleDateFormat("yyyy,MM,dd");
	public static final SimpleDateFormat yyyyMM2 = new SimpleDateFormat("yyyy,MM");
	public static final SimpleDateFormat yyyyMMddWW = new SimpleDateFormat("YYYY-MM-dd-WW");
	public static final SimpleDateFormat yyyyMMddHH = new SimpleDateFormat("YYYY-MM-dd HH");
	private final BlockingQueue<String> trackingQueue = new LinkedBlockingQueue<String>(6000);
	Logger log = Logger.getLogger(TrackingBean.class);

	public void userTracking(String key) {
		try {
			if (key != null)
				trackingQueue.put(key);
			else
				log.warn(">>>>>>>> TrackingWorker key is null");
		} catch (InterruptedException e) {
			log.error("", e);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				tracking(trackingQueue.take());
			} catch (InterruptedException e) {
				log.error("", e);
			} catch (Exception e) {
				log.error("", e);
			}
		}

	}

	private void tracking(String columName) throws Exception {
		Date d = Calendar.getInstance().getTime();
		String keyYYYYMM = yyyyMM.format(d);
		String keyYYYYMMDD = yyyyMMdd.format(d);
		String keyYYYYMMddww = yyyyMMddWW.format(d);
		String keyYYYYMMHH = yyyyMMddHH.format(d);
		Connection con = null;
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
		String pre = "TRACK_NEW_USER";
		try {
			con = JDBCConnection.getInstance().getConnection();
			con.setAutoCommit(false);
			stm = con.prepareStatement("insert into trk_user (id,new_user_count,user_login_count) values(?,0,0)");
			boolean f = false;
			if (!checkKeyExist(keyYYYYMM, "trk_user")) {
				stm.setString(1, keyYYYYMM);
				stm.addBatch();
				f = true;
			}
			if (!checkKeyExist(keyYYYYMMDD, "trk_user")) {
				stm.setString(1, keyYYYYMMDD);
				stm.addBatch();
				f = true;
			}
			if (!checkKeyExist(keyYYYYMMddww, "trk_user")) {
				stm.setString(1, keyYYYYMMddww);
				stm.addBatch();
				f = true;
			}
			if (!checkKeyExist(keyYYYYMMHH, "trk_user")) {
				stm.setString(1, keyYYYYMMHH);
				stm.addBatch();
				f = true;
			}

			if (f) {
				stm.executeBatch();
			}
			stm2 = con.prepareStatement("update trk_user set " + columName + " = (" + columName + "+1) where id in(?,?,?,?)");
			stm2.setString(1, keyYYYYMM);
			stm2.setString(2, keyYYYYMMDD);
			stm2.setString(3, keyYYYYMMddww);
			stm2.setString(4, keyYYYYMMHH);

			stm2.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			if (stm != null)
				stm.close();
			if (stm2 != null)
				stm2.close();
			if (con != null)
				con.close();
		}
	}

	private boolean checkKeyExist(String key, String tableName) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		boolean alreadyExist = false;
		try {
			con = JDBCConnection.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * from " + tableName + "  where id=?");
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
		} finally {
			if (stm != null)
				stm.close();
			if (result != null)
				result.close();
			if (con != null)
				con.close();
		}
		return alreadyExist;
	}
}
