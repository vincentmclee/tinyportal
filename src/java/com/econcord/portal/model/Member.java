package com.econcord.portal.model;

import java.util.Map;
import org.thinking.tinymvc.persistence.PersistenceEntity;

public class Member extends PersistenceEntity<Long> {

  private static final long serialVersionUID  = 1L;
  
  private Long id ;
  private String principal;     // 帳號
  private String credential;    // 密碼 (登入時輸入的密碼), 不存於DataBase
  private String givenName;     // 中文名稱, 不存於DataBase
  private String orgDn;         // 所屬單位DN, 不存於DataBase
  private String role;          // 所屬角色
  private Map<String,String> preferences;  // 個人設定

  private Long selectedPage = 1L;    // 目前所選的 TabPage id, 預設為 1

  public Member() {
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

  public String getCredential() {
	return credential;
  }

  public void setCredential(String credential) {
	this.credential = credential;
  }

  public String getGivenName() {
	return givenName;
  }

  public void setGivenName(String givenName) {
	this.givenName = givenName;
  }

  public String getOrgDn() {
	return orgDn;
  }

  public void setOrgDn(String orgDn) {
	this.orgDn = orgDn;
  }

  public Map<String, String> getPreferences() {
	return preferences;
  }

  public void setPreferences(Map<String, String> preferences) {
	this.preferences = preferences;
  }

  public String getPrincipal() {
	return principal;
  }

  public void setPrincipal(String principal) {
	this.principal = principal;
  }

  public String getRole() {
	return role;
  }

  public void setRole(String role) {
	this.role = role;
  }

  public Long getSelectedPage() {
	return selectedPage;
  }

  public void setSelectedPage(Long selectedPage) {
	this.selectedPage = selectedPage;
  }
  
  public boolean hasPreference(String preference) {
	return getPreferences().containsKey(preference);
  }

  public String getPreference(String key) {
	String value = getPreferences().get(key) ;
	if (value == null) {
	  return "" ;
	} else {
	  return value ;
	}
  }

  public void setPreference(String key, String value) {
	getPreferences().put(key, value) ;
  }
  
}
