/**
 * Copyright (c) - 2014, Dion Global Solutions. Company confidential.
 */
package com.web.models;

/**
 * @author <a mailto:lalit.tanwar@dionglobal.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Sep 4, 2014
 */
public class UserDetails {
	private Name name;
	private Integer age;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
