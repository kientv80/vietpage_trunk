package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vng.zalosdk.service.ZaloMessageService;
import com.vng.zalosdk.service.ZaloServiceConfigure;
import com.vng.zalosdk.service.ZaloServiceFactory;
import com.vnsoft.server.biz.FeedBean;
import com.vnsoft.server.biz.TrackingBean;
import com.vnsoft.server.model.Feed;
import com.vnsoft.server.plugin.social.SocialServiceFactory;
import com.vnsoft.server.plugin.social.ZaloLinkMessage;
import com.vnsoft.server.plugin.social.ZaloService;
import com.vnsoft.server.util.IdGeneratorHelper;

public class FeedAction extends StandarLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8102357965767210059L;
	private String feed;
	private String title;
	private String link;
	private List<Feed> feeds = new ArrayList<>();

	private String feedId = null;

	@Override
	public String execute() {
		try {
			System.out.println("feed>>>>>>>>>>>>>>>>>>>>> id" + getComId());
			if(getFeedId() != null && isNumber(getFeedId())){
				Feed f = FeedBean.getInstance().getFeed(Long.valueOf(getFeedId()));
				if(f != null){
					feeds.add(f);
					TrackingBean.getInstance().feedViewTracking(f.getId());
				}
				else
					feeds = FeedBean.getInstance().getFeeds(Long.valueOf(getComId()), 10);
			}else{
				feeds = FeedBean.getInstance().getFeeds(Long.valueOf(getComId()), 10);
			}

			System.out.println("Feed found=" + feeds.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.execute();
		if(isMobilePhone(getHttpServletRequest())){
			return "m_"+SUCCESS;
		}
		return SUCCESS;
	}
	@Override
	protected boolean loadItem() {
		return false;
	}
	public String manage() {
		try {
			if ("add".equals(getAction())) {
				Feed f = new Feed();
				f.setFeed(getFeed());
				f.setTitle(title);
				f.setLink(link);
				String imageUrl="";
				if (file != null && getComId() != null) {
					Map<String,String> images = uploadFile(getComId() + "_feed_" + IdGeneratorHelper.getGenId()+".jpg", getComId(),UPLOAD_OBJECT.FEED);
					f.setImage(images.get(StandarLayout.IMAGE));
					f.setThumb1Image(images.get(StandarLayout.THUMBNAIL));
					f.setThumb2Image(images.get(StandarLayout.THUMBNAIL_SMALL));
					imageUrl = "http://vietpage.info" + images.get(StandarLayout.THUMBNAIL_SMALL);
				}
				f.setComid(Long.valueOf(getComId()));
				FeedBean.getInstance().addFeed(f);
				ZaloService zs = SocialServiceFactory.getZaloService();
				String linkdesc =getFeed();
				if(getFeed()!=null && getFeed().length() > 100)
					linkdesc = getFeed().substring(0,100);
				ZaloLinkMessage msg = new ZaloLinkMessage(84908995558l, "http://vietpage.info/feed?comid="+getComId(), title,linkdesc, imageUrl);
				zs.sendLinkMessageByPhonenumber(msg);
			} else if ("delete".equals(getAction()) && getFeedId() != null && isNumber(getFeedId())) {
				Feed f = FeedBean.getInstance().getFeed(Long.valueOf(getFeedId()));
				if(f.getComid() == Long.valueOf(getComId()).longValue()){
					FeedBean.getInstance().removeFeed(Long.valueOf(getFeedId()));
				}else{
					return "access_denined";
				}
			}
			feeds = FeedBean.getInstance().getFeeds(Long.valueOf(getComId()), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.execute();
		if(isMobilePhone(getHttpServletRequest())){
			return "m_"+SUCCESS;
		}
		return SUCCESS;
	}
	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	

}
