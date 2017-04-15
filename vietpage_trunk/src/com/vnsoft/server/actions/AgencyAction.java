package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;

import com.vnsoft.server.biz.AgencyBean;
import com.vnsoft.server.model.Agency;
import com.vnsoft.server.model.Website;

public class AgencyAction extends BaseAction {
	private String username;
	private String password;
	private List<Website> websites = new ArrayList<>();
	private boolean login;

	@Override
	public String execute() throws Exception {
		if (getHttpServletRequest().getSession().getAttribute("AGENCY_LOGIN") != null) {
			setLogin(true);
		}
		try {

			System.out.println(getAction() + getUsername() + getPassword());
			if ("login".equals(getAction())) {
				Agency a = AgencyBean.getInstance().login(getUsername(), getPassword());
				if (a != null) {
					getHttpServletRequest().getSession().setAttribute("AGENCY_LOGIN", a);
					login = true;
					System.out.println("Login successful");
				}
			} else if ("logout".equals(getAction())) {
				getHttpServletRequest().getSession().removeAttribute("AGENCY_LOGIN");
				login = false;
			}
			if (getHttpServletRequest().getSession().getAttribute("AGENCY_LOGIN") != null) {
				Agency a = (Agency) getHttpServletRequest().getSession().getAttribute("AGENCY_LOGIN");
				System.out.println(a.getId());
				setWebsites(AgencyBean.getInstance().getWebsites(a.getId()));
				System.out.println(getWebsites().size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Agency login(String username, String pass) {

		return null;
	}

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

	public boolean getLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public List<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}
}
