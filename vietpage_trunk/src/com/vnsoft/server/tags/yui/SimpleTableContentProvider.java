package com.vnsoft.server.tags.yui;

import java.util.Map;

import javax.servlet.jsp.PageContext;


public interface SimpleTableContentProvider {
	public StringBuilder buildContent(Object data, int colindex,Map params,PageContext pageContext);
}
