package com.JavaProg.Calculator;

public class TestingAdditionFunction {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Calculator Obj=new Calculator();
		int Res=Obj.Addition(10, 20);
		
		if(Res==30)
			System.out.println("Addition works fine with 2 positive numbers..PASSED");
		else
			System.out.println("Addition does not work fine with 2 positive numbers..FAILED");
		
	}

}
