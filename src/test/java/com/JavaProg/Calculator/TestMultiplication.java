package com.JavaProg.Calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestMultiplication 
{
	Calculator cal;
	int Result;
	@BeforeClass
	public void Init()
	{
		cal=new Calculator();
	}
	
	@BeforeMethod
	public void ReintializingResult()
	{
		Result=0;
	}
	
	@Test(priority = 1,dataProvider = "ProvideValues",groups={"RegressionTest"})
	public void TestMultiplicationWithPositiveNumbers(int num1,int num2,int ExpectedResult)
	{
		Result=cal.Multiplication(num1,num2);
		Assert.assertEquals(Result,ExpectedResult,"Multiplication is not worked");
	}
	@DataProvider
	public Object[][] ProvideValues()
	{
		Object[][] SetofValues=new Object[3][3];
		/*3 Sets
		 * Set1 :1,2,2
		 * Set2 :10,20,200
		 * Set3 :1000,2000,2000000
		 */
		//This is Set 1: 3,4,12
		SetofValues[0][0]=3;
		SetofValues[0][1]=4;
		SetofValues[0][2]=12;
		
		//This is set2 :12,10,120
		SetofValues[1][0]=12;
		SetofValues[1][1]=10;
		SetofValues[1][2]=120;
		
		//Set3: 1000,2000,2000000
		SetofValues[2][0]=1000;
		SetofValues[2][1]=2000;
		SetofValues[2][2]=2000000;
	    return SetofValues;	
		
	}
	//To store the report in the folder
	@BeforeSuite
	@Parameters({"RequestID"})
	public void CreateResultReport(String RequestID)
	{
		System.out.println("I am in a Before SUITE!!");
		try {
			Files.createDirectories(Paths.get("./"+RequestID));
			}
		catch(IOException ex)
		{
			System.out.println("Problem in creating directory");
		}
	}
	@AfterSuite
	@Parameters({"RequestID"})
	public void CopyResult(String RequestID)
	{
		System.out.println("In After SUITE!");
		try {
		Files.copy(Paths.get("C:\\Users\\Ami\\eclipse-workspace\\Calculator\\target\\surefire-reports\\emailable-report.html"),Paths.get("./"+RequestID+"/Result.html"),StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException ex)
		{
			System.out.println("Problem in creating directory");
		}
	}
}
