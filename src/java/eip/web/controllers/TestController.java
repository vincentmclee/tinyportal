package eip.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller  {

  private String viewPage;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView(viewPage);
  }

  public void setViewPage(String viewPage) {
	this.viewPage = viewPage;
  }
 
}
