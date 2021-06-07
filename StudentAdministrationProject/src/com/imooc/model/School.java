package com.imooc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.imooc.comparator.ChineseComparator;
import com.imooc.comparator.MathComparator;

public class School {

	private Map<String, Class> schoolMap = new HashMap<String, Class>();

	public Map<String, Class> getSchoolMap() {
		return schoolMap;
	}		//schoolMap可以调用addClass方法录入信息，所以不需要另外设置set方法

	public void addClass(Class c) {
		schoolMap.put(c.getClassName(), c);
	}

	public void deleteClass(String className) {
		if (schoolMap.containsKey(className)) {
			schoolMap.remove(className);
		}
	}

	public Class searchByName(String className) {
		Class temp = null;
		if (schoolMap.containsKey(className)) {
			temp = schoolMap.get(className);
		}
		return temp;
	}

	public void sortMathByAverage() {
		List<Class> classList = new ArrayList<Class>();
		Iterator<Class> it = schoolMap.values().iterator();
		while (it.hasNext()) {
			Class temp = it.next();
			classList.add(temp);
		}		//新声明一个可用于comparator比较器的List，并将value值录入该List
		if (classList.get(0).getStuList().size() == 0) {
			System.out.println("还未向班级中添加学生");
		} else {
			boolean temp = false;
			for(int i = 0; i < classList.size(); i++) {
				if(classList.get(i).getChineseAverage() == 0.0) {
					System.out.println(classList.get(i).getClassName() + "还没有录入数学成绩");
					temp = true;
				}
			}
			if(temp) {
				return;
			}
			Collections.sort(classList, new MathComparator());
			System.out.println("数学平均成绩由大到小的排序为：");
			for (int i = 0; i < classList.size(); i++) {
				System.out.println(classList.get(i).getClassName() + "的平均分：" + classList.get(i).getMathAverage());
			}
		}
	}

	public void sortChineseByAverage() {
		List<Class> classList = new ArrayList<Class>();
		Iterator<Class> it = schoolMap.values().iterator();
		while (it.hasNext()) {
			Class temp = it.next();
			classList.add(temp);
		}
		if (classList.get(0).getStuList().size() == 0) {
			System.out.println("还未向班级中添加学生");
		} else {
			boolean temp = false;
			for(int i = 0; i < classList.size(); i++) {
				if(classList.get(i).getChineseAverage() == 0.0) {
					System.out.println(classList.get(i).getClassName() + "还没有录入语文成绩");
					temp = true;
				}
			}
			if(temp) {
				return;
			}		//没有录入语文成绩时，语文平均分为0.0，循环输出没有录入成绩的班级，并中止方法
			Collections.sort(classList, new ChineseComparator());
			System.out.println("语文平均成绩由大到小的排序为：");
			for (int i = 0; i < classList.size(); i++) {
				System.out.println(classList.get(i).getClassName() + "的平均分：" + classList.get(i).getChineseAverage());
			}
		}
	}

	public void displayClassName() {
		System.out.println("所有的班级名称为：");
		Iterator<String> it = schoolMap.keySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
