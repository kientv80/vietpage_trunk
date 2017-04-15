package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jcs.JCS;
import org.apache.log4j.Logger;

import com.vnsoft.server.cache.CacheType;
import com.vnsoft.server.cache.JCSCacheClient;
import com.vnsoft.server.cache.JSCCacheManager;
import com.vnsoft.server.model.KeyValue;

public class LocationBean {
	private static LocationBean location = null;
	Logger log = Logger.getLogger(LocationBean.class);
	public static LocationBean getInstance(){
		if(location == null)
			location = new LocationBean();
		return location;
	}
	public List<KeyValue> getCity() throws Exception{
		JCSCacheClient cache = JSCCacheManager.getInstace().getCityCache();
		Object tmp = cache.get(CacheType.CITY);
		if (tmp != null)
			return (List<KeyValue>) tmp;
		
		List<KeyValue> cities = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from city where id in (select distinct city_id from location) order by name asc");
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue city = new KeyValue(result.getString("id"), result.getString("name"));
				cities.add(city);
			}
			cache.put(CacheType.CITY, cities);
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
		return cities;
		
	}
	public List<KeyValue> getLocation(int city,  boolean all) throws Exception{
		JCSCacheClient cache = JSCCacheManager.getInstace().getLocationCache();
		Object tmp = cache.get(city);
		if (tmp != null)
			return (List<KeyValue>) tmp;
		
		List<KeyValue> locations = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		String sql = "";
		if(all){
			sql = "Select * from location where city_id=? order by name asc";
		}else{
			sql = "Select * from location where city_id=? and id in (select distinct location_id from company) order by name asc";
		}
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from location where city_id=? order by name asc");
			stm.setInt(1, city);
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue location = new KeyValue(result.getString("id"), result.getString("name"));
				locations.add(location);
			}
			cache.put(city, locations);
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
		return locations;
		
	}
	public List<KeyValue> getLocation() throws Exception{
		JCSCacheClient cache = JSCCacheManager.getInstace().getLocationCache();
		Object tmp = cache.get(CacheType.LOCATION);
		if (tmp != null)
			return (List<KeyValue>) tmp;
		
		List<KeyValue> locations = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from location order by name asc");
			result = stm.executeQuery();
			while (result.next()) {
				KeyValue location = new KeyValue(result.getString("id"), result.getString("name"));
				locations.add(location);
			}
			cache.put(CacheType.LOCATION, locations);
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
		return locations;
		
	}
}
