package eip.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

public class Test3Controller implements Controller {
  
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	return new ModelAndView(new RedirectView(request.getContextPath() + "/test/TestController.do"));
  }

}
