package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class PurchaseForeignCurrencyPage extends BasePage{

	public PurchaseForeignCurrencyPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//div[@id='tabs']/ul/li[3]")
	public WebElement purchaseCurrencyTab;
	
	@FindBy (id = "pc_currency")
	public WebElement currency;
	
	@FindBy (id = "pc_amount")
	public WebElement amount;
	
	@FindBy (id = "pc_inDollars_true")
	public WebElement usDollars;
	
	@FindBy (id = "pc_calculate_costs")
	public WebElement calculateCosts;
	
	@FindBy (id = "purchase_cash")
	public WebElement purchaseCash;
	
	@FindBy (id = "alert_content")
	public WebElement alertContent;
	
		public Select purchasecurrency() {
			return new Select(currency);
		}
}
