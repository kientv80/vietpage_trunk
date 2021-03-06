package com.vnsoft.server.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.Item;
import com.vnsoft.server.model.Menu;
import com.vnsoft.server.model.MenuJSONObject;
import com.vnsoft.server.util.JSONHelper;
import com.vnsoft.server.util.UIHelper;

public class MenuTag extends TagSupport{
	private List<Menu> menus;
	private String width;
	private String height;
	private String divId;
	private String btnPrefix;
	private String editable;
	private String editItemCallBack;
	private boolean showContInf;
	private boolean showAssessment;
	private Logger log = Logger.getLogger(MenuTag.class);
	@Override
	public int doEndTag() throws JspException {
		List<MenuJSONObject> menuJson = new ArrayList<MenuJSONObject>();
		StringBuilder buttons = new StringBuilder();
		List<String> buttonIds = new ArrayList<>();
		if(menus != null){
			for(Menu menu: menus){
				MenuJSONObject jobj = new MenuJSONObject();
				jobj.setLabel(menu.getName());
				StringBuilder itemsHTML = new StringBuilder();
				itemsHTML.append("<table>");
				for(Item item: menu.getItems()){
					itemsHTML.append("<tr><td>");
					if("true".equals(editable)){
						itemsHTML.append(UIHelper.itemToHTML(getWidth(), getHeight(), item,true,btnPrefix,editItemCallBack,false,pageContext,true,showContInf,showAssessment));
						if(!buttonIds.contains( btnPrefix+menu.getId()+"_"+item.getId())){
							buttons.append( btnPrefix).append(menu.getId()+"_"+item.getId()).append(",");
							buttonIds.add(btnPrefix+menu.getId()+"_"+item.getId());
						}
						
					}else{
						itemsHTML.append(UIHelper.itemToHTML(getWidth(), getHeight(), item,false,btnPrefix,editItemCallBack,false,pageContext,true,showContInf,showAssessment));
						if(!buttonIds.contains( "btn"+menu.getId()+"_"+item.getId())){
							buttons.append( "btn").append(menu.getId()+"_"+item.getId()).append(",");
							buttonIds.add("btn"+menu.getId()+"_"+item.getId());
						}
					}
					
					itemsHTML.append("</td></tr>");
				}
				itemsHTML.append("</table>");
				jobj.setContent(itemsHTML.toString());
				menuJson.add(jobj);
			}
			pageContext.setAttribute("menuButtons", buttons);
		}

		StringBuilder content = new StringBuilder();
		try {

			content.append("<script type=\"text/javascript\">YUI().use('tabview', function(Y) {").append("\n");
			content.append("var tabview = new Y.TabView({").append("\n");
			content.append("    children: ").append("\n");
			content.append(JSONHelper.toJSONArray(menuJson).toString()).append("\n");
			content.append("});");
			content.append("    tabview.render('#"+divId+"');tabview.selectChild(0);});</script>").append("\n");
			pageContext.getOut().print(content.toString());
		} catch (Exception e) {
			log.error("", e);
		}
		return EVAL_PAGE;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public String getBtnPrefix() {
		return btnPrefix;
	}

	public void setBtnPrefix(String btnPrefix) {
		this.btnPrefix = btnPrefix;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getEditItemCallBack() {
		return editItemCallBack;
	}

	public void setEditItemCallBack(String editItemCallBack) {
		this.editItemCallBack = editItemCallBack;
	}

	public boolean getShowContInf() {
		return showContInf;
	}

	public void setShowContInf(boolean showContInf) {
		this.showContInf = showContInf;
	}

	public boolean getShowAssessment() {
		return showAssessment;
	}

	public void setShowAssessment(boolean showAssessment) {
		this.showAssessment = showAssessment;
	}
}
