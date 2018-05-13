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

public class TransferFunds {
	
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
		driver.findElement(By.id("transfer_funds_tab")).click(); //click on Transfer Funds tab
		Select fromAccount = new Select (driver.findElement(By.id("tf_fromAccountId")));
		fromAccount.selectByValue("3"); //select the savings account
		Select toAccount = new Select(driver.findElement(By.id("tf_toAccountId")));
		toAccount.selectByValue("2"); //select chq account
		driver.findElement(By.id("tf_amount")).sendKeys("100"); // key in the amount of funds
		driver.findElement(By.id("tf_description")).sendKeys("Funds for credit card payment");
		driver.findElement(By.id("btn_submit")).click(); //click on continue button
		driver.findElement(By.id("btn_submit")).click(); //click on submit button
		String act_message = driver.findElement(By.xpath("//*[@id='transfer_funds_content']/div/div/div[1]")).getText();
		String exp_message = "You successfully submitted your transaction.";
		Assert.assertEquals(act_message,exp_message);
		}
		@AfterTest
		public void closeout() {
		driver.quit();
		
		}
		
	
}
