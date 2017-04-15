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
		<s:checkbox id="isCargo" name="isCargo" key="vietpage.item.type" value="true"></s:checkbox>
		<s:textfield id="code" name="code" labelposition="left" key="vietpage.item.code"/>
		<s:textfield id="name" name="name" labelposition="left" key="vietpage.item.name"/>
		<s:textarea id="desc" name="desc" rows="10" cols="45" labelposition="left" key="vietpage.item.desc"/>
		<s:checkbox id="ismain" name="ismain" labelposition="left" key="vietpage.item.main"/>
		<tr>
			<s:file name="upload"  labelposition="left" key="vietpage.item.image"/>
		</tr>
	</table>
	<div id="itemOptional">
		<table >
			<s:textfield id="price" name="price" labelposition="left" key="vietpage.item.price" />
			<s:checkbox id="discount" name="discount" key="vietpage.item.discount" labelposition="left"/>
			<s:textfield id="discountPercent" name="discountPercent" key="vietpage.item.discount.percent" labelposition="left"/>
			<s:textfield id="discountPrice" name="discountPrice" key="vietpage.item.discount.newprice" labelposition="left"/>
		</table>
	</div>
	<s:hidden name="id" id="id"></s:hidden>
	<s:hidden name="type" value="menuitem"></s:hidden>
	<input type="hidden" id="itemImage" name="itemImage" />
<!-- </div> -->
			