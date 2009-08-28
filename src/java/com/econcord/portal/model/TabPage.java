package com.econcord.portal.model;

import org.thinking.tinymvc.persistence.PersistenceEntity;

public class TabPage extends PersistenceEntity<Long> {

  private static final long serialVersionUID  = 1L;

  private Long id ;
  private String uniqueName;   // 獨一無二的名稱
  private String title;        // 顯示在 Tab 上的名稱
  private Boolean widgetPage;  // 是否為只包含 widget 的頁面
  private String pageUri;      // 擊點Tab後forwrd到的 uri (同個 web application)
  private String allowRole;    // 可以看到的 role
  private Integer orderNo;     // 序號從 0 開始, 越小的顯示在越前面
  private Integer version;     // 樂觀鎖的版本號碼

  public TabPage() {
	super();
  }
  
  @Override
  public Long getId() {
	return id;
  }

  @Override
  public void setId(Long id) {
	this.id  = id;
  }

  public Boolean isWidgetPage() {
	return widgetPage;
  }

  public void setWidgetPage(Boolean widgetPage) {
	this.widgetPage = widgetPage;
  }

  public String getUniqueName() {
	return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
	this.uniqueName = uniqueName;
  }

  public String getAllowRole() {
	return allowRole;
  }

  public void setAllowRole(String allowRole) {
	this.allowRole = allowRole;
  }

  public Integer getOrderNo() {
	return orderNo;
  }

  public void setOrderNo(Integer orderNo) {
	this.orderNo = orderNo;
  }

  public String getPageUri() {
	return pageUri;
  }

  public void setPageUri(String pageUri) {
	this.pageUri = pageUri;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public Integer getVersion() {
	return version;
  }

  public void setVersion(Integer version) {
	this.version = version;
  }
  
}
