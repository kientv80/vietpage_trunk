package com.vnsoft.server.actions;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.PageContext;

import com.opensymphony.xwork2.ActionContext;

public class ChangeLanguageAction extends BaseAction{
//	private String currentUrl="";
	private String language="";
	List<String> languages = Arrays.asList(new String[]{"en","vi"});
	@Override
	public String execute() throws Exception {
		getHttpServletRequest().getSession(true).setAttribute("WW_TRANS_I18N_LOCALE", language);//WW_TRANS_I18N_LOCALE
		System.out.println("========="+getHttpServletRequest().getSession(true).getAttribute("WW_TRANS_I18N_LOCALE").toString());
//		if(languages.contains(language)){
//			Locale locale = new Locale(language);
//			ActionContext.getContext().setLocale(locale);
////			getHttpServletRequest().getRequestDispatcher(currentUrl).forward(getHttpServletRequest(), getHttpServletResponse());
//		}
		return SUCCESS;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
//	public String getCurrentUrl() {
//		return currentUrl;
//	}
//	public void setCurrentUrl(String currentUrl) {
//		this.currentUrl = currentUrl;
//	}
}
