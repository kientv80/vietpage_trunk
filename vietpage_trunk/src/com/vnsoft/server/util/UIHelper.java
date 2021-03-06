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

public class UIHelper {
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
		String itemDiv = new String(HTMLTemplate.itemTemplate);
		itemDiv = getTemplate(params, itemDiv);
		
		itemDiv = itemDiv.replace("<header>", "<a style=\"color: #ABABA9;\" class=\"link-title\" href='/vietpage?comid="+item.getComId()+"'>"+item.getCompanyName()+"</a>");
		itemDiv = itemDiv.replace("<title>", "<a href='/viewitemInPage?comid="+item.getComId()+"&itemId="+item.getId()+"'>"+item.getName()+"</a>");
		String content = "<img title=\""+item.getName()+"\" alt=\""+item.getName()+"\" style=\"width:100%;\" src=\"" + item.getThumbImage() + "\"/>";
		String editBtnEdit = "";
		String editBtnDelete = "";
		String des = item.getDescription()+"</br>";
		if(item.getIsCargo())
			des = des + "Giá: "+ df.format(item.getPrice()) + " VNĐ </br>";
		if(item.getIsDiscount())
			des = des + "Giảm giá: "+ item.getDiscountPercent() + "% giá mới:"+df.format(item.getPriceAfterDiscount()) + " VNĐ </br>";
		if(showContactInfo && item.getPhone()!=null && item.getAddress()!=null){
			des = des + "<br>"+item.getAddress()+"</br>"+item.getPhone();
		}
		
		itemDiv = itemDiv.replace("<footer1>", item.getViewCount()+" lần xem");
		if(edit){
				if(btnPrefix == null || btnPrefix.isEmpty())
					btnPrefix = "btn";
				if(callBackMethod == null || callBackMethod.isEmpty())
					callBackMethod = "editItem";
				String btnEdit = getLocalizeText(pageContext,"vietpage.edit");
				String btnDelete = getLocalizeText(pageContext,"vietpage.delete");
				
				editBtnEdit = "<button class=\"btn btn-primary  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','edit');\">"+btnEdit+"</button>";
				editBtnDelete = "<button class=\"btn btn-danger  btn-xs button\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "_delete" + "\" onclick=\""+callBackMethod+"('" + item.getId() + "','delete');\">"+btnDelete+"</button>";
				itemDiv = itemDiv.replace("<footer2>", editBtnEdit);
				itemDiv = itemDiv.replace("<footer3>", editBtnDelete);
				itemDiv = itemDiv.replace("<content>", content + des);
		}else{
			content = "<a  href=\"#\" id=\"" + btnPrefix +item.getMenuId() + "_" + item.getId() + "\" onclick=\""+callBackMethod+"('" +item.getComId()+"','"+ item.getId() + "'); \">"+
						content +
					  "</a>";
			itemDiv = itemDiv.replace("<footer2>", item.getGoodCount()+" tốt-" + item.getMediumCount()+" khá-" + item.getWeakCount() +" kém");
			String fbLike = "<div id=\""+item.getId()+"\" class=\"fb-share-button\" data-href=\"http://vietpage.info/vietpageDetail?type=item&id="+item.getId()+"\" data-type=\"button_count\"></div>";
			itemDiv = itemDiv.replace("<footer3>",fbLike);
			itemDiv = itemDiv.replace("<content>", content + des);
		}
		
		return itemDiv;
	}
	public static String pageToDivHTML(String width, String height, CompanyInfo page, boolean edit, String btnPrefix, String callBackMethod, boolean showView, PageContext pageContext, boolean showDesc,boolean showContactInfo,boolean showAssessment, boolean showRanking_,String clazz, Map<String,String> params) {
		
		String companyDiv = new String(HTMLTemplate.pageTemplate);
		companyDiv = getTemplate(params, companyDiv);
		
		companyDiv = companyDiv.replace("<header>", "<a style=\"text-decoration: none;\" href=\"/"+page.getUsername()+"\">" + page.getName()+"</a>");
		companyDiv = companyDiv.replace("<title>", "");
		String content = 
		"<a style=\"text-decoration: none;\" href=\"/"+page.getUsername()+"\">"+
				"<img  title=\""+page.getName()+"\" alt=\""+page.getName()+"\" style=\"width:100%;\" src=\"" + page.getThumImage() + "\"/>";
		
		StringBuilder desc = new StringBuilder();
		StringBuilder ranking = new StringBuilder();
		desc.append("<article style=\"flat:left;width:100%;\">");
		if (showContactInfo) {
			desc.append(page.getAddress()).append("<br>");
			desc.append(page.getPhone()).append("<br>");
		}
		desc.append("</article>" + "</a>");
		if (showRanking_) {
			ranking.append("<div class=\"rating\">").append("<div class=\"ratinglabel\"></div>");
			for (int i = 0; i < page.getCompanyRating(); i++) {
				ranking.append("<div class=\"star\"></div>");
			}
			for (int j = 0; j < 5 - page.getCompanyRating(); j++) {
				ranking.append("<div class=\"graystar\"></div>");
			}
			ranking.append("</div>");
		}
		content = content + desc.toString();
//		content = content + "</a>";
		companyDiv = companyDiv.replace("<content>", content);
		companyDiv = companyDiv.replace("<footer1>", ranking.toString());
		return companyDiv;
	}
	private static String getTemplate(Map<String,String> params, String companyDiv){
		String componentContainer = params.get("componentContainer");
		String componentContentContainer  = params.get("componentContentContainer");
		String componentHeader  = params.get("componentHeader");
		String componentTitle  = params.get("componentTitle");
		String pageContent  = params.get("pageContent");
		String componentFooter = params.get("componentFooter");
		
		if(componentContainer != null && !componentContainer.isEmpty()){
			companyDiv = companyDiv.replace("componentContainer", componentContainer);
			System.out.println("Replace ===============" + componentContainer);
		}
		if(componentContentContainer != null && !componentContentContainer.isEmpty()){
			companyDiv = companyDiv.replace("componentContentContainer", componentContentContainer);
		}
		if(componentHeader != null && !componentHeader.isEmpty()){
			companyDiv = companyDiv.replace("componentHeader", componentHeader);
		}
		if(componentTitle != null && !componentTitle.isEmpty()){
			companyDiv = companyDiv.replace("componentTitle", componentTitle);
		}
		if(pageContent != null && !pageContent.isEmpty()){
			companyDiv = companyDiv.replace("pageContent", pageContent);
		}
		if(componentFooter != null && !componentFooter.isEmpty()){
			companyDiv = companyDiv.replace("componentFooter", componentFooter);
		}
		return companyDiv;
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
