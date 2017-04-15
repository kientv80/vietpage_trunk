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
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="../../css/layout.css">
	<link rel="stylesheet" href="../../yui/api/assets/css/main.css">
	<title>
		<c:out value="${item.name }"></c:out> &nbsp;
	</title>
	<meta name="description" content="${item.toString()}">
	<meta name="keywords" content="${item.name }" >
	<meta property="og:url" itemprop="url" content="http://vietpage.info/vietpageDetail?type=item&id=${item.id}" />
	<meta property="og:image" itemprop="thumbnailUrl" content="http://vietpage.info${item.imagePath}" />
	<meta content="${item.toString()}" itemprop="description" name="description" property="og:description"/> 
	<meta content="${item.name }" name="title" itemprop="headline" property="og:title" />
	<meta property="fb:app_id" content="382999278501512" /> 
	<meta property="cookbook:author" content="http://VietPage.info" />
		
</head>
<body style="background-color:white;">
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
<div style="position: relative;float: left;width: 100%;">
	<div style="position: relative;float: left;width: 100%;padding: 10px;">
		<div style="position: relative;float: left;width: 50%;overflow: hidden;padding-left: 6px;">
			<img src="${item.imagePath}" style="max-width: 100%;">
		</div>
		<div style="position: relative;float: left;width: 50%;overflow: hidden;padding: 10px 10px 10px 10px;">
			<span>
				<b><s:text name="vietpage.item.name"></s:text>: </b><c:out value="${item.name}"></c:out><font color="#0654ba">(${item.viewCount} lần xem)</font>
				<br><b><s:text name="vietpage.item.desc"></s:text>: </b><c:out value="${item.description}"></c:out>
				<c:if test="${item.isCargo == true }">
					<br><b><s:text name="vietpage.item.price"></s:text>: </b><c:out value="${item.price}"></c:out>
				</c:if>
				<c:if test="${item.isDiscount == true }">
						<br><b><s:text name="vietpage.item.discount.percent"></s:text>: </b><c:out value="${item.discountPercent}"></c:out>(%)</td></tr>
						<br><b><s:text name="vietpage.item.discount.newprice"></s:text>: </b><c:out value="${item.priceAfterDiscount}"></c:out></td></tr>
				</c:if>
				<br><b><s:text name="vietpage.item.address"></s:text>: </b><c:out value="${item.address}"></c:out>
				<br><b><s:text name="vietpage.item.phone"></s:text>: </b><c:out value="${item.phone}"></c:out>
				<br><b><s:text name="vietpage.company.web"></s:text>: </b><a href="#" onclick="window.open('/vietpage?comid=${companyInfo.id}');">${companyInfo.name}</a></td></tr>
						
				<font color="#0654ba"><s:text name="vietpage.item.cusAssessment"></s:text>
				<div style="position:relative; width: 100%;float: left;">
						<div class="progress" style="margin-bottom: 2px;float: left;width: 25%;">
						  <div class="progress-bar progress-bar-success" title="${item.goodcmts}" role="progressbar" aria-valuenow="${item.getGoodAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getGoodAssessmentPercent()}%">
						  Tốt:${item.getGoodAssessmentPercent()}%
						  </div>
						</div>
						<div class="progress" style="margin-bottom: 2px;float: left;width: 25%;">
						  <div class="progress-bar progress-bar-info" title="${item.quitegoodcmts}" role="progressbar" aria-valuenow="${item.getQuiteGoodAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getQuiteGoodAssessmentPercent()}%">
						  Khá:${item.getQuiteGoodAssessmentPercent()}%
						  </div>
						</div>
						<div class="progress" style="margin-bottom: 2px;float: left;width: 25%;" title="${item.mediumcmts}">
						  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${item.getMediumAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getMediumAssessmentPercent()}%">
						  Trung bình: ${item.getMediumAssessmentPercent()}%
						  </div>
						</div>
						<div class="progress" style="margin-bottom: 2px;" title="${item.weakcmts}">
						  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${item.getWeakAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getWeakAssessmentPercent()}%">
						  Kém:${item.getWeakAssessmentPercent()}%
						  </div>
						</div>
					</div>
						<br><font color="blue"><s:text name="vietpage.item.yourAssessment"></s:text></font> 
						<form action="" id="assessmentItemForm">
							<s:text name="vietpage.item.good"></s:text><input type="radio" id="yourass1" name="yourass" value="good" >
							<s:text name="vietpage.item.quitegood"></s:text><input type="radio" id="yourass2" name="yourass" value="quitegood">
							<s:text name="vietpage.item.medium"></s:text><input type="radio" id="yourass3" name="yourass" value="medium" >
							<s:text name="vietpage.item.weak"></s:text><input type="radio" id="yourass4" name="yourass" value="weak">
							<br><s:textfield id="cmt" name="cmt" label="Nhân xét" cssStyle="width:100%;"></s:textfield>
							<input type="hidden" value="${item.id}" name="itemId" id="itemId">
							<input type="hidden" value="${item.comId}" name="comId" id="comId">
						</form>
						<br><br>
			</span>
		</div>
	</div>
	<div class="fb-like" style="float: right;" data-href="http://vietpage.info/vietpageDetail?type=item&id=${item.id}" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
	<div class="fb-comments"  style="float: right;"  data-href="http://vietpage.info/vietpageDetail?type=item&id=${item.id}" data-numposts="5" data-colorscheme="light"></div>
		
</div>
</body>
			