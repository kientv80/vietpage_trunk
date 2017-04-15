<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <div id="bb" style="position:relative; width: 100%;  border: 1px solid #d4d4d4;"> -->
<div class="scrollbar">
	<table>
		<tr>
			<td><a href="#"
				onclick="window.open('/lookup?domain=tuoitre.vn&redirectUrl=http://tuoitre.vn');"><img
					alt="" src="/images/news_logos/logo_tuoitre.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=vnexpress.net&redirectUrl=http://vnexpress.net/');"><img
					alt="" src="/images/news_logos/vnexpress.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=ngoisao.net&redirectUrl=http://ngoisao.net/');"><img
					alt="" src="/images/news_logos/ngoisao.jpg" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=bongdaplus.vn&redirectUrl=http://bongdaplus.vn');"><img
					alt="" src="/images/news_logos/bongda.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=vietnamworks.com&redirectUrl=http://www.vietnamworks.com');"><img
					alt="" src="/images/news_logos/vietnamworks.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=pcworld.com.vn&redirectUrl=http://www.pcworld.com.vn');"><img
					alt="" src="/images/news_logos/thegioivitinh.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=vneconomy.vn&redirectUrl=http://vneconomy.vn');"><img
					alt="" src="/images/news_logos/vneconomy.gif" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=caythuocquy.info.vn&redirectUrl=http://caythuocquy.info.vn');"><img
					alt="" src="/images/news_logos/caythuocquy.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=vuitruyentranh.vn&redirectUrl=http://vuitruyentranh.vn');"><img
					alt="" src="/images/news_logos/vuitruyentranh.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=nhaccuatui.com&redirectUrl=http://www.nhaccuatui.com');"><img
					alt="" src="/images/news_logos/nhaccuatui.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=movies.hdviet.com&redirectUrl=http://movies.hdviet.com');"><img
					alt="" src="/images/news_logos/hdviet.png" class="new_logo"></a>
			</td>
			<td><a href="#"
				onclick="window.open('/lookup?domain=www.youtube.com&redirectUrl=http://www.youtube.com');"><img
					alt="" src="/images/news_logos/youtube.jpg" class="new_logo"></a>
			</td>
		</tr>
	</table>
</div>
<div id="aaaaa" style="position:relative; width: 100%; float: left;">
	<table style="width: 100%;">
		<s:iterator value="hotNews" var="news">
			<tr>
				<td>
					<div class="news">
						<a href="${news.link }"> 
							<table style="width: 100%;">
								<tr>
									<td>
										<img src="${news.thume }" width="100%" height="480px">
									</td>
								</tr>
								<tr>
									<td>
										<span class="title">${news.title } </span>
									</td>
								</tr>
								<tr>
									<td>
										<span class="text"><c:out value="${news.content }"></c:out></span>
									</td>
								</tr>
							</table>
						</a> 
					</div>
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
<!-- </div> -->
<!-- custom scrollbars plugin -->
