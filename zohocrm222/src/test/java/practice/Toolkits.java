package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class Toolkits {
	@Test
	public void test10() {
		//ExcelUtility elib = new ExcelUtility();
		//WebDriverUtility w = new WebDriverUtility();

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips");
		
		WebElement hover = driver.findElement(By.id("toolTipButton"));
		Actions actions= new Actions(driver);
		actions.moveToElement(hover).perform();
		
		WebElement text = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		String text1=text.getText();
		WebElement textfield = driver.findElement(By.id("toolTipTextField"));
		textfield.sendKeys(text1);
				
	}

}
