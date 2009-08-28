package com.econcord.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thinking.tinymvc.ActionContext;
import org.thinking.tinymvc.IController;

public abstract class AbstractController implements IController {

  protected Logger logger = LoggerFactory.getLogger(getClass()) ;
  
  private PortalActionContext actionContext ;

  public PortalActionContext getActionContext() {
    return actionContext;
  }

  public void setActionContext(ActionContext actionContext) {
	this.actionContext = (PortalActionContext) actionContext ;
  }

}
