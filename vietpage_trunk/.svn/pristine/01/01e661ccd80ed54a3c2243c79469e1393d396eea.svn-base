<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:if test="${login == false }">
	<form action="/agency" method="post">
		User name <input type="text" name="username"><br>
		Password <input type="password" name="password">
		<input type="submit" value="Login">
		<input type="hidden" name = "action" id="action" value="login">
	</form>
</c:if>

<c:if test="${login == true }">
	Tổng website: <b><c:out value="${ websites.size()}"></c:out></b> Tổng tiền bạn kiếm được <b><c:out value="${ websites.size()*3000}"></c:out></b> VND
	<table border="1" width="100%">
		<s:iterator value="websites" var="web">
			<tr>
				<td >
					<c:out value="${web.name}"></c:out> 
				</td>
				<td>
					<a onclick="window.open('${web.url}');" href="#" >${web.url}</a><br>
				</td>
			</tr>
		</s:iterator>
	</table>
</c:if>