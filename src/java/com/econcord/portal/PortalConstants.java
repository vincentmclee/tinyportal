package com.econcord.portal;

/**
 * Container for constant values that are used in portal controller.
 */

public interface PortalConstants {

  /**
   *  預設的主題
   */
  String DEFAULT_THEME = "default" ;
  
  /**
   *  portal 登入頁的路徑
   */
  String PORTAL_LOGIN_PAGE = "/index.jsp";

  /**
   *  portal 第一頁的網址
   */
  String PORTAL_HOME_PATH = "/app/portal/page/home" ;

  /**
   * 三欄 layout的頁面路徑
   */
  String THREE_COLUMN_PAGE = "/WEB-INF/portal/three_column.jsp" ;

  /**
   * 兩欄 layout的頁面路徑
   */
  String TWO_COLUMN_PAGE = "/WEB-INF/portal/two_column.jsp" ;

  /**
   * 找不到 uri 的 TabPage 顯示頁面路徑
   */
  String EMPTY_TAB_PAGE = "/WEB-INF/portal/empty_page.jsp" ;

  /**
   * widget page layout preference 的值, 代表三欄 layout
   */
  String THREE_COLUMN_PREFERENCE_VALUE = "three_column" ;

  /**
   * widget page layout preference 的值, 代表兩欄 layout
   */
  String TWO_COLUMN_PREFERENCE_VALUE = "two_column" ;

  /**
   * 登入存在 session 中的 member 物件的 key
   */
  String AUTHENTICATION_OBJECT_KEY = "portalMember" ;

  /**
   * Widget 發生 Exception 時, 所顯示的頁面路徑
   */
  String WIDGET_EXCEPRION_PAGE = "/WEB-INF/widget/widget_exception.jsp" ;
}
