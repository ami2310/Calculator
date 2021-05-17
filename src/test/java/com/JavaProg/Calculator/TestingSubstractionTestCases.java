package com.JavaProg.Calculator;

import java.lang.annotation.Target;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingSubstractionTestCases
{
	Calculator Obj;
	int Result;
	@BeforeClass
	public void init()
	{
		System.out.println("I am in before class");
		Obj=new Calculator();
	}
	
	@BeforeMethod
	public void Reinitialise()
	{
		Result=0;
	}
	
	@Test(priority = 1,groups={"RegressionTest"})
	public void SubstractionPositiveNumbers() 
	{
		Result=Obj.Substraction(10,5);
		Assert.assertEquals(Result,5,"Substraction is not worked");
	}

}
