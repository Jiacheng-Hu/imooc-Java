package com.imooc.test;
import com.imooc.model.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department humanResources = new Department("D001", "人事部");
		Department market = new Department("D002", "市场部");
		
		Position manager = new Position("P001", "经理");
		Position assistent = new Position("P002", "助理");
		Position staff = new Position("P003", "职员");
		
		Staff a = new Staff("张铭", "S001", 29, Gender.男, humanResources, manager);
		a.description();
		System.out.println("===========================");
		Staff b = new Staff("李艾爱", "S002", 21, Gender.女, humanResources, assistent);
		b.description();
		System.out.println("===========================");
		Staff c = new Staff("孙超", "S003", 29, Gender.男, humanResources, staff);
		c.description();
		System.out.println("===========================");
		Staff d = new Staff("张美美", "S004", 26, Gender.女, market, staff);
		d.description();
		System.out.println("===========================");
		Staff e = new Staff("蓝迪", "S005", 37, Gender.男, market, manager);
		e.description();
		System.out.println("===========================");
		Staff f = new Staff("米莉", "S006", 24, Gender.女, market, staff);
		f.description();
		System.out.println("===========================");
		humanResources.staffStatistics();
		market.staffStatistics();
	}

}
