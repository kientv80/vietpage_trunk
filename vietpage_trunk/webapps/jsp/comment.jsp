<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Menu item -->
<b><s:text name="vietpage.lastcomment"></s:text>:</b>
<div id="comments"></div>
<ui:yuidatatable columns="content:Nội dung tin nhắn,postedBy:Người nhắn,postedDate:Ngày nhắn" containerId="comments" queryJsonDataUrl="/comment?comId=${companyInfo.id }&action=getcomments&" sortableColumns="postedBy" sortByColumns="postedBy"  tableWithCheckBox="false" returnValueOfColumns="content" >
</ui:yuidatatable>
<!-- <table> -->
<!-- 	<tr><td> -->
<%-- 		<ui:datatable displayedColumnsAndLabels="PostedDate:Posted Date,PostedBy:Posted By,EmailOfPoster:Email,Content:Comment content"  --%>
<%-- 		containerId="datatable"  --%>
<%-- 		columns="PostedDate,PostedBy,EmailOfPoster,Content"  --%>
<%-- 		returnValueOfColumns="Id"  --%>
<%-- 		sortableColumns="'PostedBy'"  --%>
<%-- 		data="${comments}"  --%>
<%-- 		sortBy="PostedBy"> --%>
<%-- 	</ui:datatable> --%>
<!-- 	</td></tr> -->
<!-- </table> -->
<script type="text/javascript">
	function setupTodayMenu(selectedItems){
		alert("fff");
	}
</script>
