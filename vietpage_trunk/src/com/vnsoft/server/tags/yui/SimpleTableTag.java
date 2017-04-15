package com.vnsoft.server.tags.yui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.vnsoft.server.util.UIHelper;

public class SimpleTableTag extends YUICustomTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3994894388618797372L;
	private static final String NEW_LINE = "\n";
	/**
	 * 
	 */
	private String headers;
	boolean displayHeader;
	private List<Object> data;
	private String contentProvider;
	private String params ;
	@Override
	public int doEndTag() throws JspException {
		Map<String,String> pr = new  HashMap<>();
		if(params !=null){
			String[] cparams = params.split(",");
			for(String cparam: cparams){
				String [] p = cparam.split("=");
				if(p.length !=2)
					throw new JspException("customParams must have format key=value,key=value");
				pr.put(p[0], p[1]);
			}
		}

		if(pr.get("returnedBtnNames") !=null)
			pageContext.getSession().setAttribute(pr.get("returnedBtnNames"),null);
			
//		StringBuilder c = UIHelper.toHTMLTable(getData(), getDisplayHeader(), getHeaders(), getContentProvider(),pr, pageContext);
		StringBuilder c = UIHelper.toDivHTMLTable(getData(), getDisplayHeader(), getHeaders(), getContentProvider(),pr, pageContext);
		
		print(c.toString());
		return EVAL_PAGE;
	}

	public boolean getDisplayHeader() {
		return displayHeader;
	}

	public void setDisplayHeader(boolean displayHeader) {
		this.displayHeader = displayHeader;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public String getContentProvider() {
		return contentProvider;
	}

	public void setContentProvider(String contentProvider) {
		this.contentProvider = contentProvider;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
}
