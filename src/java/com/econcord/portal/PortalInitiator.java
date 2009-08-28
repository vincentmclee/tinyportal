package com.econcord.portal;

import com.econcord.portal.model.TabPage;
import com.econcord.portal.model.Widget;
import com.econcord.portal.model.WidgetInstance;
import com.econcord.portal.service.ITabPageService;
import com.econcord.portal.service.IWidgetInstanceService;
import com.econcord.portal.service.IWidgetService;

public class PortalInitiator  {

  private ITabPageService tabPageService ;
  private IWidgetService widgetService ;
  private IWidgetInstanceService widgetInstanceService;

  public ITabPageService getTabPageService() {
	return tabPageService;
  }

  public void setTabPageService(ITabPageService tabPageService) {
	this.tabPageService = tabPageService;
  }

  public IWidgetService getWidgetService() {
	return widgetService;
  }

  public void setWidgetService(IWidgetService widgetService) {
	this.widgetService = widgetService;
  }

  public IWidgetInstanceService getWidgetInstanceService() {
	return widgetInstanceService;
  }

  public void setWidgetInstanceService(IWidgetInstanceService widgetInstanceService) {
	this.widgetInstanceService = widgetInstanceService;
  }
  
  public void init() {

	// init TabPage Data
    TabPage widgetPage = new TabPage();
	widgetPage.setUniqueName("home") ;
	widgetPage.setWidgetPage(true);
	widgetPage.setTitle("首頁");
	widgetPage.setPageUri("");
	tabPageService.saveTabPage(widgetPage);

	TabPage page = new TabPage();
	page.setUniqueName("mettingClass") ;
	page.setWidgetPage(false);
	page.setTitle("會議類別維護");
	page.setPageUri("/test/TestController.do");
	tabPageService.saveTabPage(page);

	page = new TabPage();
    page.setUniqueName("mettingNotify") ;
	page.setWidgetPage(false);
	page.setTitle("會議通知管理");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

    page = new TabPage();
	page.setUniqueName("mettingFileUpload") ;
	page.setWidgetPage(false);
	page.setTitle("會前檔案上傳");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

	page = new TabPage();
	page.setUniqueName("mettingAgenda") ;
	page.setWidgetPage(false);
	page.setTitle("會議議程編制");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

	page = new TabPage();
	page.setUniqueName("mettingAttend") ;
	page.setWidgetPage(false);
	page.setTitle("會議出席管理");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

	page = new TabPage();
	page.setUniqueName("mettingData") ;
	page.setWidgetPage(false);
	page.setTitle("會議資料管理");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

	page = new TabPage();
    page.setUniqueName("fileDownload") ;
	page.setWidgetPage(false);
	page.setTitle("檔案下載");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

	page = new TabPage();
	page.setUniqueName("report") ;
	page.setWidgetPage(false);
	page.setTitle("統計報表");
	page.setPageUri("");
	tabPageService.saveTabPage(page);

    // init a test widget data
	Widget testWidget = new Widget() ;
	testWidget.setUniqueName("test");
	testWidget.setTitle("測試");
	testWidget.setClassName("eip.web.widgets.TestWidget");
	testWidget.setDescription("測試用的widget");
	widgetService.saveWidget(testWidget);

    Widget weatherWidget = new Widget() ;
	weatherWidget.setUniqueName("weather");
	weatherWidget.setTitle("中央氣象局天氣預報");
	weatherWidget.setClassName("eip.web.widgets.WeatherWidget");
	weatherWidget.setDescription("中央氣象局天氣預報widget");
	widgetService.saveWidget(weatherWidget);

	Widget calendarWidget = new Widget() ;
	calendarWidget.setUniqueName("calendar");
	calendarWidget.setTitle("小月曆");
	calendarWidget.setClassName("eip.web.widgets.CalendarWidget");
	calendarWidget.setDescription("測試用的小月曆widget");
	widgetService.saveWidget(calendarWidget);

	// init a widgetInstance
	WidgetInstance widgetInstance = new WidgetInstance();
	widgetInstance.setWidget(calendarWidget);
	widgetInstance.setColumnNo(1);
	widgetInstance.setOrderNo(1);

	widgetInstanceService.saveWidgetInstance(widgetInstance);

    widgetInstance = new WidgetInstance();
	widgetInstance.setWidget(testWidget);
	widgetInstance.setColumnNo(2);
	widgetInstance.setOrderNo(1);

	widgetInstanceService.saveWidgetInstance(widgetInstance);

	widgetInstance = new WidgetInstance();
	widgetInstance.setWidget(weatherWidget);
	widgetInstance.setColumnNo(3);
	widgetInstance.setOrderNo(1);

	widgetInstanceService.saveWidgetInstance(widgetInstance);

  }

}
