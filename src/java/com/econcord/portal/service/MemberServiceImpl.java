package com.econcord.portal.service;

import com.econcord.portal.model.Member;
import com.econcord.portal.model.MemberDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public class MemberServiceImpl implements IMemberService {

  private MemberDao memberDao ;

  public MemberServiceImpl() {
	super();
  }
  
  public MemberDao getMemberDao() {
	return memberDao;
  }

  public void setMemberDao(MemberDao memberDao) {
	this.memberDao = memberDao;
  }
  
  public Member getMember(String principal) {
	return memberDao.findByPrincipal(principal) ;
  }

  @Transactional(readOnly=false)
  public void saveMember(Member member) {
	memberDao.save(member);
	memberDao.flush();
  }

}
