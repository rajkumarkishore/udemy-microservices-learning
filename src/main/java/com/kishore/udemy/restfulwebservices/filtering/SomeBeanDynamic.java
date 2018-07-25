package com.kishore.udemy.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// this bean is dynamically filtered
@JsonFilter("SomeBeanFilter")
public class SomeBeanDynamic {

	private String attr1;
	
	private String attr2;

	public SomeBeanDynamic(String attr1, String attr2) {
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
