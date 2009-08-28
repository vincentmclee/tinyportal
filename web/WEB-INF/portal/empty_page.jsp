<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.jspf" %>
<portal:themeLayout var="layoutPath" />
<tiny:layoutRender path="${layoutPath}">
  <tiny:layoutComponent name="content">
	<div id="notifyblock" class="notice">
	  此頁正在建構中 !
	</div>
  </tiny:layoutComponent>
</tiny:layoutRender>
