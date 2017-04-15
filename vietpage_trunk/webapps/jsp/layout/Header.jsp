<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="himage" style="position:relative; width: 100%;float: left;z-index: 1;">
	<a href="/${companyInfo.username}"><img alt="${companyInfo.name}" title="${companyInfo.name}" alt="${companyInfo.name}" src="${companyInfo.thumbHeaderImage}" width="100%"/></a>
</div>
<div style="position:relative; width: 100%;background-color: #f8f8f8; float: left;text-align: left;z-index: 2;">
	<b><s:text name="vietpage.company.address"></s:text>:</b>${companyInfo.address} - 
	<b><s:text name="vietpage.company.phone"></s:text>:</b>${companyInfo.phone} - 
	<b><s:text name="vietpage.company.web"></s:text>:</b><a href="${companyInfo.url}">${companyInfo.url}</a>
	<br>
	<div style="float: left;width: 20%;">
		<ui:rating rating="${companyInfo.companyRating}"></ui:rating>
	</div>
</div>

