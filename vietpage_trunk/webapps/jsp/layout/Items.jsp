<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<c:if test="${menuTabs.size() > 0}">
	<ui:tabview tabviewContentCSS="items" tabviewContainerCSS="itemscontainer" contentProviderClass="com.vnsoft.server.contentprovider.MenuContentProvider" data="${menuTabs}" displayTabs="${displayTabs}" id="items" customParams="columns=items1:item2:item3,editable=false,btnPrefix=setupCategory,callback=viewItem3,showView=true,showAssessment=true,showRanking=false,imageClass=item_image"></ui:tabview>
	<ui:PopupWindow panelId="itemViewPanID" width="1000" isCentered="false" showPanelButtonId="${buttons}" isVisible="false" containerId="vewItem3" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="false" showOkButton="true" okButtonCallBack="assessItem2"></ui:PopupWindow>
<br>
<div>
	<p class="link">
	<a href="/serviceId=${companyInfo.serviceTypeId}">
		<img alt="" src="../images/vietpage/click.png">Click vào đây để xem thông tin khác trên VietPage.info</a></p>
	<br>
</div>
</c:if>
