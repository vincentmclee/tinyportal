
package eip.web.widgets;

import com.econcord.portal.model.Member;
import com.econcord.portal.security.SecurityHelper;
import com.econcord.portal.widget.IWidget;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thinking.tinymvc.IView;

public class CalendarWidget implements IWidget {

  private Logger logger = LoggerFactory.getLogger(CalendarWidget.class);

  public IView render(HttpServletRequest request, HttpServletResponse response) throws Exception {

	Member member = SecurityHelper.getMemberFromSession(request.getSession()) ;

	if (logger.isInfoEnabled()) {
	  logger.info(">>>>> your givenName is '" + member.getGivenName()  + "'");
	}
	
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();

	out.println("<p style=\"margin-left: auto; margin-right: auto; width: 145px\">");
	out.println("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,00,0\" width=\"145\" height=\"145\">");
    out.println("<param name=\"movie\" value=\"http://www.sonyericsson.co.jp/fika/blogparts_collection/calender/003/main.swf?BLOG=calendar03.html\">");
    out.println("<param name=\"quality\" value=\"high\">");
	out.println("<embed src=\"http://www.sonyericsson.co.jp/fika/blogparts_collection/calender/003/main.swf?BLOG=calendar03.html\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"145\" height=\"145\"></embed>");
    out.println("</object>");
	out.println("</p>");

	out.close();
	return null;
  }

}
