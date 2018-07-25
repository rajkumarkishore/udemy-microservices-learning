package com.kishore.udemy.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class SomeBean {

	private String attr1;
	
	//static filtering
	@JsonIgnore
	private String attr2;

	public SomeBean(String attr1, String attr2) {
		super();
		this.attr1 = attr1;
		this.attr2 = attr2;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

}
