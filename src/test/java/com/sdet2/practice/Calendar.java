package com.sdet2.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtil.ExcelUtility;

public class Calendar {

	@Test(dataProvider = "getVAlues")
	public void testCity(String src, String dest) throws InterruptedException
	{

		System.out.println(src+"   "+dest);

//		Date d1 = new Date();
//		String todaysDate=d1.toString();
//
//		String[] arr =todaysDate.split(" ");
//
//		// Tue Dec 21 11:39:43 IST 2021
//		//  0   1   2     3     4   5
//		// Tue Dec 21 2021
//
//		String day=arr[0];
//		String month = arr[1];
//		String date=arr[2];
//		String year = arr[5];
//
//		String currentdate=day+" "+month+" "+date+" "+year;
//
//		System.out.println(currentdate);
//
//
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.makemytrip.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
//
//		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
//
//		//Actions action = new Actions(driver);
//		//action.moveByOffset(10, 10).build().
//
//		driver.findElement(By.id("fromCity")).sendKeys(src);
//
//		driver.findElement(By.xpath("//div[.='"+src+"']")).click();
//
//		driver.findElement(By.id("toCity")).sendKeys(dest);
//
//		driver.findElement(By.xpath("//div[.='"+dest+"']")).click();
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();

	}

	@DataProvider
	public Object getVAlues() throws EncryptedDocumentException, IOException {

		ExcelUtility excel = new ExcelUtility();

		int lastrow=excel.getLastRow("Sheet3");

		Object arr [][]= new Object[lastrow+1][2];

		for (int i = 0; i <= lastrow; i++) 
		{
			arr[i][0]=excel.readDataExcel("Sheet3", i, 0);
			arr[i][1]=excel.readDataExcel("Sheet3", i, 1);
			
		}
		return arr;


		//		arr[0][0]="DEL";
		//		arr[0][1]="BOM";
		//
		//		arr[1][0]="DEL";
		//		arr[1][1]="MAA";
		//
		//		arr[2][0]="DEL";
		//		arr[2][1]="GOI";
		//
		//
		//		arr[3][0]="DEL";
		//		arr[3][1]="HYD";
		//		
		//		return arr;


	}

}
