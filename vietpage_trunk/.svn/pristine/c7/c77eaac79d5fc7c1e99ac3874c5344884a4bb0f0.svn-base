package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;

import com.vnsoft.server.cache.CacheType;
import com.vnsoft.server.cache.JSCCacheManager;
import com.vnsoft.server.model.News;


public class NewsBean {
	private static NewsBean instance;
	Logger log = Logger.getLogger(NewsBean.class);
	private NewsBean() {
	}
	public static NewsBean getInstance(){
		if(instance == null)
			instance = new NewsBean();
		
		return instance;
	}

	
	public void editNewsInfo(News n) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Update company set news=? where id=?");
			stm.setString(1, n.getContent());
			stm.setLong(2, n.getComId());
			stm.executeUpdate();
			clearMenuCache(n.getComId());
		} catch (Exception e) {
			log.error("",e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
	}
	private void clearMenuCache(long comId){
		try {
			JSCCacheManager.getInstace().getPageCache().clear();
		} catch (CacheException e) {
			log.error("",e);
		}
	}

}
