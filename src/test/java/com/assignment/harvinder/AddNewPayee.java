package com.assignment.harvinder;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewPayee {
	
	
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
		public void addNewPayeeMethod(){
		driver.findElement(By.linkText("Pay Bills")).click();
		driver.findElement(By.linkText("Add New Payee")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys("HydroOne Utility");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RoberSpec Pkwy, Mississauga, ON  L6R1K9");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
		driver.findElement(By.id("add_new_payee")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String act_message=driver.findElement(By.id("alert_content")).getText();
		String exp_message = "The new payee HydroOne Utility was successfully created.";
		Assert.assertEquals(act_message,exp_message);
		}
		@AfterTest
		public void closeout() {
		driver.quit();
		}
		
	
}
