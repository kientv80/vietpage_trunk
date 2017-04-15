<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form
	action="companyEdit?type=company&id=${companyInfo.id }&comId=${companyInfo.id }"
	method="post">
	<table>
		<tr>
			<td >
				<c:if test="${companyInfo.ispublish == true }">
				<s:text name="vietpage.published"></s:text> :<input type="checkbox" name="publicWebsite" id="publicWebsite" value="true" checked>
				</c:if>
				<c:if test="${companyInfo.ispublish == false }">
				<s:text name="vietpage.published"></s:text> :<input type="checkbox" name="publicWebsite" id="publicWebsite">
				</c:if>
<!-- 				<input type="submit" value="Save" class="btn btn-primary  btn-xs"> -->
				<s:submit cssClass="btn btn-primary  btn-xs" key="vietpage.btn.save"></s:submit>
				<s:hidden name="action" value="edit_publish"></s:hidden>
		</td>
	</tr>
	</table>
</form>
<img alt="" src="${companyInfo.contentImage }" style="max_height:400px; max-width: 90%;"/><br>
<a href="#" id="editContentImage"><s:text name="vietpage.content.image.edit"></s:text></a><br><br>
<div id="uploadContentImage">
	<form action="companyEdit?action=editContentImage&type=company&id=${companyInfo.id }&comId=${companyInfo.id }" method="post" enctype="multipart/form-data" id="editContentImageForm">
		<s:file name="upload" key="vietpage.content.image"/>
		<s:hidden name="contentImage" id="contentImage" value="%{companyInfo.contentImage}"></s:hidden>
		<s:hidden name="action" id="action" value="editContentImage"></s:hidden>
	</form>
</div>
<ui:PopupWindow width="500" isCentered="true" showPanelButtonId="editContentImage" isVisible="false" containerId="uploadContentImage" scrollContainerId="uploadContentImage" panelTitle="${companyInfo.name }" isRender="true" zIndex="5" isModal="true" dragAble="true"  scrollHeight="250" showOkButton="true" showCancelButton="true" okButtonCallBack="uploadContentImage"></ui:PopupWindow>
<br><b><s:text name="vietpage.register.desc"></s:text>:</b>
<div>
	<form action="companyEdit?type=company&id=${companyInfo.id }&comId=${companyInfo.id }" method="post">
		<s:textarea name="description" id="description" value="%{companyInfo.description}" rows="10" cols="67"></s:textarea>
		<s:submit key="vietpage.btn.save" id="saveAbout" cssClass="btn btn-primary  btn-xs"></s:submit>
		<s:hidden name="action" value="editDescription"></s:hidden>
	</form>
</div>

<script type="text/javascript">
 	function uploadContentImage(){
 		document.getElementById("editContentImageForm").submit();
 	}
    //Setup some private variables
    var Dom = YAHOO.util.Dom,
        Event = YAHOO.util.Event;

        //The SimpleEditor config
        var myConfig = {
            height: '200px',
            width: '550px',
            dompath: true,
            focusAtStart: true
        };

    //Now let's load the SimpleEditor..
    var myEditor = new YAHOO.widget.SimpleEditor('description', myConfig);
    myEditor._defaultToolbar.buttonType = 'advanced';  
    myEditor.render();
    
  //Inside an event handler after the Editor is rendered
    YAHOO.util.Event.on('saveAbout', 'click', function() {
        //Put the HTML back into the text area
        myEditor.saveHTML();
        //The var html will now have the contents of the textarea
        var html = myEditor.get('element').value;
    });
  
  
</script>
