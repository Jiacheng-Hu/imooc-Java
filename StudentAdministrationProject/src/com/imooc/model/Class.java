package com.imooc.model;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private String classId;
	private String className;
	private List<Student> stuList = new ArrayList<Student>();

	public Class() {

	}

	public Class(String classId, String className) {
		this.setClassId(classId);
		this.setClassName(className);
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStuList() {
		return stuList;
	}		//stuList可以通过addStudent方法录入信息，不需要set方法

	@Override
	public String toString() {
		return "班级信息：[班级编号：" + classId + ", 班级名称：" + className + "]";
	}

	public void addStudent(Student stu) {
		stuList.add(stu);
	}

	public Student searchStudentByNum(String stuNum) {
		Student temp = null;
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getStuNum().equals(stuNum)) {
				temp = stuList.get(i);
				break;
			}
		}
		return temp;
	}

	public void insertChineseScore(String stuNum, float score) {
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getStuNum().equals(stuNum)) {
				stuList.get(i).setChinese(score);
				break;
			}
		}
	}

	public void insertMathScore(String stuNum, float score) {
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getStuNum().equals(stuNum)) {
				stuList.get(i).setMath(score);
				break;
			}
		}
	}

	public void deleteStudent(String stuNum) {
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getStuNum().equals(stuNum)) {
				stuList.remove(i);
				break;
			}
		}
	}

	public void displayAllStudent() {
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
	}

	public float getMathAverage() {
		float mathSum = 0.0f;
		for (int i = 0; i < stuList.size(); i++) {
			mathSum = mathSum + stuList.get(i).getMath();
		}
		return mathSum / stuList.size();
	}

	public float getChineseAverage() {
		float chineseSum = 0.0f;
		for (int i = 0; i < stuList.size(); i++) {
			chineseSum = chineseSum + stuList.get(i).getChinese();
		}
		return chineseSum / stuList.size();
	}

}
