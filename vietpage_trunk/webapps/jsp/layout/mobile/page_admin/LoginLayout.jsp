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
			Viet Page Login
		</title>
		<script src="../yui/yui/yui-min.js"></script>
		<script src="../js/util.js"></script>
		<script src="../js/mypage.js"></script>
		<link rel="stylesheet" href="../../css/m_layout.css">
		<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-45967649-1', 'vietpage.info');
		  ga('send', 'pageview');
		</script>
	</head>
	<body >
		<div class="vietpage_container" >
			<div class="login" style="height:700px;">
					<tiles:insertAttribute name="center"/>
			</div>
			<div class="footer">© Copyright VIETPAGE.INFO, All rights reserved. </div>
		</div>
	</body>
</html>
