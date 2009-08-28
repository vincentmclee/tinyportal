package com.econcord.portal.security;

import com.econcord.portal.PortalConstants;
import com.econcord.portal.model.Member;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thinking.util.UrlPathHelper;

public class SecurityFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class) ;
  
  protected static final String EXCLUDE_URIS_KEY = "Exclude.Uris";
  protected static final String REQUEST_ENCODIG_KEY = "Request.Encoding";

  private String encoding = "UTF-8" ;
  private List<String> excludedUri ;

  public void init(FilterConfig filterConfig) throws ServletException {
    String excludedParam = filterConfig.getInitParameter(EXCLUDE_URIS_KEY) ;

	if (excludedParam == null) {
      excludedUri = new ArrayList<String>();
	} else {
	  String[] uris = StringUtils.split(excludedParam.trim(), ",") ;
	  excludedUri = new ArrayList<String>();
	  for (String uri : uris) {
		excludedUri.add(uri);
	  }
	}

	if (excludedUri.size() > 0 ) {
	  if (logger.isInfoEnabled()) {
		for (String uri : excludedUri) {
		  logger.info("Excluded Uri : '" + uri + "'");
	    }
	  }
	} else {
	  if (logger.isInfoEnabled()) {
		logger.info("No Excluded Uri");
	  }
	}

	String encodingParam = filterConfig.getInitParameter(REQUEST_ENCODIG_KEY) ;
	if (encodingParam != null) {
	  encoding = encodingParam ;
	}
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	
	HttpServletRequest request = (HttpServletRequest) servletRequest ;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

	String requestUri = UrlPathHelper.getPathWithinApplication(request, encoding) ;

	if (excludedUri.contains(requestUri)) {
	  chain.doFilter(servletRequest, servletResponse);
	} else {
	  // check member in session
	  HttpSession session = request.getSession() ;
	  Member member = SecurityHelper.getMemberFromSession(session) ;
	  if (member == null) {
		response.sendRedirect(request.getContextPath() + PortalConstants.PORTAL_LOGIN_PAGE);
	  } else {
		chain.doFilter(servletRequest, servletResponse);
	  }
	}
	
  }

  public void destroy() {
	if (excludedUri != null) {
	  excludedUri.clear();
	  excludedUri = null ;
	}
  }

}
