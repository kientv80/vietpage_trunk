<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<div style="position: relative;width: 100%;max-height: 500px;overflow: hidden;">
	<img alt="" src="${companyInfo.headerImage}" style="max-height: 500px;" width="100%"/>
</div>
<!-- <div style="position: relative;width: 100%;float: left;color: gray; overflow: hidden; background-color: #fff;"> -->
<%-- 	<s:text name="vietpage.company.address"></s:text>:${companyInfo.address} - <s:text name="vietpage.company.phone"></s:text>:${companyInfo.phone} --%>
<!-- </div> -->
<div style="position:relative; float:right;width: 100%; background-color: #fff;text-align: right;">
	<div style="position: relative;float: left;font-size: 20px;color: #ABABA9;">
	${companyInfo.address}
	</div>
	<ui:rating rating="${companyInfo.companyRating}"></ui:rating>
</div>
