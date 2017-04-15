<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table style="width: 100%;float: right;background-color: #2f477a;">
  <tr align="left">
    <td style="vertical-align: top;">
    	<li>
			<a href="/home" title="Trang chính" style="padding-bottom: 0px;padding-top: 20px;height: 100%;color: white;">Home</a>
		</li>
		<li>
			<a href="/register" style="padding-bottom: 0px;padding-top: 20px;height: 100%;color: white;"><s:text name="vietpage.register" ></s:text></a>  <br>
		</li>
		<li>
			<a href="/search" style="padding-bottom: 0px;padding-top: 20px;height: 100%;color: white;"><s:text name="vietpage.search.title"></s:text></a><br>
		</li>
		<li>
			<a href="/hotnews" style="padding-bottom: 0px;padding-top: 20px;height: 100%;color: white;"><s:text name="vietpage.home.menu.news"></s:text></a>
		</li>
	</td>
	<td style="vertical-align: top;">
			<table style="background-color: #2f477a;">
				 <c:forEach items="${hotservices}" var="service">
				 	<tr>
				 		<td style="vertical-align: top">
				 		<c:if test="${service.key== serviceTypeId}">
				 			<li class="active" style="height: 100%;background-color: #eee;padding-bottom: 0px;">
							  	<a href="/home?serviceTypeId=${service.key}" title="${service.value}" style="padding-bottom: 0px;padding-top: 20px;height: 100%;color: white;">
									${service.value}
								</a>
							</li>
				 		</c:if>
				 		<c:if test="${service.key!= serviceTypeId}">
				 			<li class="active" style="height: 100%;">
							  	<a href="/home?serviceTypeId=${service.key}" title="${service.value}" style="padding-bottom: 4px;padding-top: 20px;height: 100%;color: white;">
									${service.value}
								</a>
							</li>
				 		</c:if>
				 		</td>
				 	</tr>
				 </c:forEach>
			 </table>
	</td>
  </tr>
</table>