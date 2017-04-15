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
	<link rel="stylesheet" href="../../css/layout.css">
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
	<script type="text/javascript">
// 		createLeftAds();
	</script>

	<c:if test="${currentPage.equals('setupmenu') || currentPage.equals('managemenuitem')}">
	<c:if test="${menuTabs.size()>0}">
	<div id="edititemSetupCategory"  style="text-align: left;">
		<form name="doEditItemSetupCategory" id="doEditItemSetupCategory" action="managemenuitem?action=edit&type=menuitem&targetUrl=setupmenu&comId=${companyInfo.id }"  method="post" enctype="multipart/form-data" >
				<s:include value="/jsp/itemform.jsp"></s:include>
		</form>
	</div>
	</c:if>
	<div id="addnew" style="text-align: left;">
		<form  id="doEditItem2" name="doEditItem2" action="managemenuitem?action=new&targetUrl=setupmenu&comId=${companyInfo.id }" method="post" enctype="multipart/form-data">
			<s:include value="/jsp/newitemform.jsp"></s:include>
		</form>
	</div>
	<ui:PopupWindow panelId="addNewMenuItem" width="500" isCentered="true" showPanelButtonId="add" isVisible="false" containerId="addnew" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true" okButtonCallBack="addMenuItem" showOkButton="true" showCancelButton="true"></ui:PopupWindow>

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

</c:if>
	
	
	<div class="n_container">
		<div  class="top_menu">
			<s:include value="/jsp/layout/HeaderMenu.jsp"></s:include>
		</div>
		<div class="n_banner">
			<tiles:insertAttribute name="header"/>
		</div>
<!-- 		<div class="n_mainmenu_edit"> -->
<%-- 			<tiles:insertAttribute name="mainmenu"/> --%>
<!-- 		</div> -->
		<div class="n_bar">
			<tiles:insertAttribute name="table"/>
		</div>
		<div class="n_content">
			<tiles:insertAttribute name="center"/>
		</div>
		<div class="n_leftmenu">
			<tiles:insertAttribute name="leftmenu"/>
		</div>
		<div class="n_bar" style="height: 20px; text-align: center;">© Copyright VIETPAGE.INFO, All rights reserved. </div>
	</div>

	<script type="text/javascript">
// 		createRightAds();
	</script>

<c:if test="${currentPage.equals('setupmenu') || currentPage.equals('managemenuitem')}">

<!-- Add and remove menu group -->
<div id="deleteMenuContainer">
	<form action="setupmenu?type=menu&comId=${companyInfo.id }" method="post" id="deleteMenuFrom">
		<table>
			<tr>
				<td><label><s:text name="vietpage.confirm.deletmenu"></s:text> </label></td>
			</tr>
			
		</table>
		<input type="hidden" name="id" id="id">
		<input type="hidden" name="action" id = "delete" value="delete_menu_group">
	</form>
</div>
<ui:PopupWindow panelId="showDeleteMenuPannelId"  width="500" isCentered="true" showPanelButtonId="deleteMenu" isVisible="false" containerId="deleteMenuContainer" scrollContainerId="deleteMenuContainer" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="deleteMenuGroup"></ui:PopupWindow>

<!-- Add menu group -->
	<div id="addMenuContainer">
		<form action="setupmenu?comId=${companyInfo.id }" method="post" id="createUpdateMenu">
			<table>
				<tr>
					<td><label><s:text name="vietpage.menu.group"></s:text> </label></td>
					<td><input type="text" name="name" id="name" size="50" maxlength="50"></td>
				</tr>
				<tr>
					<td><label><s:text name="vietpage.menu.group.desc"></s:text>:</label></td>
					<td><textarea rows="5" cols="40" name="description" id="description"></textarea></td>
				</tr>
			</table>
			<input type="hidden" name="id" id = "id">
			<input type="hidden" name="action" id="action" value="new_menu_group">
		</form>
	</div>
<ui:PopupWindow panelId="showAddMenuPannelId"  width="500" isCentered="true" showPanelButtonId="addMenu" isVisible="false" containerId="addMenuContainer" scrollContainerId="addMenuContainer" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="addMenuGroup"></ui:PopupWindow>
</c:if>
<!-- BEGIN main menu item view -->
<%-- <c:if test="${mainMenus.items != null && mainMenus.items.size() > 0}"> --%>
<!-- 	<div id="edititem"  style="text-align: left;"> -->
<%-- 		<form action="managemenuitem?action=edit&type=menuitem&comId=${companyInfo.id }" method="post" enctype="multipart/form-data" name="doEditItem" id="doEditItem"> --%>
<%-- 			<s:include value="/jsp/itemform.jsp"></s:include> --%>
<!-- 		</form> -->
<!-- 	</div> -->
<%-- 		<ui:PopupWindow panelId="editItemPanel1" width="500" isCentered="true" showPanelButtonId="${btn}" isVisible="false" containerId="edititem" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true" okButtonCallBack="updateMenuItem" showOkButton="true" showCancelButton="true"></ui:PopupWindow> --%>
<%-- </c:if> --%>
<script type="text/javascript">
	var doEditItem = document.getElementById("doEditItem");
	doEditItem.isCargo.onclick=m_itemTypeOnClick;
	function m_itemTypeOnClick(){
		var nodes = doEditItem.childNodes;
		var cnt = 0;
		var node;
		for (var i = 0; i < nodes.length; i++) {
		    if (nodes[i].tagName == "DIV") {
		    	if(nodes[i].id=="itemOptional"){
		    		node = nodes[i];
		    		if(doEditItem.isCargo.checked){
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
<!-- END main menu item view -->

<!--BEGIN 	Pop-up for bar -->
<c:if test="${contactInfo != null &&contactInfo.comId > 0}">
<div id="contact_info" style="text-align: left; z-index: 8;">
	<form action="contactinfo?type=contactinfo&comId=${companyInfo.id }" id="contactinfo" method="post">
		<table>
				<s:textfield name="phone" id="phones" key="vietpage.company.phone" value="%{contactInfo.phone}" maxlength="45" size="50"></s:textfield>
				<s:textfield name="email" id="email" key="vietpage.register.email" value="%{contactInfo.email}" maxlength="45" size="50"></s:textfield>
				<s:textfield name="address" id="address" key="vietpage.company.address" value="%{contactInfo.address}" maxlength="500" size="50"></s:textfield>
		</table>
		<s:hidden name="id" value="%{contactInfo.comId}"></s:hidden>
		<input type="hidden" id="action" name="action" value="edit"/>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="false" showPanelButtonId="phone" isVisible="false" containerId="contact_info" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true" showOkButton="true" okButtonCallBack="editContactInfo" showCancelButton="true"></ui:PopupWindow>

</c:if>

<c:if test="${service != null }">
<div id="service" align="left">
	<form action="service_update?type=service&comId=${companyInfo.id }" id="service_update" method="post">
		<s:textarea id="content" name = "content" key="vietpage.register.service" rows="10" cols="50" wrap="true" value="%{service.content}"></s:textarea>
		<s:hidden name="id" value="%{service.comid}"></s:hidden>
		<input type="hidden" id="action" name="action" value="edit"/>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="false" showPanelButtonId="serviceBtn" isVisible="false" containerId="service" scrollContainerId="service" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="editServiceInfo"></ui:PopupWindow>
</c:if>
<c:if test="${about != null }">
<div id="about" align="left">
	<form action="about_update?type=about&comId=${companyInfo.id }" id="about_update" method="post">
		<s:textarea id="content" name="content" key="vietpage.register.desc" rows="10" cols="50" wrap="true" value="%{about.content}"></s:textarea>
		<s:hidden name="id" value="%{about.comid}"></s:hidden>
		<input type="hidden" id="action" name="action" value="edit"/>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="false" showPanelButtonId="aboutBtn" isVisible="false" containerId="about" scrollContainerId="about" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="editAboutInfo"></ui:PopupWindow>
</c:if>
<!-- 	END Pop-up for bar -->

<!-- BEGIN SetupCategory -->

	
<form name="item" id = "deleteItemForm" action="managemenuitem" method="post">
	<input type="hidden" name="id">
	<input type="hidden" name="action" value="delete">
	<input type="hidden" name="type" value="menuitem">
</form>
<!-- END SetupCategory -->

<!-- BEGIN Edit news -->
<div id="editNews" align="left">
	<form action="companyEdit?type=news" id="companyEditNews" method="post">
		<s:textarea id="newsContent" name="newsContent" key="vietpage.news" rows="10" cols="50" wrap="true" value="%{news.content}"></s:textarea>
		<s:hidden name="id" value="%{news.id}"></s:hidden>
		<input type="hidden" id="action1" name="action" value="editNews"/>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="true" showPanelButtonId="newsEdit" isVisible="false" containerId="editNews" scrollContainerId="editNews" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="editNews"></ui:PopupWindow>
<!-- END Edit news -->

</body>

</html>

