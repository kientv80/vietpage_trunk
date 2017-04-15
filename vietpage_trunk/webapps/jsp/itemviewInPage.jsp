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

	<div style="text-align: left; margin-bottom: 0px; float: left;border: thin solid #d4d4d4;">
<%-- 		<s:include value="itemview.jsp"></s:include> --%>
		<div style="text-align: left;background-color:white;vertical-align: top;">
			<table style="background-color:white;">
				<tr>
					<td>
						<img title="${item.name }" alt="${item.name }" src="${item.imagePath}" style="max-width: 300px; max-height: 250px;">
					</td>
					<td style="vertical-align: middle;">
					
						<table>
								<tr>
									<td><b><s:text name="vietpage.item.name"></s:text></b></td><td><c:out value="${item.name}"></c:out><font color="#0654ba">(${item.viewCount} lần xem)</font></td>
								</tr>
								<tr><td><b><s:text name="vietpage.item.desc"></s:text>:</b></td><td><c:out value="${item.description}"></c:out></td></tr>
								<c:if test="${item.isCargo == true }">
									<tr><td><b><s:text name="vietpage.item.price"></s:text>:</b></td><td><c:out value="${item.price}"></c:out></td></tr>
								</c:if>
								<c:if test="${item.isDiscount == true }">
										<tr><td><b><s:text name="vietpage.item.discount.percent"></s:text>:</b></td><td><c:out value="${item.discountPercent}"></c:out>(%)</td></tr>
										<tr><td><b><s:text name="vietpage.item.discount.newprice"></s:text>:</b></td><td><c:out value="${item.priceAfterDiscount}"></c:out></td></tr>
								</c:if>
								<tr><td><b><s:text name="vietpage.item.address"></s:text>:</b></td><td><c:out value="${item.address}"></c:out></td></tr>
								<tr><td ><b><s:text name="vietpage.item.phone"></s:text>:</b></td><td><c:out value="${item.phone}"></c:out></td></tr>
				
								<tr>
									<td colspan="2">
										<font color="#0654ba"><s:text name="vietpage.item.cusAssessment"></s:text>
										<div class="progress" style="margin-bottom: 2px;">
										  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${item.getGoodAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getGoodAssessmentPercent()}%">
										  Tốt:${item.getGoodAssessmentPercent()}%
										  </div>
										</div>
										<div class="progress" style="margin-bottom: 2px;">
										  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${item.getQuiteGoodAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getQuiteGoodAssessmentPercent()}%">
										  Khá:${item.getQuiteGoodAssessmentPercent()}%
										  </div>
										</div>
										<div class="progress" style="margin-bottom: 2px;">
										  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${item.getMediumAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getMediumAssessmentPercent()}%">
										  Trung bình: ${item.getMediumAssessmentPercent()}%
										  </div>
										</div>
										<div class="progress" style="margin-bottom: 2px;">
										  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${item.getWeakAssessmentPercent()}" aria-valuemin="0" aria-valuemax="100" style="width: ${item.getWeakAssessmentPercent()}%">
										  Kém:${item.getWeakAssessmentPercent()}%
										  </div>
										</div>
										
										<font color="blue"><s:text name="vietpage.item.yourAssessment"></s:text></font> 
										<form action="" id="assessmentItemForm">
											<s:text name="vietpage.item.good"></s:text><input type="radio" id="yourass1" name="yourass" value="good" >
											<s:text name="vietpage.item.quitegood"></s:text><input type="radio" id="yourass2" name="yourass" value="quitegood">
											<s:text name="vietpage.item.medium"></s:text><input type="radio" id="yourass3" name="yourass" value="medium" >
											<s:text name="vietpage.item.weak"></s:text><input type="radio" id="yourass4" name="yourass" value="weak">
											<input type="hidden" value="${item.id}" name="itemId" id="itemId">
											<input type="hidden" value="${item.comId}" name="comId" id="comId">
										</form>
									</td>
									<td></td>
								</tr>
								<tr>
									<td colspan="2">
										<div class="fb-like" data-href="http://vietpage.info/viewitemInPage?comid=${companyInfo.id }&itemId=${item.id}" data-send="true" data-width="450" data-show-faces="true"></div>
									</td>
									<td>
									</td>
								</tr>
						</table>
						
						
					</td>
				</tr>
			</table>
		</div>
		<s:include value="/jsp/layout/Items.jsp"></s:include>
	</div>
<!-- 	<div class="ads_250x250" style="float: right;"></div> -->
</body>
			