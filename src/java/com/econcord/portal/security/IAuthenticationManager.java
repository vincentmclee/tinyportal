package com.econcord.portal.security;

public interface IAuthenticationManager {
  public Object authenticate(String principal, String credential) throws AuthenticationException ;
}
