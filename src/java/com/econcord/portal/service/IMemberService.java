package com.econcord.portal.service;

import com.econcord.portal.model.Member;

public interface IMemberService {
  public Member getMember(String principal) ;
  public void saveMember(Member member);
}
