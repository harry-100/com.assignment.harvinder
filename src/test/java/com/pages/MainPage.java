package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class MainPage extends BasePage {
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id ="transfer_funds_tab")
	public  WebElement transferFunds;
	
	@FindBy(linkText = "Pay Bills")
	WebElement payBills;
	
	public void navigateToPayBills() {
		payBills.click();
	}
	
	public void navigateToTransferFunds() {
		transferFunds.click();
	}
}
