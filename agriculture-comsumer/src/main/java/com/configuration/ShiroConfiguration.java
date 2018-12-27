package com.configuration;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.filter.RolesOrFilter;
import com.property.LoanRealm;
import com.property.ShiroProperty;


//@PropertySource(value="classpath:application-shiro.properties")
@Configuration
@EnableConfigurationProperties(ShiroProperty.class)
public class ShiroConfiguration {
	private  ShiroProperty shiroProperty;
    public ShiroConfiguration(ShiroProperty shiroProperty)
    {
    	this.shiroProperty=shiroProperty;
    }
	/*@Bean
	public FilterRegistrationBean delegatingFilterProxy()
	{
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		delegatingFilterProxy.setTargetFilterLifecycle(true);
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setName("shiroFileter");
		filterRegistrationBean.setFilter(delegatingFilterProxy);
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		
		
		return filterRegistrationBean;
	}*/
	@Bean
	public DefaultWebSessionManager webSessionManager() {
		DefaultWebSessionManager DefaultWebSessionManager =shiroProperty.getSession();
		return DefaultWebSessionManager;
	}

	@Bean
	public DefaultWebSecurityManager webSecurityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(myRealm());
		defaultWebSecurityManager.setSessionManager(webSessionManager());
		return defaultWebSecurityManager;
	}

	@Bean
	public AuthenticatingRealm myRealm() {
		LoanRealm loanRealm = new LoanRealm();
		HashedCredentialsMatcher hashedCredentialsMatcher =new HashedCredentialsMatcher("MD5");
		hashedCredentialsMatcher.setHashIterations(1024);
		loanRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return loanRealm;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFileter()
	{
		ShiroFilterFactoryBean ShiroFilterFactoryBean = shiroProperty.getShiroFilter();
		 Map<String,Filter> filterMap=new HashMap<String,Filter>();
		 filterMap.put("rolesOrFilter",new RolesOrFilter());
		ShiroFilterFactoryBean.setFilters(filterMap);
		ShiroFilterFactoryBean.setSecurityManager(webSecurityManager());
		Map<String,String> map = new HashMap<String,String>();
	/*	map.put("/findUsers","rolesOrFilter[superadmin,admin]");
		map.put("/findAdmins","rolesOrFilter[superadmin,admin]");
		map.put("/bakmain","rolesOrFilter[superadmin,admin]");
		map.put("/doAddAdmin","roles[superadmin]");
		map.put("/main","anon");
		map.put("/pre/index.html","anon");
		map.put("/dologin/**","anon");
		map.put("/tologin","anon");
		map.put("/toregister","anon");
		map.put("/doregister","anon");
		map.put("/activation","anon");
		map.put("/login","anon");
		map.put("/assets/css/**","anon");
		map.put("/assets/img/**","anon");
		map.put("/assets/js/**","anon");
		map.put("/pre/login.html","anon");
		map.put("/pre/header.html","anon");
		map.put("/pre/images/**","anon");
		map.put("/pre/js/**","anon");
		map.put("/pre/time/**","anon");
		map.put("/pre/css/**","anon");
		map.put("/**","authc");*/
	 /* map.put("/**", "anon");
		ShiroFilterFactoryBean.setFilterChainDefinitionMap(map);*/
		return ShiroFilterFactoryBean;
	}

	public ShiroProperty getShiroProperty() {
		return shiroProperty;
	}

	public void setShiroProperty(ShiroProperty shiroProperty) {
		this.shiroProperty = shiroProperty;
	}

	
}
