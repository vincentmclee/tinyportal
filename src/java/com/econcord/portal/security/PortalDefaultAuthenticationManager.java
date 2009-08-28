
package com.econcord.portal.security;

import com.econcord.portal.PortalConstants;
import com.econcord.portal.model.Member;
import com.econcord.portal.model.PortalPreference;
import com.econcord.portal.service.IMemberService;
import com.econcord.portal.theme.ThemeManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;

public class PortalDefaultAuthenticationManager implements IAuthenticationManager  {

  private String userRootDn ;

  private LdapTemplate ldapTemplate;
  private IMemberService memberService;
  
  public PortalDefaultAuthenticationManager() {
	super();
  }

  public String getUserRootDn() {
	return userRootDn;
  }

  public void setUserRootDn(String userRootDn) {
	this.userRootDn = userRootDn;
  }

  public LdapTemplate getLdapTemplate() {
	return ldapTemplate;
  }

  public void setLdapTemplate(LdapTemplate ldapTemplate) {
	this.ldapTemplate = ldapTemplate;
  }

  public IMemberService getMemberService() {
	return memberService;
  }

  public void setMemberService(IMemberService memberService) {
	this.memberService = memberService;
  }
  
  @SuppressWarnings("unchecked")
  public Object authenticate(String principal, String credential) throws AuthenticationException {

	LdapTemplate template = getLdapTemplate() ;

	String principalFilter = String.format("(&(uid=%s)(objectclass=person))", principal);
    List<DistinguishedName> principalDnList  = template
			.search( getUserRootDn(), principalFilter, SearchControls.SUBTREE_SCOPE, new ContextMapper() {
	  public Object mapFromContext(Object ctx) {
		DirContextAdapter context = (DirContextAdapter)ctx;
		return new DistinguishedName(context.getDn());
	  }

	}) ;

	if (principalDnList.size() < 1 ) {

	  throw new PrincipalNotFoundException() ;

	} else if (principalDnList.size() == 1) {

      DistinguishedName userDn = principalDnList.get(0) ;

	  // 認證
	  boolean result = template.authenticate(userDn, "(objectclass=person)", credential) ;
	  if (result == false) {
		throw new CredentialErrorException() ;
	  }

	  // 取出其他存在 ldap 中的值
	  LdapUserValue ldapValue = (LdapUserValue) template.lookup(userDn, new String[]{"chineseName", "ou"}, new AttributesMapper(){
		public Object mapFromAttributes(Attributes attrs) throws NamingException {
          LdapUserValue userValue = new LdapUserValue();
		  userValue.setChineseName((String) attrs.get("chineseName").get());
          userValue.setOu((String) attrs.get("ou").get());
		  return userValue;
		}
	  }) ;

	  // find member from database
	  IMemberService service = getMemberService() ;
	  Member member = service.getMember(principal) ;

	  // 如果 database 無此 user 則自動加入
	  if (member == null) {
		member = new Member() ;
		member.setPrincipal(principal);
		member.setCredential(credential);
		member.setGivenName(ldapValue.getChineseName());
		member.setOrgDn(ldapValue.getOu());
		member.setRole("general");

		// 加入預設的主題和 widget layout
		Map<String, String> preferences = new HashMap<String,String>() ;
		preferences.put(PortalPreference.THEME.getKey() , PortalConstants.DEFAULT_THEME ) ;
        preferences.put(PortalPreference.WIDGETLAYOUT.getKey() , PortalConstants.THREE_COLUMN_PREFERENCE_VALUE ) ;
        preferences.put(PortalPreference.WIDGETCOLORCLASS.getKey(), "color-orange");
		
		member.setPreferences(preferences);
		
		try {
		  service.saveMember(member);
		} catch (Exception e) {
		  throw new AuthenticationException("Fail Save Member To Database !", e);
		}
		
	  } else {
		member.setCredential(credential);
		member.setGivenName(ldapValue.getChineseName());
		member.setOrgDn(ldapValue.getOu());
	  }

	  return member;

	} else {
	  throw new AuthenticationException();
	}

  }

  /**
   * A user value in ldap
   */
  private static class LdapUserValue {

	private String chineseName;
	private String ou;

	public LdapUserValue() {}

	public String getChineseName() {
	  return chineseName;
	}

	public void setChineseName(String chineseName) {
	  this.chineseName = chineseName;
	}

	public String getOu() {
	  return ou;
	}

	public void setOu(String ou) {
	  this.ou = ou;
	}

  }
  
}
