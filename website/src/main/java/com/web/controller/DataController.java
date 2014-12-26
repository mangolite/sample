package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.web.app.AppClient;
import com.web.models.Greeting;
import com.web.models.AuthResponse;
import com.webutils.AbstractResponse;
import com.webutils.WebAppContext;
import com.webutils.WebSockRequest;

@Controller
@MessageMapping("/action")
public class DataController {

	@Autowired
	public static AppClient rxController;

	@MessageMapping("/hello")
	@SendTo("/event/greetings")
	public Greeting greeting(AuthResponse message) throws Exception {
		// Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + "!");
	}

	@MessageMapping("/wsr/{handlerName}/{actionName}")
	public AbstractResponse wrappedRequest(WebSockRequest message,
			@DestinationVariable("handlerName") String handlerName,
			@DestinationVariable("actionName") String actionName)
			throws Exception {
		WebAppContext.setRequestContext(message);
		return rxController.invokeHanldler(handlerName, actionName, message);
	}

}
