package com.web.models;

import org.spamjs.mangolite.abstracts.AbstractResponse;

public class AuthResponse extends AbstractResponse {

	private String sessionID;

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	@Override
	public Object getData() {
		return null;
	}

}
