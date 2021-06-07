package com.imooc.model;

public class Student {

	private String stuNum;
	private String stuName;
	private float math;
	private float chinese;
	
	public Student() {
		
	}
	
	public Student(String stuNum, String stuName) {
		this.setStuNum(stuNum);
		this.setStuName(stuName);
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}

	public float getChinese() {
		return chinese;
	}

	public void setChinese(float chinese) {
		this.chinese = chinese;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		result = prime * result + ((stuNum == null) ? 0 : stuNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj.getClass() == Student.class) {
			Student student = (Student) obj;
			return student.getStuName().equals(stuName) && student.getStuNum().equals(stuNum);
		}
		return false;
	}

	@Override
	public String toString() {
		return "学生信息：[学号：" + stuNum + ", 姓名：" + stuName + "]";
	}
	
	
	
}
