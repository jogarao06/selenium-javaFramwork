package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public static WebDriver sdriver;


	@BeforeSuite(groups = {"smokeTest","RegressionTest"})
	public void setUp() 
	{
		System.out.println("Connect to DB");

	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","RegressionTest"})
	public void launchBrowser_URL() throws IOException {
		String browser=FileUtil.objforfileutil().readDatafromPropfile("browser");
		//Launch browser
		
		//String browser=System.getProperty("BROWSER");
	
		System.out.println(browser);
		
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
		sdriver=driver;
	}

	@BeforeMethod(groups = {"smokeTest","RegressionTest"})
	public void logintoApp() throws IOException 
	{
		//Login to app

		lp.logintoApp();

	}

	@AfterMethod(groups = {"smokeTest","RegressionTest"})
	public void logoutfromApp() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		hp.logOutfromApp();
	}

	@AfterClass(groups ={"smokeTest","RegressionTest"})
	public void tearDown() throws InterruptedException 
	{

		Thread.sleep(1000);
		driver.close();
	}
	@AfterSuite(groups = {"smokeTest","RegressionTest"})
	public void disconnectfromDB() {
		System.out.println("Disconnect");
	}

	public static void takeScreenshot(String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);
	}


}
