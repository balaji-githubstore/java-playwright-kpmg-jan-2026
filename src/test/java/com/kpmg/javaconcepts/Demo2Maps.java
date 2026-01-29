package com.kpmg.javaconcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//genric type
public class Demo2Maps {

	public static void main(String[] args) {
		
		
		Map<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(101, "john");
		map1.put(102, "jack");
		map1.put(103, "kim");
		
		map1.put(102, "peter");
		
		
		
		System.out.println(map1.get(101));
		
	}
}
