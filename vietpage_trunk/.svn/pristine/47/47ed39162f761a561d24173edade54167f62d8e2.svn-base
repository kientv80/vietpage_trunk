<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
	<tr>
		<td style="margin-top: 10px;">
			<img alt="" src="${companyInfo.contentImage }" style="max-width: 100%;"/>
		</td>
	</tr>
	<tr>
		<td >
			${companyInfo.description}
		</td>
	</tr>

	
	<tr>
		<td>
				<c:if test="${companyInfo.addresses.size()>0 }">
						<table style="width: 100%;">
							<tr>
								<td><p class="link">Các địa chỉ khác</p></td>
							</tr>
						</table>
						<table style="border: thin solid #d4d4d4; width: 100%;">
						<tr style="border: thin solid #d4d4d4; ">
							<th style="border: thin solid #d4d4d4; ">Địa chỉ</th>
							<th style="border: thin solid #d4d4d4; ">Điện thoại</th>
							<th style="border: thin solid #d4d4d4; ">Email</th>
							<th style="border: thin solid #d4d4d4; ">Bản đồ</th>
						</tr>
						<c:forEach items="${companyInfo.addresses}" var="ad">
							<tr style="border: thin solid #d4d4d4; "><td>${ad.address}</td>
								<td style="border: thin solid #d4d4d4; ">${ad.phone}</td>
								<td style="border: thin solid #d4d4d4; ">${ad.email}</td>
								<td style="border: thin solid #d4d4d4; ">
								<a href="${ad.map}"><img alt="Map of the shop" src="/images/googlemap.jpg" height="20px" width="20px"></a></td>
							</tr>
						</c:forEach>
						</table>
				</c:if>
				
		</td>
	</tr>
</table>
<br>
<div class="fb-like" data-href="http://vietpage.info/vietpage?comid=${companyInfo.id}" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
<div class="fb-comments" data-href="http://vietpage.info/vietpage?comid=${companyInfo.id}" data-numposts="5" data-colorscheme="light"></div>






