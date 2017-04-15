<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="menuBar">
	<ul class="nav navbar-nav">
		<c:forEach items="${hotservices}" var="service">
			<li class="active">
			  	<a href="/home?serviceTypeId=${service.key}" title="${service.value}" style="padding-bottom: 2px;padding-top: 10px;">
					${service.value}
				</a>
			</li>
		</c:forEach>
    </ul>
</div>
