<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/jsp/layout/HeaderMenu.jsp"></s:include>
<div class="vietpage_top_banner">
	<div class="vietpage_logo">
		<img alt="viet page logo" title="viet page logo" src="/images/vietpage/logo_vietpage.png"/>
	</div>
	<div class="vietpage_top_banner_ads">
	</div>
</div>
<div style="float: right;width: 50%;">
	<a href="/search" title="Search">
		<input type="text" style="width: 300px;" placeholder="Tìm kiếm theo khu vực và dịch vụ" ><img alt="search" src="/images/vietpage/search.png" width="30px" height="30px">
	</a>
</div>
<div style="width: 30%; float: right;text-align: left;margin-left: 4px;">
	<div class="fb-like" data-href="https://www.facebook.com/vietpage.info" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
</div>


<div class="menuBar">
	<ul class="nav navbar-nav" style="height: 100%;">
	 <li>
		<div class="btn-group" style="position: relative;float: left; height: 100%;">
		   <img title="viet page" alt="viet page" src="/images/vietpage/m_menu.png" style="padding:10px 10px 4px 4px; width: 40px;height: 40px;" data-toggle="dropdown"/>
		  <ul class="dropdown-menu" role="menu" style="text-align: left;">
		    <c:forEach items="${hotservices}" var="sv">
			 		<c:if test="${sv.key== serviceTypeId}">
		 				<li class="divider"></li>
					  	<li><a href="/home?serviceTypeId=${sv.key}" title="${sv.value}" style="padding:6px;">
							${sv.value}
						</a></li>
			 		</c:if>
			 		<c:if test="${sv.key!= serviceTypeId}">
		 		 		<li class="divider"></li>
					  	<li><a href="/home?serviceTypeId=${sv.key}" title="${sv.value}" style="padding:6px;">
							${sv.value}
						</a></li>
			 		</c:if>
			 </c:forEach>

			 <li class="divider"></li>
			 <li><a href="/hotnews" style="padding:6px;"><s:text name="vietpage.home.menu.news"></s:text> </a></li>
			 <li class="divider"></li>
			 <li><a href="/home?recentVisit=true" style="padding:6px;">Các trang xem gần đây</a></li>
		  </ul>
		</div>
 	</li>
	  <li class="active"  style="height: 100%;padding-bottom: 0px;">
	  	<c:if test="${currentPage.equals('home') && ('true'!=recentVisit) && ( serviceTypeId == 0 || serviceTypeId == null) || currentPage.equals('news') && ( serviceTypeId == 0 || serviceTypeId == null) || (currentPage.equals(''))}">
	  		<a href="/news" title="Tin Mới" style="padding-right:6px;height: 100%;background-color: #eee;">
	  		<font color="white">Tin Mới</font>
			</a>
	  	</c:if>
	  	<c:if test="${serviceTypeId != null || currentPage.equals('hotnews') || ('true'==recentVisit)}">
	  		<a href="/news" title="Tin Mới" style="padding-right:6px;height: 100%;">
	  		<font color="white">Tin Mới</font>
			</a>
	  	</c:if>
	  </li>
	 <c:forEach items="${hotservices}" var="service">
	 		<c:if test="${service.key== serviceTypeId}">
	 			<li class="active" style="height: 100%;background-color: #eee;padding-bottom: 0px;">
				  	<a href="/home?serviceTypeId=${service.key}" title="${service.value}" style="padding-right:6px;height: 100%;">
						<font color="white">${service.value}</font>
					</a>
				</li>
	 		</c:if>
	 		<c:if test="${service.key!= serviceTypeId}">
	 			<li class="active" style="height: 100%;">
				  	<a href="/home?serviceTypeId=${service.key}" title="${service.value}" style="padding-right:6px;height: 100%;">
						<font color="white">${service.value}</font>
					</a>
				</li>
	 		</c:if>
	 </c:forEach>
    </ul>
</div>
<c:if test="${serviceTypeId != null}">
	<div class="vietpage_menu ">
			<form action="/home" id = "searchForm" method="get" onsubmit="return search();">
					<div id="selectLocation" class="searchcontrol_full">
						<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" onchange="search();"></s:select>
					</div>
					<div id="selectCity" class="searchcontrol_full">
						<s:select  list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId"  onchange="searchByCity();"></s:select>
					</div>
					<s:hidden name="action" value="search"></s:hidden>
					<s:hidden name="serviceTypeId"></s:hidden>
			</form>	
	</div>
</c:if>
<script type="text/javascript">
 	function search(){
 		var form = document.getElementById("searchForm");
 		form.submit();
 	}
 	function searchByCity(){
 		loadLocation('limit');
 		var form = document.getElementById("searchForm");
 		form.submit();
 	}
</script>