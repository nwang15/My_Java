package security.config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.LdapIdentityStoreDefinition;


@CustomFormAuthenticationMechanismDefinition
(
	loginToContinue = @LoginToContinue(
	loginPage="/security/customLogin.xhtml", 
	errorPage="/security/customLogin.xhtml?error")
)



@LdapIdentityStoreDefinition(
url = "ldap://metro-ds1.nait.ca:389",
callerSearchBase = "dc=nait,dc=ca",
callerNameAttribute = "SamAccountName",	
groupSearchBase = "dc=nait,dc=ca",
bindDn = "cn=DMIT Student1,ou=DMITStudentRestricted,ou=Student,ou=DMIT,ou=SICET,dc=nait,dc=ca",
bindDnPassword = "Password2015",
priority = 5
)



@ApplicationScoped
public class ApplicationConfig {

}
