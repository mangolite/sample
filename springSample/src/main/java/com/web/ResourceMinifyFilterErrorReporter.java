package com.web;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

import com.utils.Log;

/**
 * Error log class.
 *
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * @lastModified Aug 19, 2014
 */
public class ResourceMinifyFilterErrorReporter implements ErrorReporter {
	private static final Log log = new Log();

	public void warning(String message, String sourceName, int line,
			String lineSource, int lineOffset) {
		if (line < 0) {
			log.warn(message);
		} else {
			log.warn(line + ':' + lineOffset + ':' + message);
		}
	}

	public void error(String message, String sourceName, int line,
			String lineSource, int lineOffset) {
		if (line < 0) {
			log.error(message);
		} else {
			log.error(line + ':' + lineOffset + ':' + message);
		}
	}

	public EvaluatorException runtimeError(String message, String sourceName,
			int line, String lineSource, int lineOffset) {
		error(message, sourceName, line, lineSource, lineOffset);
		return new EvaluatorException(message);
	}
}
