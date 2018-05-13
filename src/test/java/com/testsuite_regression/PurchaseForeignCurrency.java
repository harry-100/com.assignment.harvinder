package com.testsuite_regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.PayBillsPage;
import com.pages.PurchaseForeignCurrencyPage;

public class PurchaseForeignCurrency extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	MainPage mp;
	PayBillsPage pb;
	PurchaseForeignCurrencyPage pf;
//	WebDriver driver;
	@Test
	public void purchaseCurrency()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mp = new MainPage (driver);
		pb = new PayBillsPage(driver);
		pf = new PurchaseForeignCurrencyPage(driver);
	
		hp.signin();
		lp.login();
		mp.navigateToPayBills();
		pf.purchaseCurrencyTab.click();
		pf.purchasecurrency().selectByValue("MXN");
		pf.amount.sendKeys("100");
		pf.usDollars.click();
		pf.calculateCosts.click();
		pf.purchaseCash.click();
		String act_message = pf.alertContent.getText();
		String exp_message = "Foreign currency cash was successfully purchased.";
		Assert.assertEquals(act_message,exp_message);
					
}
}