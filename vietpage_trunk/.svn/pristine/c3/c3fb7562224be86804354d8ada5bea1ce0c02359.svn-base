<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="selectService" class="searchcontrol">
<form action="approvePage?action=search" method="post" id="searchPage">
	<input type="text" placeholder="Page Name" name="searchText" id="searchText">
	<c:if test="${ isReviewed != null}">
	Is Reviewed: <input type="checkbox" name="isReviewed" value="true" checked="checked">
	</c:if>
	<c:if test="${ isReviewed == null}">
	Is Reviewed: <input type="checkbox" name="isReviewed" value="false">
	</c:if>
	<c:if test="${ isApproved != null}">
	Is Approved: <input type="checkbox" name="isApproved" value="true" checked="checked">
	</c:if>
	<c:if test="${ isApproved == null}">
	Is Approved: <input type="checkbox" name="isApproved" value="false">
	</c:if>
	<input type="submit" value="Search" class="btn btn-primary btn-xs">
</form>
</div>
<br>
<div class="table-responsive" style="float: left;">
	<table class="table table-hover table-bordered">
		<thead >
			<tr>
				<th>Image</th><th>Name</th><th>Phone</th><th>Address</th><th>Email</th><th>Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="companies" var="com">
					<tr>
						<td>
							<img src="${com.contentImage }" width="120px" height="100px">
						 </td>
						 <td>
						 	<a href="#"  onclick="window.open('${com.url}')">${com.name}</a>
						 </td>
						<td>
						 	${com.phone}
						 </td>
						 <td>
						 	${com.address}
						 </td>
						<td>
							${com.email}
						</td>
						<td>
							<c:if test="${com.isapproved == true }">
								<input type="button" onclick="unApprove(${com.id});" value="UnApprove" class="btn btn-danger  btn-xs">
							</c:if>
							<c:if test="${com.isapproved == false }">
								<input type="button" onclick="approve(${com.id});" value="Approve" class="btn btn-primary  btn-xs">
							</c:if>
							<c:if test="${com.isReviewed == false }">
								<br><br>
								<input type="button" onclick="reviewed(${com.id});" value="Reviewed" class="btn btn-primary  btn-xs">
							</c:if>
								<br><br>
								<input type="button" onclick="deleteCom(${com.id});" value="Delete" class="btn btn-danger  btn-xs">
						</td>
					</tr>
			</s:iterator>
			</tbody>
	</table>
</div>
<form action="approvePage" method="post" id="approvePage">
	<input type="hidden" name="comid">
	<input type="hidden" name="action">
</form>
<script type="text/javascript">
	function unApprove(id){
		var form = document.getElementById("approvePage");
		form.action.value="un_approve";
		form.comid.value=id;
		form.submit();
	}
	function approve(id){
		var from = document.getElementById("approvePage");
		from.action.value="approve";
		from.comid.value=id;
		from.submit();
	}
	function reviewed(id){
		var from = document.getElementById("approvePage");
		from.action.value="reviewed";
		from.comid.value=id;
		from.submit();
	}
	function deleteCom(id){
		var from = document.getElementById("approvePage");
		from.action.value="delete";
		from.comid.value=id;
		from.submit();
	}
</script>
