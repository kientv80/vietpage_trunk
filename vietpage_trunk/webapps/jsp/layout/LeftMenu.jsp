<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="boder">
	<img alt="" src="/images/note.jpg" width="60px" height="60px" align="left">
	<b><c:out value="${news.createddate}"></c:out>:</b><c:out value="${news.content}"></c:out>
	<br><br><br>
</div>
<c:if test="${recentComs != null && recentComs.size() > 0 }">
	<div class="section" style="font-size: 20px;"><s:text name="vietpage.recentPages"></s:text></div>
	<div style="float: left;position: relative;width: 100%;">
		<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1,Item 2" displayHeader="false" data="${recentComs }"  params="clazz=recentVisitedPages,width=100%,height=100%,editable=false,showContactInfo=true,showAssessment=false,imageClass=item_image2,componentContainer=pageSallContainer,showRanking=true"></ui:table>
	</div>
</c:if>
<div class="same_companies">
	<div class="section" style="font-size: 20px;"><s:text name="vietpage.samecompany"></s:text></div>
	<c:if test="${otherCompanies != null && otherCompanies.size() > 0 }">
		<div style="float: left;position: relative;">
			<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1" displayHeader="false" data="${otherCompanies }"  params="clazz=interested_item,imageClass=interested_item_image2,editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true,componentContainer=pageSallContainer"></ui:table>
		</div>
	</c:if>
	
</div>
<c:if test="${suggestItems.size()>0 }">
<div class="same_companies panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title"><s:text name="vietpage.suggest.items"></s:text></h3>
	</div>
		<s:iterator value="suggestItems" var="lm_item">
			<ui:item item="${lm_item}" edit="false" btnPrefix="btn" showView="false" showShortDesc="true" clazz="item_s" customParams="imageClass=item_image"></ui:item>
		</s:iterator>
</div>
</c:if>

