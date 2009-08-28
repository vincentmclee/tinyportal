package com.econcord.portal.security;

public class CredentialErrorException extends AuthenticationException {

  public CredentialErrorException() {
  }

  public CredentialErrorException(String message) {
	super(message);
  }

  public CredentialErrorException(String message, Throwable cause) {
	super(message, cause);
  }

  public CredentialErrorException(Throwable cause) {
	super(cause);
  }

}
