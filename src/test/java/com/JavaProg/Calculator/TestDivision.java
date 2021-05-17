package com.JavaProg.Calculator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDivision 
{
	Calculator cal;
	int Result;
	@BeforeGroups("RegressionTest")
	public void initGroup()
	{
		System.out.println("I am in before group");
		cal=new Calculator();
	}
	@BeforeClass
	public void CreateObj()
	{
		cal=new Calculator();
	}
	
	@BeforeMethod
	public void InitialiseResult()
	{
		Result=0;
	}
	
	@Test(priority = 1)
	public void TestDivisionWithPositiveNumbers()
	{
		System.out.println("In case 1 of Division");
		Result=cal.Division(100,2);
		Assert.assertEquals(Result, 50,"Division is not working");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("I am After Method");
		
	}
	@Test(priority = 2,groups={"RegressionTest"})
	public void TestDivisionWithnegativeNumbers()
	{
		System.out.println("I am in test case 2 of Division");
		Result=cal.Division(-30,-2);
		Assert.assertEquals(Result,15,"Division is not working");
	}
	
	@AfterClass
	public void ReleaseObj()
	{
		System.out.println("I am in after class");
		cal=null;
	}
	
}
