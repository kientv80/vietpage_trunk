package com.vnsoft.server.actions;


public class LookupRedirectAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -994110734927713633L;
	private String comid;
	private String webid;
	private String domain;
	private String redirectUrl;
	@Override
	public String execute() throws Exception {
		if(getDomain()!=null && !getDomain().isEmpty())
			trackingVisit(getDomain());
		
		if(redirectUrl != null){
			getHttpServletResponse().sendRedirect(redirectUrl);
			return null;
		}
		return super.execute();
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getWebid() {
		return webid;
	}
	public void setWebid(String webid) {
		this.webid = webid;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}

}
