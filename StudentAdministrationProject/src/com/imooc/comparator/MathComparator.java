package com.imooc.comparator;

import java.util.Comparator;
import com.imooc.model.Class;

public class MathComparator implements Comparator<Class> {

	@Override
	public int compare(Class o1, Class o2) {
		// TODO Auto-generated method stub
		float score2 = o2.getMathAverage();
		float score1 = o1.getMathAverage();
		return (int) (score2 - score1);
	}

}
