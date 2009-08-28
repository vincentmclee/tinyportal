package com.econcord.portal;

import com.econcord.portal.model.Member;
import com.econcord.portal.security.SecurityHelper;
import org.thinking.tinymvc.ActionContext;
import org.thinking.tinymvc.spring.SpringHelper;

public class PortalActionContext extends ActionContext {

  public <T> T getBean(String id, Class<T> type) {
    return SpringHelper.getBean(id, type, getServletContext());
  }

  public Member getMember() {
	return SecurityHelper.getMemberFromSession(getSession()) ;
  }
  
}
