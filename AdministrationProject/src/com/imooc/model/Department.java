package com.imooc.model;

public class Department {

	private String departmentNo;
	private String departmentName;
	private Staff[] staffArr = new Staff[200];
	private int staffNum = 0;
	
	public Department() {
		
	}
	
	public Department(String departmentNo, String departmentName) {
		this.setDepartmentNo(departmentNo);
		this.setDepartmentName(departmentName);
	}
	
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Staff[] getStaffArr() {
		return staffArr;
	}
	public int getStaffNum() {
		return staffNum;
	}
	
	public void addStaff(Staff staff) {
		for(int i = 0; i < staffArr.length; i++) {
			if(staffArr[i] == null) {
				staffArr[i] = staff;
				staffNum++;
				break;
			}
		}
	}
	
	public void staffStatistics() {
		System.out.println(this.getDepartmentName() + "总共有" + staffNum + "名员工");
	}
	
	
	
	
}
