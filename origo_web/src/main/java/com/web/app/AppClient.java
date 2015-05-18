package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spamjs.mangolite.annotations.HandlerScan;
import org.spamjs.mangolite.annotations.ModelScan;
import org.spamjs.mangolite.app.StompTunnelClient;
import org.spamjs.mangolite.app.WebAppClient;
import org.spamjs.mangolite.app.WebAppProperties;

@Service
@HandlerScan("com.web.handler")
@ModelScan("com.web.models")
public class AppClient extends WebAppClient {

	@Autowired
	public AppClient(WebAppProperties webAppProperties,
			StompTunnelClient stompTunnelClient) {
		super(webAppProperties, stompTunnelClient);
	}

}
