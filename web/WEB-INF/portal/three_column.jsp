<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.jspf" %>
<portal:themeLayout var="layoutPath" />
<tiny:layoutRender path="${layoutPath}">
  <tiny:layoutComponent name="content">
	<portal:preference var="widgetColorClass" preference="portal.widget.color.class" />
	<div id="columns">
	  <ul id="column1" class="column">
		<c:forEach var="widgetInstance" items="${widgetsColumn1}">
		  <li class="widget ${widgetColorClass}" id="widget${widgetInstance.id}">
            <div class="widget-head">
			  <img src="${contextPath}/themes/default/images/icon.gif" width="17" height="17" alt="icon" />
              <h3>${widgetInstance.widget.title}</h3>
            </div>
            <div class="widget-content">
              <script type="text/javascript">
			  <!--
			     $.get('${contextPath}/app/widget/render/${widgetInstance.widget.id}', 
				       { timestamp: new Date().getTime() },
					   function(data){
					     $('#widget${widgetInstance.id} div.widget-content').html(data);
					   },
				       'html');
			  //-->
			</script>
            </div>
          </li>
		</c:forEach>
	  </ul>
	  <ul id="column2" class="column">
		<c:forEach var="widgetInstance" items="${widgetsColumn2}">
		  <li class="widget ${widgetColorClass}" id="widget${widgetInstance.id}">
            <div class="widget-head">
			  <img src="${contextPath}/themes/default/images/icon.gif" width="17" height="17" alt="icon" />
              <h3>${widgetInstance.widget.title}</h3>
            </div>
            <div class="widget-content">
              <script type="text/javascript">
			  <!--
			    $.get('${contextPath}/app/widget/render/${widgetInstance.widget.id}',
				      { timestamp: new Date().getTime() },
					  function(data){
					     $('#widget${widgetInstance.id} div.widget-content').html(data);
					  },
				      'html');
			  //-->
			</script>
            </div>
          </li>
		</c:forEach>
	  </ul>
	  <ul id="column3" class="column">
		<c:forEach var="widgetInstance" items="${widgetsColumn3}">
		  <li class="widget ${widgetColorClass}" id="widget${widgetInstance.id}">
            <div class="widget-head">
			  <img src="${contextPath}/themes/default/images/icon.gif" width="17" height="17" alt="icon" />
              <h3>${widgetInstance.widget.title}</h3>
            </div>
            <div class="widget-content">
              <script type="text/javascript">
			  <!--
			    $.get('${contextPath}/app/widget/render/${widgetInstance.widget.id}',
				      { timestamp: new Date().getTime() },
					  function(data){
					     $('#widget${widgetInstance.id} div.widget-content').html(data);
					  },
				      'html');
			  //-->
			</script>
            </div>
          </li>
		</c:forEach>
	  </ul>
	</div>
  </tiny:layoutComponent>
</tiny:layoutRender>
