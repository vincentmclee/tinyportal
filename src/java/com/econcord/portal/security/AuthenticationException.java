package com.econcord.portal.security;

public class AuthenticationException extends Exception {

  public AuthenticationException(Throwable cause) {
	super(cause);
  }

  public AuthenticationException(String message, Throwable cause) {
	super(message, cause);
  }

  public AuthenticationException(String message) {
	super(message);
  }

  public AuthenticationException() {
  }

}
