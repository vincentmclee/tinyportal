package com.econcord.portal.service;

import com.econcord.portal.model.TabPage;
import java.util.List;

public interface ITabPageService {
  public List<TabPage> getTabPages() ;
  public void saveTabPage(TabPage page);
  public TabPage getTabPageByUniqueName(String name);
}
