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
	<meta property="og:title"           content="${companyInfo.name}" /> 
	<meta property="og:image"           content="http://vietpage.info/${companyInfo.headerImage}" /> 
	<meta property="cookbook:author"    content="http://VietPage.info" />
	
	
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
	<link rel="stylesheet" href="../../css/m_layout.css">
	<link rel="stylesheet" href="../../css/dialog.css">
	
	<!-- 	scrollbar -->
	<link href="../../css/scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" />
	<script src="../js/scrollbar/jquery-1.9.1.js"></script>
	<script src="../js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- 	End scrollbar -->

	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-45967649-1', 'vietpage.info');
	  ga('send', 'pageview');
	</script>
	<script type="text/javascript">
// 		registerWindowResizeEvent();
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
	
	<div class="vietpage_container">
		<div class="cover_admin">
			<tiles:insertAttribute name="cover"/>
		</div>
		<div class="info_container_admin">
			<tiles:insertAttribute name="info"/>
		</div>
		<div class="pageAdminContent">
			<tiles:insertAttribute name="content"/>
		</div>
	</div>
	
	<c:if test="${contactInfo != null &&contactInfo.comId > 0}">
		<div id="contact_info" style="text-align: left; z-index: 8;">
			<form action="contactinfo?type=contactinfo&comId=${companyInfo.id }" id="contactinfo" method="post">
				<table>
						<s:textfield name="phone" id="phones" key="vietpage.company.phone" value="%{contactInfo.phone}" maxlength="45" ></s:textfield>
						<s:textfield name="email" id="email" key="vietpage.register.email" value="%{contactInfo.email}" maxlength="45" ></s:textfield>
						<s:textfield name="address" id="address" key="vietpage.company.address" value="%{contactInfo.address}" maxlength="500" ></s:textfield>
				</table>
				<s:hidden name="id" value="%{contactInfo.comId}"></s:hidden>
				<input type="hidden" id="action" name="action" value="edit"/>
			</form>
		</div>
		<ui:PopupWindow width="900" isCentered="false" showPanelButtonId="phone" isVisible="false" containerId="contact_info" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true" showOkButton="true" okButtonCallBack="editContactInfo" showCancelButton="true"></ui:PopupWindow>
	</c:if>
	<div id="map_image_container1" class="map">
		<img alt="" src="${companyInfo.mapImage}" style="width: 100%;">
	</div>
	<ui:PopupWindow panelId="showMapImage1" width="900" isCentered="false" showPanelButtonId="map_image1" isVisible="false" containerId="map_image_container1" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="false" showOkButton="true" showCancelButton="false"></ui:PopupWindow>
	
		<c:if test="${menuTabs.size()>0 && !currentPage.equals('manageFeed')}">
			<div id="edititemSetupCategory"  style="text-align: left;">
				<form name="doEditItemSetupCategory" id="doEditItemSetupCategory" action="managemenuitem?action=edit&type=menuitem&targetUrl=setupmenu&comId=${companyInfo.id }"  method="post" enctype="multipart/form-data" >
						<s:include value="/jsp/layout/mobile/page_admin/itemform.jsp"></s:include>
				</form>
			</div>
		</c:if>
		
		<div id="addnew" style="text-align: left;">
			<form  id="doEditItem2" name="doEditItem2" action="managemenuitem?action=new&targetUrl=setupmenu&comId=${companyInfo.id }" method="post" enctype="multipart/form-data">
				<s:include value="/jsp/layout/mobile/page_admin/newitemform.jsp"></s:include>
			</form>
		</div>
		<ui:PopupWindow panelId="addNewMenuItem" width="900" isCentered="true" showPanelButtonId="add" isVisible="false" containerId="addnew" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true" okButtonCallBack="addMenuItem" showOkButton="true" showCancelButton="true"></ui:PopupWindow>
		
		<form name="item" id = "deleteItemForm" action="managemenuitem" method="post">
			<input type="hidden" name="id">
			<input type="hidden" name="action" value="delete">
			<input type="hidden" name="type" value="menuitem">
		</form>
		
		
		<script type="text/javascript">
			function showTarget(){
				document.getElementById("target").style.visibility="visible";
			}
		</script>
		<script type="text/javascript">
			var doEditItemSetupCategory = document.getElementById("doEditItemSetupCategory");
			doEditItemSetupCategory.isCargo.onclick=edit_itemTypeOnClick;
			function edit_itemTypeOnClick(){
				var nodes = doEditItemSetupCategory.childNodes;
				var cnt = 0;
				var node;
				for (var i = 0; i < nodes.length; i++) {
				    if (nodes[i].tagName == "DIV") {
				    	if(nodes[i].id=="itemOptional"){
				    		node = nodes[i];
				    		if(doEditItemSetupCategory.isCargo.checked){
				    			nodes[i].style.display="block";
				    		}else{
				    			nodes[i].style.display="none";
				    		}
				    		break;
				    	}
				    }
				}
			}
			var doEditItem2 = document.getElementById("doEditItem2");
			doEditItem2.isCargo.onclick=adnew_itemTypeOnClick;
			function adnew_itemTypeOnClick(){
				var nodes = doEditItem2.childNodes;
				var cnt = 0;
				var node;
				for (var i = 0; i < nodes.length; i++) {
				    if (nodes[i].tagName == "DIV") {
				    	if(nodes[i].id=="itemOptional"){
				    		node = nodes[i];
				    		if(doEditItem2.isCargo.checked){
				    			nodes[i].style.display="block";
				    		}else{
				    			nodes[i].style.display="none";
				    		}
				    		break;
				    	}
				    }
				}
			}
		</script>
	
</body>
</html>

