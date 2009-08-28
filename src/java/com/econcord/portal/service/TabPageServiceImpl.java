package com.econcord.portal.service;

import com.econcord.portal.model.TabPage;
import com.econcord.portal.model.TabPageDao;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public class TabPageServiceImpl implements ITabPageService {

  private static final Logger logger = LoggerFactory.getLogger(TabPageServiceImpl.class) ;

  private TabPageDao tabPageDao ;

  public TabPageServiceImpl() {
    super();
  }

  public TabPageDao getTabPageDao() {
	return tabPageDao;
  }

  public void setTabPageDao(TabPageDao tabPageDao) {
	this.tabPageDao = tabPageDao;
  }

  public List<TabPage> getTabPages() {
	return tabPageDao.findAllOrderByOrderNo();
  }

  @Transactional(readOnly=false)
  public void saveTabPage(TabPage page) {
	// 遞增 排序數字
	Integer orderNo = tabPageDao.getMaxOrderNo() ;
	logger.info("max orderNo is : '" + orderNo + "'") ;
	if (orderNo == null) {
	  orderNo = 0;
	} else {
	  orderNo = orderNo + 1 ;
	}
	
	page.setOrderNo(orderNo) ;
	tabPageDao.save(page);
	tabPageDao.flush();
  }

  public TabPage getTabPageByUniqueName(String name) {
	return tabPageDao.findByUniqueName(name) ;
  }

}
