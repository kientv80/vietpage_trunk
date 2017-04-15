package com.vnsoft.server.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.Item;
import com.vnsoft.server.util.UIHelper;

public class ItemTag extends TagSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7899999041061968128L;

	Item item;
	String width;
	String height;
	private String style;
	private String clazz;
	private boolean edit;
	private boolean showView;
	private boolean showContInf;
	private boolean showAssessment;
	private boolean showRating;
	private boolean showShortDesc;
	private String btnPrefix;
	private String callBackMethod;
	private int column =1;
	private String customParams=null;
	private Logger log = Logger.getLogger(ItemTag.class);
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
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

	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			Map params = new HashMap<>();
			if(customParams !=null){
				String[] cparams = customParams.split(",");
				for(String cparam: cparams){
					String [] p = cparam.split("=");
					if(p.length !=2)
						throw new JspException("customParams must have format key=value,key=value");
					params.put(p[0], p[1]);
				}
			}
			String content = UIHelper.itemToDivHTML(width, height, item,edit,btnPrefix,callBackMethod,showView,pageContext, showShortDesc,showContInf,showAssessment,showRating,clazz,params);
			pageContext.getOut().print(content);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("", e);
		}
		return EVAL_PAGE;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public boolean getEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public String getBtnPrefix() {
		return btnPrefix;
	}
	public void setBtnPrefix(String btnPrefix) {
		this.btnPrefix = btnPrefix;
	}
	public String getCallBackMethod() {
		return callBackMethod;
	}
	public void setCallBackMethod(String callBackMethod) {
		this.callBackMethod = callBackMethod;
	}
	public boolean getShowView() {
		return showView;
	}
	public void setShowView(boolean showView) {
		this.showView = showView;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public boolean getShowShortDesc() {
		return showShortDesc;
	}
	public void setShowShortDesc(boolean showShortDesc) {
		this.showShortDesc = showShortDesc;
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
	public boolean getShowRating() {
		return showRating;
	}
	public void setShowRating(boolean showRating) {
		this.showRating = showRating;
	}
	public String getCustomParams() {
		return customParams;
	}
	public void setCustomParams(String customParams) {
		this.customParams = customParams;
	}


}
