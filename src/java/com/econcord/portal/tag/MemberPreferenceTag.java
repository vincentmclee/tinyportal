package com.econcord.portal.tag;

import com.econcord.portal.model.Member;
import com.econcord.portal.security.SecurityHelper;
import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MemberPreferenceTag extends SimpleTagSupport {

  private String var;
  private String preference;

  public void setPreference(String preference) {
	this.preference = preference;
  }

  public void setVar(String var) {
	this.var = var;
  }
  
  @Override
  public void doTag() throws JspException, IOException {
    JspContext context = getJspContext();
	PageContext pageContext = (PageContext) context;

	Member member = SecurityHelper.getMemberFromSession(pageContext.getSession()) ;
	String value = member.getPreference(preference);
	context.setAttribute(var, value) ;
  }

}
