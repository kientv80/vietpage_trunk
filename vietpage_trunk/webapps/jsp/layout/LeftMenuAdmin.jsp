<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="boder list-group">

	
	<a href="/editRegisterInfo?action=loadRegisterInfo" class="list-group-item">
		<img src="/images/vietpage/register_form.png"  width="20" height="20"/><s:text name="vietpage.menu.admin.editregisterinfo"></s:text>
	</a>
	<a href="/edit?comId=${companyInfo.id }" class="list-group-item">
		<img src="/images/vietpage/Home.png"  width="20" height="20"/><s:text name="vietpage.menu.admin.home"></s:text>
	</a>
	<a href="/groupmenu?comId=${companyInfo.id }" class="list-group-item">
		<img src="/images/vietpage/sanpham.png"  width="20" height="20"/><s:text name="vietpage.menu.setup"></s:text>
	</a>
<%-- 	<a href="/setupmenu?type=company&id=${companyInfo.id}&action=edit" title="" class="list-group-item"> --%>
<%-- 		<img src="/images/vietpage/sanpham.png"  width="20" height="20"/><s:text name="vietpage.menu.manageitem"></s:text> --%>
<!-- 	</a> -->
	<a href="/comment?comid=${companyInfo.id }" class="list-group-item">
		<img src="/images/vietpage/message.png"  width="20" height="20"/><s:text name="vietpage.menu.admin.comment"></s:text>
	</a>
	<a href="/manageFeed?comid=${companyInfo.id }" class="list-group-item">
		<img src="/images/vietpage/bantin.png"  width="20" height="20"/><s:text name="vietpage.com.feed"></s:text>
	</a>
	<a href="/report" class="list-group-item">
		<img src="/images/vietpage/Chart.png"  width="20" height="20"/> Báo cáo
	</a>
	<a href="../docs/HuongDanThayDoiWebsiteTrenVietPage_V01.pdf" class="list-group-item">
		<img src="/images/vietpage/Help.png"   width="20" height="20"/> Tài liệu hướng dẫn
	</a>
</div>
<div class="boder panel panel-primary">
<!-- 	<div class="panel-heading"> -->
<%-- 		<h3 class="panel-title"><s:text name="vietpage.com.news"></s:text></h3> --%>
<!-- 	</div> -->
	<img alt="" src="/images/note.jpg" width="60px" height="60px" align="left">
	<b><s:text name="vietpage.page.news"></s:text>:</b><c:out value="${news.content}"></c:out>
	<a href="#" title="Edit News" id="newsEdit"><s:text name="vietpage.edit"></s:text> </a>
</div>


<script type="text/javascript">
 	function editNews(){
 		var form = document.getElementById("companyEditNews");
 		form.submit();
 	}
</script>

