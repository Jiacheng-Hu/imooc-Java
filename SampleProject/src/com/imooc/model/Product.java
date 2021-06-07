package com.imooc.model;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String property;
	private double price;
	
	public Product() {
		
	}
	
	public Product(int id, String name, String property, double price) {
		this.setId(id);
		this.setName(name);
		this.setProperty(property);
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "产品id：" + id + "\n产品名称：" + name + "\n产品属性：" + property + "\n产品价格：" + price + "元";
	}
	
	

}
