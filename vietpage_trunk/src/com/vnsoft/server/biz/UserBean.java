package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.User;
import com.vnsoft.server.util.SecurityHelper;

public class UserBean {
	private static UserBean instance;
	private static Logger log = Logger.getLogger(UserBean.class);
	private UserBean(){
		
	}
	public static UserBean getInstance(){
		if(instance == null)
			instance = new UserBean();
		
		return instance;
	}
	public static User login(String userName, String password) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		User user = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from users where username=? and password=?");
			stm.setString(1, userName);
			stm.setString(2, SecurityHelper.endcodeSHA256(password));
			result = stm.executeQuery();
			while (result.next()) {
				user = new User(result.getString("username"), result.getString("role"), result.getInt("id"));
			}
			TrackingBean.getInstance().trackingUserLogin();
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
		return user;
	}
	
	public static User getUser(String userName) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		User user = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from users where username=?");
			stm.setString(1, userName);
			result = stm.executeQuery();
			while (result.next()) {
				user = new User(result.getString("username"), result.getString("role"), result.getInt("id"));
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
		return user;
	}
	public static User createUser(User user) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("insert into users(username, password,role) values(?,?,?)");
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getRole());
			stm.executeUpdate();
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return getUser(user.getUsername());
	}
	public static void main(String[] args) {
		System.out.println((SecurityHelper.endcodeSHA256("12345678")));
	}
}
