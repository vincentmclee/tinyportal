package com.econcord.portal.tag;

import com.econcord.portal.model.Member;
import com.econcord.portal.model.TabPage;
import com.econcord.portal.security.SecurityHelper;
import com.econcord.portal.service.ITabPageService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.thinking.tinymvc.spring.SpringHelper;

public class PageTabTag extends SimpleTagSupport {

  @Override
  public void doTag() throws JspException, IOException {
	JspContext context = getJspContext();
	PageContext pageContext = (PageContext) context;

	ITabPageService tabPageService = SpringHelper.getBean("tabPageService", ITabPageService.class, pageContext.getServletContext()) ;
	Member member = SecurityHelper.getMemberFromSession(pageContext.getSession()) ;

	List<TabPage> tabPages = tabPageService.getTabPages() ;
	Long selectedPageId = member.getSelectedPage() ;
	
	JspWriter out = context.getOut();
	out.println("<div class=\"tabs\"><ul>");

    for (TabPage tabPage : tabPages) {
      if (tabPage.getId().equals(selectedPageId)) {
		out.println("<li class=\"active\"><a href=\"#pagecontent\"><span>" + tabPage.getTitle() +  "<span></a></li>");
	  } else {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest() ;
		String contextPath = request.getContextPath() ;
		String pagePath = contextPath + "/app/portal/page/" + tabPage.getUniqueName();
        out.println("<li><a href=\"" + pagePath + "\"><span>" + tabPage.getTitle() + "</span></a></li>");
	  }
	}

	out.println("</ul></div>");
  }

}
