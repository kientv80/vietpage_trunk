<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" type="image/x-icon" href="../images/icon.png"/>
   <title>
		<s:text name="vietpage.title"></s:text>
	</title>
	<meta property="fb:app_id"          content="382999278501512" /> 
	<meta property="og:url"             content="http://vietpage.info/register" /> 
	<meta property="og:title"           content="Đăng ký website miễn phí trên Việt Page" /> 
	<meta property="og:image"           content="http://vietpage.info/images/vietpage/logo_vietpage.png" /> 
	<meta property="cookbook:author"    content="http://VietPage.info" />
	
	<meta name="description" content="Đăng kỳ website miễn phí, tạo website miễn phí" />
	<meta name="keywords" content="VietPage, Viet page, Viet Page, Đăng kỳ website miễn phí, tạo website miễn phí" />
	<meta name="author" content="vietpage.info" />
	<meta content="vi-VN"/>
	
	<script src="../js/util.js"></script>
	<script src="../js/mypage.js"></script>
	<script src="../yui/yui/yui-min.js"></script>
	<script src="../js/base_js.js"></script>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<!-- 	<link rel="stylesheet" href="../yui/api/assets/css/smain.css"> -->
	<link rel="stylesheet" href="../../css/m_layout.css">
	<s:head/>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-45967649-1', 'vietpage.info');
	  ga('send', 'pageview');
	
	</script>
</head>
<body class="yui3-skin-sam">
	<div class="vietpage_container">
			<div class="header">
				<img alt="viet page logo" title="viet page logo" src="/images/vietpage/logo_vietpage.png"/>
			</div>
			<div class="body">
				<div class="registercontent" style="width: 100%;"> 
					<tiles:insertAttribute name="content"/>
				</div>
			</div>
			<div class="footer"> All rights reserved</div>
	</div>
</body>
</html>

