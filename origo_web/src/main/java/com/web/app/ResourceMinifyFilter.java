package com.web.app;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.spamjs.mangolite.app.WebAppResourceMinifyFilter;

/**
 * Servlet Filter to Minify JavaScript and CSS files on the fly, currently it
 * uses YUI compressor, it can be changed
 * 
 * NOTE:- Handling multiple files at once, support need to be added
 * http://www.julienlecomte.net/blog/2007/08/11/
 * http://yuilibrary.com/download/#yuicompressor
 * 
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * 
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ResourceMinifyFilter extends WebAppResourceMinifyFilter {
	private static final String RES_PATH_MATCH = "/(app/)*resources[0-9.]*/";
	private static final String RES_PATH_REPLACE = "/resources/";
	private static final String LIB_PATH_MATCH = "/(app/)*lib[0-9.]*/";
	private static final String LIB_PATH_REPLACE = "/resources/weblib/";
	private static final String ROOT_PATH_REPLACE = "/resources/webroot/";
	private static final String APP_CONTEXT = "app";

	private static Map<String, String> cache = new Hashtable<String, String>();

	public String filterURI(String requestURI) {
		return requestURI.replaceAll(RES_PATH_MATCH, RES_PATH_REPLACE);
		// .replaceAll(LIB_PATH_MATCH, LIB_PATH_REPLACE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.spamjs.mangolite.AsbtractResourceMinifyFilter#getCache()
	 */
	public Map<String, String> getCache() {
		return cache;
	}

}