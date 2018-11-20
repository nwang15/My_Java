package security.service;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJBAccessException;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.security.enterprise.SecurityContext;

@DeclareRoles({"DMIT2015Instructor","DMIT2015Student","PROG_DMIT"})
public class NorthwindSecurityInterceptor {

	@Inject
	private SecurityContext sessionContext;
	
	@AroundInvoke
	public Object verifyAccess(InvocationContext context) throws Exception {
		String methodName = context.getMethod().getName();
		
		if (methodName.matches("^delete.*$")) {
			if (sessionContext.isCallerInRole("DMIT2015Instructor")) {
				Object result = context.proceed();
				return result;
			} else {
				throw new EJBAccessException("Access denied. You do not have permission to execute this method.");
			}
			
		} else if (methodName.matches("^update.*$")) {
			if (sessionContext.isCallerInRole("DMIT2015Instructor")||sessionContext.isCallerInRole("DMIT2015Student")) {
				Object result = context.proceed();
				return result;
			} else {
				throw new EJBAccessException("Access denied. You do not have permission to execute this method.");
			}
			
		} else if (methodName.matches("^add.*$")) {
			if (sessionContext.isCallerInRole("DMIT2015Instructor")||sessionContext.isCallerInRole("DMIT2015Student")||sessionContext.isCallerInRole("PROG_DMIT")) {
				Object result = context.proceed();
				return result;
			} else {
				throw new EJBAccessException("Access denied. You do not have permission to execute this method.");
			}
			
		} 
		Object result = context.proceed();
		return result;
	}
}
