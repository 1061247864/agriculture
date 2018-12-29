package com.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

public class RolesOrFilter  extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)

			throws Exception {
		Subject subject = getSubject(request, response);
		
		if(subject.getPrincipal()==null)
		{
			return false;
		}
		String [] roles =(String [])mappedValue;
		if(roles!=null)
		{
			for (String string : roles) {
				if(subject.hasRole(string))
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		
		
		WebUtils.issueRedirect(request, response, "login");
		return false;
	}
	

}
