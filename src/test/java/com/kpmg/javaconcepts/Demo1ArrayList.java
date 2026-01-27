package com.kpmg.javaconcepts;

import java.util.ArrayList;

//non-genric type
public class Demo1ArrayList {

	public static void main(String[] args) {
		
		
		ArrayList list=new ArrayList(); 
		
		list.add(10);  //boxing
		list.add(10.3);
		
		list.add("bala");
		
		
		
		int x= (int) list.get(0); //unboxing
		
		System.out.println(x+x);
		
		int z= (int) list.get(2);
		
		
		
	}
}
