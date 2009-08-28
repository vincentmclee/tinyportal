package com.econcord.portal.security;

public class PrincipalNotFoundException extends AuthenticationException {

  public PrincipalNotFoundException() {
  }

  public PrincipalNotFoundException(String message) {
	super(message);
  }

  public PrincipalNotFoundException(String message, Throwable cause) {
	super(message, cause);
  }

  public PrincipalNotFoundException(Throwable cause) {
	super(cause);
  }

}
