package com.sdet2.practice;

import org.testng.annotations.Test;

public class SampleTest
{
	@Test()
	public void test1() 
	{
		String s1=System.getProperty("Name");
		System.out.println(s1);
		
	}

}