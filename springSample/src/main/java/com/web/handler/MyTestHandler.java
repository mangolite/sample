package com.web.handler;

import com.web.AbstractHandler;
import com.web.ActionHandler;
import com.web.HandlerAction;
import com.web.models.Greeting;
import com.web.models.HelloMessage;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "testinghandler")
public class MyTestHandler extends AbstractHandler {

	/**
	 * My method.
	 *
	 * @param message
	 *            the message
	 * @return the greeting
	 */
	@HandlerAction(name = "click")
	public Greeting myMethod(HelloMessage message) {
		return new Greeting("Hello, " + message.getName() + "! from handler");
	}

}
