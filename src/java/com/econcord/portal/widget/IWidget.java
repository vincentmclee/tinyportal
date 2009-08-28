package com.econcord.portal.widget;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thinking.tinymvc.IView;


/**
 *  A interface for widget implement
 *
 * @author thinking
 */
public interface IWidget {
  public IView render(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
