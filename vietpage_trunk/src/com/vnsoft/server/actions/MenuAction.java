package com.vnsoft.server.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.model.Menu;

public class MenuAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8063634783217332057L;
	private List<Menu> menus;
	private String name;
	private String description;
	private String targetUrl;
	private List<Item> items = new ArrayList<>();
	private Logger logger = Logger.getLogger(MenuAction.class);
	
	public String execute() {
		try {
//			init();
			if (getComId() == null || getComId().isEmpty()) {
				return "nocompanyid";
			}
			if("new".equals(getAction())){
				Menu m = new Menu();
				m.setName(getName());
				m.setDescription(getDescription());
				m.setComid(Integer.valueOf(getComId()));
				MenuBean.getInstance().addNewMenuGroup(m);
			}else if(AuthorizationInterceptor.EDIT.equals(getAction())){
				Menu m = new Menu();
				m.setName(getName());
				m.setDescription(getDescription());
				m.setComid(Integer.valueOf(getComId()));
				m.setId(Integer.valueOf(getId()));
				MenuBean.getInstance().updateMenu(m);
			}else if("delete".equals(getAction())){
				if(getId()!= null && !getId().isEmpty())
					MenuBean.getInstance().deleteMenu(Integer.valueOf(getId()),Long.valueOf(getComId()));
			}
			menus = MenuBean.getInstance().loadMenus(Long.valueOf(getComId()));
			setItems(MenuBean.getInstance().getAllMenuItems(Long.valueOf(getComId())));
		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		}
		super.execute();
		if(targetUrl != null && !targetUrl.isEmpty()){
			return targetUrl;
		}else{
			return SUCCESS;
		}
	}

	public List<Menu> getMenus() {
		return menus;
	}
	public List<Item> getItems() {
		return items ;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public static void main(String[] args) {
		File a = new File("D:\\Working\\projects\\example\\webapps\\js");
		for (File f : a.listFiles()) {
			System.out.println("<script src=\"../js/" + f.getName() + "\"></script>");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
}
