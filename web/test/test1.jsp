<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.jspf" %>
<portal:themeLayout var="layoutPath" />
<tiny:layoutRender path="${layoutPath}">
  <tiny:layoutComponent name="content">
	<form method="post" action="${contextPath}/test/Test2Controller.do">
      使用者 : <input type="text" name="username" size="32" /><br>
	  部門名稱 : <input type="text" name="orgname" size="32" /><br>
	  <input type="submit" value="確定" />
	</form>
  </tiny:layoutComponent>
</tiny:layoutRender>
