package eip.web.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test2Controller implements Controller {

  private String viewPage;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userkeyword = request.getParameter("username");
	String deptkeyword = request.getParameter("orgname");

	Map<String,Object> model = new HashMap<String,Object>() ;
    model.put("user", userkeyword);
	model.put("dept", deptkeyword);

	return new ModelAndView(viewPage, model);
  }

  public void setViewPage(String viewPage) {
	this.viewPage = viewPage;
  }
  
}
