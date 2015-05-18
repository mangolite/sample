package com.web.app;

import java.util.Arrays;

import javax.websocket.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import org.spamjs.utils.Log;
import org.spamjs.mangolite.app.WebApp;
import org.spamjs.mangolite.app.WebAppSocketConfig;

//import org.spamjs.utils.Log;

/**
 * {@link EnableAutoConfiguration Auto-configuration} to enable Spring MVC to
 * handle {@link Endpoint} requests. It is assumed that endpoint requests will
 * be mapped and handled via an already registered {@link DispatcherServlet}.
 * 
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.web.controller", "com.web.config",
		"com.web.app" })
public class WebApplication extends WebApp {

	public static final Log LOG = new Log();

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(WebApplication.class);
		ApplicationContext ctx = app.run(args);
		LOG.info("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			LOG.info(beanName);
		}

	}

	@Autowired
	AppClient appClient;
}
