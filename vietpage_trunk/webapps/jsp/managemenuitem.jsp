<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Menu item -->
<c:if test="${errorMessage != null}">
	<font color="red"> <c:out value="${errorMessage}"></c:out></font>
</c:if>
<c:if test="${items != null && items.size() > 0}">
<div style="overflow: auto; height: 500px">
	<ui:table contentProvider="com.vnsoft.server.contentprovider.ItemSimpleTableContentProvider"  headers="Item 1, Item 2" displayHeader="false" data="${items }" params="imageClass=item_image,editable=true,btnPrefix=btn_,callback=editItem2"></ui:table>
</div>
</c:if>
	<br>
	<input type="button" id="add" value='<s:text name="vietpage.item.add"></s:text>' class="btn btn-primary  btn-xs">
	<br><br>
	<c:if test="${items != null && items.size() > 0}">
	<div id="edititem2"  style="text-align: left;">
		<form  action="managemenuitem?action=edit&type=menuitem&comId=${companyInfo.id }"  method="post" enctype="multipart/form-data" id="doEditItem2">
			<s:include value="itemform.jsp"></s:include>
		</form>
		<ui:PopupWindow panelId="editItemPanel" width="500" isCentered="true" showPanelButtonId="${buttons}" isVisible="false" containerId="edititem2" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true" okButtonCallBack="updateMenuItem2" showOkButton="true" showCancelButton="true"></ui:PopupWindow>
	</div>
	</c:if>
	
	<div id="addnew"  style="text-align: left;">
		<form action="managemenuitem?action=new" method="post" enctype="multipart/form-data" id="addNewMenuItem">
			<s:include value="newitemform.jsp"></s:include>
		</form>
	</div>
	
	<ui:PopupWindow panelId="addNewMenuItemPanelId" width="500" isCentered="true" showPanelButtonId="add" isVisible="false" containerId="addnew" panelTitle="${companyInfo.name }" isRender="true" zIndex="8" isModal="true" dragAble="true" okButtonCallBack="addNewMenuItem" showOkButton="true" showCancelButton="true"></ui:PopupWindow>

	<script type="text/javascript">
	var doEditItem2 = document.getElementById("doEditItem2");
	doEditItem2.isCargo.onclick=edit_itemTypeOnClick;
	function edit_itemTypeOnClick(){
		var nodes = doEditItem2.childNodes;
		var cnt = 0;
		var node;
		for (var i = 0; i < nodes.length; i++) {
		    if (nodes[i].tagName == "DIV") {
		    	if(nodes[i].id="itemOptional"){
		    		node = nodes[i];
		    		if(doEditItem2.isCargo.checked){
		    			nodes[i].style.display="block";
		    		}else{
		    			nodes[i].style.display="none";
		    		}
		    		break;
		    	}
		    }
		}
	}
	var addNewMenuItem = document.getElementById("addNewMenuItem");
	addNewMenuItem.isCargo.onclick=adnew_itemTypeOnClick;
	function adnew_itemTypeOnClick(){
		var nodes = addNewMenuItem.childNodes;
		var cnt = 0;
		var node;
		for (var i = 0; i < nodes.length; i++) {
		    if (nodes[i].tagName == "DIV") {
		    	if(nodes[i].id=="itemOptional"){
		    		node = nodes[i];
		    		if(addNewMenuItem.isCargo.checked){
		    			nodes[i].style.display="block";
		    		}else{
		    			nodes[i].style.display="none";
		    		}
		    		break;
		    	}
		    }
		}
	}
</script>
	
	
	