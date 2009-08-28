package com.econcord.portal.theme;

/**
 * 代表一個 主題
 *
 * @author thinking
 */
public class Theme {

  private String id;     // identity
  private String name;   // displayname
  private String layoutSource; // layout file source

  public Theme() {
	super() ;
  }

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getLayoutSource() {
	return layoutSource;
  }

  public void setLayoutSource(String layoutSource) {
	this.layoutSource = layoutSource;
  }
  
  public String getPageLayoutPath() {
	return String.format("/%s/%s", id, getLayoutSource());
  }

  @Override
  public boolean equals(Object obj) {
	if (obj == null) {
	  return false;
	}
	if (getClass() != obj.getClass()) {
	  return false;
	}
	final Theme other = (Theme) obj;
	if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
	  return false;
	}
	return true;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
	return hash;
  }

  @Override
  public String toString() {
	return String.format("id: %s (%s)", id, name);
  }

}
