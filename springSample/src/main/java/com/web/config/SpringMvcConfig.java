package com.web.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// currently not using these configs
		// registry.addResourceHandler("/css").addResourceLocations("/css/").setCachePeriod(31556926);
		// registry.addResourceHandler("/img").addResourceLocations("/img/").setCachePeriod(31556926);
		// registry.addResourceHandler("/js").addResourceLocations("/js/").setCachePeriod(31556926);
	}
}
