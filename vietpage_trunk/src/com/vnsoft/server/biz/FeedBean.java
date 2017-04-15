package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;

import com.vnsoft.server.cache.JCSCacheClient;
import com.vnsoft.server.cache.JSCCacheManager;
import com.vnsoft.server.model.Feed;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.plugin.social.FaceBookFeed;
import com.vnsoft.server.plugin.social.SocialServiceFactory;
import com.vnsoft.server.plugin.social.ZaloLinkFeed;

public class FeedBean {
	private static FeedBean instance;
	Logger log = Logger.getLogger(FeedBean.class);

	private FeedBean() {
	}

	public static FeedBean getInstance() {
		if (instance == null)
			instance = new FeedBean();

		return instance;
	}

	public List<Feed> getPendingFeeds() throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<Feed> feeds = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE f.approve = 0 and c.id=f.comid ORDER BY f.id DESC");
			result = stm.executeQuery();
			feeds = resulSetToList(result, true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return feeds;
	}

	public List<Feed> approveFeed(long feedId) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		List<Feed> feeds = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("update feed set approve = 1 where id=?");
			stm.setLong(1, feedId);
			stm.executeUpdate();
			Feed f = getFeed(feedId);
			if (f != null) {
				String fd = f.getFeed();
				if (fd != null && fd.length() > 100)
					fd = fd.substring(0, 100) + " ...";
				ZaloLinkFeed lf = new ZaloLinkFeed("http://vietpage.info/feed?comid=" + f.getComid() + "&feedId=" + f.getId(), f.getComName() + ":" + f.getTitle(), f.getFeed(), "http://vietpage.info" + f.getThumb1Image());
				lf.setMessage(fd);
				try {
					SocialServiceFactory.getZaloService().pushLinkFeed(lf);
				} catch (Exception e) {
					log.error("", e);
				}
				try {
					SocialServiceFactory.getFaceBookService().postFeed(new FaceBookFeed("http://vietpage.info/vietpageDetail?type=news&id="+f.getId(), lf.getLinkTitle(), lf.getLinkDesc(), lf.getLinkThumb()));
				} catch (Exception e) {
					log.error("", e);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			;
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return feeds;
	}

	public List<Feed> rejectFeed(long feedId) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		List<Feed> feeds = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("update feed set approve = 2 where id=?");
			stm.setLong(1, feedId);
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return feeds;
	}

	public List<Feed> getFeeds(int limit) throws Exception {

		JCSCacheClient cache = JSCCacheManager.getInstace().getFeedCache();
		Object tmp = cache.get("LastedFeeds");
		if (tmp != null && ((List<Feed>) tmp).size() > 0)
			return (List<Feed>) tmp;

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<Feed> feeds = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE f.approve = true and DATE(posted_date) >= CURDATE() - INTERVAL 30 DAY and c.id=f.comid ORDER BY f.id DESC limit " + limit);
			result = stm.executeQuery();
			feeds = resulSetToList(result, true);
			if (feeds.size() <= 20) {
				stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE f.approve = true and c.id=f.comid ORDER BY f.id DESC limit " + limit);
				result = stm.executeQuery();
				feeds = resulSetToList(result, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		cache.put("LastedFeeds", feeds);
		return feeds;
	}

	public Map<String, List<Feed>> getRecentFeeds(int limit) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		Map<String, List<Feed>> feed = new HashMap<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			for (KeyValue sv : ServiceTypeBean.getInstance().getHotServiceType()) {
				List<Feed> feeds = new ArrayList<>();
				stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE f.approve = 1 and DATE(posted_date) >= CURDATE() - INTERVAL 30 DAY and c.id=f.comid and c.service_id = ? ORDER BY f.id DESC limit " + limit);
				stm.setLong(1, Long.valueOf(sv.getKey()));
				result = stm.executeQuery();
				feeds = resulSetToList(result, true);
				if (feeds.size() <= 20) {
					stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE f.approve = 1 and c.id=f.comid and c.service_id = ? ORDER BY f.id DESC limit " + limit);
					stm.setLong(1, Long.valueOf(sv.getKey()));
					result = stm.executeQuery();
					feeds = resulSetToList(result, true);
				}
				feed.put(sv.getValue(), feeds);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return feed;

	}

	private List<Feed> resulSetToList(ResultSet result, boolean getComName) throws SQLException {
		List<Feed> feeds = new ArrayList<>();
		while (result.next()) {
			Feed a = new Feed();
			a.setId(result.getInt("id"));
			a.setFeed(result.getString("feed"));
			a.setImage(result.getString("image"));
			a.setTitle(result.getString("title"));
			a.setLink(result.getString("link"));
			a.setThumb1Image(result.getString("thumb1_image"));
			a.setThumb2Image(result.getString("thumb2_image"));
			a.setPostedDate(result.getDate("posted_date"));
			a.setComid(result.getLong("comid"));
			a.setViewCount(result.getInt("view_count"));
			if (getComName) {
				a.setComName(result.getString("name"));
			}
			feeds.add(a);
		}
		return feeds;
	}

	public List<Feed> getFeeds(long comId, int limit) throws Exception {

		// JCS cache = JSCCacheManager.getInstace().getCache(CacheType.FEEDS);
		// Object tmp = cache.get(comId);
		// if(tmp != null && ((List<Feed>)tmp).size()>0)
		// return (List<Feed>)tmp;

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<Feed> feeds = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select * from feed where comid=? order by id desc limit " + limit);
			stm.setLong(1, comId);
			result = stm.executeQuery();
			feeds = resulSetToList(result, false);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		// cache.put(comId, feeds);
		return feeds;
	}

	public Feed getFeed(long id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		Feed a = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("SELECT  *, c.name FROM feed f, company c WHERE c.id=f.comid and f.id=?");
			stm.setLong(1, id);
			result = stm.executeQuery();
			List<Feed> f = resulSetToList(result, true);
			if (f != null && f.size() > 0)
				return f.get(0);
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
		return a;
	}

	public void editFeedInfo(Feed n) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Update feed set feed=?,posted_date=?,image=?,title=?,thumb1_image=?,thumb2_image=?, link=? where id=?");
			stm.setString(1, n.getFeed());
			stm.setDate(2, new Date(System.currentTimeMillis()));
			stm.setString(3, n.getImage());
			stm.setString(4, n.getTitle());
			if (n.getImage() != null && n.getImage().lastIndexOf("/") > 0) {
				String impagePath = n.getImage().substring(0, n.getImage().lastIndexOf("/") + 1);
				String name = n.getImage().substring(n.getImage().lastIndexOf("/") + 1, n.getImage().length());
				stm.setString(5, impagePath + "thumbnail." + name);
				stm.setString(6, impagePath + "thumbnail-" + name);
			} else {
				stm.setString(5, "");
				stm.setString(6, "");
			}
			stm.setString(7, n.getLink());
			stm.setLong(8, n.getId());
			stm.executeUpdate();
			clearFeedCache();
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
	}

	private void clearFeedCache() {
		try {
			JSCCacheManager.getInstace().getFeedCache().clear();
		} catch (CacheException e) {
			log.error("", e);
		}
	}

	public void addFeed(Feed n) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("insert into feed(feed,comid,posted_date,image,title,link,thumb1_image,thumb2_image) values(?,?,?,?,?,?,?,?)");
			stm.setString(1, n.getFeed());
			stm.setLong(2, n.getComid());
			stm.setDate(3, new Date(System.currentTimeMillis()));
			stm.setString(4, n.getImage());
			stm.setString(5, n.getTitle());
			stm.setString(6, n.getLink());
			if (n.getImage() != null && !n.getImage().isEmpty()) {
				stm.setString(7, n.getThumb1Image());
				stm.setString(8, n.getThumb2Image());
			} else {
				stm.setString(7, null);
				stm.setString(8, null);
			}

			stm.executeUpdate();
			clearFeedCache();
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
	}

	public void removeFeed(long id) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("delete from feed where id = ?");
			stm.setLong(1, id);
			stm.executeUpdate();
			clearFeedCache();
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
	}
}
