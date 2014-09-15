/**
 * Copyright (c) - 2014, Dion Global Solutions. Company confidential.
 */
package com.web.models;

/**
 * @author <a mailto:lalit.tanwar@dionglobal.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Sep 3, 2014
 */
public class Tag {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public Tag(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
