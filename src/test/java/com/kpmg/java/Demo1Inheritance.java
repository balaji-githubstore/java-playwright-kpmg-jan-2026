package com.kpmg.java;


class Father
{
	public int fAge=60;
	
	public Father(int a)
	{
		fAge=a;
		System.out.println("father constructor!!");
	}
	

	public void fatherStyle()
	{
		System.out.println("father style 123");
	}
}

class Son extends Father
{
	public int sAge=20;
	
	public Son(int a, int b)
	{
		super(a);
		this.sAge=b;
		System.out.println("son constructor!!");
	}
	
	public void sonStyle()
	{
		System.out.println("son style");
	}
}





public class Demo1Inheritance {

	public static void main(String[] args) {
		
		Son s=new Son(80,25);
		
		System.out.println(s.fAge);
		System.out.println(s.sAge);
		
		s.fatherStyle();
		s.sonStyle();
		
		
		
	}

}
