package com.econcord.portal.tag;

import com.econcord.portal.model.Member;
import com.econcord.portal.model.PortalPreference;
import com.econcord.portal.security.SecurityHelper;
import com.econcord.portal.theme.ThemeManager;
import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.thinking.tinymvc.spring.SpringHelper;

public class ThemeLayoutTag extends SimpleTagSupport {

  private String var;
 
  public void setVar(String var) {
	this.var = var;
  }

  @Override
  public void doTag() throws JspException, IOException {
	JspContext context = getJspContext();
	PageContext pageContext = (PageContext) context;

	Member member = SecurityHelper.getMemberFromSession(pageContext.getSession()) ;
	ThemeManager themeManager = SpringHelper.getBean("themeManager", ThemeManager.class, pageContext.getServletContext()) ;

	String memberTheme = member.getPreference(PortalPreference.THEME.getKey()) ;
	
	context.setAttribute(var, themeManager.getPageLayoutPath(memberTheme)) ;
  }

}
