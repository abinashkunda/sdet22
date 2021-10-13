package testscriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pomrepository.Createopportunity;
import com.crm.pomrepository.Home;
import com.crm.pomrepository.Login;
import com.crm.pomrepository.Opportunities;
import com.crm.pomrepository.OrganizationPage;
import com.crm.vtiger.genericutilities2.BaseClass;
import com.crm.vtiger.genericutilities2.ExcelUtility;
import com.crm.vtiger.genericutilities2.WebDriverUtility;

public class Createopportunitywithdelete extends BaseClass {
	@Test(groups ="Smoke")
	public void Test6() {
		
	//public Createopportunitywithdelete(WebDriver driver) {
		// TODO Auto-generated constructor stub
	

	//public static void main(String[]args) throws Throwable {
		//String oppName = "Comcast_1";
		 ExcelUtility elib = new ExcelUtility();
		 WebDriverUtility w = new WebDriverUtility();
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(" http://localhost:8888");
		
		
		
		Login loginPage = new Login(driver);
		loginPage.loginToApp("admin", "admin");
		
		
		Home homePage = new Home(driver);
		homePage.getOpportunitieslinkElement().click();
		
		 Opportunities opportunitiespage = new  Opportunities(driver);
		 opportunitiespage.getOppimgbtnElement().click();
		 
			//String oppname = elib.getExcelData("Sheet1", 0, 1);
		 
		 Createopportunity createopportunity = new Createopportunity(driver);
		 createopportunity.getOpportunitynamElement().sendKeys("data");
		 createopportunity.getReltoOrg().click();
         w.switchToWindow(driver, "Accounts&action");
         OrganizationPage opOrganizations = new OrganizationPage(driver);
         opOrganizations.getOrgpage().click();
         
         w.switchToWindow(driver, "Opportunities");
         
         	Createopportunity crb = new Createopportunity(driver);
         crb.getErasebtn().click();

}

}
