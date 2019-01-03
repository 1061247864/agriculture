package com.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filter.RolesOrFilter;
import com.property.LoanRealm;
import com.property.ShiroProperty;

//@PropertySource(value="classpath:application-shiro.properties")
@Configuration
@EnableConfigurationProperties(ShiroProperty.class)
public class ShiroConfiguration {
	private ShiroProperty shiroProperty;

	public ShiroConfiguration(ShiroProperty shiroProperty) {
		this.shiroProperty = shiroProperty;
	}

	/*
	 * @Bean public FilterRegistrationBean delegatingFilterProxy() {
	 * DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
	 * delegatingFilterProxy.setTargetFilterLifecycle(true); FilterRegistrationBean
	 * filterRegistrationBean = new FilterRegistrationBean();
	 * filterRegistrationBean.setName("shiroFileter");
	 * filterRegistrationBean.setFilter(delegatingFilterProxy);
	 * filterRegistrationBean.setOrder(1);
	 * filterRegistrationBean.addUrlPatterns("/*");
	 * 
	 * 
	 * return filterRegistrationBean; }
	 */
	@Bean
	@ConfigurationProperties(prefix = "shiro.redis")
	public RedisManager shiroRedisManager() {
		return new RedisManager();

	}

	@Bean
	public DefaultWebSessionManager webSessionManager(RedisCacheManager redisCacheManager) {
		DefaultWebSessionManager defaultWebSessionManager = shiroProperty.getSession();
		if(null==defaultWebSessionManager) {
			defaultWebSessionManager = new DefaultWebSessionManager();
			
		}
		defaultWebSessionManager.setCacheManager(redisCacheManager);
		 RedisSessionDAO redisSessionDAO = new  RedisSessionDAO();
		 redisSessionDAO.setRedisManager(redisCacheManager.getRedisManager());
		 defaultWebSessionManager.setSessionDAO(redisSessionDAO);
		return defaultWebSessionManager;
	}

	@Bean
	public DefaultWebSecurityManager webSecurityManager(RedisCacheManager redisCacheManager,DefaultWebSessionManager defaultWebSessionManager) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setCacheManager(redisCacheManager);
		defaultWebSecurityManager.setRealm(myRealm());
		defaultWebSecurityManager.setSessionManager(defaultWebSessionManager);
		return defaultWebSecurityManager;
	}

	@Bean
	public AuthenticatingRealm myRealm() {
		LoanRealm loanRealm = new LoanRealm();
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("MD5");
		hashedCredentialsMatcher.setHashIterations(1024);
		loanRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return loanRealm;
	}


	
	@Bean
	public ShiroFilterFactoryBean shiroFileter(DefaultWebSecurityManager webSecurityManager) {
		ShiroFilterFactoryBean ShiroFilterFactoryBean = shiroProperty.getShiroFilter();
		Map<String, Filter> filterMap = new HashMap<String, Filter>();
		filterMap.put("rolesOrFilter", new RolesOrFilter());
		ShiroFilterFactoryBean.setFilters(filterMap);
		ShiroFilterFactoryBean.setSecurityManager(webSecurityManager);
		/* Map<String,String> map = new HashMap<String,String>(); */
		/*
		 * map.put("/findUsers","rolesOrFilter[superadmin,admin]");
		 * map.put("/findAdmins","rolesOrFilter[superadmin,admin]");
		 * map.put("/bakmain","rolesOrFilter[superadmin,admin]");
		 * map.put("/doAddAdmin","roles[superadmin]"); map.put("/main","anon");
		 * map.put("/pre/index.html","anon"); map.put("/dologin/**","anon");
		 * map.put("/tologin","anon"); map.put("/toregister","anon");
		 * map.put("/doregister","anon"); map.put("/activation","anon");
		 * map.put("/login","anon"); map.put("/assets/css/**","anon");
		 * map.put("/assets/img/**","anon"); map.put("/assets/js/**","anon");
		 * map.put("/pre/login.html","anon"); map.put("/pre/header.html","anon");
		 * map.put("/pre/images/**","anon"); map.put("/pre/js/**","anon");
		 * map.put("/pre/time/**","anon"); map.put("/pre/css/**","anon");
		 * map.put("/**","authc");
		 */
		/*
		 * map.put("/**", "anon");
		 * ShiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		 */
		return ShiroFilterFactoryBean;
	}

	@Bean
	public RedisCacheManager shiroRedsiCacheManager(RedisManager redisManager,ShiroRedisSerializeble shiroRedisSerializeble) {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setValueSerializer(shiroRedisSerializeble);
		redisCacheManager.setRedisManager(redisManager);
		return redisCacheManager;

	}
	
	
	public ShiroProperty getShiroProperty() {
		return shiroProperty;
	}

	public void setShiroProperty(ShiroProperty shiroProperty) {
		this.shiroProperty = shiroProperty;
	}

}
