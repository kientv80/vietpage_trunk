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
		Tìm kiếm trên Viet Page
	</title>
	<meta property="fb:app_id"          content="382999278501512" /> 
	<meta property="og:url"             content="http://vietpage.info/search" /> 
	<meta property="og:title"           content="Tìm kiếm trên Việt Page" /> 
	<meta property="og:image"           content="http://vietpage.info/images/vietpagesearch.png" /> 
	<meta property="cookbook:author"    content="http://VietPage.info" />
	
	<meta name="description" content="Tìm kiếm thông tin trên Việt page" />
	<meta name="keywords" content="VietPage, Viet page, Viet Page, tìm kiếm thông tin, tìm sản phẩm, tìm dịch vụ, tìm địa chỉ" />
	<meta content="vi-VN"/>

	
	<script src="../yui/yui/yui-min.js"></script>
	<script src="../js/util.js"></script>
	<script src="../js/mypage.js"></script>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
	
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
<body style="width: 100%;">
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=382999278501512";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	
<script>
  window.fbAsyncInit = function() {
    // init the FB JS SDK
    FB.init({
      appId      : '382999278501512',                        // App ID from the app dashboard
      status     : true,                                 // Check Facebook Login status
      xfbml      : true                                  // Look for social plugins on the page
    });

    // Additional initialization code such as adding Event Listeners goes here
  };

  // Load the SDK asynchronously
  (function(){
     // If we've already installed the SDK, we're done
     if (document.getElementById('facebook-jssdk')) {return;}

     // Get the first script element, which we'll use to find the parent node
     var firstScriptElement = document.getElementsByTagName('script')[0];

     // Create a new script element and set its id
     var facebookJS = document.createElement('script'); 
     facebookJS.id = 'facebook-jssdk';

     // Set the new script's source to the source of the Facebook JS SDK
     facebookJS.src = '//connect.facebook.net/en_US/all.js';

     // Insert the Facebook JS SDK into the DOM
     firstScriptElement.parentNode.insertBefore(facebookJS, firstScriptElement);
   }());
</script>
	
	<div class="vietpage_container">
		<div class="page" >
			<div class="search_header" style="border: 0px;">
				<tiles:insertAttribute name="header"/>
			</div>
			<div class="body" style="border: 0px;">
				<tiles:insertAttribute name="search"/>
			</div>
			<div class="footer">© Copyright VIETPAGE.INFO, All rights reserved. </div>
		</div>
	</div>
</body>
</html>

