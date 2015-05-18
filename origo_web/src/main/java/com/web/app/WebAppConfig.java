package com.web.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import org.spamjs.mangolite.app.WebAppMvcConfig;
import org.spamjs.mangolite.app.WebAppSecurityConfig;
import org.spamjs.mangolite.app.WebAppSocketConfig;

@Configuration
public class WebAppConfig {

	@EnableWebSocketMessageBroker
	public static class WebSocketConfig extends WebAppSocketConfig {

	}

	@ComponentScan(basePackages = { "com.web.controller" })
	public static class MyWebAppMvcConfig extends WebAppMvcConfig {

	}
	
	@EnableWebMvcSecurity
	public static class SecurityConfiguration extends WebAppSecurityConfig {

	}
}
