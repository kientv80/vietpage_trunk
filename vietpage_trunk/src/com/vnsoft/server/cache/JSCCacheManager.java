package com.vnsoft.server.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;

public class JSCCacheManager {

	Logger log = Logger.getLogger(JSCCacheManager.class);
	private static JSCCacheManager instance;
	private JCSCacheClient pageCache;
	private JCSCacheClient cityCache;
	private JCSCacheClient locationCache;
	private JCSCacheClient pageMainMenu;
	private JCSCacheClient pageMenu;
	private JCSCacheClient newItemCache;
	private JCSCacheClient discountItemCache;
	private JCSCacheClient pageLocationService;
	private JCSCacheClient feedCache;
	private JSCCacheManager() {
		try {
			
			setCityCache(new JCSCacheClient(JCS.getInstance("default")));
			setLocationCache(new JCSCacheClient(JCS.getInstance("default")));
			newItemCache = new JCSCacheClient(JCS.getInstance("default"));
			discountItemCache = new JCSCacheClient(JCS.getInstance("default"));
			
			setPageCache(new JCSCacheClient(JCS.getInstance("PAGE")));
			setPageLocationService(new JCSCacheClient(JCS.getInstance("pagelocation")));
			
			setPageMainMenu(new JCSCacheClient(JCS.getInstance("menu")));
			setPageMenu(new JCSCacheClient(JCS.getInstance("menu")));
			
			setFeedCache(new JCSCacheClient(JCS.getInstance("feed")));
			
		} catch (CacheException e) {
			e.printStackTrace();
			log.error("", e);
		}
	}

	public static JSCCacheManager getInstace() {
		synchronized (JSCCacheManager.class) {
			if (instance == null)
				instance = new JSCCacheManager();
		}
		return instance;
	}

	public JCSCacheClient getPageCache() {
		return pageCache;
	}

	public void setPageCache(JCSCacheClient pageCache) {
		this.pageCache = pageCache;
	}

	public JCSCacheClient getCityCache() {
		return cityCache;
	}

	public void setCityCache(JCSCacheClient cityCache) {
		this.cityCache = cityCache;
	}

	public JCSCacheClient getLocationCache() {
		return locationCache;
	}

	public void setLocationCache(JCSCacheClient locationCache) {
		this.locationCache = locationCache;
	}

	public JCSCacheClient getPageMainMenu() {
		return pageMainMenu;
	}

	public void setPageMainMenu(JCSCacheClient pageMainMenu) {
		this.pageMainMenu = pageMainMenu;
	}

	public JCSCacheClient getPageMenu() {
		return pageMenu;
	}

	public void setPageMenu(JCSCacheClient pageMenu) {
		this.pageMenu = pageMenu;
	}

	public JCSCacheClient getNewItemCache() {
		return newItemCache;
	}

	public void setNewItemCache(JCSCacheClient newItemCache) {
		this.newItemCache = newItemCache;
	}

	public JCSCacheClient getDiscountItemCache() {
		return discountItemCache;
	}

	public void setDiscountItemCache(JCSCacheClient discountItemCache) {
		this.discountItemCache = discountItemCache;
	}

	public JCSCacheClient getPageLocationService() {
		return pageLocationService;
	}

	public void setPageLocationService(JCSCacheClient pageLocationService) {
		this.pageLocationService = pageLocationService;
	}

	public JCSCacheClient getFeedCache() {
		return feedCache;
	}

	public void setFeedCache(JCSCacheClient feedCache) {
		this.feedCache = feedCache;
	}

}
