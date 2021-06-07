package com.imooc.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.imooc.model.Class;
import com.imooc.model.School;
import com.imooc.model.Student;

public class TestDemo {

	static Scanner sc = new Scanner(System.in);		//定义全局接收

	Class mainStudentList = new Class();
	School school = new School();		//由于主学生列表不属于班级，所以单独实例化并不添加至HashMap

	public void mainMenu() {
		System.out.println("*******************");
		System.out.println("**主菜单**");
		System.out.println("1--班级管理");
		System.out.println("2--学校管理");
		System.out.println("0--退出");
		System.out.println("*******************");
	}		//主菜单

	public void schoolMenu() {
		System.out.println("*********************************");
		System.out.println("**学校管理**");
		System.out.println("1--创建班级");
		System.out.println("2--删除班级");
		System.out.println("3--通过班级名称查询班级信息");
		System.out.println("4--对各班语文成绩按平均分进行由大到小排序");
		System.out.println("5--对各班数学成绩按平均分进行由大到小排序");
		System.out.println("6--显示所有班级名称");
		System.out.println("9--返回上一级菜单");
		System.out.println("*********************************");
	}		//学校管理菜单

	public void classMenu() {
		System.out.println("*********************************");
		System.out.println("**班级管理**");
		System.out.println("1--添加学生信息到主学生列表");
		System.out.println("2--添加学生信息到普通班级");
		System.out.println("3--通过学号查询学生信息");
		System.out.println("4--输入班级的语文成绩");
		System.out.println("5--输入班级的数学成绩");
		System.out.println("6--删除学生信息");
		System.out.println("7--显示所有学生信息");
		System.out.println("9--返回上一级菜单");
		System.out.println("*********************************");
	}		//班级管理菜单

	public void test() {
		while (true) {		//菜单及功能循环展示
			mainMenu();
			int n = 0;
			try {
				n = sc.nextInt();
				if (n == 0) {
					System.out.println("退出程序");
					sc.close();
					System.exit(0);		//关闭键盘输入，中止程序
				}
				switch (n) {
				case 1:
					testClass();		//调用班级测试方法
					break;
				case 2:
					testSchool();		//调用学校测试方法
					break;
				default:
					System.out.println("输入有误，没有对应的操作");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数字");
				sc.next();		//捕获异常并接收异常值，以便循环继续进行
			}
		}
	}

	public void testSchool() {
		while (true) {
			schoolMenu();
			System.out.println("请输入对应数字进行学校列表管理");
			int n = 0;
			try {
				n = sc.nextInt();
				switch (n) {
				case 1:
					System.out.println("向学校中添加班级");
					System.out.println("请输入班级编号：");
					String classId = sc.next();
					System.out.println("请输入班级名称：");
					String className = sc.next();
					school.addClass(new Class(classId, className));
					if (school.searchByName(className) != null) {
						System.out.println("添加成功");
					} else {
						System.out.println("添加失败");
					}
					break;
				case 2:
					System.out.println("从学校中删除班级");
					if (school.getSchoolMap().isEmpty()) {
						System.out.println("尚未添加班级，请先添加班级");
					} else {
						System.out.println("请输入班级名称");
						String classNameInCase2 = sc.next();
						if (school.searchByName(classNameInCase2) == null) {
							System.out.println("该班级不存在");
						} else {
							school.deleteClass(classNameInCase2);
							if (school.searchByName(classNameInCase2) == null) {
								System.out.println("删除成功");
							} else {
								System.out.println("删除失败");
							}
						}
					}
					break;
				case 3:
					System.out.println("通过班级名称查询班级");
					if (school.getSchoolMap().isEmpty()) {
						System.out.println("尚未添加班级，请先添加班级");
					} else {
						System.out.println("请输入班级名称");
						String classNameInCase3 = sc.next();
						if (school.searchByName(classNameInCase3) != null) {
							System.out.println("班级信息：" + school.searchByName(classNameInCase3));
						} else {
							System.out.println("该班级不存在");
						}
					}
					break;
				case 4:
					System.out.println("对各班语文成绩按平均分进行由大到小排序");
					if (school.getSchoolMap().isEmpty()) {
						System.out.println("尚未添加班级，请先添加班级");
					} else {
						school.sortChineseByAverage();
					}
					break;
				case 5:
					System.out.println("对各班数学成绩按平均分进行由大到小排序");
					if (school.getSchoolMap().isEmpty()) {
						System.out.println("尚未添加班级，请先添加班级");
					} else {
						school.sortMathByAverage();
					}
					break;
				case 6:
					System.out.println("显示所有的班级名称");
					if (school.getSchoolMap().isEmpty()) {
						System.out.println("尚未添加班级，请先添加班级");
					} else {
						school.displayClassName();
					}
					break;
				case 9:
					test();
					break;
				default:
					System.out.println("输入有误，没有对应的操作");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("键入数据类型错误，请输入数字！");
				sc.next();
			}
		}
	}

	public void testClass() {
		boolean flag = false;
		while (true) {
			classMenu();
			System.out.println("请输入对应数字进行班级列表管理");
			int n = 0;
			try {
				n = sc.nextInt();
				switch (n) {
				case 1:
					System.out.println("添加学生信息到主学生列表中");
					do {
						System.out.println("请输入要添加的学生信息个数：");
						try {
							int sum = sc.nextInt();
							flag = false;		//捕获异常时flag已设置为true，若第二次输入无异常，应将flag设置为false以跳出循环
							for (int i = 1; i <= sum; i++) {
								System.out.println("请输入第" + i + "个学生信息");
								System.out.println("请输入学生ID：");
								String stuID = sc.next();
								System.out.println("请输入学生姓名：");
								String stuName = sc.next();
								if (mainStudentList.searchStudentByNum(stuID) != null) {
									System.out.println("该学生ID已添加至主学生列表");
									i--;		//学生不可重复添加至主学生列表
								} else {
									mainStudentList.addStudent(new Student(stuID, stuName));
									if (mainStudentList.searchStudentByNum(stuID) != null) {
										System.out.println("添加成功");
									} else {
										System.out.println("添加失败");
									}
								}

							}
							System.out.println("主学生列表的信息为：");
							mainStudentList.displayAllStudent();
						} catch (InputMismatchException e) {
							System.out.println("键入格式错误，请输入数字！");
							sc.next();
							flag = true;
						}
					} while (flag);
					break;
				case 2:
					System.out.println("添加学生信息到普通班级");
					do {
						System.out.println("请输入要添加的班级名称");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;		//未找到班级，从输入班级名称处循环
							System.out.println("未查询到此班级");
						} else {
							flag = false;		//找到班级后跳出循环
							do {
								System.out.println("请输入要添加的学生个数：");
								try {
									int sum = sc.nextInt();
									flag = false;
									for (int i = 1; i <= sum; i++) {
										System.out.println("请输入第" + i + "个学生信息");
										System.out.println("请输入学生ID：");
										String strID = sc.next();
										if (mainStudentList.searchStudentByNum(strID) == null) {
											System.out.println("该学生信息在主学生列表中不存在，请输入学生的其他信息");
											System.out.println("请输入要添加的学生姓名：");
											String strName = sc.next();
											mainStudentList.addStudent(new Student(strID, strName));
										}
										boolean temp = false;
										String tmp = "";
										for (Class c : school.getSchoolMap().values()) {
											for (int j = 0; j < c.getStuList().size(); j++) {
												if (c.getStuList().get(j).getStuNum().equals(strID)) {
													tmp = c.getClassName();
													temp = true;
													break;
												}
											}
										}
										if (temp) {
											System.out.println("该学生ID已添加至" + tmp);
											i--;		//同一学生ID不能在一个班级出现两次，也不能出现在不同班级
										} else {
											school.searchByName(className)
													.addStudent(mainStudentList.searchStudentByNum(strID));
											if (school.searchByName(className).searchStudentByNum(strID) != null) {
												System.out.println("添加成功");
											} else {
												System.out.println("添加失败");
											}
										}
									}
									System.out.println("主学生列表");
									mainStudentList.displayAllStudent();
									System.out.println(className + "班级列表：");
									school.searchByName(className).displayAllStudent();
								} catch (InputMismatchException e) {
									System.out.println("键入格式错误，请输入数字！");
									sc.next();
									flag = true;
								}
							} while (flag);

						}
					} while (flag);
					break;
				case 3:
					System.out.println("通过学号查询学生信息");
					do {
						System.out.println("请输入要查询的班级名称：");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;
							System.out.println("该班级不存在");
						} else {
							flag = false;
							if (school.searchByName(className).getStuList().size() == 0) {
								System.out.println("没有学生信息，请先添加学生信息");		//没有学生信息时，stuList()长度为0
							} else {
								System.out.println("请输入要查询的学生ID");
								String stuID = sc.next();
								if (school.searchByName(className).searchStudentByNum(stuID) == null) {
									System.out.println("该学生信息在" + className + "不存在");
								} else {
									System.out.println(school.searchByName(className).searchStudentByNum(stuID));
								}
							}
						}
					} while (flag);
					break;
				case 4:
					System.out.println("输入班级的语文成绩");
					do {
						System.out.println("请输入班级名称：");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;
							System.out.println("该班级不存在");
						} else {
							flag = false;
							if (school.searchByName(className).getStuList().size() == 0) {
								System.out.println("没有学生信息，请先添加学生信息");
							} else {
								for (int i = 0; i < school.searchByName(className).getStuList().size(); i++) {
									String strID = school.searchByName(className).getStuList().get(i).getStuNum();
									String strName = school.searchByName(className).getStuList().get(i).getStuName();
									System.out.println("学生ID：" + strID + "，学生姓名：" + strName);
									System.out.println("请输入学生语文成绩：");
									try {
										float score = sc.nextFloat();
										school.searchByName(className).insertChineseScore(strID, score);
										if (school.searchByName(className).getStuList().get(i).getChinese() != 0.0) {
											System.out.println("添加语文成绩成功");
										} else {
											System.out.println("添加语文成绩失败");
										}
									} catch (InputMismatchException e) {
										System.out.println("键入数据格式有误，请输入数值型");
										sc.next();
										i--;
									}
								}
							}
						}
					} while (flag);
					break;
				case 5:
					System.out.println("输入班级的数学成绩");
					do {
						System.out.println("请输入班级名称：");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;
							System.out.println("该班级不存在");
						} else {
							flag = false;
							if (school.searchByName(className).getStuList().size() == 0) {
								System.out.println("没有学生信息，请先添加学生信息");
							} else {
								for (int i = 0; i < school.searchByName(className).getStuList().size(); i++) {
									String strID = school.searchByName(className).getStuList().get(i).getStuNum();
									String strName = school.searchByName(className).getStuList().get(i).getStuName();
									System.out.println("学生ID：" + strID + "，学生姓名：" + strName);
									System.out.println("请输入学生数学成绩：");
									try {
										float score = sc.nextFloat();
										school.searchByName(className).insertMathScore(strID, score);
										if (school.searchByName(className).getStuList().get(i).getMath() != 0.0) {
											System.out.println("添加数学成绩成功");
										} else {
											System.out.println("添加数学成绩失败");
										}
									} catch (InputMismatchException e) {
										System.out.println("键入数据格式有误，请输入数值型");
										sc.next();
										i--;
									}
								}
							}
						}
					} while (flag);
					break;
				case 6:
					System.out.println("删除学生信息");
					do {
						System.out.println("请输入班级名称：");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;
							System.out.println("该班级不存在");
						} else {
							flag = false;
							if (school.searchByName(className).getStuList().size() == 0) {
								System.out.println("没有学生信息，请先添加学生信息");
							} else {
								System.out.println("请输入学生ID：");
								String stuID = sc.next();
								if (school.searchByName(className).searchStudentByNum(stuID) == null) {
									System.out.println("没有找到ID：" + stuID + "的学生信息");
								} else {
									school.searchByName(className).deleteStudent(stuID);
									if (school.searchByName(className).searchStudentByNum(stuID) == null) {
										System.out.println("删除成功");
									} else {
										System.out.println("删除失败");
									}
								}
							}
						}
					} while (flag);
					break;
				case 7:
					System.out.println("显示所有学生信息");
					do {
						System.out.println("请输入班级名称：");
						String className = sc.next();
						if (school.searchByName(className) == null) {
							flag = true;
							System.out.println("该班级不存在");
						} else {
							flag = false;
							if (school.searchByName(className).getStuList().size() == 0) {
								System.out.println("没有学生信息，请先添加学生信息");
							} else {
								school.searchByName(className).displayAllStudent();
							}
						}
					} while (flag);
					break;
				case 9:
					test();
					break;
				default:
					System.out.println("输入有误，没有对应的操作");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数字！");
				sc.next();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDemo td = new TestDemo();
		td.test();
	}

}
