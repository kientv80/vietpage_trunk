<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="lookup_icon">
	<img alt="" src="/images/vietpagesearch.png" style="width: 100%;">
<!-- 	<div class="fb-like" data-href="http://vietpage.info/search" data-layout="standard" data-action="like" data-show-faces="true" data-share="true" ></div> -->
</div>

<form action="/search" method="post" id="searchFormId">
	<s:select  cssClass="search_control" list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top"  onchange="loadLocation('limit');"></s:select>
	<s:select  cssClass="search_control" list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" ></s:select>
	<s:select  cssClass="search_control" list="serviceType" listValue="value" listKey="key" name="serviceTypeId" id="selectedServiceId" labelposition="top" ></s:select>
	<input  class="searchcontrol_text" type="text" placeholder="Tên muốn tìm" name="searchText" id="searchText" />
	<img alt="search" src="/images/vietpage/search.png" onclick="search();" style="width: 50px;height: 50px;float: right;margin-right: 30px;">
	<s:hidden name="action" value="search"></s:hidden>
</form>

<div class="search_result">
	<c:if test="${companies != null && companies.size() > 0 }">
			<div class="items" >
				<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="items1" displayHeader="false" data="${companies }"  params="clazz=company,width=100%,height=480px,editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true"></ui:table>
			</div>
	</c:if>
</div>
<script type="text/javascript">
 	function search(){
 		var form = document.getElementById("searchFormId");
 		if(form.selectedServiceId.selectedIndex==0){
 			alert("Bạn cần chọn loại dịch vụ?");
 			return false;
 		}else{
 			form.submit();
 		}
 	}
</script>

