<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form id = "menuGroupForm">
<!-- Menu item -->
<table>
	<tr>
		<td>
			<table>
				<s:select list="menus" listValue="name" listKey="id" key="vietpage.menu.group" name="selectedMenuId" id="selectedMenuId"></s:select>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<td align="left" width="30px">
						<input type="button" id="addMenu" value='<s:text name="vietpage.menu.group.add"></s:text>' class="btn btn-primary  btn-xl">
					</td>
					<td align="left"  width="30px">
						<input type="button" id="deleteMenu" value='<s:text name="vietpage.delete"></s:text>' class="btn btn-danger  btn-xl">
					</td>
				</tr>
			</table>
		</td>
	</tr>

</table>
</form>
<!-- Add and remove menu group -->
<div id="deleteMenuContainer">
	<form action="setupmenu?type=menu&comId=${companyInfo.id }" method="post" id="deleteMenuFrom">
		<table>
			<tr>
				<td><label><s:text name="vietpage.confirm.deletmenu"></s:text> </label></td>
			</tr>
			
		</table>
		<input type="hidden" name="id" id="id">
		<input type="hidden" name="action" id = "delete" value="delete_menu_group">
	</form>
</div>
<ui:PopupWindow panelId="showDeleteMenuPannelId"  width="900" isCentered="true" showPanelButtonId="deleteMenu" isVisible="false" containerId="deleteMenuContainer" scrollContainerId="deleteMenuContainer" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="deleteMenuGroup"></ui:PopupWindow>

<!-- Add menu group -->
	<div id="addMenuContainer">
		<form action="setupmenu?comId=${companyInfo.id }" method="post" id="createUpdateMenu">
			<s:textfield  name="name" id="name" cssStyle="width:100%;" labelposition="top" key="vietpage.menu.group"></s:textfield>
			<s:textarea  rows="5" cssStyle="width:100%;" name="description" id="description" labelposition="top" key="vietpage.menu.group.desc"></s:textarea>
			<input type="hidden" name="id" id = "id">
			<input type="hidden" name="action" id="action" value="new_menu_group">
		</form>
	</div>
<ui:PopupWindow panelId="showAddMenuPannelId"  width="900" isCentered="true" showPanelButtonId="addMenu" isVisible="false" containerId="addMenuContainer" scrollContainerId="addMenuContainer" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="addMenuGroup"></ui:PopupWindow>

<ui:tabview tabviewContentCSS="items" tabviewContainerCSS="itemscontainer" contentProviderClass="com.vnsoft.server.contentprovider.MenuContentProvider" data="${menuTabs}" displayTabs="${displayTabs}" id="menu2" customParams="width=100%,height=480,columns=items1,editable=true,btnPrefix=setupCategory,callback=setupCategoryEditItem"></ui:tabview>
<c:if test="${menuTabs != null || menuTabs.size() > 0}">
	<ui:PopupWindow panelId="editItemPanelSetupCategory" width="900" isCentered="true" showPanelButtonId="${buttons}" isVisible="false" containerId="edititemSetupCategory" panelTitle="${companyInfo.name }" isRender="true" zIndex="6" isModal="true" dragAble="true" okButtonCallBack="update3" showOkButton="true" showCancelButton="true"></ui:PopupWindow>
	<br>
</c:if>
<script type="text/javascript">
	function showTarget(){
		document.getElementById("target").style.visibility="visible";
	}
</script>

	

