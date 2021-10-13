package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkillraryLoginPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsbtn;
	
	@FindBy(xpath="(//a[.=' SkillRary Demo APP'])[2]")
	private WebElement skillraryDemoapp;
	
	@FindBy(name="q")
	private WebElement searchtab;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement searchbtn;
	
	public SkillraryLoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void gearsButton() {
		gearsbtn.click();
	}
	
    public void skillrarydemoApplication() 
    {
    	WebDriverWait wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[.=' SkillRary Demo APP'])[2]")));
    	skillraryDemoapp.click();
    }
    	
    	public void searchTextbox(String name) {
    		searchtab.sendKeys(name);
    	}
    	
    	public void searchbutton() {
    		searchbtn.click();
    }
    }

