package com.econcord.portal.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.thinking.tinymvc.persistence.HibernateDao;

public class MemberDao extends HibernateDao<Member ,Long>{

  public Member findByPrincipal(String principal) {
	Session session = getSessionFactory().getCurrentSession();
	Query query = session.createQuery("from Member where principal = :principal") ;
	query.setString("principal", principal) ;
	return Member.class.cast(query.uniqueResult());
  }
  
}
