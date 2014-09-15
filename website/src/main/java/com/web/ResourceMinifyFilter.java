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
 * <filter> <display-name>Files Minify Filter</display-name>
 * <filter-name>ResourceMinifyFilter</filter-name> <filter-class>com.dfferentia
 * .filter.ResourceMinifyFilter</filter-class> <init-param>
 * <param-name>preserve-semi</param-name> <param-value>true</param-value>
 * </init-param> </filter> <filter-mapping>
 * <filter-name>ResourceMinifyFilter</filter-name>
 * <url-pattern>*.js</url-pattern> <dispatcher>REQUEST</dispatcher>
 * </filter-mapping> <filter-mapping>
 * <filter-name>ResourceMinifyFilter</filter-name>
 * <url-pattern>*.css</url-pattern> <dispatcher>REQUEST</dispatcher>
 * </filter-mapping>
 * 
 * <servlet-mapping> <servlet-name>appServlet</servlet-name>
 * <url-pattern>/</url-pattern> </servlet-mapping>
 * 
 * 
 * 
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * 
 * @version 1.0
 */
@SuppressWarnings("unused")
@Component
public class ResourceMinifyFilter implements Filter {
	private static final String PARAM_LINEBREAK = "line-break";
	private static final String PARAM_WARN = "warn";
	private static final String PARAM_NOMUNGE = "nomunge";
	private static final String RES_PATH_MATCH = "/app/resources[0-9.]*/";
	private static final String RES_PATH_REPLACE = "/resources/";
	private static final String LIB_PATH_MATCH = "/app/libs[0-9.]*/";
	private static final String LIB_PATH_REPLACE = "/libs/";
	public static final String EXT_JS = ".js";
	public static final String EXT_CSS = ".css";
	private static final boolean ALWAYS_MINIFY = true;
	private static boolean MINIFY_FILES = true;
	private static boolean MINIFY_DEBUG_MODE = true;

	private FilterConfig filterConfig;

	/**
	 * Insert a line break after the specified column number
	 */
	private int lineBreakPos = -1;

	/**
	 * Display possible errors in the code
	 */
	private boolean warn = false;

	/**
	 * Minify only, do not obfuscate
	 */
	private boolean munge = true;

	/**
	 * Preserve unnecessary semicolons
	 */
	private boolean preserveAllSemiColons = false;
	private boolean disableOptimizations = false;

	private static Map<String, String> cache = new Hashtable<String, String>();

	static {
		MINIFY_FILES = ALWAYS_MINIFY || !DebugUtil.isDebugBuild();
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig = filterConfig;

		String lineBreak = filterConfig.getInitParameter(PARAM_LINEBREAK);
		if (lineBreak != null) {
			lineBreakPos = Integer.parseInt(lineBreak);
		}

		String warnString = filterConfig.getInitParameter(PARAM_WARN);
		if (warnString != null) {
			warn = Boolean.parseBoolean(warnString);
		}

		String noMungeString = filterConfig.getInitParameter(PARAM_NOMUNGE);
		if (noMungeString != null) {
			/**
			 * swap values because it's nomunge
			 */
			munge = Boolean.parseBoolean(noMungeString) ? false : true;
		}

		String preserveAllSemiColonsString = filterConfig
				.getInitParameter("preserve-semi");
		if (preserveAllSemiColonsString != null) {
			preserveAllSemiColons = Boolean
					.parseBoolean(preserveAllSemiColonsString);
		}
	}

	public String filterURI(String requestURI) {
		return requestURI.replaceAll(RES_PATH_MATCH, RES_PATH_REPLACE)
				.replaceAll(LIB_PATH_MATCH, LIB_PATH_REPLACE);
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// ServletOutputStream servletOutputStream =
		// response.getOutputStream();
		response.setContentType("application/x-javascript; charset=UTF-8");
		// response.setCharacterEncoding("UTF-8");
		ServletContext context = filterConfig.getServletContext();
		String requestURI = filterURI(request.getRequestURI());
		InputStream inputStream = context.getResourceAsStream(requestURI);
		String morefiles = request.getParameter("@");
		Boolean skipMinification = (request.getParameter("no") != null) ? Boolean.TRUE
				: Boolean.FALSE;
		;
		String[] files = {};
		if (morefiles != null) {
			files = morefiles.split(",");
		}
		if (MINIFY_FILES && !skipMinification) {
			try {
				writeMinifiedFiles(response, context, requestURI, inputStream,
						files);
			} catch (Exception e) {
				writeOriginalFiles(response, context, inputStream, files);
			}
		} else {
			writeOriginalFiles(response, context, inputStream, files);
		}
	}

	private void writeMinifiedFiles(HttpServletResponse response,
			ServletContext context, String requestURI, InputStream inputStream,
			String[] files) throws IOException {
		PrintWriter servletOutputStream = response.getWriter();
		writeMinifiedFileToServletOutputStream(requestURI, inputStream,
				servletOutputStream);
		for (String file : files) {
			if (file != null && !file.isEmpty()) {
				InputStream inputStreamTemp = context
						.getResourceAsStream(filterURI(file));
				if (inputStreamTemp != null) {
					writeMinifiedFileToServletOutputStream(file,
							inputStreamTemp, servletOutputStream);
				}
			}
		}
		servletOutputStream.close();
	}

	private void writeOriginalFiles(HttpServletResponse response,
			ServletContext context, InputStream inputStream, String[] files)
			throws IOException {
		OutputStream output = response.getOutputStream();
		ByteStreams.copy(inputStream, output);
		for (String file : files) {
			if (file != null && !file.isEmpty()) {
				InputStream inputStreamTemp = context
						.getResourceAsStream(filterURI(file));
				if (inputStreamTemp != null) {
					ByteStreams.copy(inputStreamTemp, output);
				}
			}
		}
		output.flush();
	}

	private void writeMinifiedFileToServletOutputStream(String requestURI,
			InputStream inputStream, PrintWriter servletOutputStream)
			throws IOException {
		if (ALWAYS_MINIFY || !cache.containsKey(requestURI)) {
			String s;
			if (requestURI.endsWith(EXT_JS)) {
				s = getCompressedJavaScript(inputStream);
			} else if (requestURI.endsWith(EXT_CSS)) {
				s = getCompressedCss(inputStream);
			} else {
				s = "This file format is not supported by this filter. Only .css and .js are supported";
			}
			cache.put(requestURI, s);
		}
		write(cache.get(requestURI), servletOutputStream);
	}

	/**
	 * Write s to servletOutputStream
	 *
	 * @param s
	 * @param servletOutputStream
	 */
	private void write(String s, PrintWriter servletOutputStream) {
		servletOutputStream.print(s);
		// servletOutputStream.print(s);
		// servletOutputStream.close();
	}

	/**
	 * Note that the inputStream is closed!
	 *
	 * @param inputStream
	 * @throws IOException
	 */
	private String getCompressedJavaScript(InputStream inputStream)
			throws IOException {
		InputStreamReader isr = new InputStreamReader(inputStream);
		JavaScriptCompressor compressor = new JavaScriptCompressor(isr,
				new ResourceMinifyFilterErrorReporter());
		inputStream.close();

		StringWriter out = new StringWriter();
		compressor.compress(out, lineBreakPos, munge, warn,
				preserveAllSemiColons, disableOptimizations);
		out.flush();

		StringBuffer buffer = out.getBuffer();
		return buffer.toString();
	}

	/**
	 * Note that the inputStream is closed!
	 *
	 * @param inputStream
	 * @throws IOException
	 */
	private String getCompressedCss(InputStream inputStream) throws IOException {
		InputStreamReader isr = new InputStreamReader(inputStream);
		CssCompressor compressor = new CssCompressor(isr);
		inputStream.close();

		StringWriter out = new StringWriter();
		compressor.compress(out, lineBreakPos);
		out.flush();

		StringBuffer buffer = out.getBuffer();
		return buffer.toString();
	}

	public void destroy() {
	}

}