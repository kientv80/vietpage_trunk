<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="btn-group" style="position: relative;width: 14.28571%;height: 100%;float: left;padding:20px 0px 20px 0px;background-color: #2f477a;">
	   <img title="viet page" alt="viet page" src="/images/vietpage/m_menu.png" style="padding: 8px;" data-toggle="dropdown"/>
	  <ul class="dropdown-menu" role="menu" style="width:500px;text-align: left;font-size: 35px;">
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
		 <li>
	 		<a href="/home" title="Trang chính" style="padding:6px;">
				Viet Page - Tin Tức
			</a>
		</li>
		 <li class="divider"></li>
		 <li><a href="/hotnews" style="padding:6px;"><s:text name="vietpage.home.menu.news"></s:text> </a></li>
		 <li class="divider"></li>
		 <li><a href="/home?recentVisit=true" style="padding:6px;">Các trang xem gần đây</a></li>
		 
		 <li class="divider"></li>
		 <li><a href="/mregister" title="Tao Page"><s:text name="vietpage.register.menu"></s:text></a></li>
		 
		 <li class="divider"></li>
		 <li>
			<c:if test="${isLogin == null}">
				<a href="/login" title="Login"><s:text name="vietpage.login"></s:text> </a>
			</c:if>
			<c:if test="${isLogin != null}">
				<a href="/login?action=logout" title="Logout"><s:text name="vietpage.logout"></s:text> </a>
			</c:if>
		 </li>
	  </ul>
</div>
<!-- <div style="position: relative;width:85.714%;float: left;"> -->
	<div class="info" style="padding-left: 10px;">
			<a href="/vietpage?comid=${companyInfo.id }&target=homePage" title="About us" id="aboutBtn" style="color: #fff;">
				<img src="/images/vietpage/m_home.png" class="menu_button" id="viewMenu"/>
			</a>
	</div>
	<div class="info" >
		<a href="/items?comid=${companyInfo.id }" title="Menu" id="viewMenu" style="color: #fff;">
			<img src="${productImg}" class="menu_button" id="viewMenu"/>
		</a>
	</div>
	<div class="info" >
		<a href="/feed?comid=${companyInfo.id }" title="Bản Tin"  id="commentBtn" style="color: #fff;">
			<img src="/images/vietpage/m_news.png" class="menu_button" id="viewMenu" />
		</a>
	</div>
	
	<div class="info">
			<a href="#"  id="phone" style="color: #fff;">
				<img src="/images/vietpage/m_phone.png" class="menu_button"/>
			</a>
	</div>
	<div class="info" >
		<a href="#" id="map_image1" style="color: #fff;">
			<img alt="Map of the shop" src="/images/vietpage/m_map.png" class="menu_button">
		</a>
	</div>
	<div class="info" >
		<a href="/home" title="Viet Page"  style="color: white;">
			<img alt="Map of the shop" src="/images/vietpage/vietpage_icon.png" class="menu_button">
		</a>
	</div>
