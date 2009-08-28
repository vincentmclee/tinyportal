package com.econcord.portal.controller;

import com.econcord.portal.AbstractController;
import com.econcord.portal.PortalConstants;
import com.econcord.portal.model.Member;
import com.econcord.portal.model.PortalPreference;
import com.econcord.portal.model.TabPage;
import com.econcord.portal.model.WidgetInstance;
import com.econcord.portal.security.CredentialErrorException;
import com.econcord.portal.security.IAuthenticationManager;
import com.econcord.portal.security.PrincipalNotFoundException;
import com.econcord.portal.security.SecurityHelper;
import com.econcord.portal.service.ITabPageService;
import com.econcord.portal.service.IWidgetInstanceService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.GenericValidator;

import org.thinking.tinymvc.IView;
import org.thinking.tinymvc.ModelMap;
import org.thinking.tinymvc.view.ForwardView;
import org.thinking.tinymvc.view.RedirectView;

public class PortalController extends AbstractController {

  public IView login() {
	
    HttpServletRequest request = getActionContext().getRequest() ;
	String principal = request.getParameter("j_username") ;
	String credential = request.getParameter("j_password");
	String remeberMe = request.getParameter("remeber_me");

	ModelMap errorModel = new ModelMap() ;
	errorModel.addAttribute("j_username", principal) ;
   
	if (GenericValidator.isBlankOrNull(principal) || GenericValidator.isBlankOrNull(credential)) {
	  getActionContext().getFlash().setValue("message", "帳號或密碼不可為空");
	  return new ForwardView(PortalConstants.PORTAL_LOGIN_PAGE, errorModel);
	}

	IAuthenticationManager authenticationManager = getActionContext().getBean("authenticationManager", IAuthenticationManager.class);
	Member member = null ;
	try {
	  member = (Member) authenticationManager.authenticate(principal, credential);
	} catch (PrincipalNotFoundException e) {
	  if (logger.isInfoEnabled()) {
		logger.info("無此帳號" , e);
	  }
	  getActionContext().getFlash().setValue("message", "無此帳號");
	  return new ForwardView(PortalConstants.PORTAL_LOGIN_PAGE, errorModel);

	} catch (CredentialErrorException e) {
      if (logger.isInfoEnabled()) {
		logger.info("密碼錯誤" , e);
	  }
	  getActionContext().getFlash().setValue("message", "密碼錯誤");
	  return new ForwardView(PortalConstants.PORTAL_LOGIN_PAGE, errorModel);

	} catch (Exception e) {
	   if (logger.isErrorEnabled()) {
		logger.error("未知的登入錯誤" , e);
		getActionContext().getFlash().setValue("message", "未知的登入錯誤");
	    return new ForwardView(PortalConstants.PORTAL_LOGIN_PAGE, errorModel);
	  }
	}

	if (member != null) {
      // save member to session
	  HttpSession session = getActionContext().getSession() ;
	  SecurityHelper.saveMamberToSession(session, member);
	  
	  // redirect to user homepage
	  return new RedirectView(PortalConstants.PORTAL_HOME_PATH);
	  
	} else {
	  // should not happen
	  logger.error("未知的錯誤");
	  return new ForwardView(PortalConstants.PORTAL_LOGIN_PAGE, errorModel);
	}
	
  }

  public IView page(String pageName) {

	Member member = getActionContext().getMember();
	ITabPageService pageService = getActionContext().getBean("tabPageService", ITabPageService.class) ;
    TabPage page = pageService.getTabPageByUniqueName(pageName) ;

    member.setSelectedPage(page.getId());

	if (page.isWidgetPage()) {

	  IWidgetInstanceService widgetInstanceService = getActionContext().getBean("widgetInstanceService", IWidgetInstanceService.class) ;
	  
      if (member.getPreference(PortalPreference.WIDGETLAYOUT.getKey()).equals(PortalConstants.TWO_COLUMN_PREFERENCE_VALUE)) {

		// 抓出此 member的所有widget instance
        List<WidgetInstance> instancesInColumnOne = widgetInstanceService.getWidgetInstancesByColumnNo(1) ;
        List<WidgetInstance> instancesInColumnTwo = widgetInstanceService.getWidgetInstancesByColumnNo(2) ;

		ModelMap model = new ModelMap() ;
		model.addAttribute("widgetsColumn1", instancesInColumnOne) ;
        model.addAttribute("widgetsColumn2", instancesInColumnTwo) ;

		return new ForwardView(PortalConstants.TWO_COLUMN_PAGE, model);
	  } else {

		// 抓出此 member的所有widget instance
        List<WidgetInstance> instancesInColumnOne = widgetInstanceService.getWidgetInstancesByColumnNo(1) ;
        List<WidgetInstance> instancesInColumnTwo = widgetInstanceService.getWidgetInstancesByColumnNo(2) ;
        List<WidgetInstance> instancesInColumnThree = widgetInstanceService.getWidgetInstancesByColumnNo(3) ;

		ModelMap model = new ModelMap() ;
		model.addAttribute("widgetsColumn1", instancesInColumnOne) ;
        model.addAttribute("widgetsColumn2", instancesInColumnTwo) ;
		model.addAttribute("widgetsColumn3", instancesInColumnThree) ;

		return new ForwardView(PortalConstants.THREE_COLUMN_PAGE, model);
	  }
	} else {
	  String forwardUri = page.getPageUri() ;
      logger.info("forward uri is : '" + forwardUri + "'");
	  if ( forwardUri == null || forwardUri.equals("")) {
		return new ForwardView(PortalConstants.EMPTY_TAB_PAGE) ;
	  } else {
		return new ForwardView(forwardUri) ;
	  }
	}

  }
  
  public IView logout() {
	getActionContext().getSession().invalidate();
	return new RedirectView(PortalConstants.PORTAL_LOGIN_PAGE);
  }

}
