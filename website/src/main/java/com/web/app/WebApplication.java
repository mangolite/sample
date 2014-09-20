package com.web.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

import com.utils.Log;
import com.web.ResourceMinifyFilter;

//import com.utils.Log;

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
@ComponentScan(basePackages = { "com.web.controller", "com.web.config" })
public class WebApplication extends SpringBootServletInitializer {

	private static final Log LOG = new Log();

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

	/**
	 * Register with FilterRegistrationBean, files which are to be minified or
	 * if any other filter is to be added
	 * 
	 * Refer : http://www.leveluplunch.com/blog/2014/04/01/spring-boot-
	 * configure-servlet-mapping-filters/
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {

		ResourceMinifyFilter compressingFilter = new ResourceMinifyFilter();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("*.js");
		urlPatterns.add("*.css");
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setFilter(compressingFilter);
		return registrationBean;

	}

	/*
	 * @Bean public ServletRegistrationBean
	 * dispatcherRegistration(DispatcherServlet dispatcherServlet) {
	 * ServletRegistrationBean registration = new ServletRegistrationBean(
	 * dispatcherServlet); registration.addUrlMappings("/page/*",
	 * "/whatever2/*"); return registration; }
	 */
}
