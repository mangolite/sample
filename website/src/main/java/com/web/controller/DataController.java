package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.web.app.MessageClient;
import com.web.models.Greeting;
import com.web.models.HelloMessage;
import com.webutils.WebContextUtil;
import com.webutils.WebSockRequest;

@Controller
@MessageMapping("/action")
public class DataController {

	private SimpMessagingTemplate simpMessagingTemplate;

	public SimpMessagingTemplate getSimpMessagingTemplate() {
		return simpMessagingTemplate;
	}

	@Autowired
	public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		MessageClient.setClient(simpMessagingTemplate);
	}

	public static HandlerFactory hf = new HandlerFactory();

	@MessageMapping("/hello")
	@SendTo("/event/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

	@MessageMapping("/wsr/{handlerName}/{actionName}")
	public Object wrappedRequest(WebSockRequest message, @DestinationVariable("handlerName") String handlerName,
			@DestinationVariable("actionName") String actionName) throws Exception {
		WebContextUtil.setRequestContext(message);
		return hf.invokeHanldler(handlerName, actionName, message);
	}

}
