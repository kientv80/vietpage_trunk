package com.vnsoft.server.worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.JDBCConnection;
import com.vnsoft.server.biz.TrackingBean;

public class UserInterestedWorker implements Runnable {
	private final BlockingQueue<UserInterestedData> trackingQueue = new LinkedBlockingQueue<UserInterestedData>(6000);
	Logger log = Logger.getLogger(TrackingBean.class);

	public void trackUserInterested(String visistorId, int serviceId, int locationId) {
		try {
			UserInterestedData data = new UserInterestedData();
			data.setVisistorId(visistorId);
			data.setLocationId(locationId);
			data.setServiceId(serviceId);
			trackingQueue.put(data);
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

	private void tracking(UserInterestedData data) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from visistor_interested where visistor_id=?");
			stm.setString(1, data.getVisistorId());
			rs = stm.executeQuery();
			String score = "";
			while (rs.next()) {
				score = rs.getString("score");
			}
			if (score != null && !score.isEmpty()) {
				Map<String, Integer> scores = toScore(score);
				if (data.serviceId > 0 && scores.containsKey("s" + data.serviceId)) {
					scores.put("s" + data.serviceId, scores.get("s" + data.serviceId) + 1);
				} else if (data.serviceId > 0) {
					scores.put("s" + data.serviceId, 1);
				}
				if (data.locationId > 0 && scores.containsKey("l" + data.locationId)) {
					scores.put("l" + data.locationId, scores.get("l" + data.locationId) + 1);
				} else if (data.locationId > 0) {
					scores.put("l" + data.locationId, 1);
				}
				if (data.locationId > 0 || data.serviceId > 0) {
					String strScore = toStrScores(scores);
					stm = con.prepareStatement("update visistor_interested set score=? where visistor_id=?");
					stm.setString(1, strScore);
					stm.setString(2, data.visistorId);
					stm.executeUpdate();
				}

			} else {
				String strScore = "";// "s"+data.getServiceId()+"="+"1"+":l"+data.getLocationId()+"="+"1";
				if (data.serviceId > 0) {
					strScore = "s" + data.getServiceId() + "=" + "1";
				}
				if (data.locationId > 0) {
					strScore = strScore + ":l" + data.getLocationId() + "=" + "1";
				}
				if (strScore != "") {
					stm = con.prepareStatement("update visistor_interested set score=? where visistor_id=?");
					stm.setString(1, strScore);
					stm.setString(2, data.visistorId);
					stm.executeUpdate();
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
	}

	private String toStrScores(Map<String, Integer> scores) {
		StringBuilder str = new StringBuilder();
		for (Entry<String, Integer> e : scores.entrySet()) {
			str.append(e.getKey()).append("=").append(e.getValue()).append(":");
		}
		return str.toString();
	}

	private Map<String, Integer> toScore(String score) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (score.indexOf(":") > 0) {
			for (String s : score.split(":")) {
				String[] tmp = s.split("=");
				if (tmp.length == 2) {
					map.put(tmp[0], Integer.valueOf(tmp[1]));
				}
			}
		}
		return map;
	}

	
}
