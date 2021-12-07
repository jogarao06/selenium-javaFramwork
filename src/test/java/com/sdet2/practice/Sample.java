package com.sdet2.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample 
{
	int a;
	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("beforeClass");
		a=5;
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterClass
	public void afterClass() 
	{
		System.out.println("afterClass");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@Test(alwaysRun = true)
	public void TYSS() {
		System.out.println(a);
	}
	@Test(dependsOnMethods = "TYSS")
	public void RMG() {
		System.out.println("RMG");
	}

}