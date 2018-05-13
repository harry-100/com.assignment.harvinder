package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class PayBillsPage extends BasePage{

	public PayBillsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (linkText= "Add New Payee")
	public WebElement addNewPayee;
	
	@FindBy(id = "np_new_payee_name")
	public WebElement  newPayeename;
	
	@FindBy( id = "np_new_payee_address")
	public WebElement  newpayeeAddress;
	
	@FindBy( id = "np_new_payee_account")
	public WebElement  newPayeeAccount;
	
	@FindBy (id = "np_new_payee_details")
	public WebElement  newPayeeDetails;
	
	@FindBy (id = "add_new_payee")
	public WebElement  addNewPayeeBtn;
	
	@FindBy (linkText = "Pay Saved Payee")
	public WebElement paySavedPayee;
	
	@FindBy (name = "payee")
	public WebElement payeeName;
	
	@FindBy (name = "account")
	public WebElement account;
	
	@FindBy (name = "amount")
	public WebElement amount;
	
	@FindBy (name = "date")
	public WebElement date;
	
	@FindBy (name = "description")
	public WebElement description;
	
	@FindBy (id = "pay_saved_payees")
	public WebElement payBtn;
	
	@FindBy (id = "alert_content")
	public WebElement message;
	
	public Select setPayee() {
		return new Select(payeeName);
	}
	
	public Select setAccount() {
		return new Select(account);
	}
	
}
