package com.vnsoft.server.tags.yui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

public class YUITabViewTag extends YUICustomTag{
	private String displayTabs="";//fieldName:Label,fieldName:Label
	private Map<String,Object> data = new HashMap<>();//key is displayTabs fieldName
	private String contentProviderClass;
	private String customParams=null;//for mat key=value,key=value
	private String tabviewContainerCSS="";
	private String tabviewContentCSS="";
	private String tabviewOnSelection;
	Logger log = Logger.getLogger(YUITabViewTag.class);
	String id;
	@Override
	public int doEndTag() throws JspException {
		
		StringBuilder tmp = new StringBuilder();
		Map params = new HashMap<>();
		params.put("displayTabs", displayTabs);
		params.put("id", id);
		if(customParams !=null){
			String[] cparams = customParams.split(",");
			for(String cparam: cparams){
				String [] p = cparam.split("=");
				if(p.length !=2)
					throw new JspException("customParams must have format key=value,key=value");
				params.put(p[0], p[1]);
			}
		}
		try {
			TabViewContentProvider contentBuilder = (TabViewContentProvider)Class.forName(getContentProviderClass()).newInstance();
			String[] tabs = getDisplayTabs().split(",");
			tmp.append("<div id=\""+id+"\" class=\""+tabviewContainerCSS+"\">").append("\n");//Start container div
			tmp.append(buildTabs());//build tab
			tmp.append("<div class=\""+tabviewContentCSS+"\">").append("\n");//Start tab content
			for(String tab : tabs){
				String t[] = tab.split(":");
				if(t.length == 2){
					tmp.append("<table width=\"100%\"><tr><td>");
					tmp.append("<div id=\""+ t[0] +"\" class=\""+tabviewContentCSS+"\">").append("\n");
					tmp.append("<p>").append("\n");
					tmp.append(contentBuilder.buildContent(getData().get(t[0]),params,pageContext)).append("\n");
					tmp.append("</p>").append("\n");
					tmp.append("</div>").append("\n");
					tmp.append("</td></tr></table>");
				}
			}
			tmp.append("</div>").append("\n");//End tab content
			tmp.append("</div>").append("\n");//End container div
			tmp.append("<script type=\"text/javascript\">").append("\n")
			.append("YUI().use('tabview', function(Y) {").append("\n")
			.append("    var tabview123 = new Y.TabView({srcNode:'#"+id+"'});").append("\n")
			.append("    tabview123.render();").append("\n");
			
			if(tabviewOnSelection!=null && !tabviewOnSelection.isEmpty())
				tmp.append("    tabview123.on('selectionChange', function (e) {"+tabviewOnSelection+"(e.newVal.get('label'));});").append("\n");
			
			tmp.append("});").append("\n")
			.append("</script>").append("\n");
			print(tmp.toString());
		} catch (Exception e) {
			log.error("TabTag", e);
		}
		return EVAL_PAGE;
	}
	private StringBuilder buildTabs() throws JspException{
		StringBuilder tmp = new StringBuilder();
		String[] tabs = getDisplayTabs().split(",");
		tmp.append("<ul>").append("\n");
		for(String tab : tabs){
			String[] t = tab.split(":");
			if(t.length !=2){
				throw new JspException("displayTabs must have format fieldName:Label,fieldName:Label");
			}
			tmp.append(" <li><a href=\"#"+t[0]+"\">"+t[1]+"</a></li>").append("\n");
		}
		tmp.append("</ul>").append("\n");
		return tmp;
	}
	public String getContentProviderClass() {
		return contentProviderClass;
	}
	public void setContentProviderClass(String contentProviderClass) {
		this.contentProviderClass = contentProviderClass;
	}
	public Map<String,Object> getData() {
		return data;
	}
	public void setData(Map<String,Object> data) {
		this.data = data;
	}
	public String getDisplayTabs() {
		return displayTabs;
	}
	public void setDisplayTabs(String displayTabs) {
		this.displayTabs = displayTabs;
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getCustomParams() {
		return customParams;
	}
	public void setCustomParams(String customParams) {
		this.customParams = customParams;
	}
	public String getTabviewContainerCSS() {
		return tabviewContainerCSS;
	}
	public void setTabviewContainerCSS(String tabviewContainerCSS) {
		this.tabviewContainerCSS = tabviewContainerCSS;
	}
	public String getTabviewContentCSS() {
		return tabviewContentCSS;
	}
	public void setTabviewContentCSS(String tabviewContentCSS) {
		this.tabviewContentCSS = tabviewContentCSS;
	}
	public String getTabviewOnSelection() {
		return tabviewOnSelection;
	}
	public void setTabviewOnSelection(String tabviewOnSelection) {
		this.tabviewOnSelection = tabviewOnSelection;
	}
}
