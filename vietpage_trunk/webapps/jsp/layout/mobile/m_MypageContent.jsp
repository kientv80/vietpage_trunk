<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<c:if test="${recentComs != null && recentComs.size() > 0 && 'true'==recentVisit}">
	<div class="section">
		<s:text name="vietpage.recentPages"></s:text>
	</div>
	<div class="items" >
		<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="items1" displayHeader="false" data="${recentComs }"  params="clazz=company_small,width=100%,height=100%,editable=false,callback=m_viewItem3,showView=false,showDesc=false,showContactInfo=true,showAssessment=false,showRanking=true"></ui:table>
	</div>
</c:if>
<c:if test="${companies != null && companies.size() > 0 && 'true'!=recentVisit}">
	<div class="items" >
		<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="items1" displayHeader="false" data="${companies }"  params="clazz=company,width=100%,height=480px,editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true"></ui:table>
	</div>
</c:if>
<c:if test="${(companies == null || companies.size() == 0) && action == 'search'}">
	Chưa tìm thấy kết quả phù hợp mời bạn thử lại sau hoặc chỉn lại điều kiện tìm kiếm.
</c:if>

