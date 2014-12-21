package com.web.app;

import org.springframework.stereotype.Repository;

import com.webutils.AbstractWebAppClient;
import com.webutils.annotations.HandlerScan;
import com.webutils.annotations.ModelScan;

@Repository
@HandlerScan("com.web.handler")
@ModelScan("com.web.model")
public class AppClient extends AbstractWebAppClient {

	public AppClient() {
		super();
	}

}
