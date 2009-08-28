package com.econcord.portal.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.thinking.tinymvc.persistence.HibernateDao;

public class WidgetInstanceDao extends HibernateDao<WidgetInstance ,Long> {

  @SuppressWarnings("unchecked")
  public List<WidgetInstance> findByColumnNoOrdByOrderNo(Integer columnNo) {
    Session session = getSessionFactory().getCurrentSession();
	Query query = session.createQuery("from WidgetInstance where columnNo = :columnNo order by orderNo asc") ;
	query.setInteger("columnNo", columnNo) ;
	return query.list();
  }
   
}
