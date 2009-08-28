package com.econcord.portal.theme;

import java.util.Map;

public class ThemeManager {

  private String themesRoot ;

  private Map<String, Theme> themes ;

  public ThemeManager() {}

  public String getThemesRoot() {
	return themesRoot;
  }

  public void setThemesRoot(String themesRoot) {
	this.themesRoot = themesRoot;
  }

  public Map<String, Theme> getThemes() {
	return themes;
  }

  public void setThemes(Map<String, Theme> themes) {
	this.themes = themes;
  }

  public String getPageLayoutPath(String id) {
	Theme theme = themes.get(id) ;
	if (theme != null) {
	  return String.format("%s%s", themesRoot, theme.getPageLayoutPath());
	} else {
	  return "" ;
	}
  }

}
