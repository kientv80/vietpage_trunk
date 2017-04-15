package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.net.URL;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.FeedBean;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.biz.VisistorBean;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.Feed;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.model.Menu;
import com.vnsoft.server.model.News;

public class MyPageAction extends BaseAction {
	private static final int MAX_GET_ITEMS = 10;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6922704335078532732L;
	private String content;
	private List<News> news = new ArrayList<>();
	private List<Item> newItems = new ArrayList<>();
	private List<Item> discountItems = new ArrayList<>();
	private List<CompanyInfo> suggestComs = new ArrayList<>();
	private List<CompanyInfo> recentComs = new ArrayList<>();
	private int locationId;
	private String serviceTypeId;
	private int selectedCity;
	private String searchText;
	private List<CompanyInfo> companies = new ArrayList<>();
	private List<Feed> feeds = new ArrayList<>();
	private Logger logger = Logger.getLogger(MyPageAction.class);
	private List<Item> suggestItems = new ArrayList<>();
	private List<Menu> menus;
	private String displayTabs = "";
	private Feed latestFeed = null;
	private List<Feed> hottestFeeds = new ArrayList<>();
	private List<Feed> hightLightFeeds = new ArrayList<>();
	private Map<String,List<Feed>> recentFeeds = new HashMap<String, List<Feed>>();
	private String recentVisit;
	public List<CompanyInfo> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyInfo> companies) {
		this.companies = companies;
	}

	@Override
	public String execute() {
		String result = SUCCESS;
		try {
			logger.debug("MyPageAction: action=" + getAction() + " serviceTypeId=" + serviceTypeId);
			System.out.println("MyPageAction: action=" + getAction() + " serviceTypeId=" + serviceTypeId);
			
			URL url = new URL(getHttpServletRequest().getRequestURL().toString());
			String pageName = url.getPath();
			loadSearchCategories(selectedCity,true);
			if ("/home".equals(pageName) || "/".equals(pageName) || "/news".equals(pageName)) {
				if("true".equals(recentVisit)){
					List<Long> recentVisitedPages = VisistorBean.getInstance().getRecentVisitPages(getHttpServletRequest(), getHttpServletResponse());
					for(Long id : recentVisitedPages){
						CompanyInfo ci = CompanyBean.getInstance().getCompanyInfo(id);
						if(ci != null)
							recentComs.add(ci);
					}
				}

				if (serviceTypeId == null || serviceTypeId.isEmpty()) {
					loadFeeds();
					newItems = MenuBean.getInstance().getNewItems(MAX_GET_ITEMS,0);
					shottenItemDesc(newItems);
					discountItems = MenuBean.getInstance().getDiscountedItems(MAX_GET_ITEMS,0);
					shottenItemDesc(discountItems);
					if(!"true".equals(recentVisit))
						result = "feed";
					else
						result = "pages";
					
				} else if (isNumber(serviceTypeId)) {
					if ("search".equals(getAction())) {
						setCompanies(CompanyBean.getInstance().getCompanyInfo(selectedCity, locationId, Integer.valueOf(serviceTypeId), searchText));
						for (CompanyInfo com : companies) {
							if (com.getDescription() != null && com.getDescription().length() > 400)
								com.setDescription(com.getDescription().substring(0, 200) + " ... ");
							if (searchText != null && !searchText.isEmpty())
								com.setName(com.getName().replaceAll(searchText, "<b>" + searchText + "</b>"));
						}
						result = "pages";
					} else {
						setCompanies(CompanyBean.getInstance().getCompanyInfo(0, 0, Integer.valueOf(serviceTypeId), null));
						for (CompanyInfo com : companies) {
							if (com.getDescription() != null && com.getDescription().length() > 400)
								com.setDescription(com.getDescription().substring(0, 200) + " ... ");
							if (searchText != null && !searchText.isEmpty())
								com.setName(com.getName().replaceAll(searchText, "<b>" + searchText + "</b>"));
						}
						trackingVisit("vietpage_home");
						System.out.println(">>>>>>>>> found " + companies.size());
						result = "pages";
					}
				}
				
				String visistorId = getVisistorId();
				Map<String, List<Integer>> scores = VisistorBean.getInstance().getUserInterestedScores(visistorId);
				if (scores.get(VisistorBean.TOP3_MOST_INTERESTED_SERVICES).size() > 0) {
					suggestComs.clear();
					for (int sid : scores.get(VisistorBean.TOP3_MOST_INTERESTED_SERVICES)) {
						getSuggestComs().addAll(CompanyBean.getInstance().getCompanyInfoByService(sid, 2));
					}
					if (suggestComs.size() > 0) {
						for (CompanyInfo c : suggestComs) {
							if (c.getDescription() != null && (c.getDescription().length() > 200)) {
								c.setDescription(c.getDescription().substring(0, 200) + " ...");
							}
						}
					}
				}
				if(suggestComs.size() < 5 ){
					suggestComs.clear();
					for (KeyValue k : getHotservices()) {
						getSuggestComs().addAll(CompanyBean.getInstance().getCompanyInfoByService(Long.valueOf(k.getKey()), 2));
					}
					if (suggestComs.size() > 0) {
						for (CompanyInfo c : suggestComs) {
							if (c.getDescription() != null && (c.getDescription().length() > 200)) {
								c.setDescription(c.getDescription().substring(0, 200) + " ...");
							}
						}
					}
				}
				suggestComs.removeAll(recentComs);
			} else {
				getHttpServletRequest().setAttribute("page", pageName.substring(1, pageName.length()));
				result = "vietpage";
			}

		} catch (Exception e) {
			logger.error("", e);
		}
		if (isMobilePhone(getHttpServletRequest())) {
			return "m_" + result;
		} else {
			return result;
		}
	}

	private void loadFeeds() throws Exception {
		feeds = FeedBean.getInstance().getFeeds(11);
		int hotFeedCount = 2;
		if (feeds.size() > 0) {
			setLatestFeed(feeds.get(0));
			latestFeed.setFeed(latestFeed.getFeed().replaceAll("\\<.*?\\>", ""));
			if(isMobilePhone(getHttpServletRequest())){
				if (latestFeed.getFeed().length() > 50) {
					latestFeed.setFeed(latestFeed.getFeed().substring(0, 50));
				}
			}else{
				if (latestFeed.getFeed().length() > 250) {
					latestFeed.setFeed(latestFeed.getFeed().substring(0, 250)+"...");
				}
				if (latestFeed.getTitle() != null && latestFeed.getTitle().length() > 100) {
					latestFeed.setTitle(latestFeed.getTitle().substring(0, 100)+"...");
				}
			}

		}
		if (feeds.size() > 1 && feeds.size() < hotFeedCount + 1) {
			setHottestFeeds(feeds.subList(1, feeds.size()));
		} else if (feeds.size() > 1 ){
			setHottestFeeds(feeds.subList(1, hotFeedCount + 1));
		}
		for (Feed f : hottestFeeds) {
			if (f.getTitle().length() > 100) {
				f.setTitle(f.getTitle().substring(0, 100) + " ...");
			}
		}
		if (feeds.size() > hotFeedCount + 1) {
			if(feeds.size() > hotFeedCount + 8)
				setHightLightFeeds(feeds.subList(hotFeedCount + 1, hotFeedCount + 8));
			else
				setHightLightFeeds(feeds.subList(hotFeedCount + 1, feeds.size()));
		}
		for (Feed f : hightLightFeeds) {
			if (f.getTitle().length() > 50) {
				f.setTitle(f.getTitle().substring(0, 50) + " ...");
			}
			if (f.getFeed().length() > 100) {
				f.setFeed(f.getFeed().substring(0, 100)+"...");
			}
		}
		setRecentFeeds(FeedBean.getInstance().getRecentFeeds(100));
		for(List<Feed> f : recentFeeds.values()){
			f.removeAll(feeds);
			for(Feed tmp : f){
				tmp.setFeed(tmp.getFeed().replaceAll("\\<.*?\\>", ""));
				if (tmp.getFeed().length() > 100) {
					tmp.setFeed(tmp.getFeed().substring(0, 100)+"...");
				}
				if (tmp.getTitle().length() > 50) {
					tmp.setTitle(tmp.getTitle().substring(0, 50) + " ...");
				}
			}
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(int selectedCity) {
		this.selectedCity = selectedCity;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public List<CompanyInfo> getSuggestComs() {
		return suggestComs;
	}

	public void setSuggestComs(List<CompanyInfo> suggestComs) {
		this.suggestComs = suggestComs;
	}

	public List<Item> getSuggestItems() {
		return suggestItems;
	}

	public void setSuggestItems(List<Item> suggestItems) {
		this.suggestItems = suggestItems;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getDisplayTabs() {
		return displayTabs;
	}

	public void setDisplayTabs(String displayTabs) {
		this.displayTabs = displayTabs;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public Feed getLatestFeed() {
		return latestFeed;
	}

	public void setLatestFeed(Feed latestFeed) {
		this.latestFeed = latestFeed;
	}

	public List<Feed> getHottestFeeds() {
		return hottestFeeds;
	}

	public void setHottestFeeds(List<Feed> hottestFeeds) {
		this.hottestFeeds = hottestFeeds;
	}

	public List<Feed> getHightLightFeeds() {
		return hightLightFeeds;
	}

	public void setHightLightFeeds(List<Feed> hightLightFeeds) {
		this.hightLightFeeds = hightLightFeeds;
	}

	public List<Item> getNewItems() {
		return newItems;
	}

	public void setNewItems(List<Item> newItems) {
		this.newItems = newItems;
	}

	public List<Item> getDiscountItems() {
		return discountItems;
	}

	public void setDiscountItems(List<Item> discountItems) {
		this.discountItems = discountItems;
	}
	public static void main(String[] args) {
        /*java.net.URL oracle = new java.net.URL("http://vnexpress.net/tin-tuc/thoi-su/de-xuat-lam-cau-duong-sat-sat-cau-long-bien-2960116.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        
        in.close();*/
		int count = 1;
		if(count%2==1)
			System.out.println("ok man");
	}

	public List<CompanyInfo> getRecentComs() {
		return recentComs;
	}

	public void setRecentComs(List<CompanyInfo> recentComs) {
		this.recentComs = recentComs;
	}

	public Map<String,List<Feed>> getRecentFeeds() {
		return recentFeeds;
	}

	public void setRecentFeeds(Map<String,List<Feed>> recentFeeds) {
		this.recentFeeds = recentFeeds;
	}

	public String getRecentVisit() {
		return recentVisit;
	}

	public void setRecentVisit(String recentVisit) {
		this.recentVisit = recentVisit;
	}
}
