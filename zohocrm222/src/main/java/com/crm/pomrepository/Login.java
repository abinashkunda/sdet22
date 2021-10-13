package com.crm.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;

	@FindBy(name="user_password")
	private WebElement userpasswordEdt;

	@FindBy(id="submitButton")
	private WebElement loginbtn;


	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public void loginToApp(String userName, String password) {
		usernameEdt.sendKeys(userName);
		userpasswordEdt.sendKeys(password);
		loginbtn.click();

	}

}

