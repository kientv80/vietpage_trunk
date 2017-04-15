<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Menu item -->
<c:if test="${mainMenus.items != null && mainMenus.items.size() > 0}">
<div class="mainmenu" id="id_mainmenu">
	<table class="table">
		<tr height="100px" class="tr">
		<s:iterator value="mainMenus.items" var="item">
			<td class="td">
					<ui:item item="${item}" edit="true" callBackMethod="editItem" clazz="item_mainmenu" customParams="imageClass=item_image"></ui:item>
			</td>
		</s:iterator>
		</tr>
	</table>
</div>
</c:if>




<!-- Move all to TableEdit.jsp after fixing z-Index -->


<script type="text/javascript">
// 	var doEditItem = document.getElementById("doEditItem");
// 	doEditItem.isCargo.onclick=m_itemTypeOnClick;
// 	function m_itemTypeOnClick(){
// 		var nodes = doEditItem.childNodes;
// 		var cnt = 0;
// 		var node;
// 		for (var i = 0; i < nodes.length; i++) {
// 		    if (nodes[i].tagName == "DIV") {
// 		    	if(nodes[i].id=="itemOptional"){
// 		    		node = nodes[i];
// 		    		if(doEditItem.isCargo.checked){
// 		    			nodes[i].style.display="block";
// 		    		}else{
// 		    			nodes[i].style.display="none";
// 		    		}
// 		    		break;
// 		    	}
// 		    }
// 		}
// 	}
</script>
