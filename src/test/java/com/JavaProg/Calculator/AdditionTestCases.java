package com.JavaProg.Calculator;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
public class AdditionTestCases 
{

	Calculator Obj;
	int Result;
	@BeforeGroups("RegressionTest")
	public void initGroup()
	{
		System.out.println("I am in before group");
		Obj=new Calculator();
	}
	@BeforeClass
	public void init()
	{
		System.out.println("I am in before class");
		Obj=new Calculator();
	}
	@BeforeMethod
	public void Reintialise()
	{
		System.out.println();
		Result=0;
	}
	@Test(priority=1,groups= {"RegressionTest"})
	public void TestAdditionWithPositiveNumbers()
	{
		
	     Result=Obj.Addition(10,20);
		Assert.assertEquals(Result, 30,"Addition does not work with positive numbers");
	}
	@Test(priority=3)
	public void TestAdditionWithZeroNumbers()
	{	
		
		int Result=Obj.Addition(0, 0);
		Assert.assertEquals(Result, 0,"Addition does not work with zero numbers");
	}

	@Test(priority=2,groups={"RegressionTest"})
	public void TestAdditionWithOnePositiveOneNegative()
	{
		 
		int Result=Obj.Addition(10, -8);
		Assert.assertEquals(Result, 2,"Addition does not work with 1 Positive and 1 Negative numbers");
	}
	
	
	
}