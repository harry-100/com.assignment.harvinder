package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class TransferFundsPage extends BasePage{

	public TransferFundsPage( WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "transfer_funds_tab")
	public WebElement transferFundsTab;
	
	@FindBy (id = "tf_fromAccountId")
	WebElement fromAccount;
	
	@FindBy (id = "tf_toAccountId")
	WebElement toAccount;
	
	@FindBy(id= "tf_amount")
	public WebElement amount;
	
	@FindBy (id = "tf_description")
	public WebElement  transferDescription;
	
	@FindBy (id = "btn_submit")
	public WebElement submitBtn;
	
	@FindBy (xpath = "//*[@id='transfer_funds_content']/div/div/div[1]")
	public WebElement transferFundsContent;
	
	public Select setFromAccount() {
		
	return	new Select(fromAccount);
	}
	
	public Select setToAccount() {
		return new Select(toAccount);
	}
}
