package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
	}
	@FindBy(name="username")
	WebElement usrName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[type='submit'")
	WebElement loginBtn;
	
	public void enterUserName(String usrnm) {
		usrName.sendKeys(usrnm);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	
	

}
