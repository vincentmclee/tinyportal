package com.econcord.portal.service;

import com.econcord.portal.model.WidgetInstance;
import java.util.List;

public interface IWidgetInstanceService {
  public List<WidgetInstance> getWidgetInstancesByColumnNo(Integer columnNo) ;
  public void saveWidgetInstance(WidgetInstance widgetInstance) ;
}
