package com.uttara.prjcts;

import java.util.Comparator;

public class StringLengthCmp implements Comparator<String> {
	
	public int compare(String o1, String o2) {								//For comparing string length while sorting
		return o1.length()- o2.length();
	

	}
}