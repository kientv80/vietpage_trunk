package com.vnsoft.server.actions;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.FeedBean;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.model.Feed;
import com.vnsoft.server.model.Item;

public class FBPluginAction extends BaseAction {
	String title;
	String desc;
	String url;
	String imageUrl;
	String targetUrl;
	private String type;
	private String id;
	public static String DOMAIN="http://vietpage.info";
	Logger log = Logger.getLogger(FBPluginAction.class);
	@Override
	public String execute() throws Exception {
		if ("news".equals(type) && isNumber(id)) {
			Feed f = FeedBean.getInstance().getFeed(Long.valueOf(id));
			if (f != null) {
				title = f.getTitle();
				desc = f.getFeed();
				url=DOMAIN + "/vietpageDetail?type=news&id="+id;
				imageUrl = f.getImage();
				targetUrl = DOMAIN+ "/feed?comid="+f.getComid()+"&feedId="+f.getId();
			}
			return SUCCESS;
		}else if ("item".equals(type) && isNumber(id)) {
			Item i = MenuBean.getInstance().getItem(Integer.valueOf(id));
			title = i.getName();
			desc = i.toString();
			url=DOMAIN + "/vietpageDetail?type=item&id="+id;
			imageUrl = i.getImagePath();
			targetUrl = DOMAIN+ "/items?comid="+i.getComId()+"&id="+i.getId()+"&action=viewItem";
			return SUCCESS;
		}else{
			getHttpServletResponse().sendRedirect("/home");
			return SUCCESS;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
