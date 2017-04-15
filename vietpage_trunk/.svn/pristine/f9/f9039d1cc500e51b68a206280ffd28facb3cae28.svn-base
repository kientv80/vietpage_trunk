package com.vnsoft.server.contentprovider;

import java.util.Map;

import javax.servlet.jsp.PageContext;

import com.vnsoft.server.model.Item;
import com.vnsoft.server.tags.yui.SimpleTableContentProvider;
import com.vnsoft.server.util.UIHelper;

public class ItemSimpleTableContentProvider implements SimpleTableContentProvider{

	@Override
	public StringBuilder buildContent(Object data, int colindex, Map params, PageContext pageContext) {
		String btn = params.get("btnPrefix")+"";
		String width = params.get("width")+"";
		if(params.get("width")==null)
			width = "";
		
		String height = params.get("height")+"";
		if(params.get("height") == null)
			height = "";
		String clazz = params.get("clazz")+"";
		String editable = params.get("editable")+"";
		String callBack = params.get("callback")+"";
		String showView = params.get("showView")+"";
		String showDesc = params.get("showDesc")+"";
		String showContactInfo = params.get("showContactInfo")+"";
		String showAssessment = params.get("showAssessment")+"";
		String showRanking = params.get("showRanking")+"";
		
		boolean showview = false;
		boolean showConInf = false;
		boolean showAssess = false;
		boolean showRanking_ = false;
		if("true".equals(showContactInfo))
			showConInf = true;
		if("true".equals(showAssessment))
			showAssess = true;
		boolean b_showDesc = false;
		
		if(params.get("returnedBtnNames") !=null){
			String returnedBtnNames = params.get("returnedBtnNames").toString();
			if(pageContext.getSession().getAttribute(returnedBtnNames)!=null){
				String buttons = pageContext.getSession().getAttribute(returnedBtnNames).toString();
				Item i = (Item)data;
				buttons = buttons + btn + i.getMenuId() + "_" + i.getId()+",";
				pageContext.getSession().setAttribute(returnedBtnNames,buttons);
			}else{
				String buttons = "";
				Item i = (Item)data;
				buttons = btn + i.getMenuId() + "_" + i.getId()+",";
				pageContext.getSession().setAttribute(returnedBtnNames,buttons);
			}
		}
		if("true".equals(showView))
			showview = true;
		if("true".equals(showDesc))
			b_showDesc = true;
		if("true".equals(showRanking))
			showRanking_ = true;
		
		if("true".equals(editable)){
			return new StringBuilder(UIHelper.itemToDivHTML(width, height, (Item)data, true, btn, callBack, showview,pageContext,b_showDesc,showConInf,showAssess,showRanking_,clazz,params));
		}else{
			return new StringBuilder(UIHelper.itemToDivHTML(width, height, (Item)data, false, btn, callBack, showview,pageContext,b_showDesc,showConInf,showAssess,showRanking_,clazz,params));
		}
		
	}

}
