<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form action="pageVisitReport" method="post">
	<s:select list="reportTime" listValue="value" listKey="key" name="time"></s:select>
	<s:select list="pages" listValue="value" listKey="key" name="pageId"></s:select>
	<input type="submit" value="Search" class="btn btn-primary btn-xs">
</form>
<br>
<b>Total: </b><c:out value="${total }"></c:out>
<br>
<div id="report" class="chart">
	<ui:chart containerId="report" chartType="line" chartData="${chartData}" title="Page Visit Report" yTitle="Visit Count" xTitle="Time"></ui:chart>
</div>

