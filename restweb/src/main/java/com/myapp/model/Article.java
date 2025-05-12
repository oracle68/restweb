package com.myapp.model;

import java.io.Serializable;

public class Article implements Serializable{

	private static final long serialVersionUID = -7254520911382284473L;
	
	private String name;
	private String desc;
	private String price;
	
	public Article() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
