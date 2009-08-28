package com.econcord.portal.controller;

import com.econcord.portal.AbstractController;
import com.econcord.portal.PortalConstants;
import com.econcord.portal.model.Widget;
import com.econcord.portal.service.IWidgetService;
import com.econcord.portal.widget.IWidget;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thinking.tinymvc.IView;
import org.fest.reflect.exception.ReflectionError;
import org.thinking.tinymvc.view.ForwardView;
import static org.fest.reflect.core.Reflection.type;
import static org.fest.reflect.core.Reflection.constructor;
import static org.fest.reflect.core.Reflection.method;

public class WidgetController extends AbstractController {

  public IView render(String widgetId) throws IOException {
    
	IWidgetService widgetService = getActionContext().getBean("widgetService", IWidgetService.class) ;
    Widget widget = widgetService.getWidget(Long.parseLong(widgetId)) ;

	String widgetClassName = widget.getClassName() ;
	logger.info("widget classname is : '" + widgetClassName + "'");

	try {
	  Class<? extends IWidget> widgetType = type(widgetClassName).loadAs(IWidget.class);
      IWidget widgetInstance = constructor().in(widgetType).newInstance();

	  return method("render").withReturnType(IView.class)
                             .withParameterTypes(HttpServletRequest.class, HttpServletResponse.class)
                             .in(widgetInstance)
                             .invoke(getActionContext().getRequest(), getActionContext().getResponse());
	  
	} catch(ReflectionError e) {
	  String message = "Create widget class instance '" + widgetClassName + "' error" ;
	  if (logger.isErrorEnabled()) {
        logger.error(message, e);
	  }
	  return new ForwardView(PortalConstants.WIDGET_EXCEPRION_PAGE);
	} catch (Exception e) {
	  if (logger.isErrorEnabled()) {
        logger.error("Render widget error", e);
	  }
	  return new ForwardView(PortalConstants.WIDGET_EXCEPRION_PAGE);
	}
	
  }

}
