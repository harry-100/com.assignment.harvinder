package com.assignment.harvinder;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PurchaseForeignCurrency {
	
	 WebDriver driver;
	
	 @BeforeTest
	 public void signIn(){
	
		
		By signIn = By.id("signin_button");
		System.setProperty("webdriver.chrome.driver","./src/test/resources\\chromedriver.exe"); 
        driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(signIn).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	 }
		@Test
		public void purchaseCurrency() {
		driver.findElement(By.id("pay_bills_tab")).click(); //click on Pay Bills tab
		driver.findElement(By.xpath("//div[@id='tabs']/ul/li[3]")).click(); //click on Purchase Foreign Fund tab
		Select currency = new Select(driver.findElement(By.id("pc_currency")));
		currency.selectByValue("MXN");
		driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1000");
		driver.findElement(By.id("pc_inDollars_true")).click(); //Select US Dollars
		driver.findElement(By.id("pc_calculate_costs")).click(); //click on calculate costs
		driver.findElement(By.id("purchase_cash")).click();  //click on purchase 
		String act_message = driver.findElement(By.id("alert_content")).getText();
		String exp_message = "Foreign currency cash was successfully purchased.";
		Assert.assertEquals(act_message,exp_message);
		}
		@AfterTest
		public void closeout() {
		driver.quit();
		
		}
		
}
