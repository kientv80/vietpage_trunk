<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- <div class="vietpage_menu "> -->
<%-- 	<div class="section" style="font-size: 20px;"><s:text name="vietpage.item.filter"></s:text></div> --%>
<!-- 	<form action="/home" id = "searchForm" method="get" onsubmit="return search();"> -->
<!-- 			<div id="selectCity" class="searchcontrol_full"> -->
<%-- 				<s:select  list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top"  onchange="loadLocation('limit');"></s:select> --%>
<!-- 			</div> -->
<!-- 			<div id="selectLocation" class="searchcontrol_full"> -->
<%-- 				<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" ></s:select> --%>
<!-- 			</div> -->
<!-- 			<div id="selectService" class="searchcontrol_full"> -->
<%-- 				<s:select list="serviceType" listValue="value" listKey="key" name="serviceTypeId" id="selectedServiceId" labelposition="top" ></s:select> --%>
<!-- 			</div> -->
<!-- 			<div id="selectService" class="searchcontrol_full"> -->
<!-- 				<input type="text" placeholder="Tên sản phẩm" name="searchText" id="searchText" style="height: 22px;width: 80%;" /> -->
<!-- 				<img alt="search" src="/images/vietpage/search.png" onclick="search();" width="32px" height="32px"> -->
<!-- 			</div> -->
<%-- 			<s:hidden name="action" value="search"></s:hidden> --%>
<!-- 	</form>	 -->
<!-- </div> -->
<div class="vietpage_menu">
	<c:if test="${suggestComs != null && suggestComs.size() > 0 }">
		<div class="section" style="font-size: 20px;"><s:text name="vietpage.suggestedPages"></s:text></div>
		<div style="float: left;position: relative;">
			<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1" displayHeader="false" data="${suggestComs }"  params="clazz=interested_item,width=100%,height=100%,editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true,imageClass=item_image,componentContainer=pageSallContainer"></ui:table>
		</div>
	</c:if>
	<c:if test="${recentComs != null && recentComs.size() > 0 }">
		<div class="section" style="font-size: 20px;"><s:text name="vietpage.recentPages"></s:text></div>
		<div style="float: left;position: relative;">
			<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1,Item 2" displayHeader="false" data="${recentComs }"  params="clazz=recentVisitedPages,width=100%,height=100%,editable=false,showContactInfo=true,showAssessment=false,showRanking=true,imageClass=item_image2,componentContainer=pageSallContainer"></ui:table>
		</div>
	</c:if>

</div>

<script type="text/javascript">
//  	function search(){
//  		var form = document.getElementById("searchForm");
//  		if(form.selectedServiceId.selectedIndex==0){
//  			showMessage("Bạn cần chọn loại dịch vụ?");
//  			return false;
//  		}else{
//  			form.submit();
//  		}
//  	}
 	
</script>