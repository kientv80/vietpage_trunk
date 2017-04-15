<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	
	<!-- 	scrollbar -->
	<link href="../../css/scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" />
	<script src="../js/scrollbar/jquery-1.9.1.js"></script>
	<script src="../js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	
	<script src="../js/jquery.contentcarousel.js"></script>
	<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
	<!-- the jScrollPane script -->
	<script type="text/javascript" src="../js/jquery.mousewheel.js"></script>
	
	<!-- 	End scrollbar -->
<div class="feedlatestnewscontainer">
	<div class="feedlatestnews" >
		<div class="itemContent" style="text-align: left;">
			<c:if test="${latestFeed.image !=null && !latestFeed.image.isEmpty()}">
						<div class="feedlatestnewsImage">
							<a href="/feed?comid=${latestFeed.comid }&feedId=${latestFeed.id}"  class="link-title" style="text-decoration: none;">
									<img title="${latestFeed.title }" alt="${latestFeed.title }" src="${latestFeed.thumb1Image }" style="width: 100%;max-height: 220px;"><br>
							</a>
						</div>
						<div style="position: relative;float: left;width: 100%;">
							<a href="/feed?comid=${latestFeed.comid }&feedId=${latestFeed.id}"  class="link-title" style="text-decoration: none;">
								<span class="title"> ${latestFeed.title}</span>
							</a>
							<span class="text">
								<br>
								${latestFeed.feed}
							</span>
							<br>
							<span class="text_gray">
								${latestFeed.postedDate}:
								<c:if test="${latestFeed.comName !=null && !latestFeed.comName.isEmpty()}">
										${latestFeed.comName}
								</c:if>
								(${latestFeed.viewCount} lần xem)
							</span><br>
						</div>
				</c:if>
				<c:if test="${latestFeed.image ==null || latestFeed.image.isEmpty()}">
					<a href="/vietpage?comid=${latestFeed.comid }"  class="link-title" style="text-decoration: none;">
						<h1 class="title"> ${latestFeed.title}</h1><br>
						<font size="1.5">	
						<c:if test="${latestFeed.comName !=null && !latestFeed.comName.isEmpty()}">
							${latestFeed.comName}:
						</c:if>
						${latestFeed.postedDate} (${latestFeed.viewCount} lần xem)
						</font>
				</c:if>
	</div>
	</div>
	<div class="feedhightlightnews">
		<table>
			<s:iterator value="hightLightFeeds" var="f">
				<tr >
					<td class="hightlightrow">
						<div class="itemContent">
							<span class="text_gray_small">${f.postedDate}: ${f.comName}</span><br>
							<a href="/feed?comid=${f.comid }&feedId=${f.id}" class="link-title" style="text-decoration: none;">
									<c:if test="${f.image !=null && !f.image.isEmpty()}">
										<div style="position:relative; float:left; width: 35%; height: 60px;overflow: hidden;">
											<img title="${f.title }" alt="${f.title }"  src="${f.thumb2Image }" style="width: 100%;" align="left">
										</div>
									</c:if>
									<div class="title" style="float:right; width: 65%;padding-left: 2px;">
										<span class="text">${f.title}</span>
									</div>
							</a>
						</div>
					</td>
				 </tr>
			</s:iterator>
		</table>
	</div>
	
	<div class="feedhotnewscontainer">
			<s:iterator value="hottestFeeds" var="f">
					<div class="feedhotnews">
						<div class="itemContent">
							<a href="/feed?comid=${f.comid }&feedId=${f.id}" class="link-title" style="text-decoration: none;">
								<c:if test="${f.image !=null && !f.image.isEmpty()}">
									<div class="feedhotnews_image">
										<img title="${f.title }" alt="${f.title }" src="${f.thumb2Image }" width="100%">
									</div>
								</c:if>	
								${f.title}
							</a>
							<br>
							<span class="text_gray_small">
							${f.postedDate}:
							<c:if test="${f.comName !=null && !f.comName.isEmpty()}">
								${f.comName}
							</c:if>
							(${f.viewCount} lần xem)<br>
							</span>
						 </div>
					 </div>
			</s:iterator>
	</div>
</div>


<c:if test="${recentFeeds != null && recentFeeds.size() > 0}">
	<c:forEach items="${recentFeeds }" var="feeds">
		<c:if test="${feeds.value.size()>0}">
		<div class="section">Thông tin từ ${feeds.key }</div>
		<c:forEach items="${feeds.value }" var="f">
			<div style="position: relative;width: 48%;font-family: Arial;color: #333;float: left; margin: 4px; padding:4px; overflow: hidden;height: 160px;border-bottom: thin dotted #ddd;text-align: left;">
				<span class="text_gray">
					<c:if test="${f.comName !=null && !f.comName.isEmpty()}">
						${f.comName}:
					</c:if>
					${f.postedDate}(${f.viewCount} lần xem)<br>
				</span>
				<a href="/feed?comid=${f.comid }&feedId=${f.id}" class="link-title" style="text-decoration: none;">
					<div style="position: relative;float: left;padding: 4px;width: 140px;height: 100px;overflow: hidden;">
						<img alt="" src="${f.thumb2Image}" style="width: 100%; min-height: 100px;">
					</div>
					<span>${f.title}</span>
				</a>
				<br>
				<span class="text">${f.feed}</span>
			</div>
		</c:forEach>
		</c:if>
	</c:forEach>
</c:if>

<c:if test="${newItems != null && newItems.size() > 0}">
<div class="section">Sản Phẩm Mới</div>
	<div class="n_itemslist">
			<div id="ca-container" class="ca-container">
			<div class="ca-wrapper">
					<s:iterator value="newItems" var="m_item">
							<div class="ca-item ca-item-2">
								<ui:item width="100%" item="${m_item}" edit="false" clazz="item_xs" customParams="imageClass=feedhotnews_image,showCodeAndCount=false"
 									callBackMethod="viewItemInPage" btnPrefix="btn" showView="true" showShortDesc="false"></ui:item>
							</div>
					</s:iterator>
			</div>
		</div>
	</div>
	<br><br><br>
</c:if>

<c:if test="${discountItems != null && discountItems.size() > 0}">
	<div class="section">Sản Phẩm Giảm Giá</div>
		<div class="n_itemslist">
				<div id="discountitem-container" class="ca-container">
				<div class="ca-wrapper">
					<s:iterator value="discountItems" var="disitem">
						<div class="ca-item ca-item-2">
								<ui:item width="100%" item="${disitem}" edit="false" clazz="item_xs" customParams="imageClass=feedhotnews_image,showCodeAndCount=false"
 									callBackMethod="viewItemInPage" btnPrefix="btn" showView="true" showShortDesc="false"></ui:item> 
						</div>
					</s:iterator>
				</div>
		</div>
	</div>
	<br><br><br><br>
</c:if>
<script type="text/javascript">
	$('#ca-container').contentcarousel();
	$('#discountitem-container').contentcarousel();

	(function($){
	    $(window).load(function(){
	        $(".feedhightlightnews").mCustomScrollbar({
	            horizontalScroll:false,
	            theme:"dark"
	        });
	    });
	})(jQuery);

	function viewItemInPage(pageId,itemId){
		window.location.href="/items?comid="+pageId+"&id="+itemId+"&action=viewItem";
	}

</script>
