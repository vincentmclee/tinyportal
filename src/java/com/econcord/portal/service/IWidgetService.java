package com.econcord.portal.service;

import com.econcord.portal.model.Widget;

public interface IWidgetService {
  public Widget getWidget(Long id);
  public void saveWidget(Widget widget) ;
}
