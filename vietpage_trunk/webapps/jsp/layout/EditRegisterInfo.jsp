<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<font color="red"><c:out value="${errorMessage}"></c:out></font> 
	<form action="editRegisterInfo" method="post" enctype="multipart/form-data" id="registerForm">
		<b><s:text name="vietpage.register"></s:text>:</b> <br> <br>
		<div class="register_content">
			<b><s:text name="vietpage.register.cominfo"></s:text>:</b>
			<table >
				<s:textfield name="name" id="name" key="vietpage.register.name"  size="35" maxlength="100" tooltip="Name of your company" value="%{comInfo.name}"></s:textfield>
				<s:textfield name="address" key="vietpage.register.address" size="35" maxlength="500" tooltip="Address of your company" value="%{comInfo.address}"></s:textfield>
				<s:textfield name="phone" key="vietpage.register.phone" size="35" maxlength="50" tooltip="Phone number of your shop" value="%{comInfo.phone}"></s:textfield>
				<s:textfield name="email" key="vietpage.register.email" size="35" maxlength="100" tooltip="Email that customer can send to you" value="%{comInfo.email}"></s:textfield>
				<s:textfield name="url" key="vietpage.register.url" size="35" maxlength="100" tooltip="If you already have a website, please put your URL here" value="%{comInfo.url}"></s:textfield>
				<tr>
					<td colspan="2">
						<table style="text-align: left;">
							<tr>
								<td>
									<table>
									<s:select list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top" label="City" onchange="loadLocation();"></s:select>
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
				<s:file name="upload" key="vietpage.register.map"></s:file>
				<s:hidden name="action" value="updateRegisterInfo"></s:hidden>
				<tr>
					<td>
						<input type="button" value="Lưu thay đổi thông tin đăng ký" onclick='updateRegisterInfo();' class="btn btn-primary  btn-xs">
					</td>
					<td></td>
				</tr>
			</table>
		</div>
	</form>
	
	<table style="border: thin solid #d4d4d4; width: 100%;">
		<tr style="border: thin solid #d4d4d4; ">
			<td><b>Các địa chỉ khác</b></td>
		</tr>
		<tr>
			<td>
				<div >
					<form action="/address" id="addressFormId" method="post" enctype="multipart/form-data">
						<table>
							<s:textfield id="phone" name="phone" key="vietpage.item.phone" size="100"></s:textfield>
							<s:textfield id="email" name="email" key="vietpage.register.email" size="100"></s:textfield>
							<s:textfield id="address" name="address" key="vietpage.item.address" size="100"></s:textfield>
							<s:file name="upload" key="vietpage.register.map" ></s:file>
							<tr>
								<td colspan="2">
									<table style="text-align: left;">
										<tr>
											<td>
												<table>
												<s:select list="city" listValue="value" listKey="key" name="selectedCity" id="selectedCityId" labelposition="top" label="City" onchange="loadLocation2('addressFormId');"></s:select>
												</table>
											</td>
											<td>
												<table>
												<s:select list="location" listValue="value" listKey="key" name="locationId" id="selectedLocationId" labelposition="top" label="Location"></s:select>	
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" value="Tạo Thêm địa chỉ" class="btn btn-primary  btn-xs" onclick="confirmSubmitCreateAdress();">
								</td>
								<td>
									<input id="btnEdit" type="button" value="Lưu thay đổi" class="btn btn-primary  btn-xs" onclick="submitEditAdress();" disabled="disabled">
								</td>
							</tr>
						</table>
						<input type="hidden" id="action" name="action">
							<s:hidden name="addressId"></s:hidden>
							<s:hidden name="pageId"></s:hidden>
							<s:hidden name="map"></s:hidden>
					</form>
				</div>
			</td>
		</tr>
	</table>
	<table style="border: thin solid #d4d4d4; width: 100%;">
	<tr style="border: thin solid #d4d4d4; ">
		<th style="border: thin solid #d4d4d4; ">Địa chỉ</th>
		<th style="border: thin solid #d4d4d4; ">Điện thoại</th>
		<th style="border: thin solid #d4d4d4; ">Email</th>
		<th style="border: thin solid #d4d4d4; ">Bản đồ</th>
		<th style="border: thin solid #d4d4d4; ">Thay đổi</th>
	</tr>
	<c:if test="${comInfo.addresses.size()>0 }">
			<c:forEach items="${comInfo.addresses}" var="ad">
				<tr style="border: thin solid #d4d4d4; "><td>${ad.address}</td>
					<td style="border: thin solid #d4d4d4; ">${ad.phone}</td>
					<td style="border: thin solid #d4d4d4; ">${ad.email}</td>
					<td style="border: thin solid #d4d4d4; ">
					<a href="${ad.map}"><img alt="Map of the shop" src="/images/googlemap.jpg" height="20px" width="20px"></a></td>
					<td style="border: thin solid #d4d4d4; ">
						<input type="button" id="adress_edit" value="Edit" class="btn btn-primary  btn-xs" onclick="editAdress('${ad.id}','${ad.address}','${ad.phone}','${ad.email}','${comInfo.id}','${ad.map}');">
						<input type="submit" id="adress_new"  value="Delete" class="btn btn-primary  btn-xs">
					</td>
				</tr>
			</c:forEach>
	</c:if>
	</table>

<script type="text/javascript">
	window.onload = function() {
		  document.getElementById("name").focus();
	};
	function updateRegisterInfo(){
		var registerForm = document.getElementById("registerForm");
		showDialog("Bạn có chắc muốn thay đổi thông tin?","icon-success",function(){submitForm();});
		return true;
	}
	function submitForm(){
		var registerForm = document.getElementById("registerForm");
		registerForm.submit();
		return true;
	}
	function editAdress(id,address,phone,email,pageId,map){
		var form = document.getElementById("addressFormId");
		document.getElementById("btnEdit").disabled=false;
		form.address.value=address;
		form.phone.value=phone;
		form.email.value=email;
		form.addressId.value=id;
		form.pageId.value=pageId;
		form.map.value=map;
	}
	function submitEditAdress(){
		if(!validate()){
			alert("Địa chỉ và phone là bắt buộc");
		}else{
			var form = document.getElementById("addressFormId");
			form.action.value='edit';
			form.submit();
		}

	}
	function validate(){
		var form = document.getElementById("addressFormId");
		if(form.address.value == null || form.address.value ==""){
			return false;
		}else if(form.phone.value == null || form.phone.value== ""){
			return false;
		}
		return true;
	}
	function confirmSubmitCreateAdress(){
		if(!validate()){
			alert("Địa chỉ và phone là bắt buộc");
		}else{
			showDialog("Bạn có muốn tạo mới địa chỉ này?","icon-question",function(){
				document.getElementById("btnEdit").disabled="disabled";
				submitCreateAdress();
			});
		}
	}
	function submitCreateAdress(){
		var form = document.getElementById("addressFormId");
		form.action.value='add';
		form.submit();
	}
	function deleteAddress(id,pageId){
		var form = document.getElementById("addressFormId");
		form.addressId.value=id;
		form.pageId.value=pageId;
		form.action.value='delete';
		showDialog("Bạn có thật sự muốn xóa mới địa chỉ này?","icon-question",function(){
			form.submit();
		});
		
	}
</script>