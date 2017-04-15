<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table style="width: 100%;background-color: #4c66a4;">
	<tr>
		<td>
			<table style="width: 100%;">
				<tr height="30px">
					<td width="20px" align="center">
						<a href="/vietpage?comid=${companyInfo.id }&target=homePage" title="About us" id="aboutBtn">
							<img src="/images/vietpage/Home.png"  class="menu_button" />
							<br><font color="white">Trang Chủ</font>
						</a>
					</td>
					
					<td width="20px" align="center">
						<a href="/items?comid=${companyInfo.id }" title="Menu" id="viewMenu" style="font-weight: ">
							<img src="/images/vietpage/sanpham.png" class="menu_button"  />
							 <br><font color="white"><s:text name="vietpage.page.item"></s:text></font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="/feed?comid=${companyInfo.id }" title="Bản Tin">
							<img src="/images/vietpage/bantin.png"  class="menu_button"  />
							<br><font color="white">Bản Tin</font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="#" title="Phone to call us" id="phone" >
							<img src="/images/vietpage/Phone.png" class="menu_button" />
							<br><font color="white">Liên Hệ</font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="#" id="map_image1">
							<img alt="Map of the shop" src="/images/googlemap.jpg" class="menu_button">
							<br><font color="white">Bản Đồ</font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="#" title="Our services"  id="serviceBtn">
							<img src="/images/vietpage/User.png" class="menu_button" />
							<br><font color="white">Dịch Vụ</font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="#" title="Nhắn tin"  id="commentBtn">
							<img src="/images/vietpage/message.png"  class="menu_button" />
							<br><font color="white">Nhắn Tin</font>
						</a>
					</td>
					<td width="20px" align="center">
						<a href="/serviceId=${companyInfo.serviceTypeId}" title="Viet Page">
							<img src="/images/vietpage/vietpage_icon.png"  class="menu_button" id="vietpage" />
							<br><font color="white">Viet Page</font>
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<script type="text/javascript">
//  	function resize(id){
//  		var img = document.getElementById(id);
//  		img.width=80;
//  		img.height=100;
//  	}
//  	function reloadsize(id){
//  		var img = document.getElementById(id);
//  		img.width=60;
//  		img.height=80;
//  	}
// 	function test(msg){
// 		alert("ok");
// 	}
</script>