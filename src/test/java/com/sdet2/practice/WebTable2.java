package com.sdet2.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("12345");

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		List<WebElement> chkbox=driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[1]/input"));
	
		for (int i = 3; i < chkbox.size()+2; i++) 
		{
		driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[1]/input")).click();
		
		}
		
		
	}

}
