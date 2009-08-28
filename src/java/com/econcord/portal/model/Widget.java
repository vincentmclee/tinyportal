package com.econcord.portal.model;

import org.thinking.tinymvc.persistence.PersistenceEntity;

public class Widget extends PersistenceEntity<Long> {

  private static final long serialVersionUID  = 1L;

  private Long id ;
  private String uniqueName;  // 獨一無二的名稱
  private String title;       // 顯示在 widget title 上的名稱
  private String className;   // 實作 IWidget 的 java class name
  private String description; // 描述
  private String allowRole;   // 可以看到的 role
  private String icon;        // icon
  private Integer version;    // 樂觀鎖的版本號碼
  
  public Widget() {
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

  public String getAllowRole() {
	return allowRole;
  }

  public void setAllowRole(String allowRole) {
	this.allowRole = allowRole;
  }

  public String getClassName() {
	return className;
  }

  public void setClassName(String className) {
	this.className = className;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public String getIcon() {
	return icon;
  }

  public void setIcon(String icon) {
	this.icon = icon;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public String getUniqueName() {
	return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
	this.uniqueName = uniqueName;
  }

  public Integer getVersion() {
	return version;
  }

  public void setVersion(Integer version) {
	this.version = version;
  }
  
}
