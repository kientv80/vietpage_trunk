package com.vnsoft.server.tags.yui;

import javax.servlet.jsp.JspException;

public class PopupWindowTag extends YUICustomTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5997224577534159708L;
	String containerId;
	private String showPanelButtonId;
	String panelTitle;
	private String panelId="panel";
	int width;
	int zIndex;
	String isCentered;
	String isModal;
	String isVisible;
	String isRender;
	private int scrollHeight;
	private boolean scroll;
	private String scrollContainerId;
	private boolean dragAble;
	private boolean showOkButton;
	private String okButtonCallBack;
	private boolean showCancelButton;
	
	
	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(String panelTitle) {
		this.panelTitle = panelTitle;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getzIndex() {
		return zIndex;
	}

	public void setzIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	public String getIsCentered() {
		return isCentered;
	}

	public void setIsCentered(String isCentered) {
		this.isCentered = isCentered;
	}

	public String getIsModal() {
		return isModal;
	}

	public void setIsModal(String isModal) {
		this.isModal = isModal;
	}

	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	public String getIsRender() {
		return isRender;
	}

	public void setIsRender(String isRender) {
		this.isRender = isRender;
	}

	@Override
	public int doEndTag() throws JspException {
		if(showPanelButtonId == null || showPanelButtonId.isEmpty())
			return EVAL_PAGE;
		StringBuilder yuiJs = new StringBuilder();
		yuiJs.append("<script type=\"text/javascript\">").append("\n").
		append("$(document).ready(function(){").append("\n").
		append("YUI().use('datatable-mutable', 'panel', 'dd-plugin', function (Y) {").append("\n");
		for(String btn : showPanelButtonId.split(",")){
			if(btn !=null && !btn.isEmpty())
				yuiJs.append(btn+"  = Y.one('#"+btn+"');").append("\n");
		}
		
		yuiJs.append("	var "+panelId+" = new Y.Panel({").append("\n")
		.append("		srcNode : '#"+containerId+"',").append("\n")
		.append("		headerContent : '"+panelTitle+"',").append("\n")
		.append("		width : "+width+",").append("\n")
		.append("		zIndex : "+zIndex+",").append("\n")
		.append("		centered : "+isCentered+",").append("\n")
		.append("		modal : "+isModal+",").append("\n")
		.append("		visible : "+isVisible+",").append("\n")
		.append("		render : "+isRender+"");
		if(dragAble){
			yuiJs.append(",").append("\n");
			yuiJs.append("		plugins : [ Y.Plugin.Drag ]").append("\n");
		}else{
			yuiJs.append("\n");
		}
		yuiJs.append("	});").append("\n");
		if(showOkButton){
			yuiJs.append("	"+panelId+".addButton({").append("\n")
			.append("		value : 'Ok',").append("\n")
			.append("		section : Y.WidgetStdMod.FOOTER,").append("\n")
			.append("		action : function(e) {").append("\n")
			.append("			e.preventDefault();").append("\n")
//			.append("			"+panelId+".hide();").append("\n")
	        .append("			if(this.callback){").append("\n")
//	        .append("   			this.callback();").append("\n")
	        .append("   			if(this.callback()){ \n").append( panelId+".hide();\n").append("}").append("\n")
//	        .append("			    "+panelId+".hide();").append("\n")
	        .append("			}else{"+panelId+".hide();}").append("\n")
			.append("		}").append("\n")
			.append("	});").append("\n");
		}
		if(showCancelButton){
			yuiJs.append("	"+panelId+".addButton({").append("\n")
			.append("		value : 'Cancel',").append("\n")
			.append("		section : Y.WidgetStdMod.FOOTER,").append("\n")
			.append("		action : function(e) {").append("\n")
			.append("			e.preventDefault();").append("\n")
			.append("			"+panelId+".hide();").append("\n")
			.append("		}").append("\n")
			.append("	});").append("\n");
		}
		if(okButtonCallBack!=null)
			yuiJs.append(""+panelId+".callback="+okButtonCallBack).append(";").append("\n");
		
		for(String btn : showPanelButtonId.split(",")){
			yuiJs.append(btn+".on('click', function (e) {").append("\n")
			.append("			if(this.callback){").append("\n")
		    .append("   			this.callback('hello');").append("\n")
		    .append("			}").append("\n")
			.append("    		"+panelId+".show();").append("\n")
			.append("    });").append("\n");
		}
		yuiJs.append("});").append("\n");
		if(scroll){
			yuiJs.append(getScrollJs(scrollHeight, scrollContainerId)).append("\n");
		}
		yuiJs.append("});");
		yuiJs.append("</script>").append("\n");
		print(yuiJs.toString());
		return EVAL_PAGE;
	}

	public String getShowPanelButtonId() {
		return showPanelButtonId;
	}

	public void setShowPanelButtonId(String showPanelButtonId) {
		this.showPanelButtonId = showPanelButtonId;
	}

	public boolean isScroll() {
		return scroll;
	}

	public void setScroll(boolean scroll) {
		this.scroll = scroll;
	}

	public boolean isDragAble() {
		return dragAble;
	}

	public void setDragAble(boolean dragAble) {
		this.dragAble = dragAble;
	}

	public int getScrollHeight() {
		return scrollHeight;
	}

	public void setScrollHeight(int scrollHeight) {
		this.scrollHeight = scrollHeight;
	}

	public String getScrollContainerId() {
		return scrollContainerId;
	}

	public void setScrollContainerId(String scrollContainerId) {
		this.scrollContainerId = scrollContainerId;
	}

	public boolean isShowOkButton() {
		return showOkButton;
	}

	public void setShowOkButton(boolean showOkButton) {
		this.showOkButton = showOkButton;
	}

	public boolean isShowCancelButton() {
		return showCancelButton;
	}

	public void setShowCancelButton(boolean showCancelButton) {
		this.showCancelButton = showCancelButton;
	}

	public String getOkButtonCallBack() {
		return okButtonCallBack;
	}

	public void setOkButtonCallBack(String okButtonCallBack) {
		this.okButtonCallBack = okButtonCallBack;
	}

	public String getPanelId() {
		return panelId;
	}

	public void setPanelId(String panelId) {
		this.panelId = panelId;
	}

}
