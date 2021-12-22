package com.sdet2.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Debug {


	@Test
	public void login()
	{
				WebDriver driver= new ChromeDriver();
				driver.get("http://localhost:8888/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
		
				Debug1 d1 = new Debug1();
				d1.loginVtiger(driver);
				
				driver.close();

		String s1 = "hyderabad";

		String empty="";

		for (int i = s1.length()-1; i >=0; i--)
		{

			empty=empty+s1.charAt(i);

		}
		System.out.println(empty);


	}
}
