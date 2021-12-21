package com.sdet2.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FutureDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();


		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		driver.findElement(By.xpath("//li[@data-cy='account']")).click();

		driver.findElement(By.id("fromCity")).sendKeys("HYD");

		driver.findElement(By.xpath("//div[.='HYD']")).click();

		driver.findElement(By.id("toCity")).sendKeys("BLR");

		driver.findElement(By.xpath("//div[.='BLR']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

		Thread.sleep(2000);

		for (int i = 0; i <11; i++) 
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='Fri Apr 01 2022']")).click();
				break;	
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}

		}



	}

}
