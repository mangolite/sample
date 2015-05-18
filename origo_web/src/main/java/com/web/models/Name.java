package com.web.models;

/**
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Sep 4, 2014
 */
public class Name {

	private String fname;
	private String lname;

	public Name() {
		this.fname = null;
		this.lname = null;
	}

	public Name(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
