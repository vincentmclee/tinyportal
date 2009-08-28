package com.econcord.portal.model;

public enum PortalPreference {

  THEME("portal.theme") ,
  WIDGETLAYOUT("portal.widget.layout"),
  WIDGETCOLORCLASS("portal.widget.color.class")
  ;

  private final String key;

  PortalPreference(String key) {
	this.key = key;
  }

  public String getKey() {
	return key;
  }

}
