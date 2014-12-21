package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.webutils.StompClient;
import com.webutils.WebAppContext;

/**
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Sep 10, 2014
 */
@Service
public class MessageClient extends StompClient{

	@Autowired
	public MessageClient(SimpMessagingTemplate simpMessagingTemplate){
		super(simpMessagingTemplate);
	}
}