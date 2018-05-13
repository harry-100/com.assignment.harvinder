package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="user_login")
	WebElement userName;
	
	@FindBy (id="user_password")
	WebElement password;
	
	@FindBy (name="submit")
	WebElement submit;
	
	public void login () {
		userName.sendKeys("username");
		password.sendKeys("password");
		submit.click();
	}
}
