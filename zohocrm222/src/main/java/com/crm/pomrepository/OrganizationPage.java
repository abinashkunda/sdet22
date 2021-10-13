package com.crm.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	 WebDriver driver;
	 public OrganizationPage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
      public WebElement getOrgpage() {
		return orgpage;
	}
	@FindBy(linkText = "wipro")
		private WebElement orgpage;

}
