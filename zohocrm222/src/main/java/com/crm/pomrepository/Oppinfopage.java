package com.crm.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oppinfopage {
	 WebDriver driver;
	 public Oppinfopage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
}

      @FindBy(xpath = "//span[@class='dvHeaderText']")
      private WebElement oppinfoedt;
      
	public WebElement getOppinfoedt() {
		return oppinfoedt;
	}

}
