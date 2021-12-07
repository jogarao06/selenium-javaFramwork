package com.Vtiger.genericUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;

public class BaseClass 
{
	public  WebDriver driver;
	public LoginPage lp;
	public WebDriverUtil webutil;

	@BeforeSuite(groups = {"smokeTest"})
	public void setUp() 
	{
		System.out.println("Connect to DB");

	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest"})
	public void launchBrowser_URL(String browser) throws IOException {
	//String browser=FileUtil.objforfileutil().readDatafromPropfile("browser");
		//Launch browser
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver= new SafariDriver();
		}
		else
		{
			driver=	new ChromeDriver();
		}
		//get url
		driver.get(FileUtil.objforfileutil().readDatafromPropfile("url"));
		//Maximise window and wait
		webutil = new WebDriverUtil(driver);
		webutil.maximisewindow();
		webutil.pageloadtimeout();
		lp = new LoginPage(driver);
	}

	@BeforeMethod(groups = {"smokeTest"})
	public void logintoApp() throws IOException 
	{
		//Login to app

		lp.logintoApp();

	}

	@AfterMethod(groups = {"smokeTest"})
	public void logoutfromApp() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		hp.logOutfromApp();

	}

	@AfterClass(groups ={"smokeTest"})
	public void tearDown() throws InterruptedException {

		Thread.sleep(1000);
		driver.close();
	}
	@AfterSuite(groups = {"smokeTest"})
	public void disconnectfromDB() {
		System.out.println("Disconnect");
	}

}
