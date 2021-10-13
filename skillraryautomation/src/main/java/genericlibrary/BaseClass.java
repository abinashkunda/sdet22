package genericlibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public PropertyFile pdata=new PropertyFile();
	public WebUtilities utilities=new WebUtilities();
	
	
	@BeforeMethod
	public void openapp() throws FileNotFoundException, IOException {
		
		WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(pdata.getData("url"));
	//driver.get("https://www.skillrary.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@AfterMethod
public void closeapp() {
	driver.quit();
}

}
