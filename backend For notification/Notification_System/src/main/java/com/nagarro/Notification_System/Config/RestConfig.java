package com.nagarro.Notification_System.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class RestConfig {
	
	
	/*
	 * configure for cross-platform use
	 */
	@Bean
public CorsFilter corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("POST");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);	
	}
}