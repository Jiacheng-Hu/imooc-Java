package com.imooc.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.imooc.model.RealEstate;

public class EstateTest {

	static Scanner sc = new Scanner(System.in);				//定义全局变量sc接收键入数据
	List<RealEstate> estateList;				//定义对象集合，并在添加时初始化，2、3步骤用来判断是否为null

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstateTest test = new EstateTest();
		while(true) {
			test.menu();
			int n = 0;
			try {
				n = sc.nextInt();
				if(n == 0) {
					System.out.println("结束程序");
					break;
				}
				switch(n) {
					case 1:
						test.addEstate();
						break;
					case 2:
						test.showEstate();
						//判断集合里是否有元素，如果没有则提示先添加元素
						if(test.estateList != null) {
							test.showEstateDetails();
						}
						break;
					case 3:
						test.showEstate();
						//判断集合里是否有元素，如果没有则提示先添加元素
						if(test.estateList != null) {
							test.showEstateInRange();
						}
						break;
					default:
						System.out.println("请输入相应的数字");
						break;
				}
			}catch(InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数字");
				sc.next();				//用于接收错误数据
			}
		}
	}

	public void menu() {
		System.out.println("********************************");
		System.out.println("房源中心");
		System.out.println("1--添加房源");
		System.out.println("2--查看具体房源信息");
		System.out.println("3--区间查看房源信息");
		System.out.println("0--退出房源中心");
		System.out.println("********************************");
	}

	public void addEstate() throws InputMismatchException {
		int index = 0;				//控制循环次数的变量
		estateList = new ArrayList<RealEstate>();
		while (index <= 4) {
			System.out.println("输入房源编号：");
			System.out.println("编号从0开始，并为连续数值，如：0，1，2，3");
			int id = 0;
			try {
				id = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数值");
				sc.next();
				continue;				//键入错误数据格式，中止本次循环并开始下次循环
			}
			System.out.println("请输入房源名称：");
			String name = sc.next();
			System.out.println("请输入房源地址：");
			String address = sc.next();
			System.out.println("请输入房源户型：");
			String type = sc.next();
			estateList.add(new RealEstate(id, name, address, type));
			index++;
		}
	}

	public void showEstate() {
		if (estateList == null) {
			System.out.println("您还没有录入房源信息，请先录入房源信息");
		} else {
			Iterator<RealEstate> it = estateList.iterator();
			while (it.hasNext()) {
				RealEstate temp = it.next();
				System.out.println("房源编号    房源名称");
				System.out.println(temp.getId() + "         " + temp.getName());
			}
		}
	}

	public void showEstateDetails() throws InputMismatchException {
		System.out.println("请输入要查看的房源编号");
		int n = 0;				//键盘键入要查看的编号
		try {
			n = sc.nextInt();
			//键入编号不能为负数，不能超过录入的数据总量，否则提示没有录入信息
			if (n >= estateList.size() || n < 0) {
				System.out.println("没有录入信息");
				showEstateDetails();				//若录入负数或超出数据总量，则递归
			} else {
				Iterator<RealEstate> it = estateList.iterator();
				boolean flag = false;				//定义flag变量用于循环体外判断是否找到对应的数据
				while (it.hasNext()) {
					RealEstate temp = it.next();
					if (temp.getId() == n) {
						System.out.println(temp);
						flag = true;
						break;
					}
				}
				if(!flag) {
					System.out.println("没有录入信息");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("键入数据格式错误，请输入数值");
			sc.next();
			showEstateDetails();				//若键入数据格式错误，递归
		}
	}

	public void showEstateInRange() throws InputMismatchException {
		int i = 0;
		int j = 0;
		try {
			System.out.println("请输入要查看房源信息的第一个编号");
			i = sc.nextInt();
			if (i >= estateList.size() || i < 0) {
				System.out.println("没有录入信息");
				showEstateInRange();
				return;
			}
			System.out.println("请输入要查看房源信息的第二个编号");
			j = sc.nextInt();
			if (j >= estateList.size() || j < 0) {
				System.out.println("没有录入信息");
				showEstateInRange();
				return;
			}				//若i、j数值为负或大于集合中数据总量，输出错误信息并递归，然后return终止之后的代码执行
			if (i == j) {
				System.out.println(estateList.get(i));
			}				//i、j相等时应单独列出，否则for循环执行条件冲突
			if (i > j) {
				int temp = i;
				i = j;
				j = temp;
			}				//如果键入的第一个数的值大于第二个数，则将两个数调换位置
			for(int n = i; n < j; n++) {
				System.out.println(estateList.get(n));
				System.out.println("----------------------------");
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("键入数据格式错误，请输入数值");
			showEstateInRange();				//若键入数据格式错误，输出异常信息并递归
		}
	}

}
