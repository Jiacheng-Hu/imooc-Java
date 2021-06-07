package com.imooc.comparator;

import java.util.Comparator;
import com.imooc.model.Class;

public class ChineseComparator implements Comparator<Class> {

	@Override
	public int compare(Class o1, Class o2) {
		// TODO Auto-generated method stub
		float score2 = o2.getChineseAverage();
		float score1 = o1.getChineseAverage();
		return (int) (score2 - score1);
	}

}
