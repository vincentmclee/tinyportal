<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.jspf" %>
<portal:themeLayout var="layoutPath" />
<tiny:layoutRender path="${layoutPath}">
  <tiny:layoutComponent name="content">
	<p>
	  使用者 : ${user}<br>
	  部門 : ${dept}
	</p>
	<p>
	  <a href="<c:url value="/test/Test3Controller.do" />" title="回會議類別維護首頁">回會議類別維護首頁</a>
	</p>
  </tiny:layoutComponent>
</tiny:layoutRender>
