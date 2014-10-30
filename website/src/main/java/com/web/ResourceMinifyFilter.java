package com.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.google.common.io.ByteStreams;
import com.utils.DebugUtil;
import com.webutils.AsbtractResourceMinifyFilter;
import com.yahoo.platform.yui.compressor.CssCompressor;
import com.yahoo.platform.yui.compressor.JavaScriptCompressor;

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
@Component
public class ResourceMinifyFilter extends AsbtractResourceMinifyFilter {
	private static final String RES_PATH_MATCH = "/(app/)*resources[0-9.]*/";
	private static final String RES_PATH_REPLACE = "/resources/";
	private static final String LIB_PATH_MATCH = "/(app/)*lib[0-9.]*/";
	private static final String LIB_PATH_REPLACE = "/lib/";

	private static Map<String, String> cache = new Hashtable<String, String>();

	@Override
	public String filterURI(String requestURI) {
		return requestURI.replaceAll(RES_PATH_MATCH, RES_PATH_REPLACE)
				.replaceAll(LIB_PATH_MATCH, LIB_PATH_REPLACE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webutils.AsbtractResourceMinifyFilter#getCache()
	 */
	@Override
	public Map<String, String> getCache() {
		return cache;
	}

	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webutils.AsbtractResourceMinifyFilter#getLibPath()
	 */
	@Override
	public String getLibPath() {
		return LIB_PATH_REPLACE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webutils.AsbtractResourceMinifyFilter#getResourcesPath()
	 */
	@Override
	public String getResourcesPath() {
		return RES_PATH_REPLACE;
	}

}