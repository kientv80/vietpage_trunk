<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="lookup_icon">
	<a href="/search" ><img alt="" src="/images/vietpagesearch.png"></a>
</div>
<div style="width: 100%; float: left;text-align: center;">
	<div class="fb-like" data-href="https://www.facebook.com/vietpage.info" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
</div>
<div style="width: 100%;float: left;">
	<form action="/search" method="get" id="searchFormId" onsubmit="return search();">
		<div class="vietpagesearch">
				<div id="selectCity" class="searchcontrol" style="float: left;padding-left: 1px;">
					<s:select list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top"  onchange="loadLocation('limit');" cssClass="search_control"></s:select>
				</div>
				<div id="selectLocation" class="searchcontrol">
					<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" cssClass="search_control"></s:select>
				</div>
				<div id="selectService" class="searchcontrol">
					<s:select list="serviceType" listValue="value" listKey="key" name="serviceTypeId" id="selectedServiceId" labelposition="top" cssClass="search_control"></s:select>
				</div>
				<div id="selectService" class="searchcontrol_text">
					<input type="text" placeholder="Text to search" name="searchText" id="searchText" class="search_control" />
				</div>
				<img alt="search" src="/images/vietpage/search.png" onclick="search();" width="30px" style="float: left;">
				<s:hidden name="action" value="search"></s:hidden>
		</div>
	</form>
</div>
<div style="width: 100%;height: 500px;text-align: center;"> 
	<c:if test="${companies != null && companies.size() > 0}">
			<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1,Item 2,Item 2" displayHeader="false" data="${companies }"  params="editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true,imageClass=item_image"></ui:table>
	</c:if>
</div>

<script type="text/javascript">
 	function search(){
 		var form = document.getElementById("searchFormId");
 		if(form.selectedServiceId.selectedIndex==0){
 			showMessage("Bạn cần chọn loại dịch vụ?");
 			return false;
 		}else{
 			form.submit();
 		}
 	}
</script>

