package com.crm.vtiger.genericutilities2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.pomrepository.Home;
import com.crm.pomrepository.Login;


public class BaseClass {
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib= new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups={"Smoke"})
	public void connectDB()
	{
		System.out.println("DB connection successfull");
	}
	@BeforeClass(groups={"Smoke"})
	public void launchBrowser() throws Throwable
	{
		//read the data from property file
		driver.get("http://localhost:8888");
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			}
		else {
			System.out.println("invalid browser name");
		}
		System.out.println("browser launch successfully");
		
		wlib.maximizewindow(driver);
		wlib.waitUntilpageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups={"Smoke"})
	public void LoginToApp() throws Throwable
	{
		//read data from property file
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		
		//login to app
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login successful");
		
	}
	@AfterMethod(groups={"Smoke"})
	public void LogoutofApp()
	{
		//sign out of home page
		Home hp = new Home(driver);
		hp.logout();
		System.out.println("sign out successful");
		
	}
	@AfterClass(groups={"Smoke"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("browser closed successfully");
	}
	@AfterSuite(groups={"Smoke"})
	public void closeDB()
	{
		System.out.println("db connection cloised successfully");
	}
	
	
	

}


