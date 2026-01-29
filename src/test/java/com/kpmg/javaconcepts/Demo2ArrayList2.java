package com.kpmg.javaconcepts;

import java.util.ArrayList;

//genric type
public class Demo2ArrayList2 {

	public static void main(String[] args) {
		
		
		ArrayList<String> colors=new ArrayList<String>(); 
		
		colors.add("blue");
		colors.add("black");
		colors.add("red");
		
		System.out.println(colors);
		System.out.println(colors.get(0));
		
		System.out.println(colors.size());
		
		
		
		
	}
}
