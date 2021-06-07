package com.imooc.model;

public class RealEstate {
	
	private int id;
	private String name;
	private String address;
	private String type;
	
	public RealEstate() {
		
	}
	
	public RealEstate(int id, String name, String address, String type) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setType(type);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	//重写toString()方法，输出对象信息
	@Override
	public String toString() {
		return "房源编号：" + id + "\n房源名称：" + name + "\n房源地址：" + address + "\n房屋类型：" + type;
	}
	
}
