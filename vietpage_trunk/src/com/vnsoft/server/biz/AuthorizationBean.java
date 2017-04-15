package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorizationBean {
	public static long getOwnerOfMenuItem(int id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		long comid = 0;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select comid from menuitem where id=?");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				comid = result.getLong("comid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return comid;
	}
	public static long getOwnerOfNews(int id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		long comid = 0;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select comid from news where id=?");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				comid = result.getLong("comid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return comid;
	}
	public static long getOwnerOfService(int id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		long comid = 0;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select comid from service where id=?");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				comid = result.getLong("comid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return comid;
	}
	public static long getOwnerOfContactInfo(int id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		long comid = 0;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select comid from contactinfo where id=?");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				comid = result.getLong("comid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
		return comid;
	}
	public static long getOwnerOfAbout(int id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		long comid = 0;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select comid from about where id=?");
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				comid = result.getLong("comid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return comid;
	}
	
}
