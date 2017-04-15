package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.KeyValue;

public class ServiceTypeBean {
	private static ServiceTypeBean serviceType = null;
	Logger log = Logger.getLogger(ServiceTypeBean.class);
	public static ServiceTypeBean getInstance(){
		if(serviceType == null)
			serviceType = new ServiceTypeBean();
		return serviceType;
	}
	public List<KeyValue> getServiceType() throws Exception{
		List<KeyValue> serviceTypes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from servicetype order by name asc");
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue serviceType = new KeyValue(result.getString("id"), result.getString("name"));
				serviceTypes.add(serviceType);
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return serviceTypes;
		
	}
	public List<KeyValue> getHotServiceType() throws Exception{
		List<KeyValue> serviceTypes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from servicetype where hot=true and id in (select distinct service_id from company) order by displayorder");
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue serviceType = new KeyValue(result.getString("id"), result.getString("name"));
				serviceTypes.add(serviceType);
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return serviceTypes;
		
	}
	public List<KeyValue> getServiceTypes(List<Integer> serviceIds) throws Exception{
		List<KeyValue> serviceTypes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			String id = "";
			for(int sid : serviceIds){
				id = id + sid + ",";
			}
			id = id + "-1";
			stm = con.prepareStatement("Select * from servicetype where id in ("+id+") order by name asc");
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue serviceType = new KeyValue(result.getString("id"), result.getString("name"));
				serviceTypes.add(serviceType);
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return serviceTypes;
		
	}
}
