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
	<title>
		<c:out value="${item.name }"></c:out> 
	</title>
	<meta name="title" content="${item.toString()}"/>
    <meta name="description" content="${item.toString()}" />
 	<meta property="fb:app_id"          content="382999278501512" /> 
	<meta property="og:url"             content="http://vietpage.info/viewitemInPage?comid=${companyInfo.id}&itemId=${item.id}" /> 
	<meta property="og:title"           content="${item.name }" /> 
	<meta property="og:image"           content="http://vietpage.info/${item.imagePath}" /> 
	<meta property="cookbook:author"    content="http://VietPage.info" />
</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=382999278501512";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	<div style="text-align: left; margin-bottom: 0px; float: left;border: thin solid #d4d4d4;">
		<s:include value="m_itemview.jsp"></s:include>
		
		<s:include value="/jsp/layout/mobile/m_Items.jsp"></s:include>
	</div>
<!-- 	<div class="ads_250x250" style="float: right;"></div> -->
</body>
			