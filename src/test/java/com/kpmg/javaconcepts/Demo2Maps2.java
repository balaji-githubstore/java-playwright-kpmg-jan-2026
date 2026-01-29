package com.kpmg.javaconcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//genric type
public class Demo2Maps2 {

	public static void main(String[] args) {

		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(101, "john");
		map1.put(102, "jack");
		map1.put(103, "kim");

		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(101, "kim");
		map2.put(102, "kim1");
		map2.put(103, "kim2");

		ArrayList<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		
		list.add(map1);
		list.add(map2);
		
		
		System.out.println(list);
		
		System.out.println(list.get(0).get(102));

	}
}
