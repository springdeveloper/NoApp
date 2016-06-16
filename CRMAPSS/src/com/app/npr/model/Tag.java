package com.app.npr.model;

import java.io.Serializable;

public class Tag implements Serializable{

	public int id;
	public String tagName;

	//getter and setter methods

	public Tag(int id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}

	public Tag() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
