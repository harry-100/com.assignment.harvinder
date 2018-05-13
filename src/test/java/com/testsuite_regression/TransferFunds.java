package com.testsuite_regression;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.PayBillsPage;
import com.pages.TransferFundsPage;

public class TransferFunds extends BaseClass{
//	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MainPage mp;
	TransferFundsPage tf;
	
	@Test
	public void transfer()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mp = new MainPage (driver);
		tf = new TransferFundsPage(driver);
		
		hp.signin();
		lp.login();
		mp.transferFunds.click();
		tf.setFromAccount().selectByIndex(1);
		tf.setToAccount().selectByIndex(2);
		tf.amount.sendKeys("100");
		tf.transferDescription.sendKeys("For Mortgage Payment");
		tf.submitBtn.click();
		tf.submitBtn.click();
		String act_message = tf.transferFundsContent.getText();
		String exp_message = "You successfully submitted your transaction.";
		Assert.assertEquals(act_message,exp_message);
				
}
}