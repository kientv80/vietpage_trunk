package com.vnsoft.server.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.vnsoft.server.actions.ItemAction;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.Item;
import com.vnsoft.server.tags.yui.SimpleTableContentProvider;

public class CopyOfUIHelper {
	private static final DecimalFormat df = new DecimalFormat("#");
	public static String itemToHTML(String width, String height, Item item, boolean edit, String btnPrefix, String callBackMethod, boolean showView, PageContext pageContext, boolean showDesc,boolean showContactInfo,boolean showAssessment) {
		
		String code = getLocalizeText(pageContext,"vietpage.item.code");
		String name = getLocalizeText(pageContext,"vietpage.item.name");
		String desc = getLocalizeText(pageContext,"vietpage.item.desc");
		String price = getLocalizeText(pageContext,"vietpage.item.price");
		String discountPercent = getLocalizeText(pageContext,"vietpage.item.discount.percent");
		String newPrice = getLocalizeText(pageContext,"vietpage.item.discount.newprice");
		String company = getLocalizeText(pageContext,"vietpage.item.company");
		String view = getLocalizeText(pageContext,"vietpage.view");
		String btnEdit = getLocalizeText(pageContext,"vietpage.edit");
		String btnDelete = getLocalizeText(pageContext,"vietpage.delete");
		String address = getLocalizeText(pageContext,"vietpage.item.address");
		String phone = getLocalizeText(pageContext,"vietpage.item.phone");
		String cusAssessment = getLocalizeText(pageContext,"vietpage.item.cusAssessment");
		String good = getLocalizeText(pageContext,"vietpage.item.good");
		String quiteGood = getLocalizeText(pageContext,"vietpage.item.quitegood");
		String medium = getLocalizeText(pageContext,"vietpage.item.medium");
		String weak = getLocalizeText(pageContext,"vietpage.item.weak");
		if(!width.endsWith("px") || !width.endsWith("%"))
			width = width + "px";
		StringBuilder content = new StringBuilder();
		content.append("<tr>");
		content.append("<td align=\"left\"><img  title=\""+item.getName()+"\" alt=\""+item.getName()+"\" style=\"width:"+width+";height:"+height+";\" src=\"" + item.getThumbImage() + "\"/></td>");
		content.append("</tr>");
		String menuName = "";
		content.append("<tr>");
		content.append("<td align=\"left\">");
		if(showAssessment && (item.getGoodAssessmentPercent() > 0 ||item.getQuiteGoodAssessmentPercent()>0 || item.getMediumAssessmentPercent()>0 ||item.getWeakAssessmentPercent()>0)){
			content.append("<div class=\"progress\" style=\"margin-bottom:1px;\">").
			append(  "<div class=\"progress-bar progress-bar-success\" style=\"width: "+item.getGoodAssessmentPercent()+"%\">").append(good).append(":"+item.getGoodAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-info\" style=\"width: "+item.getQuiteGoodAssessmentPercent()+"%\">").append(quiteGood).append(":"+item.getQuiteGoodAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-warning\" style=\"width: "+item.getMediumAssessmentPercent()+"%\">").append(medium).append(":"+item.getMediumAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-danger\" style=\"width: "+item.getWeakAssessmentPercent()+"%\">").append(weak).append(":"+item.getWeakAssessmentPercent()+"%").
			append(  "</div>").
			append("</div>");

		}
		if(item.getCode() != null && !item.getCode().isEmpty()){
			if(edit){
				content.append(item.getName()).append("(" + item.getCode()+")").append(" ("+item.getViewCount()+" lần xem)");
			}else{
				content.append("<a href=\"#\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" +item.getComId()+"','"+ item.getId() + "'); \"><font color='#0654ba'> ").
				append(item.getName()).append("(" + item.getCode()+")").append("</font></a>").append(" ("+item.getViewCount()+" lần xem)");
			}

		}else{
			if(edit){
				content.append(item.getName()).append(" ("+item.getViewCount()+" lần xem)");
			}else{
				content.append("<a href=\"#\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" +item.getComId()+"','"+ item.getId() + "'); \"><font color='#0654ba'> ").
				append(item.getName()).append("</font></a>").append(" ("+item.getViewCount()+" lần xem)");
			}
		}
		if(showDesc)
			content.append("</br>" + item.getDescription());
		if(item.getIsCargo()){
			content.append("</br>" + df.format(item.getPrice())
			+ " đ");
			if(item.getIsDiscount()){
				content.append("</br><b>"+discountPercent+": </b>" + item.getDiscountPercent()+"%" + "<b> "+newPrice+": </b>" + df.format(item.getPriceAfterDiscount())+"  đ") ;
			}
		}
		if(showContactInfo && item.getPhone()!=null && item.getAddress()!=null){
			content.append("</br>").append(item.getAddress()).append("</br>").append(item.getPhone());
		}
		if(showContactInfo && item.getCompanyName()!= null && !item.getCompanyName().isEmpty() && item.getCompanyUrl() != null && !item.getCompanyUrl().isEmpty()){
			content.append("</br>"+company+":<a href=\"/items?comid="+item.getComId()+"\">"+item.getCompanyName()+"</a>");
		}

		content.append("</td>");
		content.append("</tr>");
		
		if (edit) {
			content.append("<tr>");
			if(btnPrefix == null || btnPrefix.isEmpty())
				btnPrefix = "btn";
			if(callBackMethod == null || callBackMethod.isEmpty())
				callBackMethod = "editItem";
			content.append("<td><button class=\"btn btn-primary  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','edit');\">"+btnEdit+"</button>" +
					" <button class=\"btn btn-danger  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "_delete" + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','delete');\">"+btnDelete+"</button>"+
					"</td>");
			content.append("</tr>");	
		}
		return content.toString();
	}
	public static String itemToDivHTML(String width, String height, Item item, boolean edit, String btnPrefix, String callBackMethod, boolean showView, PageContext pageContext, boolean showDesc,boolean showContactInfo,boolean showAssessment, boolean showRanking_, String clazz,Map<String,String> params) {
//		String code = getLocalizeText(pageContext,"vietpage.item.code");
//		String name = getLocalizeText(pageContext,"vietpage.item.name");
//		String desc = getLocalizeText(pageContext,"vietpage.item.desc");
//		String price = getLocalizeText(pageContext,"vietpage.item.price");
		String discountPercent = getLocalizeText(pageContext,"vietpage.item.discount.percent");
		String newPrice = getLocalizeText(pageContext,"vietpage.item.discount.newprice");
		String company = getLocalizeText(pageContext,"vietpage.item.company");
//		String view = getLocalizeText(pageContext,"vietpage.view");
		String btnEdit = getLocalizeText(pageContext,"vietpage.edit");
		String btnDelete = getLocalizeText(pageContext,"vietpage.delete");
//		String address = getLocalizeText(pageContext,"vietpage.item.address");
//		String phone = getLocalizeText(pageContext,"vietpage.item.phone");
//		String cusAssessment = getLocalizeText(pageContext,"vietpage.item.cusAssessment");
		String good = getLocalizeText(pageContext,"vietpage.item.good");
		String quiteGood = getLocalizeText(pageContext,"vietpage.item.quitegood");
		String medium = getLocalizeText(pageContext,"vietpage.item.medium");
		String weak = getLocalizeText(pageContext,"vietpage.item.weak");
		if(width!=null && !width.isEmpty() && !width.endsWith("px") && !width.endsWith("%")){
			width = " width:" +  width + "px;";
		}else if(width!=null && !width.isEmpty()){
			width = " width:" +  width + ";";
		}
		if(width==null || width.isEmpty()){
			width = "";
		}
		if(height!=null && !height.isEmpty() && !height.endsWith("px") && !height.endsWith("%")){
			height = " height:" + height + "px;";
		}else if(height!=null && !height.isEmpty()){
			height = " height:" +  height + ";";
		}	height = "";
		StringBuilder content = new StringBuilder();
		if(clazz == null || clazz.isEmpty()||"null".equals(clazz))
			clazz = "item";
		
		String imageClass = params.get("imageClass");
		if(imageClass!=null)
			imageClass = " class=\""+imageClass+"\"";
		else
			imageClass = "";
		String showCodeAndCount = params.get("showCodeAndCount");
		if(showCodeAndCount == null || showCodeAndCount.equals("true"))
			showCodeAndCount = "true";
		
		content.append("<div class=\""+clazz+"\">");
		content.append("<div class=\""+"itemContent"+"\">");
		if(!edit && showView){
			content.append("<a href=\"#\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" +item.getComId()+"','"+ item.getId() + "'); \">");
		}
		content.append("<div "+imageClass+">");
		content.append("	<img title=\""+item.getName()+"\" alt=\""+item.getName()+"\" style=\""+width + height + "\" src=\"" + item.getThumbImage() + "\"/>").append("<br>");
		content.append("</div>");
		
		
		String itemName = item.getName();
		if(showCodeAndCount!=null && showCodeAndCount.equals("true")){
			if(item.getCode() != null && !item.getCode().isEmpty()){
				itemName = item.getName()+"(" + item.getCode()+")"+" ("+item.getViewCount()+" lần xem)";
			}else{
				itemName =item.getName()+" ("+item.getViewCount()+" lần xem)";
			}
		}

		if(edit){
			content.append(itemName);
		}else{
			content.append("<font color='#0654ba'> ").
			append(itemName).append("</font></a>");
		}

		
		if(showDesc)
			content.append("<br>").append( item.getDescription());
		
		if(showContactInfo && item.getPhone()!=null && item.getAddress()!=null){
			content.append("<br>").append(item.getAddress()).append("</br>").append(item.getPhone());
		}

		if(item.getIsCargo()){
			content.append("<br>").append(df.format(item.getPrice()) 
			+ " đ");
			if(item.getIsDiscount()){
				content.append("	<div class=\"insideitem\">")
				.append("		<br><br><b>"+discountPercent+":</b>"+ item.getDiscountPercent()+"%" +"<br>")
				.append("		"+ "<b> "+newPrice+": </b>" + df.format(item.getPriceAfterDiscount())+"  đ"+"")
				.append("	</div>");
			}
		}
		
		if(showContactInfo && item.getCompanyName()!= null && !item.getCompanyName().isEmpty() && item.getCompanyUrl() != null && !item.getCompanyUrl().isEmpty()){
			content.append("<br>"+company+":<a href=\"/items?comid="+item.getComId()+"\">"+item.getCompanyName()+"</a>");
		}
		
		
		if(showRanking_){
			content.append("<div class=\"rating\">")
			.append("<div class=\"ratinglabel\">Xếp hạng</div>");
			for(int i =0;i<item.getCompanyRating();i++){
				content.append("<div class=\"star\"></div>");
			}
			for(int j=0;j<5-item.getCompanyRating();j++){
				content.append("<div class=\"graystar\"></div>");
			}
			content.append("</div>");
		}
		if (edit) {
			if(btnPrefix == null || btnPrefix.isEmpty())
				btnPrefix = "btn";
			if(callBackMethod == null || callBackMethod.isEmpty())
				callBackMethod = "editItem";
			content.append("<br><button class=\"btn btn-primary  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','edit');\">"+btnEdit+"</button>" +
					" <button class=\"btn btn-danger  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "_delete" + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','delete');\">"+btnDelete+"</button>");
		}
		
		if(showAssessment && (item.getGoodAssessmentPercent() > 0 ||item.getQuiteGoodAssessmentPercent()>0 || item.getMediumAssessmentPercent()>0 ||item.getWeakAssessmentPercent()>0)){
			content.append("<div class=\"progress\" style=\"margin-bottom:1px;\">").
			append(  "<div class=\"progress-bar progress-bar-success\" style=\"width: "+item.getGoodAssessmentPercent()+"%\">").append(good).append(":"+item.getGoodAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-info\" style=\"width: "+item.getQuiteGoodAssessmentPercent()+"%\">").append(quiteGood).append(":"+item.getQuiteGoodAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-warning\" style=\"width: "+item.getMediumAssessmentPercent()+"%\">").append(medium).append(":"+item.getMediumAssessmentPercent()+"%").
			append(  "</div>").
			append(  "<div class=\"progress-bar progress-bar-danger\" style=\"width: "+item.getWeakAssessmentPercent()+"%\">").append(weak).append(":"+item.getWeakAssessmentPercent()+"%").
			append(  "</div>").
			append("</div>");

		}
		content.append("</div>");
		content.append("</div>");
		
		return content.toString();
	}
	public static String pageToDivHTML(String width, String height, CompanyInfo page, boolean edit, String btnPrefix, String callBackMethod, boolean showView, PageContext pageContext, boolean showDesc,boolean showContactInfo,boolean showAssessment, boolean showRanking_,String clazz, Map<String,String> params) {
		if(width!=null && !width.isEmpty() && !width.endsWith("px") && !width.endsWith("%")){
			width = " width:" +  width + "px;";
		}else if(width!=null && !width.isEmpty()){
			width = " width:" +  width + ";";
		}
		if(width==null || width.isEmpty()){
			width = "";
		}
		if(height!=null && !height.isEmpty() && !height.endsWith("px") && !height.endsWith("%")){
			height = " height:" + height + "px;";
		}else if(height!=null && !height.isEmpty()){
			height = " height:" +  height + ";";
		}
		if(height==null || height.isEmpty()){
			height = "";
		}
		if(clazz==null)
			clazz = "item";
		
		String imageClass = params.get("imageClass");
		if(imageClass!=null)
			imageClass = " class=\""+imageClass+"\"";
		else
			imageClass = "";
		
		StringBuilder content = new StringBuilder();
		content.append("<div class=\""+clazz+"\">");
		content.append("<div class=\""+"itemContent"+"\">");
		content.append("<a href=\"/"+page.getUsername()+"\">").append("<div "+imageClass+"> " +
							"<img  title=\""+page.getName()+"\" alt=\""+page.getName()+"\" style=\""+width + height+"\" src=\"" + page.getThumImage() + "\"/>" +
						"</div>");
		content.append("<article style=\"flat:left;width:100%;\">" +
							"<b>"+page.getName()).append("</b><br>");
						if(showContactInfo){
							content.append(page.getAddress()).append("<br>");
							content.append(page.getPhone()).append("<br>");
						}

						content.append("</article>" +
						"</a>");
		if(showRanking_){
			content.append("<div class=\"rating\">")
			.append("<div class=\"ratinglabel\">Xếp hạng</div>");
			for(int i =0;i<page.getCompanyRating();i++){
				content.append("<div class=\"star\"></div>");
			}
			for(int j=0;j<5-page.getCompanyRating();j++){
				content.append("<div class=\"graystar\"></div>");
			}
			content.append("</div>");
		}

		content.append("</div>");
		content.append("</div>");
		
		return content.toString();
	}
	public static String itemToHTMLAjax(String width, String height, Item item, boolean edit, String btnPrefix, String callBackMethod,PageContext pageContext) {
		String code = getLocalizeText(pageContext,"vietpage.item.code");
		String name = getLocalizeText(pageContext,"vietpage.item.name");
		String desc = getLocalizeText(pageContext,"vietpage.item.desc");
		String price = getLocalizeText(pageContext,"vietpage.item.price");
		String discountPercent = getLocalizeText(pageContext,"vietpage.item.discount.percent");
		String newPrice = getLocalizeText(pageContext,"vietpage.item.discount.newprice");
		String company = getLocalizeText(pageContext,"vietpage.item.company");
		String view = getLocalizeText(pageContext,"vietpage.view");
		String btnEdit = getLocalizeText(pageContext,"vietpage.edit");
		if(!width.endsWith("px") & !width.endsWith("%"))
			width = width + "px";
		if(!height.endsWith("px") & !height.endsWith("%")){
			height = height + "px";
		}
		StringBuilder content = new StringBuilder();
//		content.append("<table width=\"100%\" height=\"100%\" border='1'>");
		content.append("<tr>");
		content.append("<td align=\"left\"><img  title=\""+item.getName()+"\" alt=\""+item.getName()+"\" src=\"" + item.getThumbImage() + "\" height=\"" + height + "\" width=\"" + width + "\"/></td>");
		String menuName = "";
		if(item.getMenuName() != null){
			menuName = "<b>Menu:</b> " + item.getMenuName() + "</b></br>";
		}
		content.append("<td align=\"left\"><font size=\"2\">"+menuName+"<b>"+name+":</b> " + item.getName() + "</b></br><b>"+desc+":</b> " + item.getDescription());
				if(item.getIsCargo()){
					content.append("</br><b>"+price+": </b>" + df.format(item.getPrice()) + " đ");
					if(item.getIsDiscount()){
						content.append("</br><b>"+discountPercent+": </b>" + item.getDiscountPercent()+"%" + "<b> "+newPrice+": </b>" + df.format(item.getPriceAfterDiscount())+"  đ") ;
					}
				}
		content.append("</font></tr>");

		if (edit) {
			content.append("<tr>");
			content.append("<td></td>");
			String ismain = "false";
			if (item.getIsmain())
				ismain = "true";
			if(btnPrefix == null || btnPrefix.isEmpty())
				btnPrefix = "btn";
			if(callBackMethod == null || callBackMethod.isEmpty())
				callBackMethod = "editItem";
			content.append("<td><button class=\"btn btn-primary  btn-xs button\" id=\"" + btnPrefix + item.getId() + "\" onclick=\""+callBackMethod+"('" + item.getId() + "');\">"+btnEdit+"</button></td>");
			content.append("</tr>");
		}
		return content.toString();
	}
	public static StringBuilder toHTMLTable(List<Object> data, boolean displayHeader,String headers,String contentProvider ,Map params,PageContext pageContext){
		StringBuilder c = new StringBuilder();
		c.append("<table style=\"width:100%;\">");
		if(displayHeader){
			c.append("<thead><tr>");
			for(String h : headers.split(",")){
				c.append("<th>").append(h).append("<th>");
			}
			c.append("</tr></thead>");
		}
		int count =0;
		int size = data.size();
		int col = headers.split(",").length;
		SimpleTableContentProvider contentBuilder = null;
		try {
			contentBuilder = (SimpleTableContentProvider)Class.forName(contentProvider).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		while(count < size){
			c.append("<tr>");
			for(int i =0;i<col;i++){
				c.append("<td>");
				c.append("<table>");
				c.append(contentBuilder.buildContent(data.get(count), i, params,pageContext));
				c.append("</table>");
				c.append("</td>");
				count ++;
				if(count == size && i < col){
					for(int j = i+1 ;j<col;j++){
						c.append("<td>");
						c.append("</td>");
					}
					break;
				}
			}
			c.append("</tr>");
		}
		c.append("</table>");
		return c;
	}
	public static StringBuilder toDivHTMLTable(List<Object> data, boolean displayHeader,String headers,String contentProvider ,Map params,PageContext pageContext){
		StringBuilder c = new StringBuilder();
		int count =0;
		int size = data.size();
		int col = headers.split(",").length;
		SimpleTableContentProvider contentBuilder = null;
		try {
			contentBuilder = (SimpleTableContentProvider)Class.forName(contentProvider).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		while(count < size){
			c.append("<div class=\"raw\">");
			for(int i =0;i<col;i++){
				c.append(contentBuilder.buildContent(data.get(count), i, params,pageContext));
				count ++;
				if(count == size && i < col){
					break;
				}
			}
			c.append("</div>");
		}
		return c;
	}
	public static String getLocalizeText(PageContext pageContext,String key){
   		return LocalizedTextUtil.findText(ItemAction.class, key, pageContext.getRequest().getLocale());
	}
}
