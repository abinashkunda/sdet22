package testscriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pomrepository.Createopportunity;
import com.crm.pomrepository.Home;
import com.crm.pomrepository.Login;
import com.crm.pomrepository.Oppinfopage;
import com.crm.pomrepository.Opportunities;
import com.crm.vtiger.genericutilities2.BaseClass;
import com.crm.vtiger.genericutilities2.ExcelUtility;
import com.crm.vtiger.genericutilities2.WebDriverUtility;



public class CreateOpportunitywithcontacts extends BaseClass  {
	@Test(groups="Smoke")
	public void CreateOpp1() throws  Throwable {
		
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
		 
			//String oppname = elib.getExcelData("Sheet1", 1, 1);
		 
		 Createopportunity createopportunity = new Createopportunity(driver);
		 createopportunity.getOpportunitynamElement().sendKeys("data");
		 
		 Createopportunity cre = new Createopportunity(driver);
		 cre.getRelatedto();
		 w.SelectOption(cre.getRelatedto(), 1);
		 
		 
		 Createopportunity crea = new Createopportunity(driver);
		 crea.getReltodisplay().click();
		 
		 String parent = driver.getWindowHandle();  
		w.switchToWindow(driver, "Contacts&action");
	
		
			  
		Createopportunity creat = new Createopportunity(driver);
		creat.getContactsname().click();
		
		driver.switchTo().window(parent);
		
		Createopportunity create = new Createopportunity(driver);
		create.getSavebtn().click();
		
		Oppinfopage oip = new Oppinfopage(driver);
		String actual = oip.getOppinfoedt().getText();
		if (actual.contains("tcs")) {
			System.out.println("opp is created successfully==>Pass");
		}else {
			System.out.println("opp is not created successfully==>fail");
		}
		driver.close();	
		}

}
