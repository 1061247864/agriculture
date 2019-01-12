package com.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*@Configuration*/
public class CorsConfig {

	   @Bean
	    public FilterRegistrationBean corsFilter() {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        final CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("http://localhost:63342");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");// "X-Requested-With, accept, content-type, exception"
/*	        config.addAllowedHeader("X-Requested-With, accept, content-type, exception");
	        config.addAllowedMethod("GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");// "X-Requested-With, accept, content-type, exception"
*/	        config.setAllowCredentials(true);
	        //这个请求头在https中会出现,但是有点问题，下面我会说
	        //config.addExposedHeader("X-forwared-port, X-forwarded-host"); 
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        return bean;
	    }
}
