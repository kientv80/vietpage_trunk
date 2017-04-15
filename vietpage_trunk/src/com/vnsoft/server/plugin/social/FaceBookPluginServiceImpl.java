package com.vnsoft.server.plugin.social;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.PrivacyBuilder;
import facebook4j.PrivacyParameter;
import facebook4j.PrivacyType;

public class FaceBookPluginServiceImpl implements FaceBookPluginService {
	private final BlockingQueue<FaceBookFeed> jobs = new LinkedBlockingQueue<FaceBookFeed>(6000);
	private Logger log = Logger.getLogger(FaceBookPluginServiceImpl.class);
	private Facebook facebook = null;
	private static FaceBookPluginService instance = null;
	private FaceBookPluginServiceImpl() {
	}
	public static FaceBookPluginService getInstance(){
		if(instance == null){
			instance = new  FaceBookPluginServiceImpl();
			new Thread(instance).start();
		}
		return instance;
	}
	@Override
	public void run() {
		while (true) {
			try {
				if (this.facebook != null) {
					log.info(">>>>>>>>>>>>>>>>>>>..Process post FB feed");
					execute(jobs.take());
				}
			} catch (InterruptedException e) {
				log.error("", e);
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}
	private void execute(FaceBookFeed feed) {
		try {
			PostUpdate u = new PostUpdate(feed.getLinkTitle());
			u.setCaption(feed.getLinkTitle());
			u.setDescription(feed.getLinkDesc().replaceAll("\\<.*?\\>", ""));
			u.setLink(new URL(feed.getLink()));
			u.setPicture(new URL(feed.getLinkThumb()));
			u.setPublished(true);
			log.info("Post FaceBook feed URL=" + feed.getLink());
			PrivacyParameter privacy = new PrivacyBuilder().setValue(PrivacyType.ALL_FRIENDS).build();
			u.setPrivacy(privacy);
			getFacebook().postFeed("545910802183206",u);
			getFacebook().postFeed(u);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		}
	}

	public static void main(String[] args) {
	}

	@Override
	public void postFeed(FaceBookFeed feed) {
		try {
			log.info(">>>>>>>>>>>> postFeed = " + feed.linkTitle);
			jobs.put(feed);
		} catch (InterruptedException e) {
			log.error("", e);
		}
	}
	public Facebook getFacebook() {
		return this.facebook;
	}
	@Override
	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}

}
