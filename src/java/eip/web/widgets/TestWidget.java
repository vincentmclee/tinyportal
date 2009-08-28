package eip.web.widgets;

import com.econcord.portal.widget.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thinking.tinymvc.IView;
import org.thinking.tinymvc.view.ForwardView;

public class TestWidget implements IWidget {

  public IView render(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// throw new Exception("測試exception");
	return new ForwardView("/test/test_widget.jsp");
  }

}
