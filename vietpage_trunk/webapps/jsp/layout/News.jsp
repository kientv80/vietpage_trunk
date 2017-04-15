<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div style="width: 100%;position: relative;margin-top: 10px;margin-left: 20px;">
	<div class="fb-like" data-href="http://vietpage.info" data-send="true" data-width="450" data-show-faces="true"></div>
</div>
<div class="top_news">
<b><font color="#4AA4ED"><s:text name="vietpage.news"></s:text> </font></b>
	<table>
	<s:iterator value="news" var="pagenews">
		<tr>
			<td >
				<img src="${pagenews.companyImage }" width="120" height="80">
			</td>
			<td>
				<a href="/vietpage?page=${pagenews.userName }"> ${pagenews.companyName }</a><br>
				<s:text name="vietpage.page.news"></s:text> ${pagenews.createddate }: ${pagenews.content }
			</td>
		</tr>
	</s:iterator>
	</table>
</div>
