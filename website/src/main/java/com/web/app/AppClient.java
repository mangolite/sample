package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webutils.AbstractWebAppClient;
import com.webutils.annotations.HandlerScan;
import com.webutils.annotations.ModelScan;

@Repository
@HandlerScan("com.web.handler")
@ModelScan("com.web.models")
public class AppClient extends AbstractWebAppClient {

	public AppClient() {
		super();
	}
	@Autowired
	private MessageClient messageClient;

}
