<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div style="position: relative;width: 100%;overflow: hidden;font-weight: normal; color: #827F8F;font-size: 20px;float: left;background-color: white;">
		<div style="float: right;padding-right: 8px;">
		<a href="/home" title="Viet Page"><s:text name="vietpage.title"></s:text></a> | 
		<c:if test="${isLogin == null}">
			<a href="/login" title="Login"><s:text name="vietpage.login"></s:text> </a>
		</c:if>
		<c:if test="${isLogin != null}">
			<a href="/login?action=logout" title="Logout"><s:text name="vietpage.logout"></s:text> </a>
		</c:if>
	</div>
</div>

<div style="position: relative;width: 100%;overflow: hidden;margin-bottom: 10px;">
	<img alt="" src="${companyInfo.headerImage}" style="max-height: 300px;" width="100%" id="edit"/>
</div>

<div id="uploadHeader" style="position: relative;float:left; width: 100%;overflow: hidden;">
	<form action="companyEdit?type=company&comId=${companyInfo.id }" method="post" enctype="multipart/form-data" id="companyEdit">
		<s:file name="upload" key="vietpage.banner.edit"/>
		<s:hidden name="headerImage" id="headerImage" value="%{companyInfo.headerImage}"></s:hidden>
		<s:hidden name="id" id="id" value="%{companyInfo.id}"></s:hidden>
		<s:hidden name="action" id="action" value="editheader"></s:hidden>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="true" showPanelButtonId="edit" isVisible="false" containerId="uploadHeader" scrollContainerId="uploadHeader" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="editHeaderImage"></ui:PopupWindow>


<script type="text/javascript">
 	function editHeaderImage(){
 		document.getElementById("companyEdit").submit();
 	}
</script>