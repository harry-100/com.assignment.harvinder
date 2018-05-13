package com.testsuite_regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.PayBillsPage;

public class AddNewPayee extends BaseClass{

	HomePage hp;
	LoginPage lp;
	MainPage mp;
	PayBillsPage pb;
	
	@Test
	public void addPayee()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mp = new MainPage (driver);
		pb = new PayBillsPage(driver);
	
		hp.signin();
		lp.login();
		mp.navigateToPayBills();
		pb.addNewPayee.click();
		pb.newPayeename.sendKeys("Toronto Hydro");
		pb.newpayeeAddress.sendKeys("200 RoberSpec Pkwy, Mississauga, ON  L6R1K9");
		pb.newPayeeAccount.sendKeys("123234434");
		pb.newPayeeDetails.sendKeys("Natural Gas Utility");
		pb.addNewPayeeBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String act_message=driver.findElement(By.id("alert_content")).getText();
		String exp_message = "The new payee Toronto Hydro was successfully created.";
		Assert.assertEquals(act_message,exp_message);
		
		
	}
	
}
