<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:if test="${currentPage.equals('manageFeed')}">
	<div id="addFeedForm" style="border: thin solid #ddd;margin-bottom: 10px;">
		<form action="/manageFeed" id="addFeedForm1" method="post" enctype="multipart/form-data">
			<s:textfield id="title" name="title" cssStyle="width:100%;" label="Tiêu đề" labelposition="top"></s:textfield>
			<s:textarea id="feed" name="feed"  cssStyle="width:100%;" labelposition="top" key="vietpage.com.feed.content"></s:textarea>
			<s:textfield id="link" name="link" cssStyle="width:100%;" label="Địa chỉ trang quảng cáo nguồn(nếu có)" labelposition="top"></s:textfield>
			<s:file name="upload" labelposition="left" label="Hình ảnh của bản tin"/>
			<input type="button" id="submitFeed" value='<s:text name="vietpage.com.feed.add"></s:text>' class="btn btn-primary  btn-xs"  style="margin-left: 50%;">
			<s:hidden name="action" value="add"></s:hidden>
			<input type="hidden" name="comid" value="${companyInfo.id }"/>
		</form>
	</div>
</c:if>

<c:if test="${feeds != null && feeds.size() > 0 }">
	<s:iterator value="feeds" var="f">
	<table class="item" style="width: 100%;">
		
			<c:if test="${f.image !=null && !f.image.isEmpty()}">
			<tr>
				<td >
					Ngày đăng: ${f.postedDate}:(${f.viewCount} lần xem)<b>${f.title}</b><a href="/manageFeed?feedId=${f.id}&action=delete" class="btn btn-danger  btn-xs">Delete</a><br>
					<img src="${f.image }" style="max-width: 100%;">
				</td>
			</tr>
			</c:if>
			<tr>
				<td>
					<c:if test="${f.image ==null || f.image.isEmpty()}">
						Ngày đăng: ${f.postedDate}: (${f.viewCount} lần xem)<b>${f.title}</b><a href="/manageFeed?feedId=${f.id}&action=delete" class="btn btn-danger  btn-xs">Delete</a><br>
					</c:if>
					 ${f.feed}
					 	<c:if test="${f.link !=null && !f.link.isEmpty()}">
						 		<br>
								Thông tin gốc: <a href="${f.link}">${f.link}</a>
						</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<div class="fb-like" data-href="http://vietpage.info/vietpageDetail?type=news&id=${f.id}" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="fb-comments" data-href="http://vietpage.info/vietpageDetail?type=news&id=${f.id}" data-numposts="5" data-colorscheme="light"></div>
				</td>
			</tr>
	</table>
	</s:iterator>
</c:if>
<c:if test="${feeds == null || feeds.size() == 0 }">
	Chưa có bảng tin nào
</c:if>

<%-- <ui:PopupWindow panelId="addFeedId" width="900" isCentered="true" showPanelButtonId="addFeed" isVisible="false" containerId="addFeedForm" panelTitle="${companyInfo.name }" isRender="true" zIndex="2" isModal="true" dragAble="true" okButtonCallBack="addNewFeed" showOkButton="false" showCancelButton="true"></ui:PopupWindow> --%>

<script type="text/javascript">
	function addNewFeed(feed){
		if(document.getElementById("title").value == ""){
			alert("Xin nhập tiêu đề");
			return false;
		}else if(feed == ""){
			alert("Xin nhập nội dung");
			return false;
		}else{
			document.getElementById("addFeedForm1").submit();
		}
		
	}
 	function uploadContentImage(){
 		document.getElementById("editContentImageForm").submit();
 	}
    //Setup some private variables
    var Dom = YAHOO.util.Dom,
        Event = YAHOO.util.Event;

        //The SimpleEditor config
        var myConfig = {
            height: 200,
            width: 550,
            dompath: true,
            focusAtStart: true,
            enable:true
        };

    //Now let's load the SimpleEditor..
    var myEditor = new YAHOO.widget.SimpleEditor('feed', myConfig);
    myEditor._defaultToolbar.buttonType = 'advanced';  
    myEditor.render();
    
  //Inside an event handler after the Editor is rendered
    YAHOO.util.Event.on('submitFeed', 'click', function() {
        //Put the HTML back into the text area
        myEditor.saveHTML();
        //The var html will now have the contents of the textarea
        var html = myEditor.get('element').value;
        addNewFeed(html);
        
    });
  
  
</script>