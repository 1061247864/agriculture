package com.property;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="shiro")
public class ShiroProperty {
 private ShiroFilterFactoryBean shiroFilter;
private DefaultWebSessionManager session;
public ShiroFilterFactoryBean getShiroFilter() {
	if(shiroFilter==null)
	{
		shiroFilter = new ShiroFilterFactoryBean();
	}
	return shiroFilter;
}
public void setShiroFilter(ShiroFilterFactoryBean shiroFilter) {
	this.shiroFilter = shiroFilter;
}
public DefaultWebSessionManager getSession() {
	return session;
}
public void setSession(DefaultWebSessionManager session) {
	this.session = session;
}

 
}
