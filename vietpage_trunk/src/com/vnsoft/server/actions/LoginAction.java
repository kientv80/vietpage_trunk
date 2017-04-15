package com.vnsoft.server.actions;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.UserBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.User;
import com.vnsoft.server.plugin.social.SocialServiceFactory;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;

public class LoginAction extends StandarLayout {
	public static final String COMPANY_INFO = "company_info";
	/**
	 * 
	 */
	private static final long serialVersionUID = -2003161624775230261L;
	public static final String USER = "USER";
	private String username;
	private String password;
	private Logger logger = Logger.getLogger(LoginAction.class);

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() {
		try {
			if ("logout".equals(getAction())) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> logout");
				CompanyInfo com = (CompanyInfo) ActionContext.getContext().getSession().get(COMPANY_INFO);
				ActionContext.getContext().getSession().remove(COMPANY_INFO);
				ActionContext.getContext().getSession().remove("isLogin");
				if (com != null)
					getHttpServletResponse().sendRedirect("/vietpage?comid=" + com.getId());
				return "home";
			} else if ("login".equals(getAction())) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> login");
				User user = UserBean.getInstance().login(username, password);
				if (user != null) {
					Map session = ActionContext.getContext().getSession();
					session.put(USER, user);
					session.put("isLogin", true);
					CompanyInfo com = CompanyBean.getInstance().getCompanyInfoByOwner(user.getId());
					Map<String, Object> params = ActionContext.getContext().getParameters();
					params.put("action", AuthorizationInterceptor.EDIT);
					params.put("type", AuthorizationInterceptor.TYPE_COMPANY);
					params.put("id", com.getId());
					ActionContext.getContext().setParameters(params);
					session.put(COMPANY_INFO, com);
					if ("admin".equals(user.getRole())){
						Facebook facebook = new FacebookFactory().getInstance();
						facebook.setOAuthAppId("382999278501512", "a70c6de5f0ffc6810dc475143c7d46dd");
						facebook.setOAuthPermissions("publish_actions,publish_stream,read_stream,manage_pages");
						getHttpServletRequest().getSession().setAttribute("facebook", facebook);
						getHttpServletRequest().getSession().setAttribute("authen","true");
						SocialServiceFactory.getFaceBookService().setFacebook(facebook);
						String callbackURL = "http://vietpage.info/callback";
						getHttpServletResponse().sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
						return "admin";
					}
					if(isMobilePhone(getHttpServletRequest())){
						return "m_" + SUCCESS;
					}
					return SUCCESS;
				} else {
					if(isMobilePhone(getHttpServletRequest())){
						return "m_" + LOGIN;
					}
					return LOGIN;
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		if(isMobilePhone(getHttpServletRequest())){
			return "m_" + LOGIN;
		}
		return LOGIN;
	}

}
