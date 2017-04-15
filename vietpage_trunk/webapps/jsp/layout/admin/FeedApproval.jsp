<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="table-responsive" style="float: left;">
	<table class="table table-hover table-bordered">
		<thead >
			<tr>
				<th>Page name</th><th>Feed Image</th><th>Feed Title</th><th>Posted Date</th><th>Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="feeds" var="f">
					<tr>
						 <td>
						 	<a href="#"  onclick="window.open('vietpage?comid=${f.comid}')">${f.comName}</a>
						 </td>
						<td>
							<img src="${f.thumb2Image }">
						 </td>
						<td>
						 	${f.title}
						 </td>
						 <td>
						 	${f.postedDate}
						 </td>
						<td>
							<a  href="#"  onclick="window.open('/feed?comid=${f.comid}&feedId=${f.id}')" class="btn btn-primary  btn-xs">View Feed</a>
							<a href="/approveFeed?action=approve&feedId=${f.id}" class="btn btn-primary  btn-xs">Approve</a>
							<a href="/approveFeed?action=reject&feedId=${f.id}" class="btn btn-danger  btn-xs">Reject</a>
						
						
						</td>
					</tr>
			</s:iterator>
		</tbody>
	</table>
</div>

