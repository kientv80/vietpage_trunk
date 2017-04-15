<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<font color="red"><c:out value="${errorMessage}"></c:out></font> 
<!-- <div class="register_content"> -->
	<form action="register" method="post" enctype="multipart/form-data" id="registerForm">
		<b><s:text name="vietpage.register"></s:text>:</b> <br> <br>
		<div class="register_content">
			<b><s:text name="vietpage.register.cominfo"></s:text>:</b>
			<table >
				<s:textfield id="name" name="name" key="vietpage.register.name"  size="35" maxlength="100" tooltip="Name of your company"  ></s:textfield>
				<s:textfield name="address" key="vietpage.register.address" size="35" maxlength="500" tooltip="Address of your company" ></s:textfield>
				<s:textfield name="phone" key="vietpage.register.phone" size="35" maxlength="50" tooltip="Phone number of your shop"></s:textfield>
				<s:textfield name="email" key="vietpage.register.email" size="35" maxlength="100" tooltip="Email that customer can send to you"  ></s:textfield>
				<s:textfield name="url" key="vietpage.register.url" size="35" maxlength="100" tooltip="If you already have a website, please put your URL here"></s:textfield>
				<tr>
					<td colspan="2">
						<table style="text-align: left;">
							<tr>
								<td>
									<table>
									<s:select list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top" label="City" onchange="loadLocation('all');"></s:select>
									</table>
								</td>
								<td>
									<table>
									<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" label="Location"></s:select>	
									</table>
								</td>
								<td>
									<table>
									<s:select list="serviceType" listValue="value" listKey="key" name="serviceTypeId" id="selectedServiceId" labelposition="top" label="Service Type"></s:select>
									</table>
								</td>
								
							</tr>
						</table>
					</td>
				</tr>
				<s:textarea name="about" key="vietpage.register.desc" cols="54" rows="6"  ></s:textarea>
				<s:textarea name="service" key="vietpage.register.service" cols="54" rows="6"  ></s:textarea>
				<s:file name="upload" key="vietpage.register.map"></s:file>
				<s:text name="vietpage.register.login"></s:text>
				<s:textfield size="40" label="Login Name" name="username" id="username" placeholder="Page name(should not have space)"></s:textfield>
				<s:password size="40" label="Password" name="password"  placeholder="Password"></s:password>
				<s:hidden name="action" value="register"></s:hidden>
				<tr>
					<td></td>
					<td>
						<input type="button" value="Đăng Ký" onclick='dangky();' class="btn btn-primary  btn-l">
						<input value="Bỏ Đăng Ký" type="button" class="btn btn-primary  btn-l">
					</td>
				</tr>
			</table>
		</div>
	</form>
<!-- </div> -->
<script type="text/javascript">

	window.onload = function() {
		  document.getElementById("name").focus();
	};
	function dangky(){
		var registerForm = document.getElementById("registerForm");
		var name = registerForm.username.value;
		if(registerForm.selectedLocationId.selectedIndex==0){
			showDialog("Xin chọn vi trí","icon-success",function(){return false;});
			return false;
		}else if(registerForm.selectedServiceId.selectedIndex==0){
			showDialog("Xin chọn dịch vụ","icon-success",function(){return false;});
			return false;
		}
		showDialog("Cảm ơn các bạn đã tin tưởng VietPage. Login Name="+name+". Đia chi trang web của bạn là http://vietpage.info/"+name+" Bạn nhớ copy lại để có thể truy cập vào trang web của mình.","icon-success",function(){submitForm();});
		return true;
	}
	function submitForm(){
		var registerForm = document.getElementById("registerForm");
		registerForm.submit();
		return true;
	}
</script>