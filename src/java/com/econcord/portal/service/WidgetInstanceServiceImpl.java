package com.econcord.portal.service;

import com.econcord.portal.model.WidgetInstance;
import com.econcord.portal.model.WidgetInstanceDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public class WidgetInstanceServiceImpl implements IWidgetInstanceService {

  private WidgetInstanceDao widgetInstanceDao ;

  public WidgetInstanceServiceImpl() {
	super();
  }
  
  public WidgetInstanceDao getWidgetInstanceDao() {
	return widgetInstanceDao;
  }

  public void setWidgetInstanceDao(WidgetInstanceDao widgetInstanceDao) {
	this.widgetInstanceDao = widgetInstanceDao;
  }

  public List<WidgetInstance> getWidgetInstancesByColumnNo(Integer columnNo) {
	return widgetInstanceDao.findByColumnNoOrdByOrderNo(columnNo) ;
  }

  @Transactional(readOnly=false)
  public void saveWidgetInstance(WidgetInstance widgetInstance) {
	widgetInstanceDao.save(widgetInstance);
	widgetInstanceDao.flush();
  }

}
