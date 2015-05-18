package com.web.models;

import java.util.LinkedList;
import java.util.List;

public class Greeting {

	private String content;
	private String topic;
	private AuthResponse message;
	private List<Tag> tags = new LinkedList<Tag>();

	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public AuthResponse getMessage() {
		return message;
	}

	public void setMessage(AuthResponse message) {
		this.message = message;
	}

}
