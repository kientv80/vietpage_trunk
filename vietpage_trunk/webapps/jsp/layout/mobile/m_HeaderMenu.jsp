<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ui" uri="/custom-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div style="position: relative;width: 100%;float: right;padding: 6px;">
	<a href="/home" title="Trang chính" style="padding-bottom: 4px;">
		<img title="viet page logo" alt="viet page logo" src="/images/vietpage/Home.png" style="width:50px;height: 50px;"/><s:text name="vietpage.title"></s:text> |
	</a>
	<a href="/search"><s:text name="vietpage.search.title"></s:text></a> | 
	<a href="/hotnews" style="padding:6px;"><s:text name="vietpage.home.menu.news"></s:text> | </a>
	<a href="#" onclick="alert('Liên hê qua mail vietpage.info@yahoo.com.vn');"><s:text name="vietpage.contact"></s:text></a> | 
</div>