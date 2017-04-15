package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.Agency;
import com.vnsoft.server.model.Website;
import com.vnsoft.server.util.SecurityHelper;

public class AgencyBean {
	private Logger logger = Logger.getLogger(AgencyBean.class);
	private static AgencyBean instance = null;
	private AgencyBean() {
	}
	public static AgencyBean getInstance(){
		if(instance == null)
			instance = new AgencyBean();
		return instance;
	}
	public List<Website> getWebsites(int id) throws Exception{
		List<Website> websites = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("select c.*,u.username from company c, users u where c.owner_id=u.id and c.id in (select web_id from agency_website where agency_id=?)");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				Website w = new Website();
				w.setId(result.getInt("id"));
				w.setName(result.getString("name"));
				w.setUrl("/vietpage?page="+result.getString("username"));
				websites.add(w);
			}
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return websites;
		
	}
	public void trackingCreatePage(int agencyId, int webid) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("insert into agency_website (agency_id,web_id)values(?,?)");
			stm.setInt(1, agencyId);
			stm.setInt(2, webid);
			stm.executeUpdate();
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
	}
	public Agency login(String userName, String password) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		Agency a = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from agency where username=? and password=?");
			stm.setString(1, userName);
			stm.setString(2, SecurityHelper.endcodeSHA256(password));
			result = stm.executeQuery();
			while (result.next()) {
				a = new Agency();
				a.setId(result.getInt("id"));
				a.setName(result.getString("name"));
				a.setPhone(result.getString("phone"));
				a.setUsername(result.getString("username"));
			}
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return a;
	}
}
