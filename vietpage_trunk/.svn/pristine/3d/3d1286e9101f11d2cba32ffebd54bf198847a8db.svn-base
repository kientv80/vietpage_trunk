<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- <div style="text-align: left;" id="ddd"> -->
	<table>
		<c:if test="${menus != null && menus.size() > 0}">
			<s:select list="menus" listValue="name" listKey="id" name="selectedMenuId" id="selectedMenuId" key="vietpage.menu.group"></s:select>	
		</c:if>
	</table>
	<table >
		<s:textfield id="code" name="code" key="vietpage.item.code" labelposition="top" cssStyle="width:100%;"/>
		<s:textfield id="name" name="name" key="vietpage.item.name" labelposition="top" cssStyle="width:100%;"/>
		<s:textarea id="desc" name="desc" rows="3" cols="30"  key="vietpage.item.desc" labelposition="top" cssStyle="width:100%;"/>
		<s:checkbox id="ismain" name="ismain"  key="vietpage.item.main" labelposition="top" cssStyle="width:100%;"/>
		<tr>
			<s:file name="upload"   key="vietpage.item.image" labelposition="top" cssStyle="width:100%;"/>
		</tr>
		
		<s:checkbox id="isCargo" name="isCargo" key="vietpage.item.type" value="true" labelposition="top" cssStyle="width:100%;"></s:checkbox>
	</table>
	<div id="itemOptional">
		<table >
			<s:textfield id="price" name="price"  key="vietpage.item.price" labelposition="top" cssStyle="width:100%;" />
			<s:checkbox id="discount" name="discount" key="vietpage.item.discount" labelposition="top" cssStyle="width:100%;"/>
			<s:textfield id="discountPercent" name="discountPercent" key="vietpage.item.discount.percent" labelposition="top" cssStyle="width:100%;"/>
			<s:textfield id="discountPrice" name="discountPrice" key="vietpage.item.discount.newprice" labelposition="top" cssStyle="width:100%;"/>
		</table>
	</div>
	<s:hidden name="id" id="id"></s:hidden>
	<s:hidden name="type" value="menuitem"></s:hidden>
	<input type="hidden" id="itemImage" name="itemImage" />
<!-- </div> -->
			