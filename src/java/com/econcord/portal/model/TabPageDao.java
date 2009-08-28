package com.econcord.portal.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.thinking.tinymvc.persistence.HibernateDao;

public class TabPageDao extends HibernateDao<TabPage ,Long> {

  public Integer getMaxOrderNo() {
	Session session = getSessionFactory().getCurrentSession();
	Query query = session.createQuery("select max(p.orderNo) from TabPage p") ;
	return (Integer) query.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<TabPage> findAllOrderByOrderNo() {
	Session session = getSessionFactory().getCurrentSession();
	Query query = session.createQuery("from TabPage order by orderNo asc") ;
	return query.list();
  }

  public TabPage findByUniqueName(String uniqueName) {
	Session session = getSessionFactory().getCurrentSession();
	Query query = session.createQuery("from TabPage where uniqueName = :uniqueName") ;
	query.setString("uniqueName", uniqueName) ;
	return (TabPage) query.uniqueResult();
  }
  
}
