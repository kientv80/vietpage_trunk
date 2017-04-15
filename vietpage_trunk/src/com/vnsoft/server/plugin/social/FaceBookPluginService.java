package com.vnsoft.server.plugin.social;

import facebook4j.Facebook;

public interface FaceBookPluginService extends Runnable{
	public void postFeed(FaceBookFeed feed);
	public void setFacebook(Facebook facebook);
}
