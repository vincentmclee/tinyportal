<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/include.jspf"  %>
<tiny:layoutDefinition>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>桃園縣政府e化資訊平台</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/themes/default/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/themes/default/css/core.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/themes/default/css/tabs.css" />
	<c:if test="${not empty portalMember}">
	  <portal:preference var="widgetLayout" preference="portal.widget.layout" />
	  <c:choose>
		<c:when test="${widgetLayout == 'two_column'}">
		  <link rel="stylesheet" type="text/css" href="${contextPath}/themes/default/css/two_column.css" />
		</c:when>
		<c:otherwise>
		  <link rel="stylesheet" type="text/css" href="${contextPath}/themes/default/css/three_column.css" />
		</c:otherwise>
	  </c:choose>
	</c:if>
	<script type="text/javascript" src="${contextPath}/javascript/jquery.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/tabs.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/ui.core.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/ui.draggable.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/ui.droppable.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/ui.selectable.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/ui.sortable.js"></script>
	<script type="text/javascript" src="${contextPath}/javascript/widgets.js"></script>
	<script type="text/javascript">
	<!--
	  $(document).ready(function(){
		$("#head").tabs();
		Widgets.init('${contextPath}/themes/default/css/extend.css');
	  });
	//-->
	</script>
  </head>
  <body>
    <div id="head">
	  <div class="info">
        <img src="${contextPath}/themes/default/images/head_logo.jpg" alt="桃園縣政府e化資訊平台" width="555" height="64">
		<span class="navbar">
	     歡迎: ${portalMember.givenName}! |
		 <a href="#" title="個人設定">個人設定</a> |
	     <a href="${contextPath}/app/portal/logout" title="登出">登出</a>
	    </span>
	  </div>
      <portal:pageTabs />
    </div>
	<div id="content">
	  <div id="pagecontent" class="tabBlock">
		<tiny:layoutComponent name="content" />
	  </div>
	</div>
	<div class="clear"></div>
	<div id="foot">
	  <img src="${contextPath}/themes/default/images/foot_logo.jpg" alt="桃園縣政府" width="104" height="51">
	  <p>
		地 址：33001桃園市縣府路一號 　電 話：03-3322101<br>
        版權所有 © 桃園縣政府 Copyright 2008 Taoyuan County Government. All rights reserved.
	  </p>
	</div>
  </body>
</html>
</tiny:layoutDefinition>
