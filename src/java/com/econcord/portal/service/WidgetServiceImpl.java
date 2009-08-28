package com.econcord.portal.service;

import com.econcord.portal.model.Widget;
import com.econcord.portal.model.WidgetDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public class WidgetServiceImpl implements IWidgetService {

  private WidgetDao widgetDao ;

  public WidgetServiceImpl() {
    super();
  }
  
  public WidgetDao getWidgetDao() {
	return widgetDao;
  }

  public void setWidgetDao(WidgetDao widgetDao) {
	this.widgetDao = widgetDao;
  }

  public Widget getWidget(Long id) {
    return widgetDao.find(id) ;
  }

  @Transactional(readOnly=false)
  public void saveWidget(Widget widget) {
	widgetDao.save(widget);
	widgetDao.flush();
  }

}
