<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="vietpage_menu panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title"><s:text name="vietpage.item.filter"></s:text></h3>
	</div>
	<form action="/home">
			<div id="selectCity" class="searchcontrol">
				<s:select  list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top"  onchange="loadLocation('limit');"></s:select>
			</div>
			<div id="selectLocation" class="searchcontrol">
				<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" ></s:select>
			</div>
			<div id="selectService" class="searchcontrol">
				<s:select list="serviceType" listValue="value" listKey="key" name="serviceTypeId" id="selectedServiceId" labelposition="top" ></s:select>
			</div>
			<div id="selectService" class="searchcontrol">
				<input type="text" placeholder="Tên sản phẩm" name="searchText" id="searchText" size="40" style="height: 19px;font-size: 10px;" />
			</div>
			<div id="go" class="searchcontrol">
				<input type="submit" value=" Tìm " class="btn btn-primary  btn-xs">
			</div>
			<s:hidden name="action" value="search"></s:hidden>
	</form>	
</div>
<div class="vietpage_menu panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title"><s:text name="vietpage.suggestedPages"></s:text></h3>
	</div>
	<table style="vertical-align: middle;">
		<c:forEach items="${suggestComs}" var="c">
			<tr>
				<td style="vertical-align: middle;">
					<img src="${c.contentImage }" width="120px" height="100px">
				</td>
				<td style="vertical-align: middle;">
					<div>
						<a href="#" onclick="window.open('/lookup?comid=${c.id }&webid=${c.username }&redirectUrl=/items?comid=${c.id}');">${c.name} </a>
						${c.about }<br>
						${c.address }<br>
						${c.phone }<br>
					</div>
				</td>
			</tr>
			<tr><td colspan="2"><ui:rating rating="${c.companyRating}"></ui:rating></td></tr>
		</c:forEach>
	</table>
</div>

<!-- <div > -->
<!-- 	<div class="ads_250"> -->
<!-- 		<a href="/search"><img alt="" src="/images/ads/ads_lookup.png" width="100%" height="100%"></a> -->
<!-- 	</div> -->
<!-- 	<div class="ads_250"> -->
<!-- 		<a href="/register"><img alt="" src="/images/ads/ads_mypage.png"  width="100%" height="100%"></a> -->
<!-- 	</div> -->
<!-- </div> -->