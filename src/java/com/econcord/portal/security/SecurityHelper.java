package com.econcord.portal.security;


import com.econcord.portal.PortalConstants;
import com.econcord.portal.model.Member;
import javax.servlet.http.HttpSession;

public final class SecurityHelper {

  public static Member getMemberFromSession(HttpSession session) {
	return (Member) session.getAttribute(PortalConstants.AUTHENTICATION_OBJECT_KEY) ;
  }

  public static void saveMamberToSession(HttpSession session, Member member) {
	synchronized (session) {
	  if (session.getAttribute(PortalConstants.AUTHENTICATION_OBJECT_KEY) != null) {
		session.removeAttribute(PortalConstants.AUTHENTICATION_OBJECT_KEY);
		session.setAttribute(PortalConstants.AUTHENTICATION_OBJECT_KEY, member);
	  } else {
		session.setAttribute(PortalConstants.AUTHENTICATION_OBJECT_KEY, member);
	  }
	}
  }

  private SecurityHelper() {}
}
