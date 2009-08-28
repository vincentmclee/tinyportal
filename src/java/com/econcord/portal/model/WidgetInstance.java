package com.econcord.portal.model;

import org.thinking.tinymvc.persistence.PersistenceEntity;

public class WidgetInstance extends PersistenceEntity<Long> {

  private static final long serialVersionUID  = 1L;

  private Long id ;
  private Widget widget;
  private Integer columnNo;
  private Integer orderNo;
  private Integer version;

  public WidgetInstance() {
	super();
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
	this.id = id;
  }

  public Integer getColumnNo() {
	return columnNo;
  }

  public void setColumnNo(Integer columnNo) {
	this.columnNo = columnNo;
  }

  public Integer getOrderNo() {
	return orderNo;
  }

  public void setOrderNo(Integer orderNo) {
	this.orderNo = orderNo;
  }

  public Integer getVersion() {
	return version;
  }

  public void setVersion(Integer version) {
	this.version = version;
  }

  public Widget getWidget() {
	return widget;
  }

  public void setWidget(Widget widget) {
	this.widget = widget;
  }
  
}
