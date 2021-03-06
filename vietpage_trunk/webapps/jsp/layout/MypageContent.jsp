<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:if test="${companies != null && companies.size() > 0 && currentPage != 'search' }">
		<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1, Item 2, Item 3" displayHeader="false" data="${companies }"  params="editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true,imageClass=item_image"></ui:table>
</c:if>
<c:if test="${(companies == null || companies.size() == 0) && action == 'search'}">
	Chưa tìm thấy kết quả phù hợp mời bạn thử lại sau hoặc chỉn lại điều kiện tìm kiếm.
</c:if>
<c:if test="${recentComs != null && recentComs.size() > 0 && recentVisit=='true'}">
	<div class="section">
		<s:text name="vietpage.recentPages"></s:text>
	</div>
	<ui:table contentProvider="com.vnsoft.server.contentprovider.PageSimpleTableContentProvider" headers="Item 1, Item 2, Item 3" displayHeader="false" data="${recentComs }"  params="editable=false,callback=m_viewItem3,showView=true,btnPrefix=discount,returnedBtnNames=discount_btns,showDesc=true,showContactInfo=true,showAssessment=false,showRanking=true,imageClass=item_image"></ui:table>
</c:if>
<c:if test="${debug=='true' }">
	<input type="button" value="Check login" onclick="showLikePopup();"/>
	<input type="button" value="Post feed" onclick="postFeed();"/>
	<input type="button" value="Ask for permission" onclick="loginViaZalo();"/>
</c:if>

<script type="text/javascript">
function postFeed(){
		FB.ui(
		      {
		       method: 'feed',
		       name: 'Vietpage.info post feed',
		       caption: 'Post feed from vietpage.info',
		       description: (
		          'This function is not yet ready, please do not use it'
		       ),
		       link: 'http://vietpage.info/vietpageDetail?type=news&id=25',
		       picture: 'http://vietpage.info/images/217/217_feed_16859969281111653.jpg'
		      },
		      function(response) {
		        if (response && response.post_id) {
		          alert('Post was published successfully.');
		        } else {
		          alert('Post was not published.');
		        }
		      }
		    );
	}
	
	
</script>
