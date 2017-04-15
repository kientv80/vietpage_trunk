package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;

import com.vnsoft.server.biz.FeedBean;
import com.vnsoft.server.model.Feed;

public class ApproveFeedAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3449672975636385913L;
	private String feedId;
	private String isApproved = null;
	private List<Feed> feeds = new ArrayList<>();

	@Override
	public String execute() throws Exception {
		if ("approve".equals(getAction())) {
			if (isNum(feedId)) {
				log.info(">>>>>>>>>>>> approve feed");
				FeedBean.getInstance().approveFeed(Long.valueOf(getFeedId()));
			}

		} else if ("reject".equals(getAction())) {
			if (isNum(feedId)) {
				FeedBean.getInstance().rejectFeed(Long.valueOf(getFeedId()));
			}
		}
		setFeeds(FeedBean.getInstance().getPendingFeeds());
		return SUCCESS;
	}

	private boolean isNum(String comid) {
		try {
			Integer.parseInt(comid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
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

}
