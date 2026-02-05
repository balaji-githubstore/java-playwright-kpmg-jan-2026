package com.kpmg.java;

class Father1
{
	public int fAge=60;
	
	public Father1(int fAge)
	{
		this.fAge=fAge;
		System.out.println("father constructor!!");
	}


	public void fatherStyle()
	{
		System.out.println("father style 123");
	}
}


public class Demo2 {

	public static void main(String[] args) {
		
		Father1 f=new Father1(45);
		
		System.out.println(f.fAge);
		f.fatherStyle();
	}
}
