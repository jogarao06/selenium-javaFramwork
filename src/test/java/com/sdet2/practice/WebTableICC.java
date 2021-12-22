package com.sdet2.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableICC {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String teamName="Australia";
		List<WebElement> teamnames = driver.findElements(By.xpath("//tr[*]/td[2]/span[@class='u-hide-phablet']"));

		for (int i = 1; i < teamnames.size(); i++) {
			if(teamnames.get(i).getText().equalsIgnoreCase(teamName)) 
			{
				System.out.println(driver.findElement(By.xpath("//span[.='"+teamName+"']/parent::td/parent::tr/td[3]")).getText());
			}
		}







	}

}
