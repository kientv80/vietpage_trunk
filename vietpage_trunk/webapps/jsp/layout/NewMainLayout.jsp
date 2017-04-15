<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" type="image/x-icon" href="../images/icon.png"/>
   <title>
		<c:out value="${companyInfo.name }"></c:out>
	</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta property="fb:app_id"          content="382999278501512" /> 
	<meta property="og:url"             content="http://vietpage.info/items?comid=${companyInfo.id}" /> 
	<meta property="og:title"  name="title" itemprop="headline" content="${companyInfo.name}" /> 
	<meta name="description" content="${companyInfo.about}">
	<meta name="keywords" content="${item.name }" >
	<meta property="og:url" itemprop="url" content="http://vietpage.info/items?comid=${companyInfo.id}"  />
	<meta property="og:image" itemprop="thumbnailUrl" content="http://vietpage.info/${companyInfo.headerImage}" />
	<meta property="cookbook:author" content="http://VietPage.info" />
	
	
	<meta name="keywords" content="VietPage, Viet page, Viet Page, sản phẩm, tạo website miễn phí, hàng giảm giá, sản phẩm mới, tin tức từ doanh nghiệp" />
	<meta name="author" content="vietpage.info" />
	<meta content="vi-VN"/>
  	<script src="../js/canvasjs.min.js"></script>
	<script src="../yui/yui/yui-min.js"></script>
	<script src="../js/util.js"></script>
	<script src="../js/mypage.js"></script>
	<script src="../js/simpleeditor-min.js"></script>
	<link rel="stylesheet" href="../../css/assets/skins/sam/skin.css">
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="../../css/layout.css">
	<link rel="stylesheet" href="../../css/dialog.css">
	<!-- 	scrollbar -->
	<link href="../../css/scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" />
	<script src="../js/scrollbar/jquery-1.9.1.js"></script>
	<script src="../js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- 	End scrollbar -->
	<!-- 	slide show -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<link rel="stylesheet" type="text/css" href="../../css/style.css" />
	<link rel="stylesheet" type="text/css" href="../../css/jquery.jscrollpane.css" media="all" />
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="../js/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="../js/jquery.contentcarousel.js"></script>

	<!-- 	end slide show -->
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-45967649-1', 'vietpage.info');
	  ga('send', 'pageview');
	</script>
	<script type="text/javascript">
		registerWindowResizeEvent();
		detectScreenSize();
	</script>
</head>
<body class="yui-skin-sam yui3-skin-sam">
<div id="fb-root"></div>
<script>
	window.fbAsyncInit = function() {
	    // init the FB JS SDK
	    FB.init({
	      appId      : '382999278501512',                        // App ID from the app dashboard
	      status     : true,                                 // Check Facebook Login status
	      xfbml      : true                                  // Look for social plugins on the page
	    });
	 };
	 
	(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=382999278501512";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

	<div class="n_container">
		<div class="top_menu">
			<s:include value="/jsp/layout/HeaderMenu.jsp"></s:include>
		</div>
		<div class="n_banner">
			<tiles:insertAttribute name="header"/>
		</div>
		<div class="n_bar">
			<tiles:insertAttribute name="table"/>
		</div>
<!-- 		<div class="n_mainmenu" id="n_mainmenu" style="overflow: hidden;"> -->
<%-- 			<tiles:insertAttribute name="mainmenu"/> --%>
<!-- 		</div> -->
		<div class="n_leftmenu">
			<tiles:insertAttribute name="leftmenu"/>
		</div>
		<div class="n_content">
			<tiles:insertAttribute name="center"/>
		</div>

		<div class="footer">© Copyright VIETPAGE.INFO, All rights reserved. </div>
	</div>
<!-- BEGIN main menu item view -->
<!-- <div id="vewItem" style="text-align: left; height:500px;"> -->
<!-- 	<iframe src="" id="viewItemDetail" -->
<!-- 		style="width: 100%; height:100%; overflow: auto;"></iframe> -->
<!-- </div> -->
<!-- END main menu item view -->
<!-- BEGIN Items page -->
<c:if test="${menuTabs != null && menuTabs.size() > 0}">
	<div id="vewItem3" style="text-align: left; height:500px;">
		<iframe src="" id="viewItemDetail3" style="width: 100%; height: 100%; overflow: auto;"></iframe>
	</div>
</c:if>
<!-- END Items page -->



<!--BEGIN 	Pop-up for bar -->
<div id="contact_info" align="left">
	<table style="text-align: left;">
		<tr>
			<td><label><s:text name="vietpage.register.phone"></s:text>:</label></td>
			<td><c:out value="${contactInfo.phone}"></c:out></td>
		</tr>
		<tr>
			<td><label><s:text name="vietpage.register.email"></s:text>:</label></td>
			<td><c:out value="${contactInfo.email}"></c:out></td>
		</tr>
		<tr>
			<td><label><s:text name="vietpage.register.address"></s:text>:</label></td>
			<td><c:out value="${contactInfo.address}"></c:out></td>
		</tr>
	</table>
</div>
<div id="service"  style="text-align: left;">
	<pre>
	<c:out value="${service.content}"></c:out>
	</pre>
</div>

<div id="commentEditer" style="text-align: left;">
	<form action="comment?action=new" method="post" name="comment" id="comment">
		<table>
			<s:textfield key="vietpage.page.comment.name" type="text" name="postedBy"/>
			<s:textfield key="vietpage.page.comment.mail" name="emailOfPoster"/>
			<s:textarea key="vietpage.page.comment" rows="10" maxlength="400" cols="50" name="comment"/>
		</table>
		<input type="hidden" id="comid" name="comid" value="${contactInfo.comId}">
	</form>
</div>
<ui:PopupWindow panelId="contactInfoPanID" width="500" isCentered="false" showPanelButtonId="phone" isVisible="false" containerId="contact_info" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true" showOkButton="true" ></ui:PopupWindow>
<ui:PopupWindow  panelId="servicePanID" width="500" isCentered="false" showPanelButtonId="serviceBtn" isVisible="false" containerId="service" scrollContainerId="service" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="false"></ui:PopupWindow>
<ui:PopupWindow  panelId="commentPanID" width="500" isCentered="false" showPanelButtonId="commentBtn" isVisible="false" containerId="commentEditer" scrollContainerId="commentEditer" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" okButtonCallBack="addComment" showCancelButton="true"></ui:PopupWindow>	
<!-- 	END Pop-up for bar -->
<div id="map_image_container1" class="map">
	<img alt="" src="${companyInfo.mapImage}" >
</div>
<ui:PopupWindow panelId="showMapImage1" width="700" isCentered="false" showPanelButtonId="map_image1" isVisible="false" containerId="map_image_container1" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="false" showOkButton="true" showCancelButton="false"></ui:PopupWindow>

</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../js/jquery.contentcarousel.js"></script>
</html>

