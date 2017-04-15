package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.interceptor.AuthorizationInterceptor;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.model.Menu;

public class SetupMenuAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738125639978025021L;
	private String selectedIds;
	private List<Item> items ;
	private String setupmainmenu;
	private String selectedMenuId;
	private String menuId;
	private String name;
	private String description;
	private String targetUrl;
	private Logger logger = Logger.getLogger(SetupMenuAction.class);
	@Override
	public String execute() {
		try {
			if(getComId() == null || getComId().isEmpty()){
				return "nocompanyid";
			}
			setCurrentPage(ActionContext.getContext().getName());
			System.out.println("getAction>>>>>>>>>>>>>>>>>.."+getAction()+"  setupmainmenu = " + setupmainmenu + " selectedIds="+selectedIds+" selectedMenuId="+selectedMenuId);
			if (AuthorizationInterceptor.EDIT.equals(getAction()) && "editMainMenu".equals(setupmainmenu)) {
				System.out.println("selectedIds>>>>>>>>>>>>>>>>>.."+selectedIds);
				if (selectedIds != null && !selectedIds.isEmpty()) {
					List<Integer> ids = new ArrayList<>();
					for (String id : selectedIds.split(";")) {
						ids.add(Integer.valueOf(id.split(":")[1]));
					}
					MenuBean.getInstance().setMainMenuItems(ids, Integer.valueOf(getComId().trim()));
				}
			}else if (AuthorizationInterceptor.EDIT.equals(getAction()) && "editMenu".equals(setupmainmenu)) {
				if (selectedIds != null && !selectedIds.isEmpty() && selectedMenuId !=null && !selectedMenuId.isEmpty() && !"-1".equals(selectedMenuId)) {
					List<Integer> ids = new ArrayList<>();
					for (String id : selectedIds.split(";")) {
						ids.add(Integer.valueOf(id.split(":")[1]));
					}
					
					if(getComId()!=null)
						MenuBean.getInstance().setupMenu(ids,selectedMenuId,Integer.valueOf(getComId().trim()));
					else
						System.out.println("getComid=null");
				}
			} else if("new_menu_group".equals(getAction())){
				Menu m = new Menu();
				m.setName(getName());
				m.setDescription(getDescription());
				m.setComid(Integer.valueOf(getComId()));
				MenuBean.getInstance().addNewMenuGroup(m);
			}else if("update_menu_group".equals(getAction())){
				Menu m = new Menu();
				m.setName(getName());
				m.setDescription(getDescription());
				m.setComid(Integer.valueOf(getComId()));
				m.setId(Integer.valueOf(getId()));
				MenuBean.getInstance().updateMenu(m);
			}else if("delete_menu_group".equals(getAction())&& !"-1".equals(selectedMenuId)){
				if(getId()!= null && !getId().isEmpty())
					MenuBean.getInstance().deleteMenu(Integer.valueOf(getId()),Long.valueOf(getComId()));
			}
			setMenus(MenuBean.getInstance().loadMenus(Long.valueOf(getComId())));
			if(getCurrentPage().equals("groupmenu")){
				getMenus().add(0, new Menu(-1, "Main menu", "Main Menu"));
			}
//			setItems(MenuBean.getInstance().getAllMenuItems(Long.valueOf(getComId())));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>this is me " + menuId);
			
			super.execute();
		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();{
				
			}
		}
		String result = "";
		if(getTargetUrl() != null && !getTargetUrl().isEmpty()){
			result =  getTargetUrl();
		}else{
			result =  SUCCESS;
		}
		if(isMobilePhone(getHttpServletRequest())){
			return "m_"+result;
		}else{
			return result;
		}
	}

	public String getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getSetupmainmenu() {
		return setupmainmenu;
	}

	public void setSetupmainmenu(String setupmainmenu) {
		this.setupmainmenu = setupmainmenu;
	}

	public String getSelectedMenuId() {
		return selectedMenuId;
	}

	public void setSelectedMenuId(String selectedMenuId) {
		this.selectedMenuId = selectedMenuId;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
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

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
