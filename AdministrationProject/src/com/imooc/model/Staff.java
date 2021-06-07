package com.imooc.model;

public class Staff {

	private String name;
	private String staffNo;
	private int age;
	private Gender gender;
	private Department department;
	private Position position;
	
	public Staff() {
		
	}
	
	public Staff(String name, String staffNo, int age, Gender gender, Department department, Position position) {
		this.setName(name);
		this.setStaffNo(staffNo);
		this.setAge(age);
		this.setGender(gender);
		this.setDepartment(department);
		this.setPosition(position);
		department.addStaff(this);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public String getStaffNo() {
		return this.staffNo;
	}
	
	public void setAge(int age) {
		if(age >= 18 && age <= 65) {
			this.age = age;
		} else {
			this.age = 18;
			System.out.println("输入年龄有误，已自动设为18");
		}
	}
	public int getAge() {
		return this.age;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Gender getGender() {
		return this.gender;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Department getDepartment() {
		return this.department;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	public Position getPosition() {
		return this.position;
	}
	
	public void description() {
		System.out.println("姓名：" + this.getName());
		System.out.println("工号：" + this.getStaffNo());
		System.out.println("性别：" + this.getGender());
		System.out.println("年龄：" + this.getAge());
		System.out.println("职务：" + this.getDepartment().getDepartmentName() + this.getPosition().getPositionName());
	}
	
}
