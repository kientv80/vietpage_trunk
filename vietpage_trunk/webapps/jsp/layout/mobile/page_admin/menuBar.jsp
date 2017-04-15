<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div style="position: relative;float: left;width: 100%;">
	<table style="width: 100%;">
		<tr>
			<td>
				<table style="width: 100%;">
					<tr height="30px">
						<td width="20px" align="center">
							<a href="/setupmenu?type=company&id=${companyInfo.id}&action=edit" title="">
								<img src="/images/vietpage/sanpham.png" class="menu_button" id="viewMenu" /> Edit
							</a>
						</td>
						<td width="20px" align="center">
							<a href="#" title="Phone to call us"><img src="/images/vietpage/Phone.png" class="menu_button"/> Edit</a>
						</td>
						<td width="20px" align="center">
							<a href="#" title="Our services" ><img src="/images/vietpage/User.png" class="menu_button"/> Edit</a>
						</td>
						<td width="20px" align="center">
							<a href="#" title="About us"><img src="/images/vietpage/Home.png"  class="menu_button"  /> Edit</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>


