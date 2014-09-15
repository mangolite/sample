package com.web.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.web.models.Greeting;
import com.web.models.HelloMessage;

@Controller
@MessageMapping("/action")
public class DataController {

	public static HandlerFactory hf = new HandlerFactory();

	@MessageMapping("/hello")
	@SendTo("/event/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

	@MessageMapping("/wsr/{handlerName}/{actionName}")
	@SendTo("/event/greetings")
	public Object wrappedRequest(WebSockRequest message,
			@DestinationVariable("handlerName") String handlerName,
			@DestinationVariable("actionName") String actionName)
			throws Exception {
		// Thread.sleep(3000); // simulated delay
		return hf.invokeHanldler(handlerName, actionName, message);
	}

}
