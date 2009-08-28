package eip.web.widgets;

import com.econcord.portal.widget.IWidget;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thinking.tinymvc.IView;
import org.thinking.tinymvc.view.ForwardView;

public class WeatherWidget implements IWidget {

  public IView render(HttpServletRequest request, HttpServletResponse response) throws Exception {
	return new ForwardView("/test/weather_widget.jsp");
  }

}
