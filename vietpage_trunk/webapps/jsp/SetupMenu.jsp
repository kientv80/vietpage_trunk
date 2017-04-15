<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Menu item -->
<div class="example yui3-skin-sam">
	<div id="itemTable"></div>
</div>
<form action="setupmenu?type=menuitem&targetUrl=groupmenu" method="post" id="setmenufortoday" name="setmenufortoday">
	<table >
	<c:if test="${menus != null && menus.size() > 0}">
		<tr>
			<td >
				<table>
					<tr>
						<td>
							<table>
								<s:select list="menus" listValue="name" listKey="id" key="vietpage.menu.group" name="selectedMenuId" id="selectedMenuId" ></s:select>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>

	</c:if>
		<tr>
			<td>
			<div id="datatable" style="overflow: auto;"></div>
			</td>
		</tr>
		<tr>
			<td>
					<br><s:text name="vietpage.menu.setup.main"></s:text>: <input type="radio" name="setupmainmenu" id="setupmainmenu"  value="editMainMenu" checked>
					<br><s:text name="vietpage.menu.setup.group"></s:text>: <input type="radio" name="setupmainmenu" id="setupmainmenu"  value="editMenu">
					<br><input type="button" name="setupTodayMenu" id="setupTodayMenu" value='<s:text name="vietpage.btn.save"></s:text>' class="btn btn-primary  btn-xs">
					<input type="hidden" id="selectedIds" name="selectedIds">
					<input type="hidden" id="menuId" name="menuId">
					<input type="hidden" id="action" name="action" >
			</td>
		</tr>
	</table>
	<input type="hidden" name="id" id = "id">
</form>

<ui:yuitable
    columns="ismain[checkbox]: ,id:ID,name:Name,description:Description,price:Price,thumbImage[image]:Hinh"
	containerId="datatable" queryJsonDataUrl="/item?"
	sortableColumns="name,price" sortByColumns="name" callBackMethod="setupTodayMenu"
	callBackButtonId="setupTodayMenu" returnValueOfColumns="id" tableWithCheckBox="true">
</ui:yuitable>


<script type="text/javascript">
	function setupTodayMenu(selectedItems){
		if(selectedItems==""){
			alert("Must select at least one");
			return;
		}
		document.getElementById("selectedIds").value=selectedItems;
		document.getElementById('setmenufortoday').id.value=selectedItems;
		document.getElementById('setmenufortoday').action.value="edit";
		document.getElementById('setmenufortoday').submit();
	}
	function addMenuGroup(){
		var from = document.getElementById("createUpdateMenu");
		from.action.value="new";
		from.submit();
	}
	function deleteMenuGroup(){
		var from = document.getElementById("deleteMenuFrom");
		var from2 = document.getElementById("setmenufortoday");
		var menus = from2.selectedMenuId;
		from.id.value = menus.options[menus.selectedIndex].value;
		document.getElementById("action").value="edit";
		from.submit();
	}

	function callBackRefresh(){
		var form = document.getElementById("setmenufortoday");
		var menus = form.selectedMenuId;
		return "menuId="+ menus.options[menus.selectedIndex].value +"&action=getItems&";
	}
</script>











